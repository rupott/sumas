package interfaz;

import dominio.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class VentanaJugarPartida extends javax.swing.JFrame {

    private Sistema sistema;
    private Jugador jugadorRojo;
    private Jugador jugadorAzul;
    private Configuracion configuracion;
    private boolean jugadorRojoSeleccionado = false;
    private boolean jugadorAzulSeleccionado = false;
    private boolean cantMovSeleccionada = false;
    private boolean modoSeleccionado = false;
    private int cantMov;
    private int modo;

    public VentanaJugarPartida(Sistema miSistema) {
        initComponents();
        sistema = miSistema;
        //si la lista no es vacia, muestro. Else, muestro mensaje
        if (!sistema.getListaJugadores().isEmpty()) {
            lstListaJugadores.setListData(this.sistema.getListaJugadores().toArray());
            lblMsgNoJugadores.setVisible(false);
        } else {
            lblMsgNoJugadores.setVisible(true);
        }
        //setear combo box para que muestre los modos con la descripcion
        comboModoFinalizacion.addItem("1: Llega una ficha al otro lado");
        comboModoFinalizacion.addItem("2: Llegan todas las fichas al otro lado");
        comboModoFinalizacion.addItem("3: Cantidad de movimientos limitada");
        //el campo cantidad de movimientos solo se activa para el modo 3
        panelCantMov.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblModoFinalizacion = new javax.swing.JLabel();
        comboModoFinalizacion = new javax.swing.JComboBox();
        scrollPanelAzul = new javax.swing.JScrollPane();
        lstListaJugadores = new javax.swing.JList();
        panelCantMov = new javax.swing.JPanel();
        fieldCantMov = new javax.swing.JTextField();
        lblCantMov = new javax.swing.JLabel();
        lblMsgCantMov = new javax.swing.JLabel();
        btnConfirmarAzul = new javax.swing.JButton();
        btnConfirmarRojo = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNombreJugadorRojo = new javax.swing.JLabel();
        lblNombreJugadorAzul = new javax.swing.JLabel();
        lblMsgNoJugadores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 15, 41));
        jPanel1.setForeground(new java.awt.Color(0, 51, 51));

        lblTitulo.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 248, 146));
        lblTitulo.setText("Ajustes de partida");

        lblModoFinalizacion.setForeground(new java.awt.Color(255, 248, 146));
        lblModoFinalizacion.setText("Modo de finalización:");

        comboModoFinalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModoFinalizacionActionPerformed(evt);
            }
        });

        lstListaJugadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scrollPanelAzul.setViewportView(lstListaJugadores);

        panelCantMov.setBackground(new java.awt.Color(0, 15, 41));

        fieldCantMov.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldCantMov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCantMovMouseClicked(evt);
            }
        });

        lblCantMov.setForeground(new java.awt.Color(255, 248, 146));
        lblCantMov.setText("Cantidad de movimientos:");

        lblMsgCantMov.setForeground(new java.awt.Color(255, 0, 0));
        lblMsgCantMov.setText("Ingrese una cantidad mayor a 0");

        javax.swing.GroupLayout panelCantMovLayout = new javax.swing.GroupLayout(panelCantMov);
        panelCantMov.setLayout(panelCantMovLayout);
        panelCantMovLayout.setHorizontalGroup(
            panelCantMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCantMovLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(fieldCantMov, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCantMovLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblMsgCantMov)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelCantMovLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblCantMov)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panelCantMovLayout.setVerticalGroup(
            panelCantMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCantMovLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCantMov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldCantMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMsgCantMov)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        btnConfirmarAzul.setForeground(new java.awt.Color(51, 102, 255));
        btnConfirmarAzul.setText("Confirmar jugador azul");
        btnConfirmarAzul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarAzulActionPerformed(evt);
            }
        });

        btnConfirmarRojo.setForeground(new java.awt.Color(255, 51, 51));
        btnConfirmarRojo.setText("Confirmar jugador rojo");
        btnConfirmarRojo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarRojoActionPerformed(evt);
            }
        });

        btnJugar.setBackground(new java.awt.Color(255, 248, 146));
        btnJugar.setForeground(new java.awt.Color(0, 15, 41));
        btnJugar.setText("JUGAR");
        btnJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(255, 248, 146));
        btnAtras.setForeground(new java.awt.Color(0, 15, 41));
        btnAtras.setText("Atras");
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 248, 146));
        jLabel1.setText("Selección de jugadores:");

        lblNombreJugadorRojo.setForeground(new java.awt.Color(255, 248, 146));
        lblNombreJugadorRojo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblNombreJugadorAzul.setForeground(new java.awt.Color(255, 248, 146));
        lblNombreJugadorAzul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMsgNoJugadores.setForeground(new java.awt.Color(255, 0, 0));
        lblMsgNoJugadores.setText("No hay jugadores registrados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblModoFinalizacion)
                .addGap(77, 77, 77))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(scrollPanelAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnConfirmarRojo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConfirmarAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreJugadorRojo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreJugadorAzul, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblMsgNoJugadores)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboModoFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCantMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(309, 309, 309))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(203, 203, 203))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(btnAtras)
                    .addContainerGap(609, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModoFinalizacion)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboModoFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(panelCantMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnConfirmarRojo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreJugadorRojo)
                                .addGap(18, 18, 18)
                                .addComponent(btnConfirmarAzul)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreJugadorAzul)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(scrollPanelAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMsgNoJugadores)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(436, Short.MAX_VALUE)
                    .addComponent(btnAtras)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        //salgo sin guardar       
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?\n Se perderán todos los datos del registro",
                "Confirmar salir", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnConfirmarRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarRojoActionPerformed
        //guardo al jugador rojo
        if (lstListaJugadores.getSelectedValue() != null) {
            this.jugadorRojo = (Jugador) lstListaJugadores.getSelectedValue();
            lblNombreJugadorRojo.setText(this.jugadorRojo.toString());
            jugadorRojoSeleccionado = true;
        }
    }//GEN-LAST:event_btnConfirmarRojoActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        //Creo la partida y abro la ventana del tablero
        //si me seleccionaron ambos jugadores y el modo de juego
        if (jugadorRojoSeleccionado && jugadorAzulSeleccionado && modoSeleccionado) {
            if (!jugadorRojo.equals(jugadorAzul)) {
                if (this.modo == 3) {
                    //agarro cantidad de movimientos del texfield
                    try {
                        cantMov = Integer.parseInt(fieldCantMov.getText());
                        if (cantMov > 0) {
                            cantMovSeleccionada = true;
                            this.configuracion = this.sistema.crearConfiguracion(modo, cantMov);
                            this.sistema.crearPartida(configuracion, jugadorRojo, jugadorAzul);
                            VentanaTablero tablero = new VentanaTablero(this.sistema);
                            tablero.setVisible(true);
                            this.dispose();
                        } else {
                            lblMsgCantMov.setVisible(true);
                        }

                    } catch (NumberFormatException e) {
                        lblMsgCantMov.setVisible(true);
                    }
                } else {
                    if (this.modo != 3) {
                        this.configuracion = this.sistema.crearConfiguracion(modo, cantMov);
                        this.sistema.crearPartida(configuracion, jugadorRojo, jugadorAzul);
                        VentanaTablero tablero = new VentanaTablero(this.sistema);
                        tablero.setVisible(true);
                        this.dispose();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione dos jugadores distintos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (!jugadorRojoSeleccionado) {
                JOptionPane.showMessageDialog(null, "Seleccione jugador rojo", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                if (!jugadorAzulSeleccionado) {
                    JOptionPane.showMessageDialog(null, "Seleccione jugador azul", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!modoSeleccionado) {
                        JOptionPane.showMessageDialog(null, "Seleccione modo de juego", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (!cantMovSeleccionada) {
                            JOptionPane.showMessageDialog(null, "Seleccione cantidad de movimientos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }

            }
        }
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnConfirmarAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarAzulActionPerformed
        //guardo al jugador azul
        if (lstListaJugadores.getSelectedValue() != null) {
            this.jugadorAzul = (Jugador) lstListaJugadores.getSelectedValue();
            lblNombreJugadorAzul.setText(this.jugadorAzul.toString());
            jugadorAzulSeleccionado = true;
        }
    }//GEN-LAST:event_btnConfirmarAzulActionPerformed

    private void comboModoFinalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModoFinalizacionActionPerformed
        //si el modo es Cantidad de movimientos 
        //seteo el lbl en true para que me habilite la opcion de ingresar el numero
        if (comboModoFinalizacion.getSelectedIndex() == 2) {
            lblMsgCantMov.setVisible(false);
            panelCantMov.setVisible(true);
        }else{
            lblMsgCantMov.setVisible(false);
            panelCantMov.setVisible(false);
        }
        this.modo = comboModoFinalizacion.getSelectedIndex() + 1;      //los indices arrancan en 0 en los comboBox
        modoSeleccionado = true;
    }//GEN-LAST:event_comboModoFinalizacionActionPerformed

    private void fieldCantMovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCantMovMouseClicked
        //cuando toco con el mouse el field, se vuelve a esconder el msg de error 
        lblMsgCantMov.setVisible(false);
    }//GEN-LAST:event_fieldCantMovMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //salgo sin guardar       
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?\n Se perderán todos los datos del registro",
                "Confirmar salir", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConfirmarAzul;
    private javax.swing.JButton btnConfirmarRojo;
    private javax.swing.JButton btnJugar;
    private javax.swing.JComboBox comboModoFinalizacion;
    private javax.swing.JTextField fieldCantMov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCantMov;
    private javax.swing.JLabel lblModoFinalizacion;
    private javax.swing.JLabel lblMsgCantMov;
    private javax.swing.JLabel lblMsgNoJugadores;
    private javax.swing.JLabel lblNombreJugadorAzul;
    private javax.swing.JLabel lblNombreJugadorRojo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList lstListaJugadores;
    private javax.swing.JPanel panelCantMov;
    private javax.swing.JScrollPane scrollPanelAzul;
    // End of variables declaration//GEN-END:variables
}
