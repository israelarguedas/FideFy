/*
 * @author Grupo_2
 * @author Isra Arguedas
 */
package Clases;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Cancion implements Comparable<Cancion>, Serializable{
    private String Titulo;
    private String Artista;
    private String Album;
    private String AnoLanzamiento;
    private String Genero;
    private int MeGusta;
    private int ID;

    public Cancion() {
    }

    public Cancion(String Titulo, String Artista, String Album, String AnoLanzamiento, String Genero, int MeGusta, int ID) {
        this.Titulo = Titulo;
        this.Artista = Artista;
        this.Album = Album;
        this.AnoLanzamiento = AnoLanzamiento;
        this.Genero = Genero;
        this.MeGusta = MeGusta;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String Album) {
        this.Album = Album;
    }

    public String getAnoLanzamiento() {
        return AnoLanzamiento;
    }

    public void setAnoLanzamiento(String AnoLanzamiento) {
        this.AnoLanzamiento = AnoLanzamiento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int isMeGusta() {
        return MeGusta;
    }

    public void setMeGusta(int MeGusta) {
        this.MeGusta = MeGusta;
    }


    @Override
    public int compareTo(Cancion NuevaCancion) {
        return this.Titulo.compareTo(NuevaCancion.getTitulo());
    }
    
    @Override
    public boolean equals (Object NuevaCancion) {
        Cancion vCancion_equal = (Cancion) NuevaCancion;
        return vCancion_equal.getTitulo().equals(this.Titulo);
    }

    @Override
    public String toString() {
        return "Cancion{" + "Titulo=" + Titulo + ", Artista=" + Artista + ", Album=" + Album + ", AnoLanzamiento=" + AnoLanzamiento + ", Genero=" + Genero + ", MeGusta=" + MeGusta + ", ID=" + ID + '}';
    }
    
}

