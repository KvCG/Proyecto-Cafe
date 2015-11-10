/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Anthony Carrillo
 */
public class MySQLConexion {

    private Connection con;
    private String usuario;
    private String password;
    private String server;
    private String baseDatos;
    private String puerto;

    public MySQLConexion(String usuario, String password, String server, String baseDatos, String puerto) {
        this.usuario = usuario;
        this.password = password;
        this.server = server;
        this.baseDatos = baseDatos;
        this.puerto = puerto;
    }

    public MySQLConexion() {
        this.usuario = "root";
        this.password = "tnch15";
        this.server = "127.0.0.1";
        this.baseDatos = "proyecto";
        this.puerto = "3306";
    }

    public Connection getConexion() throws SQLException {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String stringConexion = "jdbc:MySql://" + server + ":" + puerto + "/" + baseDatos;
            con = DriverManager.getConnection(stringConexion, usuario, password);
            return con;

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
    }

    public void cerrarConexion() throws SQLException {
        con.close();
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

}
