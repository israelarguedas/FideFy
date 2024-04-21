/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author 100da
 */
public class InstruccionChat implements Serializable{
    private String emisor;
    private String receptor;
    private int tema;
    private boolean detener=false;

    public InstruccionChat() {
    }

    public InstruccionChat(String emisor, String receptor) {
        this.emisor = emisor;
        this.receptor = receptor;
    }

    public InstruccionChat(String emisor, int tema) {
        this.emisor = emisor;
        this.tema = tema;
        this.receptor="";
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }
    
    public void detener(){
        this.detener=true;
    }
    
    public boolean getDetener(){
        return this.detener;
    }
    
    
    
}
