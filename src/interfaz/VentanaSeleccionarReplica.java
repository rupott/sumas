package interfaz;

import dominio.Partida;
import dominio.Sistema;
import javax.swing.JOptionPane;

public class VentanaSeleccionarReplica extends javax.swing.JFrame {

    private Sistema sistema;

    public VentanaSeleccionarReplica(Sistema miSistema) {
        initComponents();
        this.sistema = miSistema;
        //Cargo lista si no es vacia, else muestro mensaje
        if (!this.sistema.getListaPartidas().isEmpty()) {
            lstListaPartidas.setListData(this.sistema.getListaPartidas().toArray());
            lblMsgNoPartidas.setVisible(false);
        } else {
            lblMsgNoPartidas.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMsgNoPartidas = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstListaPartidas = new javax.swing.JList();
        lblPartidasReplicar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 15, 41));

        lblMsgNoPartidas.setForeground(new java.awt.Color(255, 0, 0));
        lblMsgNoPartidas.setText("No se ha jugado ninguna partida");

        btnAtras.setBackground(new java.awt.Color(255, 248, 146));
        btnAtras.setForeground(new java.awt.Color(0, 15, 41));
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(255, 248, 146));
        btnConfirmar.setForeground(new java.awt.Color(0, 15, 41));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lstListaPartidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(lstListaPartidas);

        lblPartidasReplicar.setForeground(new java.awt.Color(255, 248, 146));
        lblPartidasReplicar.setText("Partidas disponibles para replicar:");

        lblTitulo.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 248, 146));
        lblTitulo.setText("Replicar partida");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPartidasReplicar)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lblMsgNoPartidas)))
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblPartidasReplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMsgNoPartidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnConfirmar))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //si cierran con la x van para atras
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?\n",
                "Confirmar salir", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (lstListaPartidas.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una partida para continuar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            //guardo la partida que voy a replicar
            Partida partidaReplicar = (Partida) lstListaPartidas.getSelectedValue();
            this.sistema.setPartida(partidaReplicar);
            //creo una partida nueva en replicada
            this.sistema.setReplicada(new Partida(partidaReplicar.getConfiguracion(), partidaReplicar.getJugadorRojo(), partidaReplicar.getJugadorAzul()));
            //esta ventana la cierro y abro la otra
            this.dispose();
            VentanaReplicarPartida ventana = new VentanaReplicarPartida(this.sistema);
            ventana.setVisible(true);
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        //si cierran con la x van para atras
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?\n",
                "Confirmar salir", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMsgNoPartidas;
    private javax.swing.JLabel lblPartidasReplicar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList lstListaPartidas;
    // End of variables declaration//GEN-END:variables
}