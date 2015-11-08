/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.dao;

import cr.ac.una.prograIII.appProyecto.conexion.MySQLConexion;
import cr.ac.una.prograIII.appProyecto.domain.Factura;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class FacturaDao implements IBaseDao<Factura>{
private final MySQLConexion conexion;
    public FacturaDao() {
        conexion= new MySQLConexion();
    }
    
    
    @Override
    public void insertar(Factura obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("insert into Factura (idFactura,"
                                             + "fecha, ultUsuario,"
                                             + "ultFecha) values "
                                             + "(?,?,?,curdate())");
        cs.setInt(1, obj.getIdFactura());
        cs.setString(2, obj.getFecha());
        cs.setString(3, obj.getUltUsuario());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(Factura obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update Factura set idFactura = ?, "
                                            + "fecha = ?, ultUsuario = ?,"
                                            + "utlFecha = curdate() "
                                            + "where idFactura = ?");
       cs.setInt(1, obj.getIdFactura());
        cs.setString(2, obj.getFecha());
        cs.setString(3, obj.getUltUsuario());
        cs.setString(4, obj.getUltFecha());
        cs.executeUpdate();
        con.close();
        
    }

    @Override
    public void eliminar(Factura obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from Factura where idFactura = ?");
        cs.setInt(1, obj.getIdFactura());
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public Factura obtenerPorId(Factura obj) throws SQLException {
        Factura Fac = null;
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("select * from Factura where idFactura = ? " );
        cs.setInt(1, obj.getIdFactura());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            Fac = new Factura();
            Fac.setIdFactura(result.getInt("idFactura"));
            Fac.setFecha(result.getString("fecha"));
            Fac.setUltFecha(result.getString("UltFecha"));
            Fac.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return Fac;
    }

    @Override
    public ArrayList<Factura> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Factura> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Factura ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Factura Fac = new Factura();
            Fac.setIdFactura(result.getInt("idFactura"));
            Fac.setFecha(result.getString("fecha"));
            Fac.setUltFecha(result.getString("UltFecha"));
            Fac.setUltUsuario(result.getString("UltUsuario"));
            l.add(Fac);
        }
        con.close();
        return l;
    }
    @Override
    public ArrayList<Factura> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Factura> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Factura "+where );
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Factura Fac = new Factura();
           Fac.setIdFactura(result.getInt("idFactura"));
            Fac.setFecha(result.getString("fecha"));
            Fac.setUltFecha(result.getString("UltFecha"));
            Fac.setUltUsuario(result.getString("UltUsuario"));
            l.add(Fac);
        }
        con.close();
        return l;
    }

    
}
