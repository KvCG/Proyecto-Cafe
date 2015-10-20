
package cr.ac.una.prograIII.appProyecto.domain;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Cliente extends BaseDomain{
    private Integer PK_idCliente;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private String observaciones;

    public Cliente() {
    }
    
    
    

    public Cliente(Integer PK_idCliente, String nombre, String apellidos, String direccion, String fechaNacimiento, String observaciones, String telefono) {
        this.PK_idCliente = PK_idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.observaciones = observaciones;
    }

    public Cliente(Integer PK_idCliente, String nombre, String apellidos, String direccion, String fechaNacimiento, String observaciones, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_idCliente = PK_idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.observaciones = observaciones;
    }

    public Integer getPK_idCliente() {
        return PK_idCliente;
    }

    public void setPK_idCliente(Integer PK_idCliente) {
        this.PK_idCliente = PK_idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

    
    
    
    
    
}
