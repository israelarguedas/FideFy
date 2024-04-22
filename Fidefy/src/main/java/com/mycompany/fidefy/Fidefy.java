/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fidefy;

import Frames.Login;
import Frames.PerfilUsuario;
import Frames.VentanaServidor;

/**
 *
 * @author Grupo_2
 */
public class Fidefy {

    public static void main(String[] args) {
        
        //Se importan clases de frames a mostrar
        VentanaServidor vVentanaLogs = new VentanaServidor();
        Login vVentanaLogin = new Login();
        
        //Se muestran las ventanas
        vVentanaLogs.setVisible(true);
        vVentanaLogin.setVisible(true);
        
        //PerfilUsuario perfil = new PerfilUsuario("aplomrk", 1
        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setVisible(true);
        
        
        
        
    }
        
}
