/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.bl;

import cr.ac.una.prograIII.appProyecto.dao.GenericDao;
import cr.ac.una.prograIII.appProyecto.domain.ArtProv;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class ArtProvBL implements IBaseBl<ArtProv> {

    private GenericDao sDao;

    public ArtProvBL() {
        sDao = new GenericDao();
    }

    @Override
    public void insertar(ArtProv obj) throws SQLException {
        sDao.insertar(obj);
    }

    @Override
    public void modificar(ArtProv obj) throws SQLException {
        sDao.modificar(obj);
    }

    @Override
    public void eliminar(ArtProv obj) throws SQLException {
        sDao.eliminar(obj);
    }

    @Override
    public ArtProv obtenerPorId(ArtProv obj) throws SQLException {
        return (ArtProv) sDao.obtenerPorId(obj);
    }

    @Override
    public ArrayList<ArtProv> obtenerTodos() throws SQLException {
        return this.sDao.obtenerTodos(new ArtProv());
    }
    
    public ArrayList<ArtProv> obtenerConWhere(ArtProv obj, String where ) throws SQLException {
        return this.sDao.obtenerConWhere(obj, where);
    }


}
