/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import Frames.Canciones;
import Frames.PerfilUsuario;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author mhernandez
 */
public class HiloServidor extends Thread{
    
    private JTextArea registroLogs;
    private int usuarioActual;

    public HiloServidor() {
    }

    public HiloServidor(JTextArea registroLogs) {
        this.registroLogs = registroLogs;
    }
    
    public void setUsuarioActual(int pUsuarioActual){
        this.usuarioActual=pUsuarioActual;
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
            UsuarioInicioSesion vCredenciales = new UsuarioInicioSesion(); //Inicializar vCredenciales antes de los credenciales para usar el atributo nombre de usuario para otras operaciones
		
            if (objetoRecibido instanceof UsuarioRegistro) {
                UsuarioRegistro registroNuevoUsuario = (UsuarioRegistro) objetoRecibido;
                this.registroLogs.append("Informacion de usuario y preferencias musicales recibidas... \n");
                registrarUsuario(registroNuevoUsuario);
                this.registroLogs.append("Registro exitoso para usuario: " + registroNuevoUsuario.getNombre() + ".\n");
				
            } if (objetoRecibido instanceof UsuarioInicioSesion) {
                vCredenciales = (UsuarioInicioSesion) objetoRecibido;
                System.out.println("VCredenciales: " + vCredenciales.toString());

                UsuarioInicioSesion respuesta = validarUsuario(vCredenciales);
                usuarioActual = respuesta.getID();
                registroLogs.append("Usuario \n" + usuarioActual);
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
                
            } if (objetoRecibido instanceof Cancion){
                Cancion nuevaCancion = (Cancion) objetoRecibido;
                this.registroLogs.append("Cancion buscada recibida... \n");
                
                BuscarCancion(nuevaCancion);
                
                if (nuevaCancion.getArtista() == null){
                    JOptionPane.showMessageDialog(null, "ERROR: Cancion no encontrada. Intentelo de nuevo!");
                }else{
                    Canciones nuevaVentana = new Canciones(nuevaCancion);
                    nuevaVentana.setVisible(true);
                    nuevaVentana.setUsuarioActual(usuarioActual);
                    this.registroLogs.append("Cancion enviada... \n");
                }
            } if (objetoRecibido instanceof ComentariosCanciones){
                ComentariosCanciones nuevoComentario = (ComentariosCanciones) objetoRecibido;
                nuevoComentario.setIDusuario(usuarioActual); //Setear el nombre de usuario que realizo el comentario
                this.registroLogs.append("El comentario fue recibido... \n");
                
                ComentarioCancionAgregado(nuevoComentario);
                this.registroLogs.append("Comentario fue enviado... \n");
            } if (objetoRecibido instanceof InstruccionChat) {
                
                if (((InstruccionChat) objetoRecibido).getEmisor().equals("")) {
                    ArrayList<String> resultado = this.obtenerUsuarios();
                    try {
                        vSerializador.writeObject(resultado);
                        vSerializador.flush();
                    } catch (IOException e) {
                        System.err.println("Error al enviar respuesta: " + e.getMessage());
                    }
                }else{
                    ArrayList<Mensaje> resultado = this.obtenerMensajes((InstruccionChat) objetoRecibido);

                    vSerializador.writeObject(resultado);
                    vSerializador.flush();


                }

                
            } if (objetoRecibido instanceof PerfilUsuarioLR) {
                PerfilUsuarioLR dato = (PerfilUsuarioLR) objetoRecibido;

                PerfilUsuarioLR respuesta = cargarListasReproduccionPublicas(dato);
                registroLogs.append("Enviando respuesta al cliente... \n");

                // Envía la respuesta al cliente usando el ObjectOutputStream ya creado
                try {
                    System.out.println(respuesta.toString());
                    vSerializador.writeObject(respuesta);
                    vSerializador.flush();
                    registroLogs.append("Resultado consulta enviado\n");
                } catch (IOException e) {
                    System.err.println("Error al enviar respuesta: " + e.getMessage());
                }
            
            
            vDeserializador.close();
            vSerializador.close();
            vPeticionCliente.close();
        } if (objetoRecibido instanceof Usuario) {
            Usuario nuevoUsuario = (Usuario) objetoRecibido;
            this.registroLogs.append("Usuario buscado recibido... \n");
            
            BuscarUsuario(nuevoUsuario);

            if (nuevoUsuario.getNombre() == null){
                JOptionPane.showMessageDialog(null, "ERROR: Usuario no encontrado. Intentelo de nuevo!");
            }else{
            PerfilUsuario nuevaVentana = new PerfilUsuario(nuevoUsuario, usuarioActual);
            nuevaVentana.setVisible(true);
            this.registroLogs.append("Usuario enviado... \n");
            }
        }
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
            try (ResultSet resultadoConsulta = comadoPreparado.executeQuery()) {
                if (resultadoConsulta.next()) {
                    consulta.setNombreUsuario(pDato.getNombreUsuario());
                    consulta.setID(resultadoConsulta.getInt("id"));
                    consulta.setContrasena("******"); 
                    consulta.setEsValido(true);
                    usuarioActual = consulta.getID();
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
    
    if (pMensaje.getTema()>0){ //Mensaje tematico, ya que no tiene receptor
        //JOptionPane.showMessageDialog(null, "guardando en bd");
        try {
        
        conexion = vConectar.establecerConexion();
        conexion.setAutoCommit(false);
        
        String comandoInsert = "INSERT INTO chatsgrupales(remitente, mensaje, tema) VALUES (?, ?, ?);";
        PreparedStatement comandoPreparado = vConectar.establecerConexion().prepareStatement(comandoInsert);
        comandoPreparado.setString(1, pMensaje.getEmisor());
        comandoPreparado.setString(2, pMensaje.getContenido());
        comandoPreparado.setInt(3, pMensaje.getTema());
        comandoPreparado.executeUpdate();
        conexion.close();
        //JOptionPane.showMessageDialog(null, "mensaje guardado en BD");
        
        } catch (SQLException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else{
        try {
            //JOptionPane.showMessageDialog(null, "guardando en bd");
            conexion = vConectar.establecerConexion();
            conexion.setAutoCommit(false);

            String comandoInsert = "INSERT INTO chatindividual(remitente, destinatario, mensaje) VALUES (?, ?, ?);";
            PreparedStatement comandoPreparado = vConectar.establecerConexion().prepareStatement(comandoInsert);
            comandoPreparado.setString(1, pMensaje.getEmisor());
            comandoPreparado.setString(2, pMensaje.getReceptor());
            comandoPreparado.setString(3, pMensaje.getContenido());
            comandoPreparado.executeUpdate();
            conexion.close();
            //JOptionPane.showMessageDialog(null, "mensaje guardado en BD");
        
        } catch (SQLException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}

    public void BuscarCancion(Cancion nuevaCancion){
        try {
            //Crear coneccion a la Base de Datos
            Clases.ConexionBD nuevaConexion = new Clases.ConexionBD();
            
            //Crear PreparedStatement
            PreparedStatement comandoSelectPreparado = null;
            
            //Comando SELECT
            String comandoSelect =  "SELECT artista,album,id,megusta FROM canciones WHERE titulo = ?";
            comandoSelectPreparado = nuevaConexion.establecerConexion().prepareStatement(comandoSelect);

            //Definimos los parametros
            comandoSelectPreparado.setString(1,nuevaCancion.getTitulo());
            
            ResultSet resultado = comandoSelectPreparado.executeQuery();
            
            if(resultado.next()){
                nuevaCancion.setArtista(resultado.getString("artista"));
                nuevaCancion.setAlbum(resultado.getString("album"));
                nuevaCancion.setID(resultado.getInt("id"));
                nuevaCancion.setMeGusta(resultado.getInt("megusta"));
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible encontrar el registro indicado.");
            }
                    
        } catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    public void ComentarioCancionAgregado(ComentariosCanciones nuevoComentario){
        try {
            //Crear coneccion a la Base de Datos
            Clases.ConexionBD nuevaConexion = new Clases.ConexionBD();
            
            //Comando INSERT
            String comandoInsert = "INSERT INTO cancionescomentarios(idcancion, idusuario, comentario) VALUES (?, ?, ?);";
            PreparedStatement comandoInsertPreparado = nuevaConexion.establecerConexion().prepareStatement(comandoInsert);
            
            //Definimos los parametros
            comandoInsertPreparado.setInt(1, nuevoComentario.getIDcancion());
            comandoInsertPreparado.setInt(2, nuevoComentario.getIDusuario());
            comandoInsertPreparado.setString(3, nuevoComentario.getComentario());
            
            //Ejecutar el comando
            comandoInsertPreparado.executeUpdate();
            
            //Mensaje de finalizacion
            JOptionPane.showMessageDialog(null, "Se ha ingresado el comentario correctamente en la base de datos");
        
        } catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    }

private ArrayList<Mensaje> obtenerMensajes(InstruccionChat pInstruccion){
    ResultSet resultado=null;
    ArrayList<Mensaje> listaMensajes=null;
    Clases.ConexionBD nuevaConexion = new Clases.ConexionBD();
    PreparedStatement comandoSelectPreparado = null;
    String comandoSelect;
    if (pInstruccion.getTema()>0) {//chat tematico
        try {
        comandoSelect =  "SELECT id,remitente,mensaje FROM chatsgrupales WHERE tema = ?";
        comandoSelectPreparado = nuevaConexion.establecerConexion().prepareStatement(comandoSelect);
        comandoSelectPreparado.setInt(1,pInstruccion.getTema());
        resultado = comandoSelectPreparado.executeQuery();
        
            listaMensajes = new ArrayList();
            while (resultado.next()){
                String emisor = resultado.getString("remitente");
                String contenido = resultado.getString("mensaje");
                //int tema = resultado.getInt("tema");
                
                Mensaje temp = new Mensaje(emisor, null, contenido);
                listaMensajes.add(temp);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else{//Chat privados
        //JOptionPane.showMessageDialog(null, "solicitud de chat privado en server");

        try {
            comandoSelect =  "SELECT remitente,destinatario,mensaje FROM chatindividual WHERE (remitente = ? AND destinatario = ?) OR (remitente = ? AND destinatario = ?)";
            comandoSelectPreparado = nuevaConexion.establecerConexion().prepareStatement(comandoSelect);
            comandoSelectPreparado.setString(1,pInstruccion.getEmisor());
            comandoSelectPreparado.setString(2,pInstruccion.getReceptor());
            comandoSelectPreparado.setString(3,pInstruccion.getReceptor());
            comandoSelectPreparado.setString(4,pInstruccion.getEmisor());
            resultado = comandoSelectPreparado.executeQuery();
            
           /* while (resultado.next()){
            JOptionPane.showMessageDialog(null, resultado.getString("Remitente"));}*/
            
            listaMensajes = new ArrayList();
            while (resultado.next()){
                String emisor = resultado.getString("remitente");
                String receptor = resultado.getString("destinatario");
                String contenido = resultado.getString("mensaje");
                //int tema = resultado.getInt("tema");
                
                Mensaje temp = new Mensaje(emisor, receptor, contenido);
                listaMensajes.add(temp);
                //System.out.println(emisor+" "+receptor+" "+contenido);
            }
            //System.out.println("Mensaje enviados a cliente");
        } catch (SQLException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        //enviar resultSet a cliente
        return listaMensajes;
}       



    private PerfilUsuarioLR cargarListasReproduccionPublicas(PerfilUsuarioLR dato){
    //Agrega las listas de reproduccion  al combobox
    int idUsuarioBuscado = dato.getIdLista();
    PerfilUsuarioLR resultado = new PerfilUsuarioLR();
    try {
        ConexionBD vConectar = new ConexionBD();
        String query = "SELECT lr.id, lr.nombrelista FROM listareproduccion lr JOIN usuarios u ON lr.idusuario = u.id WHERE lr.visibilidad = true  AND u.id = ?";
        
        try (PreparedStatement comandoPreparado = vConectar.establecerConexion().prepareStatement(query)) {
            comandoPreparado.setInt(1, idUsuarioBuscado);
            ResultSet resultadoConsulta = comandoPreparado.executeQuery();

            while (resultadoConsulta.next()) {
                //Lee los items por el nombre de la columna "nombrelista"
                int idLista = resultadoConsulta.getInt("id");
                String nombreLista = resultadoConsulta.getString("nombrelista");
                
                resultado.setIdLista(idLista);
                resultado.setNombreLista(nombreLista);

                return resultado;
            }         

        
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }
             catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
       return resultado;      
}
    
public ArrayList<String> obtenerUsuarios(){
    ArrayList<String> usuarios = null;
    ResultSet resultado=null;
    Clases.ConexionBD nuevaConexion = new Clases.ConexionBD();
    PreparedStatement comandoSelectPreparado = null;
    String comandoSelect;
        try {
        comandoSelect =  "SELECT nombre,nombreusuario FROM usuarios";
        comandoSelectPreparado = nuevaConexion.establecerConexion().prepareStatement(comandoSelect);
        resultado = comandoSelectPreparado.executeQuery();
        
            usuarios = new ArrayList();
            while (resultado.next()){
                String nombre = resultado.getString("nombre");
                String nombreUsuario = resultado.getString("nombreusuario");
                //int tema = resultado.getInt("tema");
                
                String temp = nombre + " (@" + nombreUsuario + ")";
                usuarios.add(temp);
            }

        
        } catch (SQLException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return usuarios;
}

    public void BuscarUsuario(Usuario nuevoUsuario){
        try {
            //Crear coneccion a la Base de Datos
            Clases.ConexionBD nuevaConexion = new Clases.ConexionBD();
            
            //Crear PreparedStatement
            PreparedStatement comandoSelectPreparado = null;
            
            //Comando SELECT
            String comandoSelect =  "SELECT nombre,id FROM usuarios WHERE nombreusuario = ?";
            comandoSelectPreparado = nuevaConexion.establecerConexion().prepareStatement(comandoSelect);

            //Definimos los parametros
            comandoSelectPreparado.setString(1,nuevoUsuario.getNombreUsuario());
            
            ResultSet resultado = comandoSelectPreparado.executeQuery();
            
            if(resultado.next()){
                nuevoUsuario.setNombre(resultado.getString("nombre"));
                nuevoUsuario.setID(resultado.getInt("id"));
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible encontrar el registro indicado.");
            }
                    
        } catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
}