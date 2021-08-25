package interfaz;

import dominio.Jugador;
import dominio.Sistema;
import java.io.File;
import java.util.ArrayList;
import manejo_archivos.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class VentanaRanking extends javax.swing.JFrame {

    private Sistema sistema;

    public VentanaRanking(Sistema miSistema) {
        initComponents();
        this.sistema = miSistema;
        //inicializo lista y muestro alias con puntaje
        if (!this.sistema.obtenerRanking().isEmpty()) {
            ArrayList<Jugador> ranking = this.sistema.obtenerRanking();
            String[] lista = new String[ranking.size()];
            for (int i = 0; i < ranking.size(); i++) {
                lista[i] = ranking.get(i).getAlias() + "     " + ranking.get(i).getPuntaje();
            }
            lstListaRanking.setListData(lista);
        } else {
            String[] vacio = {"No se ha jugado ninguna partida"};
            lstListaRanking.setListData(vacio);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblRanking = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstListaRanking = new javax.swing.JList();
        btnDescargar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(0, 15, 41));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 15, 41));
        jPanel2.setFocusTraversalPolicyProvider(true);

        lblRanking.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        lblRanking.setForeground(new java.awt.Color(255, 248, 146));
        lblRanking.setText("Ranking");

        jScrollPane1.setViewportView(lstListaRanking);

        btnDescargar.setBackground(new java.awt.Color(255, 248, 146));
        btnDescargar.setForeground(new java.awt.Color(0, 15, 41));
        btnDescargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_descargar.png"))); // NOI18N
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(255, 248, 146));
        btnAtras.setForeground(new java.awt.Color(0, 15, 41));
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 248, 146));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Descargar lista con puntajes:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(lblRanking)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAtras)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(135, 135, 135))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRanking)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAtras)
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        //Guerdo la extencion del archivo
        String extension = ".txt";
        //Lista de posbles esxtenciones que el ususariopuede elejir
        String[] valores = {".txt", ".json"};
        //OptionPane para que el usuario seleccione la extencion 
        Object seleccion = JOptionPane.showInputDialog(null, "Seleccione un formato", "Guardar lista de jugadores", JOptionPane.PLAIN_MESSAGE, null, valores, DISPOSE_ON_CLOSE);
        //Si el usiario no presiono cancelar
        if (seleccion != null) {
            //Guardo la extencion seleccionada
            extension = (String) seleccion;
            JFileChooser chooser = new JFileChooser();
            int retorno = chooser.showSaveDialog(chooser);
            if (retorno == JFileChooser.APPROVE_OPTION) {
                //Le cncateno la path la extencion del archivo que se quiere guardar
                File destino = new File(chooser.getSelectedFile().toString() + extension);
                //Creo el archivo grabacion
                ArchivoGrabacion ag = new ArchivoGrabacion(destino);
                ag.grabarLinea("{");
                ag.grabarLinea("    " + "\"listaJugadores\":[");
                for (int i = 0; i < this.sistema.getListaJugadores().size(); i++){
                    Jugador unJugador = this.sistema.getListaJugadores().get(i);
                    ag.grabarLinea("        {");
                    ag.grabarLinea("        " + "\"nombre\":" + "\"" + unJugador.getNombre() + "\"" + ",");
                    ag.grabarLinea("        " + "\"alias\":" + "\"" + unJugador.getAlias() + "\"" + ",");
                    ag.grabarLinea("        " + "\"puntaje\":" + unJugador.getPuntaje() + ",");
                    ag.grabarLinea("        " + "\"edad\":" + unJugador.getEdad());
                    if (i == this.sistema.getListaJugadores().size() - 1){
                        ag.grabarLinea("        }");
                    }else{
                        ag.grabarLinea("        },");                        
                    }
                }
                ag.grabarLinea("    " + "]");
                ag.grabarLinea("}");
                ag.cerrar();
            }   
        }
    }//GEN-LAST:event_btnDescargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnDescargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRanking;
    private javax.swing.JList lstListaRanking;
    // End of variables declaration//GEN-END:variables
}
