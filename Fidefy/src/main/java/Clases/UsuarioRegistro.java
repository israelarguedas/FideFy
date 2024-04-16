/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.sql.PreparedStatement;

/**
 *
 * @author mhernandez
 */
public class UsuarioRegistro implements Serializable{
    
    private String nombre;
    private String nombreUsuario;
    private String Contrasena;
    private boolean electronica;
    private boolean rock;
    private boolean pop;
    private boolean jazz;
    private boolean clasica;
    private boolean latina;

    public UsuarioRegistro() {
    }

    public UsuarioRegistro(String nombre, String nombreUsuario, String Contrasena, boolean electronica, boolean rock, boolean pop, boolean jazz, boolean clasica, boolean latina) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.Contrasena = Contrasena;
        this.electronica = electronica;
        this.rock = rock;
        this.pop = pop;
        this.jazz = jazz;
        this.clasica = clasica;
        this.latina = latina;
    }
   
    /*
    public UsuarioRegistro(String idUsuario, boolean electronica, boolean rock, boolean pop, boolean jazz, boolean clasica, boolean latina) {
        this.nombreUsuario = idUsuario;
        this.electronica = electronica;
        this.rock = rock;
        this.pop = pop;
        this.jazz = jazz;
        this.clasica = clasica;
        this.latina = latina;
    }
    */
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

   
    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public void setNombreUsuario(String idUsuario) {
        this.nombreUsuario = idUsuario;
    }

    public boolean isElectronica() {
        return electronica;
    }

    public void setElectronica(boolean electronica) {
        this.electronica = electronica;
    }

    public boolean isRock() {
        return rock;
    }

    public void setRock(boolean rock) {
        this.rock = rock;
    }

    public boolean isPop() {
        return pop;
    }

    public void setPop(boolean pop) {
        this.pop = pop;
    }

    public boolean isJazz() {
        return jazz;
    }

    public void setJazz(boolean jazz) {
        this.jazz = jazz;
    }

    public boolean isClasica() {
        return clasica;
    }

    public void setClasica(boolean clasica) {
        this.clasica = clasica;
    }

    public boolean isLatina() {
        return latina;
    }

    public void setLatina(boolean latina) {
        this.latina = latina;
    }

    public void RegistrarPreferencias(UsuarioRegistro pDatos){
        try {
            PreparedStatement comandoInsertPreparado =null;
            Clases.ConexionBD pConexion = new Clases.ConexionBD();
            
            String comandoInsert = "INSERT INTO preferenciasmusicales(nombreusuario,electronica,pop,jazz,rock,clasica,latina)VALUE(?,?,?,?,?,?,?);";
            
            comandoInsertPreparado=pConexion.establecerConexion().prepareStatement(comandoInsert); 
           
            
            comandoInsertPreparado.setString(1, pDatos.nombreUsuario);
            comandoInsertPreparado.setBoolean(2, pDatos.electronica);
            comandoInsertPreparado.setBoolean(3, pDatos.pop);
            comandoInsertPreparado.setBoolean(4, pDatos.jazz);
            comandoInsertPreparado.setBoolean(5, pDatos.rock);
            comandoInsertPreparado.setBoolean(6, pDatos.clasica);
            comandoInsertPreparado.setBoolean(7, pDatos.latina);
            
            comandoInsertPreparado.executeUpdate();
           
        
        } catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    }

    @Override
    public String toString() {
        return "UsuarioRegistro{" + "nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", Contrasena=" + Contrasena + ", electronica=" + electronica + ", rock=" + rock + ", pop=" + pop + ", jazz=" + jazz + ", clasica=" + clasica + ", latina=" + latina + '}';
    }
    
    
   
    
    
    
}
