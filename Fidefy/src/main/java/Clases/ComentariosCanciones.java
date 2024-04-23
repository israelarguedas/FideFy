/*
 * @author israel.arguedas
 */

package Clases;

import java.io.Serializable;

public class ComentariosCanciones implements Serializable{
    private String usuarioComenta;
    private String tituloCancion;
    private String comentario;
    private int IDcancion;
    private int IDusuario;

    public ComentariosCanciones() {
    }

    public ComentariosCanciones(String usuarioComenta, String tituloCancion, String comentario, int IDcancion, int IDusuario) {
        this.usuarioComenta = usuarioComenta;
        this.tituloCancion = tituloCancion;
        this.comentario = comentario;
        this.IDcancion = IDcancion;
        this.IDusuario = IDusuario;
    }

    public int getIDcancion() {
        return IDcancion;
    }

    public void setIDcancion(int IDcancion) {
        this.IDcancion = IDcancion;
    }

    public int getIDusuario() {
        return IDusuario;
    }

    public void setIDusuario(int IDusuario) {
        this.IDusuario = IDusuario;
    }


    public String getUsuarioComenta() {
        return usuarioComenta;
    }

    public void setUsuarioComenta(String usuarioComenta) {
        this.usuarioComenta = usuarioComenta;
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public void setTituloCancion(String tituloCancion) {
        this.tituloCancion = tituloCancion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "ComentariosCanciones{" + "usuarioComenta=" + usuarioComenta + ", tituloCancion=" + tituloCancion + ", comentario=" + comentario + '}';
    }
    
    
}
