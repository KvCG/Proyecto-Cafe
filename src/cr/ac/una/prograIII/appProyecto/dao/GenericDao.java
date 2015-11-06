/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.dao;

import cr.ac.una.prograIII.appProyecto.domain.ArtProv;
import cr.ac.una.prograIII.appProyecto.domain.Articulo;
import cr.ac.una.prograIII.appProyecto.domain.Cliente;
import cr.ac.una.prograIII.appProyecto.domain.Factura;
import cr.ac.una.prograIII.appProyecto.domain.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class GenericDao {

    private IBaseDao iBaseDao;

    public GenericDao() {
    }

    public void insertar(Object obj) throws SQLException {
        if (obj instanceof Articulo) {
            iBaseDao = new ArticuloDao();
        }

        if (obj instanceof Cliente) {
            iBaseDao = new ClienteDao();
        }

        if (obj instanceof Proveedor) {
            iBaseDao = new ProveedorDao();
        }
        
        if(obj instanceof ArtProv){
            iBaseDao = new ArtProvDao();
        }
        
        if(obj instanceof Factura){
            iBaseDao = new FacturaDao();
        }
        iBaseDao.insertar(obj);
    }

    public void modificar(Object obj) throws SQLException {
        if (obj instanceof Articulo) {
            iBaseDao = new ArticuloDao();
        }

        if (obj instanceof Cliente) {
            iBaseDao = new ClienteDao();
        }

        if (obj instanceof Proveedor) {
            iBaseDao = new ProveedorDao();
        }
        
        if(obj instanceof ArtProv){
            iBaseDao = new ArtProvDao();
        }
        
        if(obj instanceof Factura){
            iBaseDao = new FacturaDao();
        }
        iBaseDao.modificar(obj);
    }

    public void eliminar(Object obj) throws SQLException {
        if (obj instanceof Articulo) {
            iBaseDao = new ArticuloDao();
        }

        if (obj instanceof Cliente) {
            iBaseDao = new ClienteDao();
        }

        if (obj instanceof Proveedor) {
            iBaseDao = new ProveedorDao();
        }
        
        if(obj instanceof ArtProv){
            iBaseDao = new ArtProvDao();
        }
        
        if(obj instanceof Factura){
            iBaseDao = new FacturaDao();
        }
        iBaseDao.eliminar(obj);
    }

    public Object obtenerPorId(Object obj) throws SQLException {
        if (obj instanceof Articulo) {
            iBaseDao = new ArticuloDao();
        }

        if (obj instanceof Cliente) {
            iBaseDao = new ClienteDao();
        }

        if (obj instanceof Proveedor) {
            iBaseDao = new ProveedorDao();
        }
        
        if(obj instanceof ArtProv){
            iBaseDao = new ArtProvDao();
        }
        
        if(obj instanceof Factura){
            iBaseDao = new FacturaDao();
        }
        return iBaseDao.obtenerPorId(obj);
    }

    public ArrayList obtenerTodos(Object obj) throws SQLException {
        if (obj instanceof Articulo) {
            iBaseDao = new ArticuloDao();
        }

        if (obj instanceof Cliente) {
            iBaseDao = new ClienteDao();
        }

        if (obj instanceof Proveedor) {
            iBaseDao = new ProveedorDao();
        }
        
        if(obj instanceof ArtProv){
            iBaseDao = new ArtProvDao();
        }
        
        if(obj instanceof Factura){
            iBaseDao = new FacturaDao();
        }
        return iBaseDao.obtenerTodos();
    }

    public ArrayList obtenerConWhere(Object obj, String where) throws SQLException {
        if (obj instanceof Articulo) {
            iBaseDao = new ArticuloDao();
        }

        if (obj instanceof Cliente) {
            iBaseDao = new ClienteDao();
        }

        if (obj instanceof Proveedor) {
            iBaseDao = new ProveedorDao();
        }
        
        if(obj instanceof ArtProv){
            iBaseDao = new ArtProvDao();
        }
        
        if(obj instanceof Factura){
            iBaseDao = new FacturaDao();
        }

        return iBaseDao.obtenerConWhere(where);
    }
}
