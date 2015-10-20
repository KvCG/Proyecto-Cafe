package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.bl.ArticuloBL;
import cr.ac.una.prograIII.appProyecto.domain.Articulo;
import cr.ac.una.prograIII.appProyecto.vista.BuscaArticulo;
import cr.ac.una.prograIII.appProyecto.vista.ManteArticulo;
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

public class ArticuloControlador implements ActionListener, DocumentListener {

    private ManteArticulo mantArticuloView;
    private ArticuloBL articuloBLModelo;

    public ArticuloControlador(ManteArticulo mantArticuloView, ArticuloBL articuloBLModelo) {
        this.mantArticuloView = mantArticuloView;
        this.articuloBLModelo = articuloBLModelo;
        this.mantArticuloView.btCancelar.addActionListener(this);
        this.mantArticuloView.btEliminar.addActionListener(this);
        this.mantArticuloView.btInsertar.addActionListener(this);
        this.mantArticuloView.btModificar.addActionListener(this);
        this.mantArticuloView.btConsultar.addActionListener(this);
        this.mantArticuloView.txtID.getDocument().addDocumentListener(this);
        this.mantArticuloView.btCargarr.addActionListener(this);
        inicializarPantalla();
    }

    private void inicializarPantalla() {
        this.mantArticuloView.txtID.setEnabled(false);
        mantArticuloView.btModificar.setEnabled(false);
        llenarTabla(this.mantArticuloView.jTableArticulos);

    }

    public void llenarTabla(JTable tablaArticulo) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaArticulo.setModel(modeloTabla);

        modeloTabla.addColumn("Id Articulo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Precio");

        Object fila[] = new Object[4];

        try {
            for (Object oAux : articuloBLModelo.obtenerTodos()) {
                Articulo s = (Articulo) oAux;
                fila[0] = s.getPK_idArticulo();
                fila[1] = s.getNombre();
                fila[2] = s.getDescripcion();
                fila[3] = s.getPrecio();

                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mantArticuloView, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ManteArticulo getMantArticuloView() {
        return mantArticuloView;
    }

    public void setMantArticuloView(ManteArticulo mantArticuloView) {
        this.mantArticuloView = mantArticuloView;
    }

    public ArticuloBL getArticuloBLModelo() {
        return articuloBLModelo;
    }

    public void setArticuloBLModelo(ArticuloBL articuloBLModelo) {
        this.articuloBLModelo = articuloBLModelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.mantArticuloView.btInsertar) {
            if (!mantArticuloView.txtNombre.getText().isEmpty() || !mantArticuloView.txtDescripcion.getText().isEmpty()
                    || !mantArticuloView.txtPrecio.getText().isEmpty()) {
                Articulo s = new Articulo();
                s.setPK_idArticulo(1); //como es auto generado no es relavante tomar el campo de texto id.
                s.setNombre(this.mantArticuloView.txtNombre.getText());
                s.setDescripcion(this.mantArticuloView.txtDescripcion.getText());
                try {
                    s.setPrecio((this.mantArticuloView.txtPrecio.getText()));

                    try {

                        this.articuloBLModelo.insertar(s);
                        llenarTabla(this.mantArticuloView.jTableArticulos);
                        mantArticuloView.btCancelar.doClick();
                        JOptionPane.showMessageDialog(mantArticuloView, "El articulo ha sido ingresado correctamente", "Articulo Agreagado", JOptionPane.INFORMATION_MESSAGE);

                    } catch (SQLException ex) {
                        Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(mantArticuloView, "Error al agregar el Articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(mantArticuloView, "Error al agregar el Articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ey) {
                    JOptionPane.showMessageDialog(mantArticuloView, "Formato de precio invalido");
                    //s.setPrecio(0.0);
                }

            } else {
                JOptionPane.showMessageDialog(mantArticuloView, "Todos los campos deben de estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == this.mantArticuloView.btConsultar) {
            BuscaArticulo articuloBuscarView = new BuscaArticulo();
            BuscaArticuloControlador articuloBuscarControlador;
            articuloBuscarControlador = new BuscaArticuloControlador(articuloBuscarView, articuloBLModelo, this.mantArticuloView.txtID);
            articuloBuscarControlador.getArticuloBuscarView().setVisible(true);

        }

        if (e.getSource() == this.mantArticuloView.btEliminar) {
            int fila = this.mantArticuloView.jTableArticulos.getSelectedRow();
            if (fila != -1) {
                Articulo a = new Articulo();
                int idArticulo = Integer.parseInt(this.mantArticuloView.jTableArticulos.getValueAt(fila, 0).toString());
                a.setPK_idArticulo(idArticulo);
                try {
                    articuloBLModelo.eliminar(a);
                    llenarTabla(this.mantArticuloView.jTableArticulos);
                    JOptionPane.showMessageDialog(mantArticuloView, "El articulo ha sido eliminado correctamente", "Socio Eliminado", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    String mensaje = ex.getMessage();
                    if(mensaje.contains("foreign")){
                        JOptionPane.showMessageDialog(mantArticuloView, "El articulo esta asociado a proveedores, debe eliminar los articulos al proveedor", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(mantArticuloView, "Error al eliminar el articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantArticuloView, "Error al eliminar el socio:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (!this.mantArticuloView.txtID.getText().isEmpty()) {
                    Articulo a = new Articulo();
                    int idArticulo = Integer.parseInt(mantArticuloView.txtID.getText());
                    a.setPK_idArticulo(idArticulo);
                    try {
                        articuloBLModelo.eliminar(a);
                        llenarTabla(this.mantArticuloView.jTableArticulos);
                        JOptionPane.showMessageDialog(mantArticuloView, "El articulo ha sido eliminado correctamente", "Socio Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(mantArticuloView, "Error al eliminar el articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(mantArticuloView, "Error al eliminar el socio:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(mantArticuloView, "No se ha seleccionado un articulo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == mantArticuloView.btModificar) {
            Articulo s = new Articulo();
            s.setPK_idArticulo(Integer.parseInt(mantArticuloView.txtID.getText()));
            s.setNombre(this.mantArticuloView.txtNombre.getText());
            s.setDescripcion(this.mantArticuloView.txtDescripcion.getText());
            s.setPrecio((this.mantArticuloView.txtPrecio.getText()));

            try {
                this.articuloBLModelo.modificar(s);
                mantArticuloView.btCancelar.doClick();
                llenarTabla(this.mantArticuloView.jTableArticulos);
                System.out.println("Modificado ");
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);

            }
            mantArticuloView.btModificar.setEnabled(false);

        }
        if (e.getSource() == mantArticuloView.btCancelar) {
            mantArticuloView.txtDescripcion.setText("");
            mantArticuloView.txtNombre.setText("");
            mantArticuloView.txtID.setText("");
            mantArticuloView.txtPrecio.setText("");
            mantArticuloView.btModificar.setEnabled(false);

        }
        if (e.getSource() == mantArticuloView.btCargarr) {
            int fila = this.mantArticuloView.jTableArticulos.getSelectedRow();
            if (fila != -1) {
                Articulo a = new Articulo();
                this.mantArticuloView.txtID.setText(this.mantArticuloView.jTableArticulos.getValueAt(fila, 0).toString());
                a.setPK_idArticulo(Integer.parseInt(mantArticuloView.txtID.getText()));
                mantArticuloView.btModificar.setEnabled(true);
                try {
                    a = articuloBLModelo.obtenerPorId(a);
                    this.mantArticuloView.txtNombre.setText(a.getNombre());
                    this.mantArticuloView.txtDescripcion.setText(a.getDescripcion());
                    this.mantArticuloView.txtPrecio.setText(String.valueOf(a.getPrecio()));

                } catch (SQLException ex) {
                    JOptionPane.showConfirmDialog(mantArticuloView, ex, null, fila, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(mantArticuloView, "No se ha seleccionado un articulo.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cargarArticulo();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargarArticulo();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargarArticulo();
    }

    private void cargarArticulo() {
        Articulo s = new Articulo();
        if (!this.mantArticuloView.txtID.getText().isEmpty()) {
            s.setPK_idArticulo(Integer.parseInt(this.mantArticuloView.txtID.getText()));
            try {
                s = articuloBLModelo.obtenerPorId(s);
                mantArticuloView.btModificar.setEnabled(true);
                this.mantArticuloView.txtNombre.setText(s.getNombre());
                this.mantArticuloView.txtPrecio.setText(String.valueOf(s.getPrecio()));
                mantArticuloView.txtDescripcion.setText(s.getDescripcion());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantArticuloView, "Error no se pudo consultar el articulo (" + ex.getMessage() + ")", "Error al cargar articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
