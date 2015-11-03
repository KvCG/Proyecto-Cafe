/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.dao;

import cr.ac.una.prograIII.appProyecto.conexion.MySQLConexion;
import cr.ac.una.prograIII.appProyecto.domain.Articulo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anthony Carrillo
 */
public class ArticuloDao implements IBaseDao<Articulo> {

    private final MySQLConexion conexion;

    public ArticuloDao() {
        conexion = new MySQLConexion();

    }

    @Override
    public void insertar(Articulo obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("insert into articulo (nombre,descripcion,"
                + "precio,"
                +"cantidad,"
                + "ultUsuario,"
                + "ultFecha) values "
                + "(?,?,?,?,?,curdate())");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getDescripcion());
        cs.setString(3, obj.getPrecio());
        cs.setInt(4, obj.getCantidad());
        cs.setString(5, obj.getUltUsuario());

        cs.executeUpdate();
        con.close();

    }

    @Override
    public void modificar(Articulo obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("update articulo set nombre = ?, "
                + "descripcion = ?, precio = ?, cantidad = ?, "
                + "ultUsuario = ?,"
                + "ultFecha = curdate() "
                + "where PK_idArticulo = ?");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getDescripcion());
        cs.setString(3, obj.getPrecio());
        cs.setInt(4, obj.getCantidad());
        cs.setString(5, obj.getUltUsuario());
        cs.setInt(6, obj.getPK_idArticulo());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void eliminar(Articulo obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("delete from articulo where PK_idArticulo = ?");
        cs.setInt(1, obj.getPK_idArticulo());

        cs.executeUpdate();
        con.close();

    }

    @Override
    public Articulo obtenerPorId(Articulo obj) throws SQLException {
        Articulo s = null;
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("select * from articulo where PK_idArticulo = ? ");
        cs.setInt(1, obj.getPK_idArticulo());

        ResultSet result = cs.executeQuery();
        while (result.next()) {
            s = new Articulo();
            s.setPK_idArticulo(result.getInt("PK_idArticulo"));
            s.setNombre(result.getString("nombre"));
            s.setDescripcion(result.getString("descripcion"));
            s.setPrecio(result.getString("precio"));
            s.setCantidad(result.getInt("cantidad"));
            s.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return s;
    }

    @Override
    public ArrayList<Articulo> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Articulo> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from Articulo ");

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Articulo s = new Articulo();
            s.setPK_idArticulo(result.getInt("PK_idArticulo"));
            s.setNombre(result.getString("nombre"));
            s.setDescripcion(result.getString("descripcion"));
            s.setCantidad(result.getInt("cantidad"));
            s.setPrecio(result.getString("precio"));
            s.setUltUsuario(result.getString("UltUsuario"));
            l.add(s);
        }
        con.close();
        return l;
    }

    @Override
    public ArrayList<Articulo> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Articulo> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from articulo " + where);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Articulo s = new Articulo();
            s.setPK_idArticulo(result.getInt("PK_idArticulo"));
            s.setNombre(result.getString("nombre"));
            s.setDescripcion(result.getString("descripcion"));
            s.setPrecio(result.getString("precio"));
            s.setCantidad(result.getInt("cantidad"));
            s.setUltUsuario(result.getString("UltUsuario"));
            l.add(s);
        }
        con.close();
        return l;
    }

}
