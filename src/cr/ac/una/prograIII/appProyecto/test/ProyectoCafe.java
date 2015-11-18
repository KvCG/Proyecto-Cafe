/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.test;

import cr.ac.una.prograIII.appProyecto.controlador.IncioControlador;
import cr.ac.una.prograIII.appProyecto.vista1.PantallaInicio;
import java.io.IOException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;


/**
 *
 * @author Kevin
 */
public class ProyectoCafe {

    public static void main(String[] args) throws IOException, JRException, SQLException {
        PantallaInicio pp = new PantallaInicio();
        IncioControlador i = new IncioControlador(pp);
        i.getPantInicio().setVisible(true);
        

        
}}
