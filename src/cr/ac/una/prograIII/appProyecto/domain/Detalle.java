/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.domain;

/**
 *
 * @author Kevin
 */
public class Detalle extends BaseDomain {
   private Integer idCliente;
   private Integer idArticulo;
   private Integer idFactura;
   private Double precioUnitario;
   private Integer cantidad;

    public Detalle(Integer idCliente, Integer idArticulo, Integer idFactura, Double precioUnitario, Integer cantidad) {
        this.idCliente = idCliente;
        this.idArticulo = idArticulo;
        this.idFactura = idFactura;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public Detalle(Integer idCliente, Integer idArticulo, Integer idFactura, Double precioUnitario, Integer cantidad, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.idCliente = idCliente;
        this.idArticulo = idArticulo;
        this.idFactura = idFactura;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }
   
   public Detalle(){}

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
   
   
    
}
