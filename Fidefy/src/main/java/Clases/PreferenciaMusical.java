/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.PreparedStatement;

/**
 *
 * @author mhernandez
 */
public class PreferenciaMusical {
    
    private String nombreUsuario;
    private boolean electronica;
    private boolean rock;
    private boolean pop;
    private boolean jazz;
    private boolean clasica;
    private boolean latina;

    public PreferenciaMusical() {
    }

    public PreferenciaMusical(String idUsuario, boolean electronica, boolean rock, boolean pop, boolean jazz, boolean clasica, boolean latina) {
        this.nombreUsuario = idUsuario;
        this.electronica = electronica;
        this.rock = rock;
        this.pop = pop;
        this.jazz = jazz;
        this.clasica = clasica;
        this.latina = latina;
    }

    public String getIdUsuario() {
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

    public void RegistrarPreferencias(PreferenciaMusical pDatos){
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
    
    
   
    
    
    
}
