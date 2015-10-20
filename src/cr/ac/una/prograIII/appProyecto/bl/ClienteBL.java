/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.bl;

import cr.ac.una.prograIII.appProyecto.dao.GenericDao;
import cr.ac.una.prograIII.appProyecto.domain.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class ClienteBL implements IBaseBl<Cliente> {
    private GenericDao sDao;

    public ClienteBL() {
        sDao = new GenericDao();
    }
    
    

    @Override
    public void insertar(Cliente obj) throws SQLException {
        sDao.insertar(obj);
    }

    @Override
    public void modificar(Cliente obj) throws SQLException {
        sDao.modificar(obj);
    }

    @Override
    public void eliminar(Cliente obj) throws SQLException {
        sDao.eliminar(obj);
    }

    @Override
    public Cliente obtenerPorId(Cliente obj) throws SQLException {
        return (Cliente)sDao.obtenerPorId(obj);
    }

    @Override
    public ArrayList<Cliente> obtenerTodos() throws SQLException {
        return this.sDao.obtenerTodos(new Cliente());
    }
    
    public ArrayList<Cliente> obtenerConWhere(Cliente obj, String where ) throws SQLException {
        return this.sDao.obtenerConWhere(obj, where);
    }
    
}
