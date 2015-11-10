/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import chatcliente.controlador.ClienteThreadControlador;

/**
 *
 * @author Anthony Carrillo
 */
public class ChatCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VentanaPc ventanaPcviwe=new VentanaPc();
        ClienteThreadControlador ct = new ClienteThreadControlador(ventanaPcviwe);
        ct.getVentanaPcView().setVisible(true);
    }
    
}
