/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.bl.ArticuloBL;
import cr.ac.una.prograIII.appProyecto.domain.Articulo;
import cr.ac.una.prograIII.appProyecto.vista.BuscaArticulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class BuscaArticuloControlador implements ActionListener {

    private BuscaArticulo articuloBuscarView;
    private ArticuloBL articuloBLModelo;
    private JTextField txtRespuesta;

    public BuscaArticuloControlador(BuscaArticulo articuloBuscarView, ArticuloBL articuloBLModelo, JTextField txtRespuesta) {
        this.articuloBuscarView = articuloBuscarView;
        this.articuloBLModelo = articuloBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.articuloBuscarView.btSeleccionar.addActionListener(this);
        this.articuloBuscarView.txtBuscar.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                llenarTabla(articuloBuscarView.jTBuscarArticulo);
            }
        });
        llenarTabla(this.articuloBuscarView.jTBuscarArticulo);
    }

    public BuscaArticuloControlador(BuscaArticulo articuloBuscarView, ArticuloBL articuloBLModelo) {
        this.articuloBuscarView = articuloBuscarView;
        this.articuloBLModelo = articuloBLModelo;
    }

    public void llenarTabla(JTable tablaArticulo) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaArticulo.setModel(modeloTabla);

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio");

        Object fila[] = new Object[5];

        String Sql = "where nombre like '%" + this.articuloBuscarView.txtBuscar.getText() + "%'";

        try {
            for (Object oAux : articuloBLModelo.obtenerConWhere(new Articulo(), Sql)) {
                Articulo s = (Articulo) oAux;
                fila[0] = s.getPK_idArticulo();
                fila[1] = s.getNombre();
                fila[2] = s.getDescripcion();
                fila[3] = s.getCantidad();
                fila[4] = s.getPrecio();

                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BuscaArticulo getArticuloBuscarView() {
        return articuloBuscarView;
    }

    public void setArticuloBuscarView(BuscaArticulo articuloBuscarView) {
        this.articuloBuscarView = articuloBuscarView;
    }

    public ArticuloBL getArticuloBLModelo() {
        return articuloBLModelo;
    }

    public void setArticuloBLModelo(ArticuloBL articuloBLModelo) {
        this.articuloBLModelo = articuloBLModelo;
    }

    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == articuloBuscarView.btSeleccionar) {
            int fila = this.articuloBuscarView.jTBuscarArticulo.getSelectedRow();
            if (fila != -1) {
                Integer idArticulo = Integer.parseInt(this.articuloBuscarView.jTBuscarArticulo.getValueAt(fila, 0).toString());
                txtRespuesta.setText(String.valueOf(idArticulo));
                this.articuloBuscarView.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(articuloBuscarView, "No se ha seleccionado un articulo.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
