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
import cr.ac.una.prograIII.appProyecto.domain.Detalle;
import cr.ac.una.prograIII.appProyecto.vista.BuscaArticulo;
import cr.ac.una.prograIII.appProyecto.vista.FacturaView;
import cr.ac.una.prograIII.appProyecto.domain.Factura;
import cr.ac.una.prograIII.appProyecto.vista.BuscaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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

    public FacturaControlador(FacturaView facturaView, ArticuloBL articuloBLModelo, ClienteBL clienteBLModeL) {
        this.facturaView = facturaView;
        this.factura = new Factura();
        this.articuloBLModelo = articuloBLModelo;
        this.clienteBlModelo = clienteBLModeL;
        this.facturaView.txtArticulo.getDocument().addDocumentListener(this);
        this.facturaView.txtIdCliente.getDocument().addDocumentListener(this);
        this.facturaView.btBuscarArticulo.addActionListener(this);
        this.facturaView.btBuscarCliente.addActionListener(this);
        this.facturaView.btAgregar.addActionListener(this);
        this.facturaView.btEliminar.addActionListener(this);
        this.facturaView.txtCantidad.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                cargaPrecio();
            }

            @Override
            public void focusLost(FocusEvent e) {
                cargaPrecio();
            }
        });
        //  llenarTabla(facturaView.jTDetalle);
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
        modeloTabla.addColumn("Nombre articulo");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio Unidad");
        modeloTabla.addColumn("Total");

        if (!factura.getDetalle().isEmpty()) {
            Object fila[] = new Object[4];
            try {
                for (Object oAux : factura.getDetalle()) {
                    Detalle c = (Detalle) oAux;
                    Articulo a = new Articulo();
                    a.setPK_idArticulo(c.getIdArticulo());
                    a = articuloBLModelo.obtenerPorId(a);
                    fila[0] = a.getNombre();
                    fila[1] = a.getCantidad();
                    fila[2] = a.getPrecio();
                    fila[3] = a.getCantidad() * Double.parseDouble(a.getPrecio());
                    modeloTabla.addRow(fila);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(facturaView, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.facturaView.btBuscarArticulo) {
            BuscaArticulo articuloBuscarView = new BuscaArticulo();
            BuscaArticuloControlador articuloBuscarControlador;
            articuloBuscarControlador = new BuscaArticuloControlador(articuloBuscarView, articuloBLModelo, facturaView.txtArticulo);
            articuloBuscarControlador.getArticuloBuscarView().setVisible(true);

        }

        if (e.getSource() == this.facturaView.btBuscarCliente) {
            BuscaCliente busClienteView = new BuscaCliente();
            BuscaClienteControlador bcc;
            bcc = new BuscaClienteControlador(busClienteView, clienteBlModelo, this.facturaView.txtIdCliente);
            bcc.getBusClienteView().setVisible(true);
        }

        if (e.getSource() == facturaView.btAgregar) {
            Detalle d = new Detalle(Integer.parseInt(facturaView.txtArticulo.getText()), Integer.parseInt(facturaView.txtArticulo.getText()), Integer.parseInt(facturaView.txtArticulo.getText()),
                    Double.parseDouble(facturaView.txtValorUnitario.getText()), Integer.parseInt(facturaView.txtCantidad.getText()));
            factura.inserta(d);
        }

        if (e.getSource() == facturaView.btEliminar) {
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
        if (!this.facturaView.txtArticulo.getText().isEmpty()) {
            s.setPK_idArticulo(Integer.parseInt(this.facturaView.txtArticulo.getText()));
            try {
                s = articuloBLModelo.obtenerPorId(s);
                this.facturaView.txtNombre.setText(s.getNombre());
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
                this.facturaView.txtNombreCliente.setText(s.getNombre()+" "+s.getApellidos());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(facturaView, "Error no se pudo consultar el articulo (" + ex.getMessage() + ")", "Error al cargar articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

  }
