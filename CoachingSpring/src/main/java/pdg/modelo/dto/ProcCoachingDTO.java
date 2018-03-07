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
public class ProcCoachingDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProcCoachingDTO.class);
    private Double idProc;
    private Double idTpago;
    private Double idCoach_Coach;
    private Double idCoachee_Coachee;
    private Double idHis_RegContable;

    public Double getIdProc() {
        return idProc;
    }

    public void setIdProc(Double idProc) {
        this.idProc = idProc;
    }

    public Double getIdTpago() {
        return idTpago;
    }

    public void setIdTpago(Double idTpago) {
        this.idTpago = idTpago;
    }

    public Double getIdCoach_Coach() {
        return idCoach_Coach;
    }

    public void setIdCoach_Coach(Double idCoach_Coach) {
        this.idCoach_Coach = idCoach_Coach;
    }

    public Double getIdCoachee_Coachee() {
        return idCoachee_Coachee;
    }

    public void setIdCoachee_Coachee(Double idCoachee_Coachee) {
        this.idCoachee_Coachee = idCoachee_Coachee;
    }

    public Double getIdHis_RegContable() {
        return idHis_RegContable;
    }

    public void setIdHis_RegContable(Double idHis_RegContable) {
        this.idHis_RegContable = idHis_RegContable;
    }
}
