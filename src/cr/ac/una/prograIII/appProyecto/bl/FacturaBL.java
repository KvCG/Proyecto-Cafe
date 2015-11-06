/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.bl;

import cr.ac.una.prograIII.appProyecto.dao.GenericDao;
import cr.ac.una.prograIII.appProyecto.domain.Factura;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class FacturaBL implements IBaseBl<Factura> {
    private GenericDao sDao;

    public FacturaBL() {
        sDao = new GenericDao();
    }
    
    

    @Override
    public void insertar(Factura obj) throws SQLException {
        sDao.insertar(obj);
    }

    @Override
    public void modificar(Factura obj) throws SQLException {
        sDao.modificar(obj);
    }

    @Override
    public void eliminar(Factura obj) throws SQLException {
        sDao.eliminar(obj);
    }

    @Override
    public Factura obtenerPorId(Factura obj) throws SQLException {
        return (Factura)sDao.obtenerPorId(obj);
    }

    @Override
    public ArrayList<Factura> obtenerTodos() throws SQLException {
        return this.sDao.obtenerTodos(new Factura());
    }
    
    public ArrayList<Factura> obtenerConWhere(Factura obj, String where ) throws SQLException {
        return this.sDao.obtenerConWhere(obj, where);
    }
}
