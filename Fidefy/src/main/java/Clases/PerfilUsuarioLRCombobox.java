/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author mhernandez
 */
public class PerfilUsuarioLRCombobox {
    
    private int idLista;
    private PerfilUsuarioLR lista;

    public PerfilUsuarioLRCombobox() {
    }
    

    public PerfilUsuarioLRCombobox(int idLista, PerfilUsuarioLR lista) {
        this.idLista = idLista;
        this.lista = lista;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public PerfilUsuarioLR getLista() {
        return lista;
    }

    public void setLista(PerfilUsuarioLR lista) {
        this.lista = lista;
    }
    
    
    
}
