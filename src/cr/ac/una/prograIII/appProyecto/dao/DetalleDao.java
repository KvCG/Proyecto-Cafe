/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.dao;

import cr.ac.una.prograIII.appProyecto.conexion.MySQLConexion;
import cr.ac.una.prograIII.appProyecto.domain.Detalle;
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
public class DetalleDao implements IBaseDao<Detalle>{
        private final MySQLConexion conexion;

    public DetalleDao() {
        conexion = new MySQLConexion();
    }
    

    @Override
    public void insertar(Detalle obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("insert into Detalle (FK_PK_idArticulo,FK_PK_idFactura,"
                                             + "cantidad,precioUnitario,ultUsuario,"
                                             + "ultFecha) values "
                                             + "(?,?,?,?,?,curdate())");

        cs.setInt(1, obj.getIdArticulo());
        cs.setInt(2, obj.getIdFactura());
        cs.setInt(3, obj.getCantidad());
        cs.setDouble(4, obj.getPrecioUnitario());;
        cs.setString(5, obj.getUltUsuario());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(Detalle obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update Detalle set FK_PK_IdCliente = ?,FK_PK_IdArticulo = ? "
                                            + "FK_PK_Factura = ?, cantidad = ?, "
                                            + "precioUnitario = ?,ultUsuario = ?,"
                                            + "ultFecha = curdate() "
                                            + "where FK_PK_idFactura = ?");
       cs.setInt(1, obj.getIdCliente());
        cs.setInt(2, obj.getIdArticulo());
        cs.setInt(3, obj.getIdFactura());
        cs.setInt(4, obj.getCantidad());
        cs.setDouble(5, obj.getPrecioUnitario());;
        cs.setString(6, obj.getUltUsuario());
        cs.setString(7, obj.getUltFecha());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void eliminar(Detalle obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from Detalle where FK_PK_idFactura = ?");
        cs.setInt(1, obj.getIdFactura());
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public Detalle obtenerPorId(Detalle obj) throws SQLException {
        Detalle De = null;
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("select * from Detalle where FK_PK_idFactura = ? " );
        cs.setInt(1, obj.getIdFactura());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            De = new Detalle();
            De.setIdFactura(result.getInt("FK_PK_idFactura"));
            De.setIdArticulo(result.getInt("FK_PK_IdArticulo"));
            De.setIdCliente(result.getInt("FK_PK_IdCliente"));
            De.setCantidad(result.getInt("cantidad"));
            De.setPrecioUnitario(result.getDouble("precioUnitario"));
            De.setUltFecha(result.getString("UltFecha"));
            De.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return De;
    }

    @Override
    public ArrayList<Detalle> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Detalle> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Detalle ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Detalle De = new Detalle();
            De.setIdFactura(result.getInt("FK_PK_idFactura"));
            De.setIdCliente(result.getInt("FK_PK_IdCliente"));
            De.setIdArticulo(result.getInt("FK_PK_IdArticulo"));
            De.setCantidad(result.getInt("cantidad"));
            De.setPrecioUnitario(result.getDouble("precioUnitario"));
            De.setUltFecha(result.getString("UltFecha"));
            De.setUltUsuario(result.getString("UltUsuario"));
            l.add(De);
        }
        con.close();
        return l;
    }
    @Override
    public ArrayList<Detalle> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Detalle> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Detalle "+where );
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Detalle De = new Detalle();
            De.setIdFactura(result.getInt("FK_PK_idFactura"));
            De.setIdCliente(result.getInt("FK_PK_IdCliente"));
            De.setIdArticulo(result.getInt("FK_PK_IdArticulo"));
            De.setCantidad(result.getInt("cantidad"));
            De.setPrecioUnitario(result.getDouble("precioUnitario"));
            De.setUltFecha(result.getString("UltFecha"));
            De.setUltUsuario(result.getString("UltUsuario"));
            l.add(De);
        }
        con.close();
        return l;
    }
    

}
