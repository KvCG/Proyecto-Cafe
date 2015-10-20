/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.bl;

import cr.ac.una.prograIII.appProyecto.dao.GenericDao;
import cr.ac.una.prograIII.appProyecto.domain.Articulo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class ArticuloBL implements IBaseBl<Articulo> {

    private GenericDao sDao;

    public ArticuloBL() {
        sDao = new GenericDao();
    }
    
    

    @Override
    public void insertar(Articulo obj) throws SQLException {
        sDao.insertar(obj);
    }

    @Override
    public void modificar(Articulo obj) throws SQLException {
        sDao.modificar(obj);
    }

    @Override
    public void eliminar(Articulo obj) throws SQLException {
        sDao.eliminar(obj);
    }

    @Override
    public Articulo obtenerPorId(Articulo obj) throws SQLException {
        return (Articulo)sDao.obtenerPorId(obj);
    }

    @Override
    public ArrayList<Articulo> obtenerTodos() throws SQLException {
        return this.sDao.obtenerTodos(new Articulo());
    }
    
    public ArrayList<Articulo> obtenerConWhere(Articulo obj, String where ) throws SQLException {
        return this.sDao.obtenerConWhere(obj, where);
    }

}
