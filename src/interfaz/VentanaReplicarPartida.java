package interfaz;

import dominio.Jugador;
import dominio.Movimiento;
import dominio.Partida;
import dominio.Sistema;
import dominio.Tablero;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaReplicarPartida extends javax.swing.JFrame {

    private Sistema sistema;
    private Tablero tablero;
    private Partida replicada;
    private JButton[][] botones;
    private ArrayList<Movimiento> lstMovimientos = new ArrayList<>();
    private int posLstMov = 0;
    int tamañoDeFuente = 34;

    public VentanaReplicarPartida(Sistema miSistema) {
        initComponents();
        this.sistema = miSistema;
        this.replicada = this.sistema.getReplicada();
        this.tablero = this.replicada.getTablero();
        //la lista de movimientos la tomo de la partida original
        this.lstMovimientos = this.sistema.getPartida().getListaMovimientos();
        // crear botones y agregarlos al panel
        panelJuego.setLayout(new GridLayout(8, 9));
        botones = new JButton[9][10];
        //para inicializar preciso un tablero nuevo, porque si uso el de replicada me toma la ultima jugada
        Tablero unTablero = new Tablero();
        inicializarTablero(panelJuego, botones, unTablero);
        //Seteo label del versus
        Jugador jugadorRojo = this.sistema.getReplicada().getJugadorRojo();
        Jugador jugadorAzul = this.sistema.getReplicada().getJugadorAzul();
        lblVersus.setText(jugadorRojo.toString() + " VS " + jugadorAzul.toString());
        //Seteo label de cantidad de movimientos
        if (this.replicada.getConfiguracion().getModoFinalizacion() == 3) {
            lblCantidadDeMovimientos.setText("Cantidad de movimientos: " + this.sistema.getReplicada().getConfiguracion().getCantidadMovimientos());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSiguiente = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        lblCantidadDeMovimientos = new javax.swing.JLabel();
        panelJuego = new javax.swing.JPanel();
        lblColorTurno = new javax.swing.JLabel();
        lblVersus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 15, 41));
        jPanel1.setLayout(null);

        btnSiguiente.setBackground(new java.awt.Color(255, 248, 146));
        btnSiguiente.setText("SIGUIENTE");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguiente);
        btnSiguiente.setBounds(290, 520, 130, 50);

        btnContinuar.setBackground(new java.awt.Color(255, 248, 146));
        btnContinuar.setText("Continuar jugando");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(btnContinuar);
        btnContinuar.setBounds(530, 540, 140, 23);

        btnAtras.setBackground(new java.awt.Color(255, 248, 146));
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras);
        btnAtras.setBounds(70, 540, 100, 23);

        lblCantidadDeMovimientos.setBackground(new java.awt.Color(0, 15, 41));
        lblCantidadDeMovimientos.setForeground(new java.awt.Color(255, 248, 146));
        lblCantidadDeMovimientos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblCantidadDeMovimientos);
        lblCantidadDeMovimientos.setBounds(230, 40, 250, 30);

        panelJuego.setMaximumSize(new java.awt.Dimension(700, 500));
        panelJuego.setMinimumSize(new java.awt.Dimension(700, 500));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(panelJuego);
        panelJuego.setBounds(110, 80, 510, 420);

        lblColorTurno.setBackground(new java.awt.Color(255, 0, 0));
        lblColorTurno.setForeground(new java.awt.Color(255, 0, 0));
        lblColorTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblColorTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rojo.jpg"))); // NOI18N
        lblColorTurno.setText("TURNO");
        jPanel1.add(lblColorTurno);
        lblColorTurno.setBounds(100, 70, 530, 440);

        lblVersus.setBackground(new java.awt.Color(0, 15, 41));
        lblVersus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblVersus.setForeground(new java.awt.Color(255, 248, 146));
        lblVersus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblVersus);
        lblVersus.setBounds(120, 10, 480, 26);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (lstMovimientos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Gana el jugador azul");
            this.dispose();
        } else {
            //replico siguiente movimiento
            //armo el movimiento a partir del elemento de la lista
            char direccion = lstMovimientos.get(posLstMov).getDireccion();
            int numero = lstMovimientos.get(posLstMov).getNumero();
            String color = lstMovimientos.get(posLstMov).getColor();
            String movimiento = Integer.toString(numero) + direccion;
            //al constructor le paso color y movimiento
            Movimiento replicoMovimiento = new Movimiento(color, movimiento);
            //ejecuto el movimiento y se agrega a la listaMovimientos de replicada
            this.replicada.moverFicha(replicoMovimiento);
            //me fijo si hay que actualizar cantidad de movimientos
            if (this.replicada.getConfiguracion().getModoFinalizacion() == 3) {
                lblCantidadDeMovimientos.setText("Cantidad de movimientos: " + this.replicada.getMovimientosRestantes());
            }
            //actualizo tablero
            dibujarTablero(botones, tablero, color);
            //si se termina la lista, termine el juego. Else actualizo posicion
            if (posLstMov == (lstMovimientos.size() - 1)) {
                String ganador = this.sistema.getPartida().getGanador();
                if (ganador.equals("empate")) {
                    JOptionPane.showMessageDialog(null, " EMPATE ");
                } else {
                    JOptionPane.showMessageDialog(null, "Gana el jugador " + ganador);
                }
                this.dispose();
            } else {
                posLstMov++;
            }
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Si apreto la x voy para atras
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?",
                "Confirmar salir", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        //continua la partida desde el estado actual
        int result = JOptionPane.showConfirmDialog(null, "¿Desea continuar la partida desde este punto?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.sistema.setPartida(this.replicada);
            VentanaTablero ventana = new VentanaTablero(this.sistema);
            ventana.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        //salir
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?",
                "Confirmar salir", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void inicializarTablero(JPanel panelJuego, JButton[][] botones, Tablero tablero) {
        //inicializa el tablero. Es como el de ventanaTablero pero no habilita botones
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 9; j++) {
                JButton jButton = new JButton();
                if (tablero.getTablero()[i - 1][j - 1].getNumero() != 0) {
                    jButton.setText(Integer.toString(tablero.getTablero()[i - 1][j - 1].getNumero()));
                    if (tablero.getTablero()[i - 1][j - 1].getColor().equals("rojo")) {
                        jButton.setBackground(Color.red);
                        jButton.setEnabled(false);
                    }
                    if (tablero.getTablero()[i - 1][j - 1].getColor().equals("azul")) {
                        jButton.setBackground(Color.blue);
                        jButton.setEnabled(false);
                    }
                }else{
                    jButton.setBackground(Color.lightGray);
                }
                jButton.setFont(new java.awt.Font("Source Sans Pro", 0, tamañoDeFuente));
                panelJuego.add(jButton);
                botones[i][j] = jButton;
                jButton.setEnabled(false);
            }
        }
    }

    public void dibujarTablero(JButton[][] botones, Tablero tablero, String turno) {
        //Dibuja el tablero en el estado actual. Es como el de ventanaTablera pero no habilita botones
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 9; j++) {
                JButton jButton = botones[i][j];
                if (tablero.getTablero()[i - 1][j - 1].getNumero() != 0) {
                    jButton.setText(Integer.toString(tablero.getTablero()[i - 1][j - 1].getNumero()));
                    if (tablero.getTablero()[i - 1][j - 1].getColor().equals("rojo")) {
                        jButton.setBackground(Color.red);
                        jButton.setEnabled(false);
                    }
                    if (tablero.getTablero()[i - 1][j - 1].getColor().equals("azul")) {
                        jButton.setBackground(Color.blue);
                        jButton.setEnabled(false);
                    }
                } else {
                    jButton.setEnabled(false);
                    jButton.setBackground(Color.lightGray);
                    jButton.setText("");
                }
                jButton.setFont(new java.awt.Font("Source Sans Pro", 0, tamañoDeFuente));
            }
        }

        if (turno.equals("rojo")) {
            lblColorTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rojo.jpg")));
        } else {
            lblColorTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/azul.jpg")));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCantidadDeMovimientos;
    private javax.swing.JLabel lblColorTurno;
    private javax.swing.JLabel lblVersus;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables
}
