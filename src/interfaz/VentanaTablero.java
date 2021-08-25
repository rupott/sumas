package interfaz;

import dominio.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class VentanaTablero extends javax.swing.JFrame {

    private Sistema sistema;
    private Partida laPartida;
    private Tablero elTablero;
    private JButton[][] botones;
    private int cantidadMov;
    private int[] fichaAMover = new int[2];
    private ArrayList<Ficha> bloqueadas = new ArrayList();
    int tamañoDeFuente = 34;

    public VentanaTablero(Sistema miSistema) {
        initComponents();
        this.sistema = miSistema;
        this.laPartida = this.sistema.getPartida();
        this.elTablero = miSistema.getPartida().getTablero();
        // crear botones y agregarlos al panel
        panelJuego.setLayout(new GridLayout(8, 9));
        botones = new JButton[9][10];
        inicializarTablero(panelJuego, botones, elTablero);
        //Seteo label del versus
        Jugador jugadorRojo = this.sistema.getPartida().getJugadorRojo();
        Jugador jugadorAzul = this.sistema.getPartida().getJugadorAzul();
        lblVersus.setText(jugadorRojo.toString() + " VS " + jugadorAzul.toString());
        //Seteo label de cantidad de movimientos
        cantidadMov = this.sistema.getPartida().getMovimientosRestantes();
        if (this.sistema.getPartida().getConfiguracion().getModoFinalizacion() == 3) {
            lblCantidadDeMovimientos.setText("Cantidad de movimientos: " + cantidadMov);
        }
    }

    //Dibuja el tablero en la posicion inicial
    private void inicializarTablero(JPanel panelJuego, JButton[][] botones, Tablero tablero) {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 9; j++) {
                JButton jButton = new JButton();
                if (tablero.getTablero()[i - 1][j - 1].getNumero() != 0) {
                    jButton.setText(Integer.toString(tablero.getTablero()[i - 1][j - 1].getNumero()));
                    if (tablero.getTablero()[i - 1][j - 1].getColor().equals("rojo")) {
                        jButton.setBackground(Color.red);
                    }
                    if (tablero.getTablero()[i - 1][j - 1].getColor().equals("azul")) {
                        jButton.setBackground(Color.blue);
                        jButton.setEnabled(false);
                    }
                } else {
                    jButton.setEnabled(false);
                    jButton.setBackground(Color.lightGray);
                }
                jButton.setFont(new java.awt.Font("Source Sans Pro", 0, tamañoDeFuente));
                jButton.addActionListener(new ListenerBoton(i, j));
                panelJuego.add(jButton);
                botones[i][j] = jButton;
            }
        }
    }

    //Dibuja el tablero en el estado actual
    private void dibujarTablero(JButton[][] botones, Tablero tablero, String turno, ArrayList<Ficha> fichasBloqueadas) {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 9; j++) {
                JButton jButton = botones[i][j];
                if (tablero.getTablero()[i - 1][j - 1].getNumero() != 0) {
                    jButton.setText(Integer.toString(tablero.getTablero()[i - 1][j - 1].getNumero()));
                    if (fichasBloqueadas.contains(tablero.getTablero()[i - 1][j - 1])) {
                        jButton.setBackground(Color.gray);
                        jButton.setEnabled(false);
                    } else {
                        if (tablero.getTablero()[i - 1][j - 1].getColor().equals("rojo")) {
                            jButton.setBackground(Color.red);
                            jButton.setEnabled(true);
                            if (turno.equals("azul")) {
                                jButton.setEnabled(false);
                            }
                        }
                        if (tablero.getTablero()[i - 1][j - 1].getColor().equals("azul")) {
                            jButton.setBackground(Color.blue);
                            jButton.setEnabled(true);
                            if (turno.equals("rojo")) {
                                jButton.setEnabled(false);
                            }
                        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        lblVersus = new javax.swing.JLabel();
        btnAbandonar = new javax.swing.JButton();
        btnPasarTurno = new javax.swing.JButton();
        lblCantidadDeMovimientos = new javax.swing.JLabel();
        lblColorTurno = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(630, 620));
        setMinimumSize(new java.awt.Dimension(630, 620));
        setPreferredSize(new java.awt.Dimension(630, 620));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        panelJuego.setMaximumSize(new java.awt.Dimension(700, 500));
        panelJuego.setMinimumSize(new java.awt.Dimension(700, 500));
        panelJuego.setPreferredSize(new java.awt.Dimension(700, 500));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(panelJuego);
        panelJuego.setBounds(60, 100, 510, 420);

        lblVersus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblVersus.setForeground(new java.awt.Color(255, 248, 146));
        lblVersus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVersus.setMaximumSize(new java.awt.Dimension(480, 29));
        lblVersus.setMinimumSize(new java.awt.Dimension(480, 29));
        lblVersus.setPreferredSize(new java.awt.Dimension(480, 29));
        getContentPane().add(lblVersus);
        lblVersus.setBounds(60, 10, 510, 50);

        btnAbandonar.setBackground(new java.awt.Color(255, 248, 146));
        btnAbandonar.setText("ABANDONAR PARTIDA");
        btnAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbandonar);
        btnAbandonar.setBounds(440, 540, 170, 40);

        btnPasarTurno.setEnabled(false);
        btnPasarTurno.setBackground(new java.awt.Color(255, 248, 146));
        btnPasarTurno.setText("PASAR TURNO");
        btnPasarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPasarTurno);
        btnPasarTurno.setBounds(20, 540, 170, 40);

        lblCantidadDeMovimientos.setForeground(new java.awt.Color(255, 248, 146));
        lblCantidadDeMovimientos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblCantidadDeMovimientos);
        lblCantidadDeMovimientos.setBounds(190, 50, 250, 40);

        lblColorTurno.setBackground(new java.awt.Color(255, 0, 0));
        lblColorTurno.setForeground(new java.awt.Color(255, 0, 0));
        lblColorTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblColorTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rojo.jpg"))); // NOI18N
        lblColorTurno.setText("TURNO");
        getContentPane().add(lblColorTurno);
        lblColorTurno.setBounds(50, 90, 530, 440);

        jPanel1.setBackground(new java.awt.Color(0, 15, 41));
        jPanel1.setMaximumSize(new java.awt.Dimension(630, 620));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 620));
        jPanel1.setPreferredSize(new java.awt.Dimension(630, 620));
        jPanel1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 630, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        abandonarPartida();
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void btnPasarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarTurnoActionPerformed
        String turno = pasoTurno();
        dibujarTablero(botones, elTablero, turno, bloqueadas);
    }//GEN-LAST:event_btnPasarTurnoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        abandonarPartida();
    }//GEN-LAST:event_formWindowClosing

    private void abandonarPartida(){
        int result = JOptionPane.showConfirmDialog(null, "¿Esá seguro que quiere abandonar?\n" + "Ganará automaticamente el otro jugador.", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            sistema.registroPartida(laPartida);
            String perdedor = laPartida.getTurno();
            if (perdedor.equals("rojo")) {
                JOptionPane.showMessageDialog(null, "Gana el jugador azul");
                laPartida.setGanador("azul");
                laPartida.getJugadorAzul().modificarPuntaje();
            } else {
                JOptionPane.showMessageDialog(null, "Gana el jugador rojo");
                laPartida.setGanador("rojo");
                laPartida.getJugadorRojo().modificarPuntaje();
            }
            this.dispose();
        }
    }
        
    
    private class ListenerBoton implements ActionListener {

    private int x;
    private int y;

    public ListenerBoton(int i, int j) {
        // en el constructor se almacena la fila y columna que se presionó
        x = i;
        y = j;
    }

    public void actionPerformed(ActionEvent e) {
        // cuando se presiona un botón, se ejecutará este método
        clickBoton(x, y);
    }
}

private void clickBoton(int filaBoton, int columnaBoton) {
        //Calculo las posiciones en la matriz de fichas de Tablero
        int fila = filaBoton - 1;
        int columna = columnaBoton - 1;
        //actualizo el tablero y el turno
        this.elTablero = laPartida.getTablero();
        String turno = laPartida.getTurno();
        //actualizo cantidad de movimientos
        cantidadMov = laPartida.getMovimientosRestantes();
        //me fijo el color de bakground del boton
        Color color = botones[filaBoton][columnaBoton].getBackground();
        //Si el bakground es azul o rojo, muestro a que posiciones se puede mover la ficha
        //sino, genero un movimiento y muevo la ultima ficha seleccionada a esa posicion
        if ((color.equals(Color.red)) || (color.equals(Color.blue))) {                          //MIRO SI TOCARON UNA DE LAS FICHAS
            //guardo las coordeadas de la ficha que se quiere mover
            fichaAMover[0] = fila;
            fichaAMover[1] = columna;
            //Limpio el tablero
            dibujarTablero(botones, elTablero, turno, bloqueadas);
            //obtengo movimientos posibles para la ficha seleccionada
            int[][] posiciones = this.laPartida.posValidas(fila, columna);
            //Marco todas las posiciones posibles
            for (int i = 0; i < 3; i++) {
                //Si la posicion es -1 significa que no es una posicion valida y no la marco
                if (posiciones[i][0] != -1) {
                    botones[posiciones[i][0] + 1][posiciones[i][1] + 1].setEnabled(true);
                    if (color.equals(Color.red)) {
                        botones[posiciones[i][0] + 1][posiciones[i][1] + 1].setBackground(Color.pink);
                    } else {
                        botones[posiciones[i][0] + 1][posiciones[i][1] + 1].setBackground(new java.awt.Color(141, 155, 255));
                    }
                }
            }
        } else {                                                                                //MIRO QUE POSICION SELECCIONARON
            //en mov conateno el numero de la ficha y la direccion del movimiento
            String mov = "0A";
            //Si la columna es menor a la de la ficha a mover entonces muevo a la izquierda
            if (columna < fichaAMover[1]) {
                //Armo el movimiento con el numero de la ficha y la direccion
                mov = elTablero.getTablero()[fichaAMover[0]][fichaAMover[1]].getNumero() + "I";
            }
            //Si la columna es mayor a la de la ficha a mover entonces muevo a la derecha
            if (columna > fichaAMover[1]) {
                //Armo el movimiento con el numero de la ficha y la direccion
                mov = elTablero.getTablero()[fichaAMover[0]][fichaAMover[1]].getNumero() + "D";
            }
            //Si la columna es igual a la de la ficha a mover entonces muevo hacia adelante
            if (columna == fichaAMover[1]) {
                //Armo el movimiento con el numero de la ficha y la direccion
                mov = elTablero.getTablero()[fichaAMover[0]][fichaAMover[1]].getNumero() + "A";
            }

            //Creo el movimiento
            Movimiento elMovimiento = new Movimiento(turno, mov);
            //Muevo la ficha
            laPartida.moverFicha(elMovimiento);
            //Actualizo lbl de cant mov
            if (laPartida.getConfiguracion().getModoFinalizacion() == 3) {
                cantidadMov = laPartida.getMovimientosRestantes();
                lblCantidadDeMovimientos.setText("Cantidad de movimientos: " + cantidadMov);
            }
            //Vuelvo a dibujar el tablero
            bloqueadas.clear();
            dibujarTablero(botones, elTablero, turno, bloqueadas);

            //Me fijo si el movimiento gana la partida
            if (laPartida.terminoJuego(laPartida.getConfiguracion())) {                         //ME FIJO SI TERMINA LA PARTIDA
                sistema.registroPartida(laPartida);
                String ganador = laPartida.getGanador();
                if (ganador.equals("empate")) {
                    JOptionPane.showMessageDialog(null, " EMPATE ");
                } else {
                    JOptionPane.showMessageDialog(null, "Gana el jugador " + ganador);
                    if (ganador.equals("rojo")) {
                        laPartida.getJugadorRojo().modificarPuntaje();
                    } else {
                        laPartida.getJugadorAzul().modificarPuntaje();
                    }
                }
                this.dispose();
            } else {                                                                            //MIRO MOVIMIENTOS GRATIS
                //Movimientos gratis
                ArrayList<Ficha> movGratis = laPartida.movimientosGratis();
                //Nos fijamos que hayan movimientos gratis
                if (!movGratis.isEmpty()) {
                    //Activo el boton para pasar de turno
                    btnPasarTurno.setEnabled(true);
                    //Recorro el tablero para marcar las fichas que corresponden a un movimiento gratis
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 9; j++) {
                            if (elTablero.getTablero()[i][j].getColor().equals(turno)) {
                                if (!movGratis.contains(elTablero.getTablero()[i][j])) {
                                    bloqueadas.add(elTablero.getTablero()[i][j]);
                                } else {
                                    //si es un movimiento gratis, me fijo si puedo mover la ficha
                                    int[][] posVal = laPartida.posValidas(i, j);
                                    //si la suma de las coord x de todas las posValidas es -3 no puedo mover la ficha porque posVal da -1 si el movimiento no es valido
                                    if ((posVal[0][0] + posVal[1][0] + posVal[2][0] == -3)) {
                                        //bloqueo las fichas que no puedo movers
                                        bloqueadas.add(elTablero.getTablero()[i][j]);
                                    }
                                }
                            }
                        }
                    }
                    //si hay mov gratis pero estan todos bloqueados paso de turno
                    if (bloqueadas.size() == 8) {
                        turno = pasoTurno();
                    }
                    dibujarTablero(botones, elTablero, turno, bloqueadas);

                } else {
                    turno = pasoTurno();
                    dibujarTablero(botones, elTablero, turno, bloqueadas);
                }
            }
        }
    }

    private String pasoTurno() {
        laPartida.pasarTurno();
        btnPasarTurno.setEnabled(false);
        String nuevoTurno = laPartida.getTurno();
        bloqueadas.clear();
        return nuevoTurno;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonar;
    private javax.swing.JButton btnPasarTurno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCantidadDeMovimientos;
    private javax.swing.JLabel lblColorTurno;
    private javax.swing.JLabel lblVersus;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables

}
