/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.domain;

import javax.swing.ImageIcon;

/**
 *
 * @author Anthony Carrillo
 */
public class Pc extends javax.swing.JButton implements Runnable {
    private int numero;

    public Pc() {
        System.out.println("eee");
    }

    public Pc(int numero) {
        this.numero = numero;
        this.setVisible(true);
        this.setSize(90, 90);
        ImageIcon iconolbl = new ImageIcon("src/cr/ac/una/prograIII/appProyecto/vista/imagenes/monitor.png");
        this.setIcon(iconolbl);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
        
        
        
        
    }
    
    
    

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
