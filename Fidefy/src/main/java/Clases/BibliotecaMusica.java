/*
 * @author Grupo_2
 * @author Isra Arguedas
 */

package Clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BibliotecaMusica {
    private ArrayList<Cancion> miBiblioteca;

    public BibliotecaMusica() {
    }

    public BibliotecaMusica(ArrayList<Cancion> miBiblioteca) {
        this.miBiblioteca = miBiblioteca;
    }

    public ArrayList<Cancion> getMiBiblioteca() {
        return miBiblioteca;
    }

    public void setMiBiblioteca(ArrayList<Cancion> miBiblioteca) {
        this.miBiblioteca = miBiblioteca;
    }
    /*
    public void agregar_cancion(Cancion NuevaCancion){
        this.miBiblioteca.add(NuevaCancion);
        NuevaCancion.setMeGusta(true);
        JOptionPane.showMessageDialog(null,
                "La cancion " + NuevaCancion.getTitulo() + " ha sido agregado a la biblioteca");
    }
    
    public void remover_cancion(Cancion NuevaCancion){
        this.miBiblioteca.remove(NuevaCancion);
        NuevaCancion.setMeGusta(false);
        JOptionPane.showMessageDialog(null,
                "La cancion " + NuevaCancion.getTitulo() + " ha sido removida de la biblioteca");
    }    
    */
}

