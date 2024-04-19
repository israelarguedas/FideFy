/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author mhernandez
 */
public class HiloServidor extends Thread{
    
    private JTextArea registroLogs;

    public HiloServidor() {
    }

    public HiloServidor(JTextArea registroLogs) {
        this.registroLogs = registroLogs;
    }

    public JTextArea getRegistroLogs() {
        return registroLogs;
    }

    public void setRegistroLogs(JTextArea registroLogs) {
        this.registroLogs = registroLogs;
    }
    

@Override
public void run() {
    ServerSocket vSocketServidor;
    registroLogs.append("Inicializando servidor!\n");
    try {
        vSocketServidor = new ServerSocket(15575);
        registroLogs.append("Esperando conexión...\n");
        while (true) {
            Socket vPeticionCliente = vSocketServidor.accept();
            registroLogs.append("Conexión establecida... esperado peticiones!\n");
            ObjectOutputStream vSerializador = new ObjectOutputStream(vPeticionCliente.getOutputStream());
            ObjectInputStream vDeserializador = new ObjectInputStream(vPeticionCliente.getInputStream());
            
            Object objetoRecibido = vDeserializador.readObject();
            
		
            if (objetoRecibido instanceof UsuarioRegistro) {
                UsuarioRegistro registroNuevoUsuario = (UsuarioRegistro) objetoRecibido;
                this.registroLogs.append("Informacion de usuario y preferencias musicales recibidas... \n");
                registrarUsuario(registroNuevoUsuario);
                this.registroLogs.append("Registro exitoso para usuario: " + registroNuevoUsuario.getNombre() + ".\n");
				
            } if (objetoRecibido instanceof UsuarioInicioSesion) {
                UsuarioInicioSesion vCredenciales = (UsuarioInicioSesion) objetoRecibido;
                System.out.println("VCredenciales: " + vCredenciales.toString());

                UsuarioInicioSesion respuesta = validarUsuario(vCredenciales);
                registroLogs.append("Enviando respuesta al cliente... \n");
                System.out.println("Servidor: " + respuesta.toString());

                // Envía la respuesta al cliente usando el ObjectOutputStream ya creado
                try {
                    System.out.println(respuesta.toString());
                    vSerializador.writeObject(respuesta);
                    vSerializador.flush();
                    registroLogs.append("Resultado consulta enviado\n");
                } catch (IOException e) {
                    System.err.println("Error al enviar respuesta: " + e.getMessage());
                }
            } if (objetoRecibido instanceof Mensaje){
                Mensaje vMensajeRecibido = (Mensaje) objetoRecibido;
                guardarMensajeBD(vMensajeRecibido);
            }
            
            vDeserializador.close();
            vSerializador.close();
            vPeticionCliente.close();
        }
    } catch (Exception e) {
        registroLogs.append("Error en run: " + e.getMessage() + "\n");
    }
}

private void registrarUsuario(UsuarioRegistro pDatos) throws ExcepcionUsuarioDuplicado, SQLException{
        
    ConexionBD vConectar = new ConexionBD();
    Connection conexion = null;
    
        try {
            
            conexion = vConectar.establecerConexion();
            conexion.setAutoCommit(false);
            
            String comandoInsert = "INSERT INTO usuarios(nombre, nombreusuario, contraseña) VALUES (?, ?, ?);";
            String comandoInsert2 = "INSERT INTO preferenciasmusicales(nombreusuario, electronica, pop, jazz, rock, clasica, latina) VALUES (?, ?, ?, ?, ?, ?, ?);";

            
            try (PreparedStatement ps = conexion.prepareStatement(comandoInsert)) {
                ps.setString(1, pDatos.getNombre());
                ps.setString(2, pDatos.getNombreUsuario());
                ps.setString(3, pDatos.getContrasena());

                int resultado = ps.executeUpdate();
                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "El usuario: " + pDatos.getNombreUsuario() + " se registró con éxito!");
                }
            }
            
            try (PreparedStatement ps2 = conexion.prepareStatement(comandoInsert2)) {
                ps2.setString(1, pDatos.getNombreUsuario());
                ps2.setBoolean(2, pDatos.isElectronica());
                ps2.setBoolean(3, pDatos.isPop());
                ps2.setBoolean(4, pDatos.isJazz());
                ps2.setBoolean(5, pDatos.isRock());
                ps2.setBoolean(6, pDatos.isClasica());
                ps2.setBoolean(7, pDatos.isLatina());
                ps2.executeUpdate();
        }
            
            //Guarda los cambios de los dos insert en la BD
            conexion.commit();
            
            
    } catch (SQLIntegrityConstraintViolationException error) {
        if (conexion != null) {
            conexion.rollback();
        }
        throw new ExcepcionUsuarioDuplicado("El usuario ya existe, favor cambie su usuario:");
    } catch (Exception error) {
        if (conexion != null) {
            conexion.rollback();  // Rollback para deshacer los cambios en caso de error
        }
        JOptionPane.showMessageDialog(null, "ERROR: " + error.toString());
    } finally {
        if (conexion != null) {
            conexion.setAutoCommit(true);  
            conexion.close();  
            
        }
    }
}
   
public UsuarioInicioSesion validarUsuario(UsuarioInicioSesion pDato) {
    UsuarioInicioSesion consulta = new UsuarioInicioSesion();
    try {
        ConexionBD vConectar = new ConexionBD();
        String query = "SELECT * FROM usuarios WHERE nombreusuario = ? AND contraseña = ?;";
        try (PreparedStatement comadoPreparado = vConectar.establecerConexion().prepareStatement(query)) {
            comadoPreparado.setString(1, pDato.getNombreUsuario());
            comadoPreparado.setString(2, pDato.getContrasena()); // Considera cambiar esto para usar contraseñas hasheadas
            try (ResultSet rs = comadoPreparado.executeQuery()) {
                if (rs.next()) {
                    consulta.setNombreUsuario(pDato.getNombreUsuario());
                    consulta.setContrasena("contra"); 
                    consulta.setEsValido(true);
                }
            }
        }
    } catch (SQLException e) {
        System.err.println("Error ValidarUsuario: " + e.getMessage());
        consulta.setEsValido(false);
    }
    return consulta;
}

private void guardarMensajeBD(Mensaje pMensaje){
    ConexionBD vConectar = new ConexionBD();
    Connection conexion = null;
    
    if (pMensaje.getReceptor().equals("")){//Mensaje tematico, ya que no tiene receptor
        try {
        
        
        conexion = vConectar.establecerConexion();
        conexion.setAutoCommit(false);
        
        String comandoInsert = "INSERT INTO usuarios(nombre, nombreusuario, contraseña) VALUES (?, ?, ?);";
        } catch (SQLException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else{//mensaje privado, que si tiene receptor
    
    }
}
              

}