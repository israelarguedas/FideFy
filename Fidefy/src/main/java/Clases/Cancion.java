/*
 * @author Grupo_2
 * @author Isra Arguedas
 */
package Clases;

public class Cancion implements Comparable<Cancion>{
    private String Titulo;
    private String Artista;
    private String Album;
    private String AnoLanzamiento;
    private String Genero;
    private boolean MeGusta;
    private int ArtistaID;
    private int ComentarioID;

    public Cancion() {
    }

    public Cancion(String Titulo, String Artista, String Album, String AnoLanzamiento, String Genero, boolean MeGusta, int ArtistaID, int ComentarioID) {
        this.Titulo = Titulo;
        this.Artista = Artista;
        this.Album = Album;
        this.AnoLanzamiento = AnoLanzamiento;
        this.Genero = Genero;
        this.MeGusta = MeGusta;
        this.ArtistaID = ArtistaID;
        this.ComentarioID = ComentarioID;
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

    public boolean isMeGusta() {
        return MeGusta;
    }

    public void setMeGusta(boolean MeGusta) {
        this.MeGusta = MeGusta;
    }

    public int getArtistaID() {
        return ArtistaID;
    }

    public void setArtistaID(int ArtistaID) {
        this.ArtistaID = ArtistaID;
    }

    public int getComentarioID() {
        return ComentarioID;
    }

    public void setComentarioID(int ComentarioID) {
        this.ComentarioID = ComentarioID;
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
}

