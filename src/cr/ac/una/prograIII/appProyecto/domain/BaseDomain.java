/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appProyecto.domain;

/**
 *
 * @author chgari
 */
public class BaseDomain {
    private String ultUsuario;
    private String ultFecha;

    public BaseDomain() {
    }

    public BaseDomain(String ultUsuario, String ultFecha) {
        this.ultUsuario = ultUsuario;
        this.ultFecha = ultFecha;
    }

    public String getUltUsuario() {
        return ultUsuario;
    }

    public void setUltUsuario(String ultUsuario) {
        this.ultUsuario = ultUsuario;
    }

    public String getUltFecha() {
        return ultFecha;
    }

    public void setUltFecha(String ultFecha) {
        this.ultFecha = ultFecha;
    }
    
    
    
}
