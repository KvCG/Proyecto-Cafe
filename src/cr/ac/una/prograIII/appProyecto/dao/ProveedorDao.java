
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.dao;

import cr.ac.una.prograIII.appProyecto.conexion.MySQLConexion;
import cr.ac.una.prograIII.appProyecto.domain.Proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProveedorDao implements IBaseDao<Proveedor> {
     private final MySQLConexion conexion;

    public ProveedorDao() {
        conexion=new MySQLConexion();
    }
    
    

    @Override
    public void insertar(Proveedor obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("insert into proveedor (nombre,descripcion,"
                                             + "ultUsuario,"
                                             + "ultFecha) values "
                                             + "(?,?,?,curdate())");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getDescripcion());
        cs.setString(3, obj.getUltUsuario());
        
        cs.executeUpdate();
        con.close();
        
    }

    @Override
    public void modificar(Proveedor obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update proveedor set nombre = ?, "
                                            + "descripcion = ?, "
                                            + "ultUsuario = ?,"
                                            + "ultFecha = curdate() "
                                            + "where PK_idProveedor = ?");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getDescripcion());
        cs.setString(3, obj.getUltUsuario());
        cs.setInt(4, obj.getPK_idProveedor());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void eliminar(Proveedor obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from proveedor where PK_idProveedor = ?");
        cs.setInt(1, obj.getPK_idProveedor());
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public Proveedor obtenerPorId(Proveedor obj) throws SQLException {
        Proveedor s = null;
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("select * from proveedor where PK_idProveedor = ? " );
        cs.setInt(1, obj.getPK_idProveedor());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            s = new Proveedor();
            s.setPK_idProveedor(result.getInt("PK_idproveedor"));
            s.setNombre(result.getString("nombre"));
            s.setDescripcion(result.getString("descripcion"));
            s.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return s;
    }

    @Override
    public ArrayList<Proveedor> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Proveedor> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Proveedor ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Proveedor s = new Proveedor();
            s.setPK_idProveedor(result.getInt("PK_idProveedor"));
            s.setNombre(result.getString("nombre"));
            s.setDescripcion(result.getString("descripcion"));
            s.setUltUsuario(result.getString("UltUsuario"));
            l.add(s);
        }
        con.close();
        return l;
    }

    @Override
    public ArrayList<Proveedor> obtenerConWhere(String where) throws SQLException {
           Connection con = conexion.getConexion();
        ArrayList<Proveedor> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Proveedor "+where);
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Proveedor s = new Proveedor();
            s.setPK_idProveedor(result.getInt("PK_idProveedor"));
            s.setNombre(result.getString("nombre"));
            s.setDescripcion(result.getString("descripcion"));
            s.setUltUsuario(result.getString("UltUsuario"));
            l.add(s);
        }
        con.close();
        return l;
    }
    
}
