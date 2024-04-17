/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Grupo_2
 */
public class ComentariosPlayList {
    
    private String usuarioComenta;
    private String usuarioComentado;
    private String nombrePlaylist;
    private String comentario;

    public ComentariosPlayList() {
    }

    public ComentariosPlayList(String usuarioComenta, String usuarioComentado, String nombrePlaylist, String comentario) {
        this.usuarioComenta = usuarioComenta;
        this.usuarioComentado = usuarioComentado;
        this.nombrePlaylist = nombrePlaylist;
        this.comentario = comentario;
    }

    public String getUsuarioComenta() {
        return usuarioComenta;
    }

    public void setUsuarioComenta(String usuarioComenta) {
        this.usuarioComenta = usuarioComenta;
    }

    public String getUsuarioComentado() {
        return usuarioComentado;
    }

    public void setUsuarioComentado(String usuarioComentado) {
        this.usuarioComentado = usuarioComentado;
    }

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public void setNombrePlaylist(String nombrePlaylist) {
        this.nombrePlaylist = nombrePlaylist;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    
}
