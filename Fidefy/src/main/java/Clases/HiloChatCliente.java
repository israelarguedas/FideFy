/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author 100da
 */
public class HiloChatCliente extends Thread{
    private JTextArea ventanaChat;
    private int tema;

    public HiloChatCliente(JTextArea ventanaChat) {
        this.ventanaChat = ventanaChat;
    }

    public JTextArea getVentanaChat() {
        return ventanaChat;
    }

    public void setVentanaChat(JTextArea ventanaChat) {
        this.ventanaChat = ventanaChat;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int pTema) {
        this.tema = pTema;
        //JOptionPane.showMessageDialog(null, this.tema);
    }
    
    
    
    @Override
    public void run(){

        //JOptionPane.showMessageDialog(null, this.tema);
        ServerSocket vSocketCliente;
        try {
            vSocketCliente = new ServerSocket(15576);
            while (true){
                Socket vPeticionCliente = vSocketCliente.accept();
                ObjectInputStream vDeserializador = new ObjectInputStream(vPeticionCliente.getInputStream());
                Mensaje nuevoMensajeRecibido = (Mensaje) vDeserializador.readObject();
                vDeserializador.close();
                vPeticionCliente.close();
                
                if (nuevoMensajeRecibido.getReceptor().equals("")) {//chat tematico
                    if (nuevoMensajeRecibido.getTema()==tema) {
                        ventanaChat.append("["+nuevoMensajeRecibido.getEmisor()+"]: "+nuevoMensajeRecibido.getContenido());
                    }
                    
                }
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(HiloChatCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloChatCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
