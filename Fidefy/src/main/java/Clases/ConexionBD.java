/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class ConexionBD {
    Connection conectar;
    
    String usuario = "root";
    String contrasena = "Puertaysilla0602";
    String bd = "fidefy";
    String ip = "127.0.0.1";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+ ":"+puerto+"/"+bd+"?serverTimezone=UTC";
    
    public Connection establecerConexion(){
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasena);
               //JOptionPane.showMessageDialog(null, "se establecio conexion");     
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Problema en la conexion"+e.toString());
        }
        return conectar;
    }
}
