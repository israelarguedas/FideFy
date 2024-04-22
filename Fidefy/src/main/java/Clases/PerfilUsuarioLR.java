/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author mhernandez
 */
public class PerfilUsuarioLR {
    
    //Clase para almacenar resultado de consulta a SQL
    
    private int idLista;
    private String nombreLista;


    public PerfilUsuarioLR() {
    }

    public PerfilUsuarioLR(int idLista, String nombreLista) {
        this.idLista = idLista;
        this.nombreLista = nombreLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    @Override
    public String toString() {
        return nombreLista;
    }
    
    
    
}
