/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.dao;

import cr.ac.una.prograIII.appProyecto.conexion.MySQLConexion;
import cr.ac.una.prograIII.appProyecto.domain.ArtProv;
import cr.ac.una.prograIII.appProyecto.domain.Articulo;
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
public class ArtProvDao implements IBaseDao<ArtProv> {

    private final MySQLConexion conexion;

    public ArtProvDao() {
        conexion = new MySQLConexion();

    }

    @Override
    public void insertar(ArtProv obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("insert into articuloproveedor (FK_PK_idArticulo,FK_PK_idProveedor, ultUsuario, ultFecha) values (?,?,?,curdate())");
        cs.setInt(1, obj.getIdArticulo());
        cs.setInt(2, obj.getIdProveedor());
        cs.setString(3, obj.getUltUsuario());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(ArtProv obj) throws SQLException {
        
    }

    @Override
    public void eliminar(ArtProv obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("delete from articuloproveedor where FK_PK_idArticulo = ?");
        cs.setInt(1, obj.getIdArticulo());
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public ArtProv obtenerPorId(ArtProv obj) throws SQLException {
        ArtProv s = null;
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("select * from articuloproveedor where FK_PK_idArticulo = ? ");
        cs.setInt(1, obj.getIdArticulo());

        ResultSet result = cs.executeQuery();
        while (result.next()) {
            s = new ArtProv();
            s.setIdArticulo(result.getInt("FK_PK_idArticulo"));
            s.setIdProveedor(result.getInt("FK_PK_idProveedor"));
            s.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return s;
    }

    @Override
    public ArrayList<ArtProv> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<ArtProv> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select a.PK_idArticulo, a.nombre from articuloproveedor ap, articulo a where ap.FK_PK_idArticulo = a.PK_idArticulo ");

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            ArtProv s = new ArtProv();

            s.setIdArticulo(result.getInt("PK_idArticulo"));
            s.setNombreArticulo(result.getString("nombre"));
            //s.setUltUsuario(result.getString("UltUsuario"));
            l.add(s);
        }
        con.close();
        return l;
    }

    @Override
    public ArrayList<ArtProv> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<ArtProv> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from articuloproveedor " + where);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            ArtProv s = new ArtProv();
            s.setIdArtProv(result.getInt("PK_idArtProv"));
            s.setIdArticulo(result.getInt("FK_PK_idArticulo"));
            s.setIdProveedor(result.getInt("FK_PK_idProveedor"));
            s.setUltUsuario(result.getString("UltUsuario"));
            l.add(s);
        }
        con.close();
        return l;
    }

}
