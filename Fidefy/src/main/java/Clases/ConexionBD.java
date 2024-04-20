/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author josue
 */
public class ConexionBD {
    Connection conectar;

    String usuario = "root";
    String contrasena = "Lobotmy@1";
    String bd = "fidefy";
    String ip = "127.0.0.1";
    String puerto = "3306";

    
    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd + "?serverTimezone=UTC";

    public Connection establecerConexion() {
        try {
            //Compatibilidad por error que me dio
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            System.out.println("Se establecio conexion con la BD");
        } catch (Exception e) {
            System.out.println("Problema en la conexión: " + e.toString());
        }
        return conectar;
    }
}