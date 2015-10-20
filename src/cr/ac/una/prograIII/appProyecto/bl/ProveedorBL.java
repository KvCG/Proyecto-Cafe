/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.bl;

import cr.ac.una.prograIII.appProyecto.dao.GenericDao;
import cr.ac.una.prograIII.appProyecto.domain.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class ProveedorBL implements IBaseBl<Proveedor> {
     private GenericDao sDao;

    public ProveedorBL() {
        sDao = new GenericDao();
    }
    
    

    @Override
    public void insertar(Proveedor obj) throws SQLException {
        sDao.insertar(obj);
    }

    @Override
    public void modificar(Proveedor obj) throws SQLException {
        sDao.modificar(obj);
    }

    @Override
    public void eliminar(Proveedor obj) throws SQLException {
        sDao.eliminar(obj);
    }

    @Override
    public Proveedor obtenerPorId(Proveedor obj) throws SQLException {
        return (Proveedor)sDao.obtenerPorId(obj);
    }
    
    @Override
    public ArrayList<Proveedor> obtenerTodos() throws SQLException {
        return this.sDao.obtenerTodos(new Proveedor());
    }
    
    public ArrayList<Proveedor> obtenerConWhere(Proveedor obj, String where ) throws SQLException {
        return this.sDao.obtenerConWhere(obj, where);
    }
}
