/*
 * @author israel.arguedas
 */

package Clases;

import java.io.Serializable;

public class ComentariosCanciones implements Serializable{
    private String usuarioComenta;
    private String tituloCancion;
    private String comentario;

    public ComentariosCanciones() {
    }

    public ComentariosCanciones(String usuarioComenta, String tituloCancion, String comentario) {
        this.usuarioComenta = usuarioComenta;
        this.tituloCancion = tituloCancion;
        this.comentario = comentario;
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
