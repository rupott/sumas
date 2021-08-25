package interfaz;

import dominio.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class VentanaRegistroJugador extends javax.swing.JFrame {

    private Sistema sistema;
    private String nombre;
    private int edad;
    private String alias;
    private boolean nombreCompleto = false;
    private boolean aliasCompleto = false;
    private boolean edadCompleta = false;

    public VentanaRegistroJugador(Sistema miSistema) {
        initComponents();
        sistema = miSistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAlias = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        fieldEdad = new javax.swing.JTextField();
        fieldAlias = new javax.swing.JTextField();
        fieldNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 15, 41));

        jLabel1.setBackground(new java.awt.Color(255, 248, 146));
        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 248, 146));
        jLabel1.setText("Registrar Jugador");

        lblAlias.setBackground(new java.awt.Color(255, 248, 146));
        lblAlias.setForeground(new java.awt.Color(255, 248, 146));
        lblAlias.setText("Alias");

        lblEdad.setBackground(new java.awt.Color(255, 248, 146));
        lblEdad.setForeground(new java.awt.Color(255, 248, 146));
        lblEdad.setText("Edad");

        lblNombre.setBackground(new java.awt.Color(255, 248, 146));
        lblNombre.setForeground(new java.awt.Color(255, 248, 146));
        lblNombre.setText("Nombre");

        btnConfirmar.setBackground(new java.awt.Color(255, 248, 146));
        btnConfirmar.setForeground(new java.awt.Color(0, 15, 41));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlias)
                            .addComponent(lblEdad)
                            .addComponent(lblNombre)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldNombre)
                                .addComponent(fieldAlias, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(fieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEdad)
                .addGap(3, 3, 3)
                .addComponent(fieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblAlias)
                .addGap(1, 1, 1)
                .addComponent(fieldAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnConfirmar))
                .addGap(20, 20, 20))
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
        //tengo que volver al menu principal sin guardar los cambios        
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?\n Se perderán todos los datos del registro",
                "Confirmar salir", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        //Tomo campos (falta edad)
        this.nombre = fieldNombre.getText();
        this.alias = fieldAlias.getText();
        //verifico que todos los campos sean NO vacios
        nombreCompleto = !this.nombre.isEmpty();
        edadCompleta = !fieldEdad.getText().isEmpty();
        aliasCompleto = !this.alias.isEmpty();

        if (nombreCompleto && edadCompleta && aliasCompleto) {
            if (sistema.aliasRepetido(this.alias)) {
                JOptionPane.showMessageDialog(null, "El alias ingresado ya existe. Por favor, ingrese uno diferente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    this.edad = Integer.parseInt(fieldEdad.getText());
                    if (this.edad > 0) {
                        sistema.registroJugador(this.nombre, this.alias, this.edad);
                        JOptionPane.showMessageDialog(null, "Jugador registrado con éxito");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "La edad tiene que ser un número mayor a 0", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "La edad tiene que ser un número mayor a 0", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            if (!nombreCompleto) {
                JOptionPane.showMessageDialog(null, "El campo Nombre no puede quedar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                if (!edadCompleta) {
                    JOptionPane.showMessageDialog(null, "El campo Edad no puede quedar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!aliasCompleto) {
                        JOptionPane.showMessageDialog(null, "El campo Alias no puede quedar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //tengo que volver al menu principal sin guardar los cambios        
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?\n Se perderán todos los datos del registro",
                "Confirmar salir", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JTextField fieldAlias;
    private javax.swing.JTextField fieldEdad;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAlias;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
