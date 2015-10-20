/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.domain;

/**
 *
 * @author Anthony Carrillo
 */
public class Proveedor extends BaseDomain{
    private int PK_idProveedor;
    private String nombre;
    private String descripcion;

    public Proveedor() {
    }

    public int getPK_idProveedor() {
        return PK_idProveedor;
    }

    public void setPK_idProveedor(int PK_idProveedor) {
        this.PK_idProveedor = PK_idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
