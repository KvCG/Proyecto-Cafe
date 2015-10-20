/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.bl.ClienteBL;
import cr.ac.una.prograIII.appProyecto.domain.Cliente;
import cr.ac.una.prograIII.appProyecto.vista.BuscaCliente;
import cr.ac.una.prograIII.appProyecto.vista1.ManteCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class ClienteControlador implements ActionListener, DocumentListener {

    private ManteCliente mantClienteView;
    private ClienteBL clienteBlModelo;

    public ClienteControlador(ManteCliente mantClienteView, ClienteBL clienteBlModelo) {
        this.mantClienteView = mantClienteView;
        this.clienteBlModelo = clienteBlModelo;

        this.mantClienteView.btCancelar.addActionListener(this);
        this.mantClienteView.btIsertar.addActionListener(this);
        this.mantClienteView.btModificar.addActionListener(this);
        this.mantClienteView.btEliminar.addActionListener(this);
        this.mantClienteView.btConsultar.addActionListener(this);
        this.mantClienteView.btCargar.addActionListener(this);
        this.mantClienteView.txtID.getDocument().addDocumentListener(this);
        inicializarPantalla();
    }

    private void inicializarPantalla() {
        mantClienteView.btModificar.setEnabled(false);
        this.mantClienteView.txtID.setEnabled(false);
        llenarTabla(this.mantClienteView.jTablaClientes);
    }

    public void llenarTabla(JTable tablaClientes) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaClientes.setModel(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos");
        modeloTabla.addColumn("Fec. Nac.");
        modeloTabla.addColumn("Telefono");

        Object fila[] = new Object[5];
        try {
            for (Object oAux : clienteBlModelo.obtenerTodos()) {
                Cliente c = (Cliente) oAux;
                fila[0] = c.getPK_idCliente();
                fila[1] = c.getNombre();
                fila[2] = c.getApellidos();
                fila[3] = c.getFechaNacimiento();
                fila[4] = c.getTelefono();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mantClienteView, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ManteCliente getMantClienteView() {
        return mantClienteView;
    }

    public void setMantClienteView(ManteCliente mantClienteView) {
        this.mantClienteView = mantClienteView;
    }

    public ClienteBL getClienteBlModelo() {
        return clienteBlModelo;
    }

    public void setClienteBlModelo(ClienteBL clienteBlModelo) {
        this.clienteBlModelo = clienteBlModelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mantClienteView.btIsertar) {
            if (!mantClienteView.txtNombre.getText().isEmpty() || !mantClienteView.txtApellidos.getText().isEmpty()
                    || !mantClienteView.txtDireccion.getText().isEmpty()) {
                Cliente c = new Cliente();
                c.setNombre(this.mantClienteView.txtNombre.getText());
                c.setApellidos(this.mantClienteView.txtApellidos.getText());
                c.setTelefono(this.mantClienteView.txtTelefono.getText());
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
                c.setFechaNacimiento(formatoFecha.format(this.mantClienteView.jCFecNac.getDate()));
                c.setDireccion(this.mantClienteView.txtDireccion.getText());
                c.setObservaciones(this.mantClienteView.txtObservaciones.getText());
                try {
                    this.clienteBlModelo.insertar(c);
                    llenarTabla(this.mantClienteView.jTablaClientes);
                    JOptionPane.showMessageDialog(mantClienteView, "El cliente ha sido ingresado correctamente.", "Cliente Agregado", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantClienteView, "Error al agregar el cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantClienteView, "Error al eliminar el cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(mantClienteView, "Todos los campos deben de estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            mantClienteView.btCancelar.doClick();

        }

        if (e.getSource() == mantClienteView.btCargar) {
            int fila = this.mantClienteView.jTablaClientes.getSelectedRow();
            if (fila != -1) {
                Cliente a = new Cliente();
                a.setPK_idCliente(Integer.parseInt(this.mantClienteView.jTablaClientes.getValueAt(fila, 0).toString()));
                try {
                    a = clienteBlModelo.obtenerPorId(a);
                    mantClienteView.btModificar.setEnabled(true);
                    this.mantClienteView.txtID.setText(Integer.toString(a.getPK_idCliente()));
                    this.mantClienteView.txtNombre.setText(a.getNombre());
                    this.mantClienteView.txtApellidos.setText(a.getApellidos());
                    this.mantClienteView.txtTelefono.setText(a.getTelefono());
                    this.mantClienteView.txtDireccion.setText(a.getDireccion());
                    this.mantClienteView.txtObservaciones.setText(a.getObservaciones());
                    Date d = new Date();
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        d = sdf.parse(a.getFechaNacimiento());
                    } catch (ParseException ex) {
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantClienteView, "Error al cargar:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                mantClienteView.btModificar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(mantClienteView, "No se ha seleccionado un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == mantClienteView.btEliminar) {
            int fila = this.mantClienteView.jTablaClientes.getSelectedRow();
            if (fila != -1) {
                Cliente s = new Cliente();
                int idC = Integer.parseInt(this.mantClienteView.jTablaClientes.getValueAt(fila, 0).toString());
                s.setPK_idCliente(idC);
                try {
                    clienteBlModelo.eliminar(s);
                    llenarTabla(this.mantClienteView.jTablaClientes);
                    JOptionPane.showMessageDialog(mantClienteView, "El cliente ha sido eliminado correctamente", "Cliente Eliminado", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantClienteView, "Error al eliminar el cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantClienteView, "Error al eliminar el cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (!this.mantClienteView.txtID.getText().isEmpty()) {
                    Cliente s = new Cliente();
                    int idC = Integer.parseInt(mantClienteView.txtID.getText());
                    s.setPK_idCliente(idC);
                    try {
                        clienteBlModelo.eliminar(s);
                        llenarTabla(this.mantClienteView.jTablaClientes);
                        mantClienteView.btCancelar.doClick();
                        JOptionPane.showMessageDialog(mantClienteView, "El cliente ha sido eliminado correctamente", "Cliente Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(mantClienteView, "Error al eliminar el cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(mantClienteView, "Error al eliminar el cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(mantClienteView, "No se ha seleccionado un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource() == mantClienteView.btCancelar) {
            mantClienteView.txtID.setText("");
            mantClienteView.txtNombre.setText("");
            mantClienteView.txtApellidos.setText("");
            mantClienteView.txtTelefono.setText("");
            mantClienteView.txtDireccion.setText("");
            mantClienteView.txtObservaciones.setText("");
            mantClienteView.jCFecNac.setDate(null);
            mantClienteView.btModificar.setEnabled(false);
        }

        if (e.getSource() == mantClienteView.btModificar) {
            Cliente a = new Cliente();
            a.setPK_idCliente(Integer.parseInt(this.mantClienteView.txtID.getText()));
            a.setNombre(this.mantClienteView.txtNombre.getText());
            a.setApellidos(this.mantClienteView.txtApellidos.getText());
            a.setDireccion(this.mantClienteView.txtDireccion.getText());
            a.setTelefono(this.mantClienteView.txtTelefono.getText());
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
            a.setFechaNacimiento(formatoFecha.format(this.mantClienteView.jCFecNac.getDate()));
            a.setObservaciones(this.mantClienteView.txtObservaciones.getText());

            try {
                clienteBlModelo.modificar(a);
                llenarTabla(this.mantClienteView.jTablaClientes);
                JOptionPane.showMessageDialog(mantClienteView, "El cliente ha sido modificado correctamente", "Cliente modificado", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantClienteView, "Error al modificar:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            mantClienteView.btModificar.setEnabled(false);
            mantClienteView.btCancelar.doClick();
        }

        if (e.getSource() == this.mantClienteView.btConsultar) {
            BuscaCliente busClienteView = new BuscaCliente();
            BuscaClienteControlador bcc;
            bcc = new BuscaClienteControlador(busClienteView, clienteBlModelo, this.mantClienteView.txtID);
            bcc.getBusClienteView().setVisible(true);
        }
    }

    public void cargaCliente() {
        Cliente a = new Cliente();
        if (!this.mantClienteView.txtID.getText().isEmpty()) {
            a.setPK_idCliente(Integer.parseInt(this.mantClienteView.txtID.getText()));
            try {
                a = clienteBlModelo.obtenerPorId(a);
                this.mantClienteView.btModificar.setEnabled(true);
                this.mantClienteView.txtNombre.setText(a.getNombre());
                this.mantClienteView.txtApellidos.setText(a.getApellidos());
                this.mantClienteView.txtTelefono.setText(a.getTelefono());
                this.mantClienteView.txtDireccion.setText(a.getDireccion());
                this.mantClienteView.txtObservaciones.setText(a.getObservaciones());
                Date d = new Date();
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    d = sdf.parse(a.getFechaNacimiento());
                } catch (ParseException ex) {
                }
                this.mantClienteView.jCFecNac.setDate(d);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantClienteView, "Error no se pudo consultar el cliente (" + ex.getMessage() + ")", "Error al cargar cliente", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cargaCliente();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargaCliente();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargaCliente();
    }
}
