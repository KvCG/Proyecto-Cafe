/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.vista;

/**
 *
 * @author Kevin
 */
public class PantallaPrincipal extends javax.swing.JFrame  {
           
     public PantallaPrincipal() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jMenuItem3 = new javax.swing.JMenuItem();
        btUsuariosEnLinea = new javax.swing.JButton();
        btLimpiarPantalla = new javax.swing.JButton();
        btIniciarServidor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTPC = new javax.swing.JTable();
        btDetenerServidor = new javax.swing.JButton();
        btBloquear = new javax.swing.JButton();
        btDesbloquear = new javax.swing.JButton();
        btEnviar = new javax.swing.JButton();
        txtMensaje = new javax.swing.JTextField();
        btFacturar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Chat_Servidor = new javax.swing.JTextArea();
        MenuBarPrincipal = new javax.swing.JMenuBar();
        menuMantenimientos = new javax.swing.JMenu();
        menuManteCliente = new javax.swing.JMenuItem();
        menuManteArticulo = new javax.swing.JMenuItem();
        menuManteProveedor = new javax.swing.JMenuItem();
        menuManteArtProv = new javax.swing.JMenuItem();
        MenuFacturacion = new javax.swing.JMenu();
        menuFacturar = new javax.swing.JMenuItem();
        MenuBuscar = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        MenuReportes = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenu7.setText("jMenu7");

        jMenu8.setText("jMenu8");

        jButton1.setText("jButton1");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btUsuariosEnLinea.setText("Usuarios en linea");
        btUsuariosEnLinea.setPreferredSize(new java.awt.Dimension(115, 23));
        btUsuariosEnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuariosEnLineaActionPerformed(evt);
            }
        });

        btLimpiarPantalla.setText("Limpiar pantalla");
        btLimpiarPantalla.setPreferredSize(new java.awt.Dimension(115, 23));
        btLimpiarPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarPantallaActionPerformed(evt);
            }
        });

        btIniciarServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/chronometer.png"))); // NOI18N
        btIniciarServidor.setText("Iniciar ");

        jTPC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "IP", "Estado", "Hora Inicio", "Hora Fin"
            }
        ));
        jScrollPane2.setViewportView(jTPC);

        btDetenerServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/media_playback_stop.png"))); // NOI18N
        btDetenerServidor.setText("Detener ");

        btBloquear.setIcon(new javax.swing.ImageIcon("D:\\Descargas\\U\\Iconos para proyectos\\1445654832_locked.png")); // NOI18N
        btBloquear.setText("Bloquear");

        btDesbloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/unlock.png"))); // NOI18N
        btDesbloquear.setText("Desbloquear");
        btDesbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesbloquearActionPerformed(evt);
            }
        });

        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/mail.png"))); // NOI18N
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        txtMensaje.setText("Mensaje");
        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });

        btFacturar.setText("Facturar");

        Chat_Servidor.setEditable(false);
        Chat_Servidor.setColumns(20);
        Chat_Servidor.setRows(5);
        jScrollPane1.setViewportView(Chat_Servidor);

        MenuBarPrincipal.setBackground(new java.awt.Color(0, 255, 204));

        menuMantenimientos.setText("Mantenimientos");

        menuManteCliente.setBackground(new java.awt.Color(255, 255, 255));
        menuManteCliente.setText("Cliente");
        menuManteCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManteClienteActionPerformed(evt);
            }
        });
        menuMantenimientos.add(menuManteCliente);

        menuManteArticulo.setBackground(new java.awt.Color(255, 255, 255));
        menuManteArticulo.setText("Articulo");
        menuManteArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManteArticuloActionPerformed(evt);
            }
        });
        menuMantenimientos.add(menuManteArticulo);

        menuManteProveedor.setBackground(new java.awt.Color(255, 255, 255));
        menuManteProveedor.setText("Proveedor");
        menuManteProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManteProveedorActionPerformed(evt);
            }
        });
        menuMantenimientos.add(menuManteProveedor);

        menuManteArtProv.setBackground(new java.awt.Color(255, 255, 255));
        menuManteArtProv.setText("Articulo por Proveedor");
        menuManteArtProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManteArtProvActionPerformed(evt);
            }
        });
        menuMantenimientos.add(menuManteArtProv);

        MenuBarPrincipal.add(menuMantenimientos);

        MenuFacturacion.setText("Facturacion");

        menuFacturar.setText("Facturar");
        MenuFacturacion.add(menuFacturar);

        MenuBarPrincipal.add(MenuFacturacion);

        MenuBuscar.setText("Buscar");

        jMenuItem10.setText("Usuario");
        MenuBuscar.add(jMenuItem10);

        jMenuItem11.setText("Cliente");
        MenuBuscar.add(jMenuItem11);

        jMenuItem12.setText("Proveedor");
        MenuBuscar.add(jMenuItem12);

        MenuBarPrincipal.add(MenuBuscar);

        MenuReportes.setText("Reportes");

        jMenu13.setText("Facturas");
        MenuReportes.add(jMenu13);

        jMenu14.setText("Clientes");
        MenuReportes.add(jMenu14);

        jMenu16.setText("Articulos");
        MenuReportes.add(jMenu16);

        MenuBarPrincipal.add(MenuReportes);

        setJMenuBar(MenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btLimpiarPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btDesbloquear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btIniciarServidor))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btBloquear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btFacturar, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                        .addComponent(btUsuariosEnLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(btDetenerServidor)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btBloquear, btDesbloquear, btDetenerServidor, btIniciarServidor});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btDesbloquear)
                        .addGap(16, 16, 16)
                        .addComponent(btIniciarServidor))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btBloquear)
                                .addComponent(btUsuariosEnLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btFacturar))
                        .addGap(16, 16, 16)
                        .addComponent(btDetenerServidor)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLimpiarPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btBloquear, btDesbloquear, btDetenerServidor, btIniciarServidor});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuManteClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManteClienteActionPerformed
    
    }//GEN-LAST:event_menuManteClienteActionPerformed

    private void menuManteArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManteArticuloActionPerformed
        
    }//GEN-LAST:event_menuManteArticuloActionPerformed

    private void menuManteProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManteProveedorActionPerformed
        
    }//GEN-LAST:event_menuManteProveedorActionPerformed

    private void menuManteArtProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManteArtProvActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_menuManteArtProvActionPerformed

    private void btUsuariosEnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuariosEnLineaActionPerformed

    }//GEN-LAST:event_btUsuariosEnLineaActionPerformed

    private void btLimpiarPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarPantallaActionPerformed

    }//GEN-LAST:event_btLimpiarPantallaActionPerformed

    private void btDesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesbloquearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btDesbloquearActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEnviarActionPerformed

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMensajeActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PantallaPrincipal p = new PantallaPrincipal();
                p.setVisible(true);
                p.setResizable(false);
                          
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea Chat_Servidor;
    private javax.swing.JMenuBar MenuBarPrincipal;
    private javax.swing.JMenu MenuBuscar;
    private javax.swing.JMenu MenuFacturacion;
    private javax.swing.JMenu MenuReportes;
    public javax.swing.JButton btBloquear;
    public javax.swing.JButton btDesbloquear;
    public javax.swing.JButton btDetenerServidor;
    public javax.swing.JButton btEnviar;
    public javax.swing.JButton btFacturar;
    public javax.swing.JButton btIniciarServidor;
    public javax.swing.JButton btLimpiarPantalla;
    public javax.swing.JButton btUsuariosEnLinea;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTPC;
    private javax.swing.JMenuItem menuFacturar;
    public javax.swing.JMenuItem menuManteArtProv;
    public javax.swing.JMenuItem menuManteArticulo;
    public javax.swing.JMenuItem menuManteCliente;
    public javax.swing.JMenuItem menuManteProveedor;
    public javax.swing.JMenu menuMantenimientos;
    public javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables

    
}
