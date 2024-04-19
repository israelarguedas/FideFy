/*
 * @author Grupo_2
 * @author Isra Arguedas
 */
package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Cancion implements Comparable<Cancion>{
    private String Titulo;
    private String Artista;
    private String Album;
    private String AnoLanzamiento;
    private String Genero;
    private int MeGusta;

    public Cancion() {
    }

    public Cancion(String Titulo, String Artista, String Album, String AnoLanzamiento, String Genero, int MeGusta) {
        this.Titulo = Titulo;
        this.Artista = Artista;
        this.Album = Album;
        this.AnoLanzamiento = AnoLanzamiento;
        this.Genero = Genero;
        this.MeGusta = MeGusta;
 
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
    
    public void BuscarCancion(Cancion nuevaCancion){
        try {
            //Crear coneccion a la Base de Datos
            Clases.ConexionBD nuevaConexion = new Clases.ConexionBD();
            
            //Crear PreparedStatement
            PreparedStatement comandoSelectPreparado = null;
            
            //Comando SELECT
            String comandoSelect =  "SELECT artista,album FROM canciones WHERE titulo = ?";
            comandoSelectPreparado = nuevaConexion.establecerConexion().prepareStatement(comandoSelect);

            //Definimos los parametros
            comandoSelectPreparado.setString(1,nuevaCancion.getTitulo());
            
            ResultSet resultado = comandoSelectPreparado.executeQuery();
            
            if(resultado.next()){
                nuevaCancion.setArtista(resultado.getString("artista"));
                nuevaCancion.setAlbum(resultado.getString("album"));
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible encontrar el registro indicado.");
            }
                    
        } catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    
    }
}

