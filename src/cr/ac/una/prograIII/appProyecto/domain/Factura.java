/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.domain;

import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class Factura extends BaseDomain {
    private Integer idFactura;
    private String fecha;
    private ArrayList<Detalle> detalle;
    
    public Factura(){}

    public Factura(Integer idFactura, String fecha, ArrayList<Detalle> detalle) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.detalle = detalle;
    }

    public Factura(Integer idFactura, String fecha, ArrayList<Detalle> detalle, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.detalle = detalle;
    }  

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Detalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<Detalle> detalle) {
        this.detalle = detalle;
    }
    
   public void inserta(Detalle d){
       detalle.add(d);
   }
       
}
