/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.bl.ProveedorBL;
import cr.ac.una.prograIII.appProyecto.domain.Proveedor;
import cr.ac.una.prograIII.appProyecto.vista.BuscaProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anthony Carrillo
 */
public class BuscaProveedorControlador implements ActionListener {

    private BuscaProveedor proveedorBuscarView;
    private ProveedorBL proveedorBLModelo;
    private JTextField txtRespuesta;

    public BuscaProveedorControlador(BuscaProveedor proveedorBuscarView, ProveedorBL proveedorBLModelo, JTextField txtRespuesta) {
        this.proveedorBuscarView = proveedorBuscarView;
        this.proveedorBLModelo = proveedorBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.proveedorBuscarView.btSeleccionar.addActionListener(this);
        this.proveedorBuscarView.txtBuscar.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                llenarTabla(proveedorBuscarView.jTBuscarProveedor);
            }
        });
        llenarTabla(this.proveedorBuscarView.jTBuscarProveedor);
    }

    public BuscaProveedorControlador(BuscaProveedor proveedorBuscarView, ProveedorBL proveedorBLModelo) {
        this.proveedorBuscarView = proveedorBuscarView;
        this.proveedorBLModelo = proveedorBLModelo;
    }
    
    

    public void llenarTabla(JTable tablaProveedor) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaProveedor.setModel(modeloTabla);

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("DESCRIPCION");

        Object fila[] = new Object[3];

        String Sql = "where nombre like '%" + this.proveedorBuscarView.txtBuscar.getText() + "%'";

        try {
            for (Object oAux : proveedorBLModelo.obtenerConWhere(new Proveedor(), Sql)) {
                Proveedor s = (Proveedor) oAux;
                fila[0] = s.getPK_idProveedor();
                fila[1] = s.getNombre();
                fila[2] = s.getDescripcion();

                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BuscaProveedor getProveedorBuscarView() {
        return proveedorBuscarView;
    }

    public void setProveedorBuscarView(BuscaProveedor proveedorBuscarView) {
        this.proveedorBuscarView = proveedorBuscarView;
    }

    public ProveedorBL getProveedorBLModelo() {
        return proveedorBLModelo;
    }

    public void setProveedorBLModelo(ProveedorBL proveedorBLModelo) {
        this.proveedorBLModelo = proveedorBLModelo;
    }

    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == proveedorBuscarView.btSeleccionar) {
            int fila = this.proveedorBuscarView.jTBuscarProveedor.getSelectedRow();
            if (fila != -1) {
                Integer idProveedor = Integer.parseInt(this.proveedorBuscarView.jTBuscarProveedor.getValueAt(fila, 0).toString());
                txtRespuesta.setText(String.valueOf(idProveedor));
                this.proveedorBuscarView.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(proveedorBuscarView, "No se ha seleccionado un proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}