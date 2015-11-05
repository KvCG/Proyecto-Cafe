/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.bl.ArticuloBL;
import cr.ac.una.prograIII.appProyecto.domain.Articulo;
import cr.ac.una.prograIII.appProyecto.vista.BuscaArticulo;
import cr.ac.una.prograIII.appProyecto.vista.FacturaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Anthony Carrillo
 */
public class FacturaControlador implements ActionListener,DocumentListener{
    FacturaView factura;
    private ArticuloBL articuloBLModelo;

    public FacturaControlador(FacturaView factura, ArticuloBL articuloBLModelo) {
        this.factura = factura;
        this.articuloBLModelo=articuloBLModelo;
        this.factura.txtArticulo.getDocument().addDocumentListener(this);
        this.factura.btBuscarArticulo.addActionListener(this);
        this.factura.txtCantidad.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                cargaPrecio();
            }

            @Override
            public void focusLost(FocusEvent e) {
                cargaPrecio();
            }
        });
       
    }

    public ArticuloBL getArticuloBLModelo() {
        return articuloBLModelo;
    }

    public void setArticuloBLModelo(ArticuloBL articuloBLModelo) {
        this.articuloBLModelo = articuloBLModelo;
    }
    

    public FacturaView getFactura() {
        return factura;
    }

    public void setFactura(FacturaView factura) {
        this.factura = factura;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.factura.btBuscarArticulo){
            BuscaArticulo articuloBuscarView = new BuscaArticulo();
            BuscaArticuloControlador articuloBuscarControlador;
            articuloBuscarControlador = new BuscaArticuloControlador(articuloBuscarView, articuloBLModelo, factura.txtArticulo);
            articuloBuscarControlador.getArticuloBuscarView().setVisible(true);
        
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
    
    private void cargaPrecio(){
    this.factura.txtTotalArt.setText(""+Integer.parseInt(factura.txtCantidad.getText())*Integer.parseInt(factura.txtValorUnitario.getText()));
    
    }
    
    private void cargarArticulo() {
        Articulo s = new Articulo();
        if (!this.factura.txtArticulo.getText().isEmpty()) {
            s.setPK_idArticulo(Integer.parseInt(this.factura.txtArticulo.getText()));
            try {
                s = articuloBLModelo.obtenerPorId(s);
                this.factura.txtNombre.setText(s.getNombre());
                this.factura.txtValorUnitario.setText(s.getPrecio());
                this.factura.txtTotalArt.setText(""+Integer.parseInt(s.getPrecio())*Integer.parseInt(factura.txtCantidad.getText()));
                
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(factura, "Error no se pudo consultar el articulo (" + ex.getMessage() + ")", "Error al cargar articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
