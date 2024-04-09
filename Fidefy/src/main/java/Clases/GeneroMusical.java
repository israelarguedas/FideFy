/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author mhernandez
 */
public class GeneroMusical {
    
    private String nombreUsuario;
    private boolean electronica;
    private boolean rock;
    private boolean pop;
    private boolean jazz;
    private boolean clasica;
    private boolean latina;

    public GeneroMusical() {
    }

    public GeneroMusical(String idUsuario, boolean electronica, boolean rock, boolean pop, boolean jazz, boolean clasica, boolean latina) {
        this.nombreUsuario = idUsuario;
        this.electronica = electronica;
        this.rock = rock;
        this.pop = pop;
        this.jazz = jazz;
        this.clasica = clasica;
        this.latina = latina;
    }

    public String getIdUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String idUsuario) {
        this.nombreUsuario = idUsuario;
    }

    public boolean isElectronica() {
        return electronica;
    }

    public void setElectronica(boolean electronica) {
        this.electronica = electronica;
    }

    public boolean isRock() {
        return rock;
    }

    public void setRock(boolean rock) {
        this.rock = rock;
    }

    public boolean isPop() {
        return pop;
    }

    public void setPop(boolean pop) {
        this.pop = pop;
    }

    public boolean isJazz() {
        return jazz;
    }

    public void setJazz(boolean jazz) {
        this.jazz = jazz;
    }

    public boolean isClasica() {
        return clasica;
    }

    public void setClasica(boolean clasica) {
        this.clasica = clasica;
    }

    public boolean isLatina() {
        return latina;
    }

    public void setLatina(boolean latina) {
        this.latina = latina;
    }

    @Override
    public String toString() {
        return "GeneroMusical{" + "idUsuario=" + nombreUsuario + ", electronica=" + electronica + ", rock=" + rock + ", pop=" + pop + ", jazz=" + jazz + ", clasica=" + clasica + ", latina=" + latina + '}';
    }
    
    
   
    
    
    
}
