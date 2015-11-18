/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.vista;

/**
 *
 * @author Anthony Carrillo
 */
public class ManteArticulo extends javax.swing.JFrame {

    /**
     * Creates new form ManteArticulo
     */
    public ManteArticulo() {
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

        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        lbDescripcion = new javax.swing.JLabel();
        lbPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        LbNombre = new javax.swing.JLabel();
        btInsertar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableArticulos = new javax.swing.JTable();
        lbId = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btConsultar = new javax.swing.JButton();
        btCargarr = new javax.swing.JButton();
        lbPrecio1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Articulos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 123, -1));
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 246, -1));

        lbDescripcion.setText("Descripcion:");
        getContentPane().add(lbDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        lbPrecio.setText("Precio:");
        getContentPane().add(lbPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 140, -1));

        LbNombre.setText("Nombre:");
        getContentPane().add(LbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        btInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/agregar.png"))); // NOI18N
        btInsertar.setText("Insertar");
        getContentPane().add(btInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 373, 120, 40));

        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/modificar.png"))); // NOI18N
        btModificar.setText("Modificar");
        getContentPane().add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 373, 120, 40));

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/elimiar.png"))); // NOI18N
        btEliminar.setText("Eliminar");
        getContentPane().add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 373, 120, 40));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        getContentPane().add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 373, 120, 40));

        jTableArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Precio"
            }
        ));
        jScrollPane2.setViewportView(jTableArticulos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 234, 478, 93));

        lbId.setText("ID:");
        getContentPane().add(lbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 123, -1));

        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/find.png"))); // NOI18N
        getContentPane().add(btConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        btCargarr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/upload.png"))); // NOI18N
        btCargarr.setText("Cargar");
        getContentPane().add(btCargarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 333, -1, -1));

        lbPrecio1.setText("Cantidad:");
        getContentPane().add(lbPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 140, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/1446626574_internt_web_technology-15.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 17, 149, 156));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/formularios.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-970, -180, 1500, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

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
            java.util.logging.Logger.getLogger(ManteArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManteArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManteArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManteArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManteArticulo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbNombre;
    public javax.swing.JButton btCancelar;
    public javax.swing.JButton btCargarr;
    public javax.swing.JButton btConsultar;
    public javax.swing.JButton btEliminar;
    public javax.swing.JButton btInsertar;
    public javax.swing.JButton btModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTableArticulos;
    public javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JLabel lbPrecio1;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
