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
public class ArtProv extends BaseDomain {
    private int idArtProv;
    private int idArticulo;
    private int idProveedor;
    
    private String nombreArticulo;
    

    public ArtProv() {
    }
    
    

    public ArtProv(int idArtProv, int idArticulo, int idProveedor) {
        this.idArtProv = idArtProv;
        this.idArticulo = idArticulo;
        this.idProveedor = idProveedor;
    }

    public ArtProv(int idArtProv, int idArticulo, int idProveedor, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.idArtProv = idArtProv;
        this.idArticulo = idArticulo;
        this.idProveedor = idProveedor;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }
    
    

    public int getIdArtProv() {
        return idArtProv;
    }

    public void setIdArtProv(int idArtProv) {
        this.idArtProv = idArtProv;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

         
    
    
}
