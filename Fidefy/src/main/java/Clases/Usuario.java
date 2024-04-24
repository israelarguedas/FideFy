/*
 * @author Grupo_2
 * @author Isra Arguedas
 */
package Clases;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;


public class Usuario implements Serializable, Comparable<Usuario>{
    private String Nombre;
    private String NombreUsuario; 
    private String Contrasena;
    private int ID;
    
    //private ArrayList<Seguidos> Seguidos;
    //private ArrayList<Seguidores> Seguidores;
    //private ListaReproduccion nuevaListaReproduccion;

    public Usuario() {
    }
    
    public Usuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }
    
    public Usuario(String NombreUsuario, String Contrasena) {
        this.NombreUsuario = NombreUsuario;
        this.Contrasena = Contrasena;
    }

    public Usuario(String Nombre, String NombreUsuario, String Contrasena, int ID) {
        this.Nombre = Nombre;
        this.NombreUsuario = NombreUsuario;
        this.Contrasena = Contrasena;
        this.ID = ID;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
   
    @Override
    public int compareTo(Usuario usuario1) {
        return this.NombreUsuario.compareTo(usuario1.getNombreUsuario());
    }
    
     @Override
     public boolean equals (Object usuario1) {
        Usuario vUsuario_equal = (Usuario) usuario1;
        return vUsuario_equal.getNombreUsuario().equals(this.NombreUsuario);
    }

    @Override
    public String toString() {
        return "Usuario{" + "Nombre=" + Nombre + ", NombreUsuario=" + NombreUsuario + ", Contrasena=" + Contrasena + ", ID=" + ID + '}';
    }
    
    /* 
    public void agregar_seguido(Seguidos NuevoSeguido){ //Seguir un nuevo usuario. Se agrega a la lista de usuarios seguidos
        this.Seguidos.add(NuevoSeguido);
        JOptionPane.showMessageDialog(null,
                "El usuario ha sido seguido exitosamente");
    }
    
    public void remover_seguido(Seguidos NuevoSeguido){ //Dejar de seguir a un usuario. Se remueve de la lista de usuarios seguidos
        this.Seguidos.remove(NuevoSeguido);
        JOptionPane.showMessageDialog(null,
                "El usuario ha sido removido exitosamente");
    }
    
    public void remover_seguidor(Seguidores Seguidor){ //Remover un seguidor. Se remueve de la lista Seguidores
        this.Seguidores.remove(Seguidor);
        JOptionPane.showMessageDialog(null,
                "El usuario ha sido removido exitosamente");
    }
    */
    //Valida que el usuario se encuentre en la base de datos
public boolean ValidarUsuario(Usuario pDato){
    
    boolean isValido = false; 
    try {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Clases.ConexionBD pConexion = new Clases.ConexionBD();
        
        System.out.println("Usuario: " + pDato.getNombreUsuario());
        System.out.println("Contraseña: " + pDato.getContrasena());
        
        
        String query = "SELECT * FROM usuarios WHERE usuarios.nombreusuario = ? AND usuarios.contraseña = ?;";
        
        ps = pConexion.establecerConexion().prepareStatement(query);
        ps.setString(1, pDato.getNombreUsuario()); 
        ps.setString(2, pDato.getContrasena()); 
        
        rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Nombre: " + rs.getString("nombreusuario")); 
            System.out.println("Contraseña: " + rs.getString("contraseña"));
            isValido = true;                        
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error ValidarUsuario:" + e.getMessage());
    }
    return isValido; 
}
    
    
    public void AgregarUsuario(Usuario pDato) throws ExcepcionUsuarioDuplicado{
        try {
            PreparedStatement ps =null;
            Clases.ConexionBD pConexion = new Clases.ConexionBD();
            
            String comandoInsert = "INSERT INTO usuarios(nombre,nombreusuario,contraseña)VALUE(?,?,?);";
            
            ps=pConexion.establecerConexion().prepareStatement(comandoInsert); 
                       
            ps.setString(1, pDato.getNombre());
            ps.setString(2, pDato.getNombreUsuario());
            ps.setString(3, pDato.getContrasena());
            
            ps.executeUpdate();
           
        } catch (SQLIntegrityConstraintViolationException error) {
            throw new ExcepcionUsuarioDuplicado("El usuario ya existe, favor cambie su usuario:");
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "ERROR"+error.toString());
        }
    }
}


