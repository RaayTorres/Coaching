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
public class RegContableDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RegContableDTO.class);
    private Date fechaPago;
    private Double idHis;
    private String tipo;
    private Double valor;
    private Double idCoachee_Coachee;

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getIdHis() {
        return idHis;
    }

    public void setIdHis(Double idHis) {
        this.idHis = idHis;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getIdCoachee_Coachee() {
        return idCoachee_Coachee;
    }

    public void setIdCoachee_Coachee(Double idCoachee_Coachee) {
        this.idCoachee_Coachee = idCoachee_Coachee;
    }
}
