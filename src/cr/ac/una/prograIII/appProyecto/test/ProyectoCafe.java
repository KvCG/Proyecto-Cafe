/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.test;

import cr.ac.una.prograIII.appProyecto.controlador.IncioControlador;
import cr.ac.una.prograIII.appProyecto.domain.Reporte;
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
        Reporte p = new Reporte();
        p.creaReporte("ListaClientes.jrxml");
        
//InputStream inputStream = null;
//        try {            
//            inputStream = new FileInputStream ("C:\\Users\\chgari.ICETEL\\Desktop\\PrograIII-Leccion14\\PrograIII-Leccion14\\src\\cr\\ac\\una\\prograIII\\appMVC\\vista\\reportes\\socioLista.jrxml");
//            Map parameters = new HashMap();
//            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//            
//            MySQLConexion Con = new MySQLConexion();
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,Con.getConexion());
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\chgari.ICETEL\\Desktop\\socioLista.pdf");
//            
//            File file = new File("C:\\Users\\chgari.ICETEL\\Desktop\\socioLista.pdf"); // Este codigo sirve para abrir los archivos de cualquier tipo
//            if (file.toString().endsWith(".pdf")) 
//                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
//            else {
//                Desktop desktop = Desktop.getDesktop();
//                desktop.open(file);
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }
}}
