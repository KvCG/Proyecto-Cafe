/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.controlador;

import cr.ac.una.prograIII.appProyecto.vista.PantallaPrincipal;
import cr.ac.una.prograIII.appProyecto.vista1.PantallaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class IncioControlador implements ActionListener {

    private PantallaInicio pantInicio;

    public IncioControlador(PantallaInicio pantInicio) {
        this.pantInicio = pantInicio;
        this.pantInicio.btIniciarSesion.addActionListener(this);
        this.pantInicio.txtPass.setText(" ");

    }

    public PantallaInicio getPantInicio() {
        return pantInicio;
    }

    public void setPantInicio(PantallaInicio pantInicio) {
        this.pantInicio = pantInicio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.pantInicio.btIniciarSesion) {
           // char [] passCorrecta = {'1', '2', '3'};
            char [] passCorrecta ={' '};
            char[] pass = this.pantInicio.txtPass.getPassword();
            if (this.pantInicio.txtUsuario.getText().equals("") && Arrays.equals(passCorrecta, pass) ) {
                PantallaPrincipal pp = new PantallaPrincipal();
                PantallaPrincipalControlador pantaPC =  new PantallaPrincipalControlador(pp);
                pantaPC.getPantallaPrinView().setVisible(true);
                this.pantInicio.dispose();
            }else{
                JOptionPane.showMessageDialog(this.pantInicio, "Usuario o contraseña invalidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
