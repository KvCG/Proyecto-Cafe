/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.bl.ArtProvBL;
import cr.ac.una.prograIII.appProyecto.bl.ArticuloBL;
import cr.ac.una.prograIII.appProyecto.bl.ProveedorBL;
import cr.ac.una.prograIII.appProyecto.domain.ArtProv;
import cr.ac.una.prograIII.appProyecto.domain.Articulo;
import cr.ac.una.prograIII.appProyecto.domain.Proveedor;
import cr.ac.una.prograIII.appProyecto.vista.BuscaArticulo;
import cr.ac.una.prograIII.appProyecto.vista.BuscaProveedor;
import cr.ac.una.prograIII.appProyecto.vista.ManteArtProv;
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

/**
 *
 * @author Kevin
 */
public class ArtProvControlador implements ActionListener, DocumentListener {

    private ManteArtProv manteArtProvView;
    private ArticuloBL artBL;
    private ProveedorBL provBL;
    private ArtProvBL artProvBL;

    public ArtProvControlador(ManteArtProv manteArtProvView, ArtProvBL artProvBL) {
        this.manteArtProvView = manteArtProvView;
        this.artProvBL = artProvBL;
        artBL = new ArticuloBL();
        provBL = new ProveedorBL();

        this.manteArtProvView.btBuscaArt.addActionListener(this);
        this.manteArtProvView.btBuscaProv.addActionListener(this);
        this.manteArtProvView.btIsertar.addActionListener(this);
        this.manteArtProvView.btEliminar.addActionListener(this);
        this.manteArtProvView.btCancelar.addActionListener(this);
        this.manteArtProvView.txtIDProv.getDocument().addDocumentListener(this);
        this.manteArtProvView.txtIDArt.getDocument().addDocumentListener(this);
        inicializarPantalla();
    }

    public ManteArtProv getManteArtProvView() {
        return manteArtProvView;
    }

    public void setManteArtProvView(ManteArtProv manteArtProvView) {
        this.manteArtProvView = manteArtProvView;
    }

    public ArticuloBL getArtBL() {
        return artBL;
    }

    public void setArtBL(ArticuloBL artBL) {
        this.artBL = artBL;
    }

    public ProveedorBL getProvBL() {
        return provBL;
    }

    public void setProvBL(ProveedorBL provBL) {
        this.provBL = provBL;
    }

    public ArtProvBL getArtProvBL() {
        return artProvBL;
    }

    public void setArtProvBL(ArtProvBL artProvBL) {
        this.artProvBL = artProvBL;
    }

    public void inicializarPantalla() {
        this.manteArtProvView.txtIDArt.setEnabled(false);
        this.manteArtProvView.txtIDProv.setEnabled(false);
        this.manteArtProvView.txtNombreArt.setEnabled(false);
        this.manteArtProvView.txtNombreProv.setEnabled(false);
        this.manteArtProvView.txtPrecio.setEnabled(false);

        llenarTabla(this.manteArtProvView.jTArtProv);
    }

    public void llenarTabla(JTable artProv) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        artProv.setModel(modeloTabla);

        modeloTabla.addColumn("ID Articulo");
        modeloTabla.addColumn("Nombre articulo");

        Object fila[] = new Object[2];

        try {
            for (Object oAux : artProvBL.obtenerTodos()) {

                ArtProv s = (ArtProv) oAux;
                fila[0] = s.getIdArticulo();
                fila[1] = s.getNombreArticulo();

                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(manteArtProvView, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == manteArtProvView.btIsertar) {
            if (!manteArtProvView.txtIDArt.getText().isEmpty() || !manteArtProvView.txtIDProv.getText().isEmpty()) {
                ArtProv c = new ArtProv();
                c.setIdArticulo(Integer.parseInt(manteArtProvView.txtIDArt.getText()));
                c.setIdProveedor(Integer.parseInt(manteArtProvView.txtIDProv.getText()));
                try {
                    this.artProvBL.insertar(c);
                    manteArtProvView.txtIDArt.setText("");
                    manteArtProvView.txtNombreArt.setText("");
                    manteArtProvView.txtPrecio.setText("");
                    llenarTabla(this.manteArtProvView.jTArtProv);
                    JOptionPane.showMessageDialog(manteArtProvView, "Ha sido ingresado correctamente.", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(ArtProvControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(manteArtProvView, "Error al agregar:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(ArtProvControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(manteArtProvView, "Error al eliminar el cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(manteArtProvView, "Todos los campos deben de estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == manteArtProvView.btEliminar) {
            int fila = this.manteArtProvView.jTArtProv.getSelectedRow();
            if (fila != -1) {
                ArtProv s = new ArtProv();
                int idC = Integer.parseInt(this.manteArtProvView.jTArtProv.getValueAt(fila, 0).toString());
                s.setIdArticulo(idC);
                try {
                    artProvBL.eliminar(s);
                    llenarTabla(this.manteArtProvView.jTArtProv);
                    JOptionPane.showMessageDialog(manteArtProvView, "Ha sido eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(manteArtProvView, "Error al eliminar:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(ArtProvControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(manteArtProvView, "Error al eliminar:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(manteArtProvView, "No se ha seleccionado una fila.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == manteArtProvView.btCancelar) {
            manteArtProvView.txtIDArt.setText("");
            manteArtProvView.txtNombreArt.setText("");
            manteArtProvView.txtPrecio.setText("");
            manteArtProvView.txtIDProv.setText("");
            manteArtProvView.txtNombreProv.setText("");
        }

        if (e.getSource() == manteArtProvView.btBuscaArt) {
            BuscaArticulo buscArtView = new BuscaArticulo();
            BuscaArticuloControlador abc;
            abc = new BuscaArticuloControlador(buscArtView, artBL, this.manteArtProvView.txtIDArt);
            abc.getArticuloBuscarView().setVisible(true);
        }

        if (e.getSource() == manteArtProvView.btBuscaProv) {
            BuscaProveedor buscProView = new BuscaProveedor();
            BuscaProveedorControlador abc;
            abc = new BuscaProveedorControlador(buscProView, provBL, this.manteArtProvView.txtIDProv);
            abc.getProveedorBuscarView().setVisible(true);
        }

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cargaArticulo();
        cargaProveedor();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargaArticulo();
        cargaProveedor();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargaArticulo();
        cargaProveedor();
    }

    public void cargaArticulo() {
        Articulo s = new Articulo();
        if (!this.manteArtProvView.txtIDArt.getText().isEmpty()) {
            s.setPK_idArticulo(Integer.parseInt(this.manteArtProvView.txtIDArt.getText()));
            try {
                s = artBL.obtenerPorId(s);
                manteArtProvView.txtNombreArt.setText((s.getNombre()));
                manteArtProvView.txtPrecio.setText(s.getPrecio());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(manteArtProvView, "Error no se pudo consultar el articulo (" + ex.getMessage() + ")", "Error al cargar articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArtProvControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cargaProveedor() {
        Proveedor s = new Proveedor();
        if (!this.manteArtProvView.txtIDProv.getText().isEmpty()) {
            s.setPK_idProveedor(Integer.parseInt(this.manteArtProvView.txtIDProv.getText()));
            try {
                s = provBL.obtenerPorId(s);
                manteArtProvView.txtNombreProv.setText((s.getNombre()));

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(manteArtProvView, "Error no se pudo consultar el proveedor (" + ex.getMessage() + ")", "Error al cargar proveedor", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArtProvControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
