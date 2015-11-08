/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.domain;

//import cr.ac.una.prograIII.appMVC.domain.BaseDomain;

/**
 *
 * @author Anthony Carrillo
 */
public class Articulo extends BaseDomain{

    private int PK_idArticulo;
    private String nombre;
    private String descripcion;
    private String precio;
    private int cantidad;

    public Articulo() {
    }

    public Articulo(int PK_idArticulo, String nombre, String descripcion, String precio, int cantidad) {
        this.PK_idArticulo = PK_idArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Articulo(int PK_idArticulo, String nombre, String descripcion, String precio, int cantidad, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_idArticulo = PK_idArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    
    public int getPK_idArticulo() {
        return PK_idArticulo;
    }

    public void setPK_idArticulo(int PK_idArticulo) {
        this.PK_idArticulo = PK_idArticulo;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public Boolean equals(Articulo e){
        if(PK_idArticulo == e.getPK_idArticulo()){
            return true;
        }
        return false;
    }

    
    
}
