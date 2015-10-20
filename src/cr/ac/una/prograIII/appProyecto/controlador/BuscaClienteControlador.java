/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.bl.ClienteBL;
import cr.ac.una.prograIII.appProyecto.domain.Cliente;
import cr.ac.una.prograIII.appProyecto.vista.BuscaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class BuscaClienteControlador implements ActionListener, KeyListener {

    private BuscaCliente busClienteView;
    private ClienteBL clienteBL;
    private JTextField repuesta;

    public BuscaClienteControlador(BuscaCliente busClienteView, ClienteBL clienteBL, JTextField repuesta) {
        this.busClienteView = busClienteView;
        this.clienteBL = clienteBL;
        this.repuesta = repuesta;
        this.busClienteView.btSeleccionar.addActionListener(this);
        llenarTabla(busClienteView.jTableCliente);
        busClienteView.txtID.addKeyListener(this);
    }

    public BuscaClienteControlador(BuscaCliente busClienteView, ClienteBL clienteBL) {
        this.busClienteView = busClienteView;
        this.clienteBL = clienteBL;
    }
    
    

    public void llenarTabla(JTable tablaCliente) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaCliente.setModel(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos");

        Object fila[] = new Object[3];

        String Sql = "where nombre like '%" + this.busClienteView.txtID.getText() + "%'";

        try {
            for (Object oAux : clienteBL.obtenerConWhere(new Cliente(), Sql)) {
                Cliente s = (Cliente) oAux;
                fila[0] = s.getPK_idCliente();
                fila[1] = s.getNombre();
                fila[2] = s.getApellidos();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.busClienteView.btSeleccionar) {
            int fila = this.busClienteView.jTableCliente.getSelectedRow();
            if (fila != -1) {
                Integer idCliente = Integer.parseInt(this.busClienteView.jTableCliente.getValueAt(fila, 0).toString());
                repuesta.setText(String.valueOf(idCliente));
                this.busClienteView.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(busClienteView, "No se ha seleccionado un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public BuscaCliente getBusClienteView() {
        return busClienteView;
    }

    public void setBusClienteView(BuscaCliente busClienteView) {
        this.busClienteView = busClienteView;
    }

    public ClienteBL getClienteBL() {
        return clienteBL;
    }

    public void setClienteBL(ClienteBL clienteBL) {
        this.clienteBL = clienteBL;
    }

    public JTextField getRepuesta() {
        return repuesta;
    }

    public void setRepuesta(JTextField repuesta) {
        this.repuesta = repuesta;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        llenarTabla(busClienteView.jTableCliente);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        llenarTabla(busClienteView.jTableCliente);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        llenarTabla(busClienteView.jTableCliente);
    }

}
