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

    public Factura() {
    }

    public Factura(Integer idFactura, String fecha) {
        this.idFactura = idFactura;
        this.fecha = fecha;
    }

    public Factura(Integer idFactura, String fecha, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.idFactura = idFactura;
        this.fecha = fecha;
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
}
