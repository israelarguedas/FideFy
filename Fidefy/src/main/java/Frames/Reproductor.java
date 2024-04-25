/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.ConexionBD;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author josue
 */
public class Reproductor extends javax.swing.JFrame {
     ConexionBD basedatos = new ConexionBD();
     private DefaultListModel<String> listModel = new DefaultListModel<>();
    private ArrayList<String> songPaths = new ArrayList<>();
    private Clip clip;
    private boolean isPaused = false;
    private int idUsuarioActual;
    

    public Reproductor() {
        initComponents();
       LstCanciones.setModel(listModel);
       jSlider1.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (!jSlider1.getValueIsAdjusting() && clip != null) {
                // Obtener la nueva posición del JSlider
                int newPosition = jSlider1.getValue();

                // Convertir la nueva posición a microsegundos
                long newPositionMicroseconds = newPosition * 1000000L;

                // Establecer la posición del clip a la nueva posición
                clip.setMicrosecondPosition(newPositionMicroseconds);
            }
        }
    });
    }

    public int getIdUsuarioActual() {
        return idUsuarioActual;
    }

    public void setIdUsuarioActual(int idUsuarioActual) {
        this.idUsuarioActual = idUsuarioActual;
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
        jSlider1 = new javax.swing.JSlider();
        btnAnterior = new javax.swing.JButton();
        btnReproducir = new javax.swing.JButton();
        btnPausar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LstCanciones = new javax.swing.JList<>();
        agregarCanciones = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jSlider2 = new javax.swing.JSlider();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 51, 19));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 290, 20));

        btnAnterior.setBackground(new java.awt.Color(2, 51, 19));
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        btnAnterior.setBorder(null);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        btnReproducir.setBackground(new java.awt.Color(2, 51, 19));
        btnReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play-button-arrowhead.png"))); // NOI18N
        btnReproducir.setBorder(null);
        btnReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproducirActionPerformed(evt);
            }
        });
        jPanel1.add(btnReproducir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        btnPausar.setBackground(new java.awt.Color(2, 51, 19));
        btnPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause-button.png"))); // NOI18N
        btnPausar.setBorder(null);
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, -1));

        btnSiguiente.setBackground(new java.awt.Color(2, 51, 19));
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fast-forward.png"))); // NOI18N
        btnSiguiente.setBorder(null);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        LstCanciones.setBackground(new java.awt.Color(2, 51, 19));
        LstCanciones.setBorder(null);
        LstCanciones.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LstCanciones.setForeground(new java.awt.Color(255, 255, 255));
        LstCanciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(LstCanciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 350, 200));

        agregarCanciones.setText("Agregar canciones");
        agregarCanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCancionesActionPerformed(evt);
            }
        });
        jPanel1.add(agregarCanciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, -1, -1));
        jPanel1.add(jSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 150, -1));

        jButton7.setBackground(new java.awt.Color(2, 51, 19));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volume-mute.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        jButton8.setBackground(new java.awt.Color(2, 51, 19));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volume-up.png"))); // NOI18N
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 50, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 50, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void reproducirCancion(String songPath) {
    try {
        // Obtener un flujo de audio desde el archivo
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(songPath));

        // Abrir el clip de audio
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        // Reproducir el clip desde el principio
        clip.setMicrosecondPosition(0);
        clip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
        ex.printStackTrace();
    }
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        clip.close();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
     if (clip != null && clip.isRunning()) {
        clip.stop();
    }

    int selectedIndex = LstCanciones.getSelectedIndex();
    int previousIndex = selectedIndex - 1;

    // Verificar si hay una canción anterior en la lista
    if (previousIndex >= 0 && previousIndex < listModel.getSize()) {
        // Seleccionar la canción anterior en la lista
        LstCanciones.setSelectedIndex(previousIndex);

        // Reproducir la canción anterior desde el principio
        String selectedSong = LstCanciones.getSelectedValue();
        if (selectedSong != null) {
            String songPath = songPaths.get(previousIndex);
            reproducirCancion(songPath);
        }
    }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void agregarCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCancionesActionPerformed
    JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de audio", "mp3", "wav", "ogg"));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            
            String query = "INSERT INTO songsplaylist(idusuario, file_names, file_locations) VALUES(?,?,?)";

            try (
                Connection conectar = basedatos.establecerConexion();
                PreparedStatement comandoPreparado = conectar.prepareStatement(query)) {

                for (File file : selectedFiles) {
                    comandoPreparado.setInt(1, idUsuarioActual);
                    comandoPreparado.setString(2, file.getName());
                    comandoPreparado.setString(3, file.getAbsolutePath());
                    comandoPreparado.executeUpdate();
                    
                    listModel.addElement(file.getName());
                    songPaths.add(file.getAbsolutePath());
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar canciones a la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } 
    }//GEN-LAST:event_agregarCancionesActionPerformed

    private void btnReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproducirActionPerformed
    String selectedSong = LstCanciones.getSelectedValue();
    if (selectedSong == null) {
        return;
    }

    // Obtener la ruta de la canción seleccionada
    int selectedIndex = LstCanciones.getSelectedIndex();
    String songPath = songPaths.get(selectedIndex);

    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(songPath));

        // Abrir el clip de audio
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        // Reproducir el clip
        clip.start();

        // Obtener la duración de la canción y ajustar el máximo del JSlider
        long duration = clip.getMicrosecondLength() / 1_000_000; // Convertir la duración a segundos
        jSlider1.setMaximum((int) duration);

    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
        ex.printStackTrace();
    }

    }//GEN-LAST:event_btnReproducirActionPerformed

    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed
        if (clip != null) {
        if (isPaused) {
            // Si la canción está pausada, la reanudamos
            clip.start();
            isPaused = false;
        } else {
            // Si la canción está en reproducción, la pausamos
            clip.stop();
            isPaused = true;
        }
    }
    }//GEN-LAST:event_btnPausarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
      if (clip != null && clip.isRunning()) {
        clip.stop();
    }

    int selectedIndex = LstCanciones.getSelectedIndex();
    int nextIndex = selectedIndex + 1;

    // Verificar si hay una siguiente canción en la lista
    if (nextIndex >= 0 && nextIndex < listModel.getSize()) {
        // Seleccionar la siguiente canción en la lista
        LstCanciones.setSelectedIndex(nextIndex);

        // Reproducir la siguiente canción
        btnReproducirActionPerformed(evt);
    }
    }//GEN-LAST:event_btnSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reproductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> LstCanciones;
    private javax.swing.JButton agregarCanciones;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnPausar;
    private javax.swing.JButton btnReproducir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    // End of variables declaration//GEN-END:variables
}
