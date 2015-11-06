/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.bl;

import cr.ac.una.prograIII.appProyecto.dao.GenericDao;
import cr.ac.una.prograIII.appProyecto.domain.Detalle;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anthony Carrillo
 */
public class DetalleBL implements IBaseBl<Detalle>{
    private GenericDao sDao;

    public DetalleBL() {
        sDao=new GenericDao();
    }
    

    @Override
    public void insertar(Detalle obj) throws SQLException {
        sDao.insertar(obj);
    }

    @Override
    public void modificar(Detalle obj) throws SQLException {
        sDao.modificar(obj);
    }

    @Override
    public void eliminar(Detalle obj) throws SQLException {
        sDao.eliminar(obj);
    }

    @Override
    public Detalle obtenerPorId(Detalle obj) throws SQLException {
        return (Detalle)sDao.obtenerPorId(obj);
    }

    @Override
    public ArrayList<Detalle> obtenerTodos() throws SQLException {
        return this.sDao.obtenerTodos(new Detalle());
    }
    public ArrayList<Detalle> obtenerConWhere(Detalle obj, String where ) throws SQLException {
        return this.sDao.obtenerConWhere(obj, where);
    }
    
}
