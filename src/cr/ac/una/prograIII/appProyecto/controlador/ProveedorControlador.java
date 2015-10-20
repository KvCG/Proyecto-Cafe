package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.bl.ArticuloBL;
import cr.ac.una.prograIII.appProyecto.bl.ProveedorBL;
import cr.ac.una.prograIII.appProyecto.domain.Articulo;
import cr.ac.una.prograIII.appProyecto.domain.Proveedor;
import cr.ac.una.prograIII.appProyecto.vista.BuscaArticulo;
import cr.ac.una.prograIII.appProyecto.vista.BuscaProveedor;
import cr.ac.una.prograIII.appProyecto.vista.ManteArticulo;
import cr.ac.una.prograIII.appProyecto.vista.ManteProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class ProveedorControlador implements ActionListener, DocumentListener {

    private ManteProveedor mantProveedorView;
    private ProveedorBL ProveedorBLModelo;

    public ProveedorControlador(ManteProveedor mantProveedorView, ProveedorBL ProveedorBLModelo) {
        this.mantProveedorView = mantProveedorView;
        this.ProveedorBLModelo = ProveedorBLModelo;
        this.mantProveedorView.btCancelar.addActionListener(this);
        this.mantProveedorView.btEliminar.addActionListener(this);
        this.mantProveedorView.btInsertar.addActionListener(this);
        this.mantProveedorView.btModificar.addActionListener(this);
        this.mantProveedorView.btConsultar.addActionListener(this);
        this.mantProveedorView.txtID.getDocument().addDocumentListener(this);
        this.mantProveedorView.btCargar.addActionListener(this);
        inicializarPantalla();
    }

    private void inicializarPantalla() {
        this.mantProveedorView.txtID.setEnabled(false);
        this.mantProveedorView.btModificar.setEnabled(false);
        llenarTabla(this.mantProveedorView.jTableProveedor);

    }

    public void llenarTabla(JTable tablaProveedor) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaProveedor.setModel(modeloTabla);

        modeloTabla.addColumn("Id Articulo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripcion");

        Object fila[] = new Object[3];

        try {
            for (Object oAux : ProveedorBLModelo.obtenerTodos()) {
                Proveedor s = (Proveedor) oAux;
                fila[0] = s.getPK_idProveedor();
                fila[1] = s.getNombre();
                fila[2] = s.getDescripcion();

                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mantProveedorView, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.mantProveedorView.btInsertar) {
            if (!mantProveedorView.txtNombre.getText().isEmpty() && !mantProveedorView.txtDescripcion.getText().isEmpty()) {
                Proveedor s = new Proveedor();
                s.setNombre(this.mantProveedorView.txtNombre.getText());
                s.setDescripcion(this.mantProveedorView.txtDescripcion.getText());
                try {
                    this.ProveedorBLModelo.insertar(s);
                    mantProveedorView.btCancelar.doClick();
                    llenarTabla(this.mantProveedorView.jTableProveedor);
                    JOptionPane.showMessageDialog(mantProveedorView, "El proveedor ha sido ingresado correctamente", "Proveedor Agreagado", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantProveedorView, "Error al agregar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantProveedorView, "Error al agregar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(mantProveedorView, "Todos los campos deben de estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == this.mantProveedorView.btConsultar) {
            BuscaProveedor proveedorBuscarView = new BuscaProveedor();
            BuscaProveedorControlador proveedorBuscarControlador = new BuscaProveedorControlador(proveedorBuscarView, ProveedorBLModelo, this.mantProveedorView.txtID);
            proveedorBuscarControlador.getProveedorBuscarView().setVisible(true);
        }

        if (e.getSource() == this.mantProveedorView.btEliminar) {
            int fila = this.mantProveedorView.jTableProveedor.getSelectedRow();
            if (fila != -1) {
                Proveedor a = new Proveedor();
                int idProveedor = Integer.parseInt(this.mantProveedorView.jTableProveedor.getValueAt(fila, 0).toString());
                a.setPK_idProveedor(idProveedor);
                try {
                    ProveedorBLModelo.eliminar(a);
                    llenarTabla(this.mantProveedorView.jTableProveedor);
                    JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor ha sido eliminado correctamente", "Proveedor Eliminado", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantProveedorView, "Error al eliminar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantProveedorView, "Error al Proveedor el proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (!mantProveedorView.txtID.getText().isEmpty()) {
                    Proveedor a = new Proveedor();
                    int idProveedor = Integer.parseInt(this.mantProveedorView.txtID.getText());
                    a.setPK_idProveedor(idProveedor);
                    try {
                        ProveedorBLModelo.eliminar(a);
                        mantProveedorView.btCancelar.doClick();
                        llenarTabla(this.mantProveedorView.jTableProveedor);
                        JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor ha sido eliminado correctamente", "Proveedor Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(mantProveedorView, "Error al eliminar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(mantProveedorView, "Error al Proveedor el proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(mantProveedorView, "No ha seleccionado ningun Proveedor");
                }
            }
        }

        if (e.getSource() == this.mantProveedorView.btModificar) {
            Proveedor s = new Proveedor();
            s.setPK_idProveedor(Integer.parseInt(mantProveedorView.txtID.getText()));
            s.setNombre(this.mantProveedorView.txtNombre.getText());
            s.setDescripcion(this.mantProveedorView.txtDescripcion.getText());
            try {
                this.ProveedorBLModelo.modificar(s);
                this.mantProveedorView.btModificar.setEnabled(false);
                mantProveedorView.btCancelar.doClick();
                llenarTabla(this.mantProveedorView.jTableProveedor);

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

        if (e.getSource() == this.mantProveedorView.btCancelar) {
            mantProveedorView.txtDescripcion.setText("");
            mantProveedorView.txtNombre.setText("");
            mantProveedorView.txtID.setText("");

        }

        if (e.getSource() == this.mantProveedorView.btCargar) {
            int fila = this.mantProveedorView.jTableProveedor.getSelectedRow();
            if (fila != -1) {
                Proveedor a = new Proveedor();
                this.mantProveedorView.txtID.setText(this.mantProveedorView.jTableProveedor.getValueAt(fila, 0).toString());
                a.setPK_idProveedor(Integer.parseInt(mantProveedorView.txtID.getText()));
                try {
                    a = ProveedorBLModelo.obtenerPorId(a);
                    this.mantProveedorView.btModificar.setEnabled(true);
                    this.mantProveedorView.txtNombre.setText(a.getNombre());
                    this.mantProveedorView.txtDescripcion.setText(a.getDescripcion());

                } catch (SQLException ex) {
                    JOptionPane.showConfirmDialog(mantProveedorView, ex, null, fila, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(mantProveedorView, "No se ha seleccionado un proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cargarProveedor() {
        Proveedor s = new Proveedor();
        if (!this.mantProveedorView.txtID.getText().isEmpty()) {
            s.setPK_idProveedor(Integer.parseInt(this.mantProveedorView.txtID.getText()));
            try {
                s = ProveedorBLModelo.obtenerPorId(s);
                this.mantProveedorView.btModificar.setEnabled(true);
                this.mantProveedorView.txtNombre.setText(s.getNombre());
                this.mantProveedorView.txtDescripcion.setText(s.getDescripcion());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantProveedorView, "Error no se pudo consultar el proveedor (" + ex.getMessage() + ")", "Error al cargar proveedor", JOptionPane.ERROR_MESSAGE);
                Logger
                        .getLogger(ArticuloControlador.class
                                .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cargarProveedor();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargarProveedor();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargarProveedor();
    }

    public ManteProveedor getMantProveedorView() {
        return mantProveedorView;
    }

    public void setMantProveedorView(ManteProveedor mantProveedorView) {
        this.mantProveedorView = mantProveedorView;
    }

    public ProveedorBL getProveedorBLModelo() {
        return ProveedorBLModelo;
    }

    public void setProveedorBLModelo(ProveedorBL ProveedorBLModelo) {
        this.ProveedorBLModelo = ProveedorBLModelo;
    }

}
