/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.Cancion;
import Clases.ComentariosCanciones;
import Clases.UsuarioInicioSesion;
import java.awt.Color;
import java.io.ObjectOutputStream;
import static java.lang.Integer.parseInt;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author israel.arguedas
 */
public class Canciones extends javax.swing.JFrame {
    private Cancion nuevaCancion;
    private int usuarioActual;
    /**
     * Creates new form Canciones
     */
    public Canciones() {
        initComponents();
    }

    public Canciones(Cancion nuevaCancion, int usuarioActual) {
        this.nuevaCancion = nuevaCancion;
        this.lblTitulo.setText(nuevaCancion.getTitulo());
        this.lblAlbum.setText(nuevaCancion.getAlbum());
        this.lblArtista.setText(nuevaCancion.getArtista()); 
        this.lblMeGusta.setText(nuevaCancion.isMeGusta()+"");
        this.usuarioActual = usuarioActual;
    }
    
    
   public Canciones(Cancion nuevaCancion) {
        initComponents();
        this.nuevaCancion = nuevaCancion;
        this.lblTitulo.setText(nuevaCancion.getTitulo());
        this.lblAlbum.setText(nuevaCancion.getAlbum());
        this.lblArtista.setText(nuevaCancion.getArtista()); 
        this.lblMeGusta.setText(nuevaCancion.isMeGusta()+"");
    }

    public int getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(int usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnIcono = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblAlbum = new javax.swing.JLabel();
        lblArtista = new javax.swing.JLabel();
        btnMeGusta = new javax.swing.JButton();
        btnComentario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaComentario = new javax.swing.JTextArea();
        btnVolver = new javax.swing.JButton();
        lblMeGusta = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 51, 19));
        jPanel1.setForeground(new java.awt.Color(2, 51, 19));

        btnIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono.png"))); // NOI18N
        btnIcono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIconoActionPerformed(evt);
            }
        });

        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Titulo");

        lblAlbum.setForeground(new java.awt.Color(255, 255, 255));
        lblAlbum.setText("Album");

        lblArtista.setForeground(new java.awt.Color(255, 255, 255));
        lblArtista.setText("Artista");

        btnMeGusta.setText("Me Gusta:");
        btnMeGusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeGustaActionPerformed(evt);
            }
        });

        btnComentario.setText("Agregar comentario");
        btnComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentarioActionPerformed(evt);
            }
        });

        txaComentario.setColumns(20);
        txaComentario.setRows(5);
        jScrollPane1.setViewportView(txaComentario);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblMeGusta.setForeground(new java.awt.Color(255, 255, 255));
        lblMeGusta.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlbum)
                            .addComponent(lblArtista)
                            .addComponent(lblTitulo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnMeGusta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMeGusta)))))
                .addGap(0, 97, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnComentario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAlbum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblArtista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMeGusta)
                    .addComponent(lblMeGusta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComentario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIconoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIconoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIconoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentarioActionPerformed
        //Instanciar Comentario de Cancion
        ComentariosCanciones nuevoComentario = new ComentariosCanciones();
        nuevoComentario.setComentario(txaComentario.getText());
        nuevoComentario.setIDcancion(nuevaCancion.getID());
        nuevoComentario.setIDusuario(usuarioActual);
        
        //JOptionPane.showMessageDialog(null, "Usuario actual: " + usuarioActual);
        //JOptionPane.showMessageDialog(null, "Comentario actual 2" + nuevoComentario.toString());
        
        //Crear un nuevo Socket
        Socket vNuevoSocket;
        
        try {
        vNuevoSocket = new Socket("127.0.0.1", 15575);//LOCALHOST
        
        //Enviar el objeto al servidor
        ObjectOutputStream vObjectOutput = new ObjectOutputStream(vNuevoSocket.getOutputStream());
        vObjectOutput.writeObject(nuevoComentario);
        
        } catch (Exception Error) {
            JOptionPane.showMessageDialog(null, "Error cliente:" + Error);
            }
    }//GEN-LAST:event_btnComentarioActionPerformed

    private void btnMeGustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeGustaActionPerformed
        if (btnMeGusta.getText().equals("Me Gusta:")) {
            AgregarMeGusta(nuevaCancion);
            btnMeGusta.setText("No Me Gusta:");
            btnMeGusta.setForeground(Color.red);
            lblMeGusta.setText(nuevaCancion.isMeGusta()+"");
            
        }else{
            QuitarMeGusta(nuevaCancion);
            btnMeGusta.setText("Me Gusta:");
            btnMeGusta.setForeground(Color.black);
            lblMeGusta.setText(nuevaCancion.isMeGusta()+"");
        }
    }//GEN-LAST:event_btnMeGustaActionPerformed
    
    private void AgregarMeGusta(Cancion nuevaCancion){
        int meGusta = this.nuevaCancion.isMeGusta();
        meGusta = meGusta + 1;
        this.nuevaCancion.setMeGusta(meGusta);
        
        try {
            //Crear coneccion a la Base de Datos
            Clases.ConexionBD nuevaConexion = new Clases.ConexionBD();
            
            //Crear PreparedStatement
            PreparedStatement comandoUpdatePreparado = null;
            
            //Comando SELECT
            String comandoUpdate =  "Update canciones SET megusta = ? WHERE titulo = ?";
            comandoUpdatePreparado = nuevaConexion.establecerConexion().prepareStatement(comandoUpdate);

            //Definimos los parametros
            comandoUpdatePreparado.setInt(1,nuevaCancion.isMeGusta());
            comandoUpdatePreparado.setString(2,nuevaCancion.getTitulo());
            
            comandoUpdatePreparado.executeUpdate();
                    
        } catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    private void QuitarMeGusta(Cancion nuevaCancion){
        int meGusta = this.nuevaCancion.isMeGusta();
        meGusta = meGusta - 1;
        this.nuevaCancion.setMeGusta(meGusta);
        
        try {
            //Crear coneccion a la Base de Datos
            Clases.ConexionBD nuevaConexion = new Clases.ConexionBD();
            
            //Crear PreparedStatement
            PreparedStatement comandoUpdatePreparado = null;
            
            //Comando SELECT
            String comandoUpdate =  "Update canciones SET megusta = ? WHERE titulo = ?";
            comandoUpdatePreparado = nuevaConexion.establecerConexion().prepareStatement(comandoUpdate);

            //Definimos los parametros
            comandoUpdatePreparado.setInt(1,nuevaCancion.isMeGusta());
            comandoUpdatePreparado.setString(2,nuevaCancion.getTitulo());
            
            comandoUpdatePreparado.executeUpdate();
                    
        } catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Canciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Canciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Canciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Canciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Canciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComentario;
    private javax.swing.JButton btnIcono;
    private javax.swing.JButton btnMeGusta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlbum;
    private javax.swing.JLabel lblArtista;
    private javax.swing.JLabel lblMeGusta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txaComentario;
    // End of variables declaration//GEN-END:variables
}
