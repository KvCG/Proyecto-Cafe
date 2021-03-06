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
public class ManteProveedor extends javax.swing.JFrame {

    /**
     * Creates new form ManteProveedor
     */
    public ManteProveedor() {
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
        jLabel1 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btInsertar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProveedor = new javax.swing.JTable();
        lbId = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btConsultar = new javax.swing.JButton();
        btCargar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proveedores");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 64, 120, -1));

        jLabel1.setText("Descripcion:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 102, -1, -1));

        txtDescripcion.setText(" ");
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 102, 120, -1));

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, -1, -1));

        btInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/agregar.png"))); // NOI18N
        btInsertar.setText("Insertar");
        getContentPane().add(btInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 292, 120, 40));

        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/modificar.png"))); // NOI18N
        btModificar.setText("Modificar");
        getContentPane().add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 292, 120, 40));

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/elimiar.png"))); // NOI18N
        btEliminar.setText("Eliminar");
        getContentPane().add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 292, 120, 40));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        getContentPane().add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 292, 120, 40));

        jTableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Descripcion"
            }
        ));
        jScrollPane2.setViewportView(jTableProveedor);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 148, 478, 93));

        lbId.setText("ID:");
        getContentPane().add(lbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, -1, -1));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 24, 120, -1));

        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/find.png"))); // NOI18N
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 11, -1, -1));

        btCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/upload.png"))); // NOI18N
        btCargar.setText("Cargar");
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });
        getContentPane().add(btCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 252, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/1446626291_vector_65_16.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 9, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appProyecto/vista/imagenes/formularios.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-970, -250, 1500, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCargarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(ManteProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManteProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManteProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManteProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManteProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btCancelar;
    public javax.swing.JButton btCargar;
    public javax.swing.JButton btConsultar;
    public javax.swing.JButton btEliminar;
    public javax.swing.JButton btInsertar;
    public javax.swing.JButton btModificar;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTableProveedor;
    private javax.swing.JLabel lbId;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
