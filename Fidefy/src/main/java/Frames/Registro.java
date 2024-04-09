/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.ExcepcionUsuarioDuplicado;
import Clases.PreferenciaMusical;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class Registro extends javax.swing.JFrame {

    PreferenciaMusical guardarGeneros = new PreferenciaMusical();
    Clases.Usuario pUsuario = new Clases.Usuario();
    Clases.Usuario pDato = new Clases.Usuario();
    
    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        cbxElectronica = new javax.swing.JCheckBox();
        cbxRock = new javax.swing.JCheckBox();
        cbxPop = new javax.swing.JCheckBox();
        cbxClasica = new javax.swing.JCheckBox();
        cbxJazz = new javax.swing.JCheckBox();
        cbxLatina = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnCrearUsuario = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtConfirmarContrasena = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 51, 19));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setBackground(new java.awt.Color(2, 51, 19));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registrate para escuchar contenido");

        jLabel3.setBackground(new java.awt.Color(2, 51, 19));
        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese un nombre de usuario:");

        jLabel4.setBackground(new java.awt.Color(2, 51, 19));
        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Digite su contraseña:");

        txtNombreUsuario.setBackground(new java.awt.Color(48, 87, 48));
        txtNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(2, 51, 19));
        btnCancelar.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelor");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbxElectronica.setForeground(new java.awt.Color(255, 255, 255));
        cbxElectronica.setText("Electronica");
        cbxElectronica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxElectronicaActionPerformed(evt);
            }
        });

        cbxRock.setForeground(new java.awt.Color(255, 255, 255));
        cbxRock.setText("Rock");

        cbxPop.setForeground(new java.awt.Color(255, 255, 255));
        cbxPop.setText("Pop");

        cbxClasica.setForeground(new java.awt.Color(255, 255, 255));
        cbxClasica.setText("Clasica");

        cbxJazz.setForeground(new java.awt.Color(255, 255, 255));
        cbxJazz.setText("Jazz");
        cbxJazz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxJazzActionPerformed(evt);
            }
        });

        cbxLatina.setForeground(new java.awt.Color(255, 255, 255));
        cbxLatina.setText("Latina");
        cbxLatina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLatinaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("¿Qué te gustaria escuchar?");

        txtContrasena.setBackground(new java.awt.Color(48, 87, 48));
        txtContrasena.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(255, 255, 255));

        btnCrearUsuario.setBackground(new java.awt.Color(2, 51, 19));
        btnCrearUsuario.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        btnCrearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(2, 51, 19));
        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ingrese su nombre:");

        txtNombre.setBackground(new java.awt.Color(48, 87, 48));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtConfirmarContrasena.setBackground(new java.awt.Color(48, 87, 48));
        txtConfirmarContrasena.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtConfirmarContrasena.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(2, 51, 19));
        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirme su contraseña:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCrearUsuario)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(90, 90, 90))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxElectronica, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxRock, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbxClasica, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxLatina, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbxPop, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxJazz, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxElectronica)
                    .addComponent(cbxPop)
                    .addComponent(cbxJazz))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxRock)
                    .addComponent(cbxClasica)
                    .addComponent(cbxLatina))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearUsuario)
                    .addComponent(btnCancelar))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void cbxElectronicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxElectronicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxElectronicaActionPerformed

    private void cbxJazzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxJazzActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxJazzActionPerformed

    private void cbxLatinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLatinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLatinaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        Login pLogin = new Login();
        pLogin.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed

    if(new String(txtContrasena.getPassword()).equals(new String(txtConfirmarContrasena.getPassword()))) {
        // Las contraseñas coinciden

            // Prepara la información del usuario en pUsuario
            String contrasena = String.valueOf(txtContrasena.getPassword());
            pUsuario.setNombreUsuario(txtNombreUsuario.getText());
            pUsuario.setNombre(txtNombre.getText());
            pUsuario.setContrasena(contrasena);

            // Intenta registrar en la base de datos y valid si el nombreUsuario existe
            try {
                
                pUsuario.AgregarUsuario(pUsuario);
                alimentarGenerosUsuario();
                
                // Limpia las casillas de la interfaz después del registro exitoso
                txtNombre.setText("");
                txtNombreUsuario.setText("");
                txtContrasena.setText("");
                txtConfirmarContrasena.setText("");
                cbxClasica.setSelected(false);
                cbxElectronica.setSelected(false);
                cbxJazz.setSelected(false);
                cbxLatina.setSelected(false);
                cbxPop.setSelected(false);
                cbxRock.setSelected(false);
                        
                JOptionPane.showMessageDialog(this, "El usuario: "+pUsuario.getNombreUsuario()+ "se registro con exito!");
                
            } catch (ExcepcionUsuarioDuplicado e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                txtNombreUsuario.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "EROR:" +e);
            }


    } else {
        // Las contraseñas no coinciden
        JOptionPane.showMessageDialog(this, "La contraseña digitada no coincide, intente de nuevo");
        txtContrasena.setText("");
        txtConfirmarContrasena.setText("");
    }   
 
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }
    
    public void alimentarGenerosUsuario(){
        
        guardarGeneros.setNombreUsuario(pUsuario.getNombreUsuario());
        guardarGeneros.setClasica(cbxClasica.isSelected());
        guardarGeneros.setElectronica(cbxElectronica.isSelected());
        guardarGeneros.setJazz(cbxJazz.isSelected());
        guardarGeneros.setLatina(cbxLatina.isSelected());
        guardarGeneros.setPop(cbxPop.isSelected());
        guardarGeneros.setRock(cbxRock.isSelected());
        
        guardarGeneros.RegistrarPreferencias(guardarGeneros);
        
        //Requiere una tabla de generosMusicales en la BD que lleva el control de los generos y usuarios
        
    }       
        


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JCheckBox cbxClasica;
    private javax.swing.JCheckBox cbxElectronica;
    private javax.swing.JCheckBox cbxJazz;
    private javax.swing.JCheckBox cbxLatina;
    private javax.swing.JCheckBox cbxPop;
    private javax.swing.JCheckBox cbxRock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtConfirmarContrasena;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
