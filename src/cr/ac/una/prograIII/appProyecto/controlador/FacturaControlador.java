/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.bl.ArticuloBL;
import cr.ac.una.prograIII.appProyecto.bl.ClienteBL;
import cr.ac.una.prograIII.appProyecto.domain.Articulo;
import cr.ac.una.prograIII.appProyecto.domain.Cliente;
import cr.ac.una.prograIII.appProyecto.vista.BuscaArticulo;
import cr.ac.una.prograIII.appProyecto.vista.FacturaView;
import cr.ac.una.prograIII.appProyecto.domain.Factura;
import cr.ac.una.prograIII.appProyecto.vista.BuscaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anthony Carrillo
 */
public class FacturaControlador implements ActionListener, DocumentListener {

    private FacturaView facturaView;
    private ArticuloBL articuloBLModelo;
    private Factura factura;
    private ClienteBL clienteBlModelo;
    private ArrayList<Articulo> listaDetalle;

    public FacturaControlador(FacturaView facturaView, ArticuloBL articuloBLModelo, ClienteBL clienteBLModeL) {

        listaDetalle = new ArrayList();
        this.facturaView = facturaView;
        this.factura = new Factura();
        this.articuloBLModelo = articuloBLModelo;
        this.clienteBlModelo = clienteBLModeL;
        this.facturaView.txtIdArticulo.getDocument().addDocumentListener(this);
        this.facturaView.txtIdCliente.getDocument().addDocumentListener(this);
        this.facturaView.btBuscarArticulo.addActionListener(this);
        this.facturaView.btBuscarCliente.addActionListener(this);
        this.facturaView.btAgregar.addActionListener(this);
        this.facturaView.btEliminar.addActionListener(this);

        this.facturaView.txtCantidad.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                cargaPrecio();
            }
        });
        llenarTabla(facturaView.jTDetalle);
        fechayHora();
    }

    public void fechayHora() {
        Calendar c1 = Calendar.getInstance();
        Integer ann = c1.get(Calendar.YEAR);
        Integer dia = c1.get(Calendar.DATE);
        Integer mes = c1.get(Calendar.MONTH) + 1;
        Integer hora = c1.get(Calendar.HOUR);
        Integer min = c1.get(Calendar.MINUTE);
        Integer seg = c1.get(Calendar.SECOND);
        String ampm = "PM";
        Integer hora1 = c1.get(Calendar.HOUR_OF_DAY);
        if (hora1 < 12) {
            ampm = "AM";
        }
        facturaView.lbFecha.setText(dia.toString() + "/" + mes.toString() + "/" + ann.toString());
        facturaView.lbHora.setText(hora.toString() + ":" + min.toString() + ":" + seg.toString() + " " + ampm);
    }

    public ArticuloBL getArticuloBLModelo() {
        return articuloBLModelo;
    }

    public void setArticuloBLModelo(ArticuloBL articuloBLModelo) {
        this.articuloBLModelo = articuloBLModelo;
    }

    public FacturaView getFactura() {
        return facturaView;
    }

    public void setFactura(FacturaView factura) {
        this.facturaView = factura;
    }

    public ClienteBL getClienteBlModelo() {
        return clienteBlModelo;
    }

    public void setClienteBlModelo(ClienteBL clienteBlModelo) {
        this.clienteBlModelo = clienteBlModelo;
    }

    public void llenarTabla(JTable tablaDetalle) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaDetalle.setModel(modeloTabla);
        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("Nombre articulo");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio Unidad");
        Integer total = 0;

        Object fila[] = new Object[4];

        for (Object oAux : listaDetalle) {
            Articulo a = (Articulo) oAux;
            fila[0] = a.getPK_idArticulo();
            fila[1] = a.getNombre();
            fila[2] = a.getCantidad();
            fila[3] = a.getPrecio();
            modeloTabla.addRow(fila);
            total += a.getCantidad() * Integer.parseInt(a.getPrecio());
            facturaView.txtTotal.setText(total.toString());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.facturaView.btBuscarArticulo) {
            BuscaArticulo articuloBuscarView = new BuscaArticulo();
            BuscaArticuloControlador articuloBuscarControlador;
            articuloBuscarControlador = new BuscaArticuloControlador(articuloBuscarView, articuloBLModelo, facturaView.txtIdArticulo);
            articuloBuscarControlador.getArticuloBuscarView().setVisible(true);

        }

        if (e.getSource() == this.facturaView.btBuscarCliente) {
            BuscaCliente busClienteView = new BuscaCliente();
            BuscaClienteControlador bcc;
            bcc = new BuscaClienteControlador(busClienteView, clienteBlModelo, this.facturaView.txtIdCliente);
            bcc.getBusClienteView().setVisible(true);
        }

        if (e.getSource() == facturaView.btEliminar) {
            int fila = this.facturaView.jTDetalle.getSelectedRow();
            if (fila != -1) {
                Integer sustraendo = Integer.parseInt(this.facturaView.jTDetalle.getValueAt(fila, 3).toString()) * Integer.parseInt(this.facturaView.jTDetalle.getValueAt(fila, 2).toString());
                Integer total = Integer.parseInt(facturaView.txtTotal.getText());
                facturaView.txtTotal.setText(Integer.toString(total - sustraendo));
                listaDetalle.remove(fila);
            }
            llenarTabla(facturaView.jTDetalle);
        }

        if (e.getSource() == facturaView.btAgregar) {
            if (!facturaView.txtNombreArticulo.getText().isEmpty()) {
                Articulo a = new Articulo();
                a.setPK_idArticulo(Integer.parseInt(facturaView.txtIdArticulo.getText()));
                try {
                    a = articuloBLModelo.obtenerPorId(a);
                } catch (SQLException ex) {
                    Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (Integer.parseInt(facturaView.txtCantidad.getText()) > a.getCantidad()) {
                    JOptionPane.showMessageDialog(facturaView, "La cantidad supera las existencias", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    a.setCantidad(a.getCantidad() - Integer.parseInt(facturaView.txtCantidad.getText()));
                    try {
                        if (a.getCantidad() <= 0) {
                            articuloBLModelo.eliminar(a);
                        } else {
                            articuloBLModelo.modificar(a);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    a.setCantidad(Integer.parseInt(facturaView.txtCantidad.getText()));
                    listaDetalle.add(a);
                }
                llenarTabla(facturaView.jTDetalle);
            }else{
                JOptionPane.showMessageDialog(facturaView, "Debe seleccionar un articulo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cargarArticulo();
        cargarCliente();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargarArticulo();
        cargarCliente();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargarArticulo();
        cargarCliente();
    }

    private void cargaPrecio() {
        this.facturaView.txtTotalArt.setText("" + Integer.parseInt(facturaView.txtCantidad.getText()) * Integer.parseInt(facturaView.txtValorUnitario.getText()));

    }

    private void cargarArticulo() {
        Articulo s = new Articulo();
        if (!this.facturaView.txtIdArticulo.getText().isEmpty()) {
            s.setPK_idArticulo(Integer.parseInt(this.facturaView.txtIdArticulo.getText()));
            try {
                s = articuloBLModelo.obtenerPorId(s);
                this.facturaView.txtNombreArticulo.setText(s.getNombre());
                this.facturaView.txtValorUnitario.setText(s.getPrecio());
                this.facturaView.txtTotalArt.setText("" + Integer.parseInt(s.getPrecio()) * Integer.parseInt(facturaView.txtCantidad.getText()));

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(facturaView, "Error no se pudo consultar el articulo (" + ex.getMessage() + ")", "Error al cargar articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cargarCliente() {
        Cliente s = new Cliente();
        if (!this.facturaView.txtIdCliente.getText().isEmpty()) {
            s.setPK_idCliente(Integer.parseInt(this.facturaView.txtIdCliente.getText()));
            try {
                s = clienteBlModelo.obtenerPorId(s);
                this.facturaView.txtNombreCliente.setText(s.getNombre() + " " + s.getApellidos());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(facturaView, "Error no se pudo consultar el articulo (" + ex.getMessage() + ")", "Error al cargar articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
