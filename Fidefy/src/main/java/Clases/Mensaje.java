/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author 100da
 */
public class Mensaje implements Serializable{
    private String emisor;
    private String receptor="";
    private int tema;
    private String contenido;
    private String fecha;

    public Mensaje() {
    }

    public Mensaje(String emisor, String receptor, String contenido, String fecha) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public Mensaje(String emisor, int tema, String contenido, String fecha) {
        this.emisor = emisor;
        this.tema = tema;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
