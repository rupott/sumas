package interfaz;

import dominio.*;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Maria Jose Carbajal Sebastian Curbelo
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Sistema sistema;
    private Clip musicaDeFondo;

    public VentanaPrincipal(Sistema miSistema) {
        initComponents();
        sistema = miSistema;
        try {
            InputStream pista = getClass().getResourceAsStream("/sonidos/tema_juego.wav");
            InputStream bufferPista = new BufferedInputStream(pista);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferPista);
            musicaDeFondo = AudioSystem.getClip();
            musicaDeFondo.open(audioInputStream);
            //Musica prendida al principio
            btnToggleMusic.doClick();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("El archivo de audio no funciona: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenuPrincipal = new javax.swing.JPanel();
        lblSumas = new javax.swing.JLabel();
        lblSumas1 = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        BtnJugarPartida = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnRegistrarJugador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BtnReplicarPartida = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BtnRanking = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnToggleMusic = new javax.swing.JToggleButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(730, 400));
        setMinimumSize(new java.awt.Dimension(730, 400));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelMenuPrincipal.setBackground(new java.awt.Color(182, 241, 255));
        panelMenuPrincipal.setMaximumSize(new java.awt.Dimension(730, 400));
        panelMenuPrincipal.setMinimumSize(new java.awt.Dimension(730, 400));
        panelMenuPrincipal.setLayout(null);

        lblSumas.setFont(new java.awt.Font("Segoe UI Black", 3, 72)); // NOI18N
        lblSumas.setForeground(new java.awt.Color(255, 248, 146));
        lblSumas.setText("S U M A S");
        panelMenuPrincipal.add(lblSumas);
        lblSumas.setBounds(180, 20, 390, 130);

        lblSumas1.setFont(new java.awt.Font("Segoe UI Black", 3, 76)); // NOI18N
        lblSumas1.setForeground(new java.awt.Color(255, 100, 200));
        lblSumas1.setText("S U M A S");
        panelMenuPrincipal.add(lblSumas1);
        lblSumas1.setBounds(170, 20, 440, 130);

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_help.png"))); // NOI18N
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        panelMenuPrincipal.add(btnHelp);
        btnHelp.setBounds(40, 30, 30, 30);

        BtnSalir.setBackground(new java.awt.Color(255, 248, 146));
        BtnSalir.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        BtnSalir.setForeground(new java.awt.Color(237, 0, 140));
        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        panelMenuPrincipal.add(BtnSalir);
        BtnSalir.setBounds(546, 357, 127, 27);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rosado.png"))); // NOI18N
        panelMenuPrincipal.add(jLabel5);
        jLabel5.setBounds(550, 360, 130, 30);

        BtnJugarPartida.setBackground(new java.awt.Color(255, 248, 146));
        BtnJugarPartida.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        BtnJugarPartida.setForeground(new java.awt.Color(0, 15, 41));
        BtnJugarPartida.setText("Jugar partida");
        BtnJugarPartida.setAlignmentY(0.0F);
        BtnJugarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJugarPartidaActionPerformed(evt);
            }
        });
        panelMenuPrincipal.add(BtnJugarPartida);
        BtnJugarPartida.setBounds(10, 244, 282, 27);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rosado.png"))); // NOI18N
        panelMenuPrincipal.add(jLabel3);
        jLabel3.setBounds(14, 247, 285, 30);

        BtnRegistrarJugador.setBackground(new java.awt.Color(255, 248, 146));
        BtnRegistrarJugador.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        BtnRegistrarJugador.setForeground(new java.awt.Color(0, 15, 41));
        BtnRegistrarJugador.setText("Registrar jugador");
        BtnRegistrarJugador.setAlignmentY(0.0F);
        BtnRegistrarJugador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRegistrarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarJugadorActionPerformed(evt);
            }
        });
        panelMenuPrincipal.add(BtnRegistrarJugador);
        BtnRegistrarJugador.setBounds(10, 200, 232, 27);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rosado.png"))); // NOI18N
        panelMenuPrincipal.add(jLabel1);
        jLabel1.setBounds(14, 203, 235, 30);

        BtnReplicarPartida.setBackground(new java.awt.Color(255, 248, 146));
        BtnReplicarPartida.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        BtnReplicarPartida.setForeground(new java.awt.Color(0, 15, 41));
        BtnReplicarPartida.setText("Replicar partida");
        BtnReplicarPartida.setAlignmentY(0.0F);
        BtnReplicarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReplicarPartidaActionPerformed(evt);
            }
        });
        panelMenuPrincipal.add(BtnReplicarPartida);
        BtnReplicarPartida.setBounds(10, 287, 335, 27);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rosado.png"))); // NOI18N
        panelMenuPrincipal.add(jLabel4);
        jLabel4.setBounds(14, 290, 338, 30);

        BtnRanking.setBackground(new java.awt.Color(255, 248, 146));
        BtnRanking.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        BtnRanking.setForeground(new java.awt.Color(0, 15, 41));
        BtnRanking.setText("Ranking");
        BtnRanking.setAlignmentY(0.0F);
        BtnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRankingActionPerformed(evt);
            }
        });
        panelMenuPrincipal.add(BtnRanking);
        BtnRanking.setBounds(10, 330, 400, 27);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rosado.png"))); // NOI18N
        panelMenuPrincipal.add(jLabel2);
        jLabel2.setBounds(14, 333, 403, 30);

        btnToggleMusic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_sonido.png"))); // NOI18N
        btnToggleMusic.setBorder(null);
        btnToggleMusic.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnToggleMusicItemStateChanged(evt);
            }
        });
        panelMenuPrincipal.add(btnToggleMusic);
        btnToggleMusic.setBounds(660, 30, 30, 30);

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_2.jpg"))); // NOI18N
        lblFondo.setText("jLabel2");
        panelMenuPrincipal.add(lblFondo);
        lblFondo.setBounds(0, 0, 730, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRankingActionPerformed
        VentanaRanking ventana = new VentanaRanking(this.sistema);
        ventana.setVisible(true);
    }//GEN-LAST:event_BtnRankingActionPerformed

    private void BtnReplicarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReplicarPartidaActionPerformed
        VentanaSeleccionarReplica ventana = new VentanaSeleccionarReplica(this.sistema);
        ventana.setVisible(true);
    }//GEN-LAST:event_BtnReplicarPartidaActionPerformed

    private void BtnRegistrarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarJugadorActionPerformed
        VentanaRegistroJugador ventana = new VentanaRegistroJugador(this.sistema);
        ventana.setVisible(true);
    }//GEN-LAST:event_BtnRegistrarJugadorActionPerformed

    private void BtnJugarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJugarPartidaActionPerformed
        VentanaJugarPartida ventana = new VentanaJugarPartida(this.sistema);
        ventana.setVisible(true);
    }//GEN-LAST:event_BtnJugarPartidaActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        this.salir();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void btnToggleMusicItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnToggleMusicItemStateChanged
        //music on cuando toggle on
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.btnToggleMusic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_sonido.png")));
            musicaDeFondo.start();
            musicaDeFondo.loop(Integer.MAX_VALUE);
        } else {
            this.btnToggleMusic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_mute.png")));
            musicaDeFondo.stop();
        }
    }//GEN-LAST:event_btnToggleMusicItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.salir();

    }//GEN-LAST:event_formWindowClosing

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        //informacion del juego
        JOptionPane.showMessageDialog(null,
                    "Como jugar:\n\n"
                  + "El objetivo del juego depende del modo de terminación elegido. Puedes ganar haciendo que\n "
                  + "una de tus fichas llegue al lado opuesto del tablero, que todas lo hagan o que logres llegar\n "
                  + "con una ficha antes de que se acabe la cantidad de movimientos.\n\n"
                  + "Las fichas tienen solo tres movimientos posibles: adelante, izquierda y derecha.\n"
                  + "Pueden avanzar de a un casillero.\n\n"
                  + "Una vez hecho el movimiento, puedes obtener movimientos adicionales sumando los valores de las\n"
                  + "fichas tuyas y de tu oponente, que esten alineadas con la ficha que acabas de mover.\n"
                  + "Puedes tener tantos movimientos adicionales, como sumas válidas de fichas alineadas!\n\n"
                  + "Ejercita tu mente usando estrategia y el poder de la matemática!\n\n",
                  "Acerca de", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_btnHelpActionPerformed

    public void salir() {
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?",
                "Confirmar salir", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                FileOutputStream ff = new FileOutputStream("archivo_sistema");
                BufferedOutputStream bb = new BufferedOutputStream(ff);
                ObjectOutputStream oo = new ObjectOutputStream(bb);
                oo.writeObject(this.sistema);
                oo.close();
                this.dispose();
                System.exit(0);
            } catch (IOException e) {
                result = JOptionPane.showConfirmDialog(null, "No se pudo guardar el estado del sistema. ¿Salir de todas maneras?",
                        "ATENCION", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    this.dispose();
                    System.exit(0);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnJugarPartida;
    private javax.swing.JButton BtnRanking;
    private javax.swing.JButton BtnRegistrarJugador;
    private javax.swing.JButton BtnReplicarPartida;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JButton btnHelp;
    private javax.swing.JToggleButton btnToggleMusic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblSumas;
    private javax.swing.JLabel lblSumas1;
    private javax.swing.JPanel panelMenuPrincipal;
    // End of variables declaration//GEN-END:variables
}
