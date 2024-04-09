/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Grupo_2
 */
public class ListaReproduccion {
    
    private String nombreLista;
    private String visibilidadLista;
    private String comentariosLista;
    private Usuario usuarioPropietario;
    private Cancion cancionesLista;

    public ListaReproduccion() {
    }

    public ListaReproduccion(String nombreLista, String visibilidadLista, String comentariosLista, Usuario usuarioPropietario, Cancion cancionesLista) {
        this.nombreLista = nombreLista;
        this.visibilidadLista = visibilidadLista;
        this.comentariosLista = comentariosLista;
        this.usuarioPropietario = usuarioPropietario;
        this.cancionesLista = cancionesLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public String getVisibilidadLista() {
        return visibilidadLista;
    }

    public void setVisibilidadLista(String visibilidadLista) {
        this.visibilidadLista = visibilidadLista;
    }

    public String getComentariosLista() {
        return comentariosLista;
    }

    public void setComentariosLista(String comentariosLista) {
        this.comentariosLista = comentariosLista;
    }

    public Usuario getUsuarioPropietario() {
        return usuarioPropietario;
    }

    public void setUsuarioPropietario(Usuario usuarioPropietario) {
        this.usuarioPropietario = usuarioPropietario;
    }

    public Cancion getCancionesLista() {
        return cancionesLista;
    }

    public void setCancionesLista(Cancion cancionesLista) {
        this.cancionesLista = cancionesLista;
    }

    @Override
    public String toString() {
        return "ListaReproduccion{" + "nombreLista=" + nombreLista + ", visibilidadLista=" + visibilidadLista + ", comentariosLista=" + comentariosLista + ", usuarioPropietario=" + usuarioPropietario + ", cancionesLista=" + cancionesLista + '}';
    }
    
    
    
    
    
    
}
