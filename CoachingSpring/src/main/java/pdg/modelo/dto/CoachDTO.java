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
public class CoachDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CoachDTO.class);
    private String apellido;
    private Double celular;
    private String contrasena;
    private String correo;
    private Double horaPagada;
    private Double horaProbono;
    private Double idCoach;
    private String identificacion;
    private String login;
    private String nombre;
    private Double telefono;
    private Double idCat_Categoria;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Double getHoraPagada() {
        return horaPagada;
    }

    public void setHoraPagada(Double horaPagada) {
        this.horaPagada = horaPagada;
    }

    public Double getHoraProbono() {
        return horaProbono;
    }

    public void setHoraProbono(Double horaProbono) {
        this.horaProbono = horaProbono;
    }

    public Double getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(Double idCoach) {
        this.idCoach = idCoach;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public Double getIdCat_Categoria() {
        return idCat_Categoria;
    }

    public void setIdCat_Categoria(Double idCat_Categoria) {
        this.idCat_Categoria = idCat_Categoria;
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
