/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.domain;

import cr.ac.una.prograIII.appProyecto.conexion.MySQLConexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Kevin
 */
public class Reporte {

    

    public void creaReporte(String a) throws IOException, JRException, SQLException {
        
        InputStream inputStream = null;
        try {
            String directorio = System.getProperty("user.dir");
            String separador = System.getProperty("file.separator");
            System.out.println(directorio);
            System.out.println(separador);
            inputStream = new FileInputStream(directorio+separador+"src\\cr\\ac\\una\\prograIII\\appProyecto\\vista\\reportes\\"+a);
            //inputStream = new FileInputStream("C:\\Users\\chgari.ICETEL\\Desktop\\PrograIII-Leccion14\\PrograIII-Leccion14\\src\\cr\\ac\\una\\prograIII\\appMVC\\vista\\reportes\\socioLista.jrxml");
            Map parameters = new HashMap();
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            MySQLConexion Con = new MySQLConexion();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, Con.getConexion());
            JasperExportManager.exportReportToPdfFile(jasperPrint, directorio+separador+"Reportes\\"+a+".pdf");

            File file = new File(directorio+separador+"Reportes\\"+a+".pdf"); // Este codigo sirve para abrir los archivos de cualquier tipo
            System.out.println(file.getAbsolutePath());
            if (file.toString().endsWith(".pdf")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
            } else {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
