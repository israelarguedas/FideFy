/*
 * @author Grupo_2
 * @author Isra Arguedas
 */
package Clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Album {
    private ArrayList<Cancion> miAlbum;
    
    private String Titulo;
    private String Artista;
    private String AnoLanzamiento;
    private String Genero;
    private int ArtistaID;

    public Album() {
    }

    public Album(ArrayList<Cancion> miAlbum) {
        this.miAlbum = miAlbum;
    }

    public Album(ArrayList<Cancion> miAlbum, String Titulo, String Artista, String AnoLanzamiento, String Genero, int ArtistaID) {
        this.miAlbum = miAlbum;
        this.Titulo = Titulo;
        this.Artista = Artista;
        this.AnoLanzamiento = AnoLanzamiento;
        this.Genero = Genero;
        this.ArtistaID = ArtistaID;
    }

    public ArrayList<Cancion> getMiAlbum() {
        return miAlbum;
    }

    public void setMiAlbum(ArrayList<Cancion> miAlbum) {
        this.miAlbum = miAlbum;
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

    public int getArtistaID() {
        return ArtistaID;
    }

    public void setArtistaID(int ArtistaID) {
        this.ArtistaID = ArtistaID;
    }

    public void agregar_cancion(Cancion NuevaCancion){
        this.miAlbum.add(NuevaCancion);
        JOptionPane.showMessageDialog(null,
                "La cancion " + NuevaCancion.getTitulo() + " ha sido agregado al album");
    }
    
    public void remover_cancion(Cancion NuevaCancion){
        this.miAlbum.remove(NuevaCancion);
        JOptionPane.showMessageDialog(null,
                "La cancion " + NuevaCancion.getTitulo() + " ha sido removida del album");
    }
    
    
}
