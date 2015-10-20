/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.dao;

import cr.ac.una.prograIII.appProyecto.conexion.MySQLConexion;
import cr.ac.una.prograIII.appProyecto.domain.Cliente;
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
public class ClienteDao implements IBaseDao<Cliente> {

    private final MySQLConexion conexion;

    public ClienteDao() {
        conexion = new MySQLConexion();

    }

    @Override
    public void insertar(Cliente obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("insert into cliente (nombre,apellidos,telefono,"
                + "direccion,fecha_nacimiento,observaciones,"
                + "ultUsuario,"
                + "ultFecha) values "
                + "(?,?,?,?,?,?,?,curdate())");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getApellidos());
        cs.setString(3, obj.getTelefono());
        cs.setString(4, obj.getDireccion());
        cs.setString(5, obj.getFechaNacimiento());
        cs.setString(6, obj.getObservaciones());
        cs.setString(7, obj.getUltUsuario());

        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(Cliente obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("update cliente set nombre = ?, "
                + "apellidos = ?, telefono = ?, direccion = ?, "
                + "observaciones = ?, fecha_nacimiento = ?,"
                + "ultUsuario = ?,"
                + "ultFecha = curdate() "
                + "where PK_idCliente = ?");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getApellidos());
        cs.setString(3, obj.getTelefono());
        cs.setString(4, obj.getDireccion());
        cs.setString(5, obj.getObservaciones());
        cs.setString(6, obj.getFechaNacimiento());
        cs.setString(7, obj.getUltUsuario());
        cs.setInt(8, obj.getPK_idCliente());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void eliminar(Cliente obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("delete from cliente where PK_idCliente = ?");
        cs.setInt(1, obj.getPK_idCliente());

        cs.executeUpdate();
        con.close();
    }

    @Override
    public Cliente obtenerPorId(Cliente obj) throws SQLException {
        Cliente c = null;
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("select * from cliente where PK_idCliente = ? ");
        cs.setInt(1, obj.getPK_idCliente());

        ResultSet result = cs.executeQuery();
        while (result.next()) {
            c = new Cliente();
            c.setPK_idCliente(result.getInt("PK_idCliente"));
            c.setNombre(result.getString("nombre"));
            c.setApellidos(result.getString("apellidos"));
            c.setTelefono(result.getString("telefono"));
            c.setDireccion(result.getString("direccion"));
            c.setFechaNacimiento(result.getString("fecha_nacimiento"));
            c.setObservaciones(result.getString("Observaciones"));
            c.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return c;
    }

    @Override
    public ArrayList<Cliente> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Cliente> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from cliente ");

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Cliente s = new Cliente();
            s.setPK_idCliente(result.getInt("PK_idcliente"));
            s.setNombre(result.getString("nombre"));
            s.setApellidos(result.getString("apellidos"));
            s.setTelefono(result.getString("telefono"));
            s.setDireccion(result.getString("direccion"));
            s.setFechaNacimiento(result.getString("fecha_nacimiento"));
            s.setObservaciones(result.getString("observaciones"));
            s.setUltUsuario(result.getString("UltUsuario"));
            l.add(s);
        }
        con.close();
        return l;

    }

    @Override
    public ArrayList<Cliente> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Cliente> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from cliente " + where);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Cliente s = new Cliente();
            s.setPK_idCliente(result.getInt("PK_idCliente"));
            s.setNombre(result.getString("nombre"));
            s.setApellidos(result.getString("apellidos"));
            s.setTelefono(result.getString("telefono"));
            s.setFechaNacimiento(result.getString("fecha_nacimiento"));
            s.setDireccion(result.getString("direccion"));
            s.setObservaciones(result.getString("observaciones"));
            s.setUltUsuario(result.getString("UltUsuario"));
            l.add(s);
        }
        con.close();
        return l;
    }

}
