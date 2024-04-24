/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author mhernandez
 */
public class UsuarioInicioSesion implements Serializable{
    
    private String NombreUsuario; 
    private String Contrasena;
    private boolean esValido;
    private int ID;

    public UsuarioInicioSesion() {
    }

    public UsuarioInicioSesion(String NombreUsuario, String Contrasena, boolean esValido) {
        this.NombreUsuario = NombreUsuario;
        this.Contrasena = Contrasena;
        this.esValido = esValido;
    }

    public UsuarioInicioSesion(String NombreUsuario, String Contrasena, boolean esValido, int ID) {
        this.NombreUsuario = NombreUsuario;
        this.Contrasena = Contrasena;
        this.esValido = esValido;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public boolean isEsValido() {
        return esValido;
    }

    public void setEsValido(boolean esValido) {
        this.esValido = esValido;
    }

    @Override
    public String toString() {
        return "UsuarioInicioSesion{" + "NombreUsuario=" + NombreUsuario + ", Contrasena=" + Contrasena + ", esValido=" + esValido + ", ID=" + ID + '}';
    }
    
}
