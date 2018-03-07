package pdg.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class CoacheeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CoacheeDTO.class);
    private String apellido;
    private Double celular;
    private String correo;
    private String direccion;
    private byte[] foto;
    private String hobbies;
    private Double idCoachee;
    private String identificacion;
    private String nombre;
    private Double telefono;
    private Double idEstado_Estado;
    private Double idDoc_TipoDocumento;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getCelular() {
        return celular;
    }

    public void setCelular(Double celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Double getIdCoachee() {
        return idCoachee;
    }

    public void setIdCoachee(Double idCoachee) {
        this.idCoachee = idCoachee;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTelefono() {
        return telefono;
    }

    public void setTelefono(Double telefono) {
        this.telefono = telefono;
    }

    public Double getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Double idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }

    public Double getIdDoc_TipoDocumento() {
        return idDoc_TipoDocumento;
    }

    public void setIdDoc_TipoDocumento(Double idDoc_TipoDocumento) {
        this.idDoc_TipoDocumento = idDoc_TipoDocumento;
    }
}
