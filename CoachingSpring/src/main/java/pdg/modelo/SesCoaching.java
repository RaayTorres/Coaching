package pdg.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "ses_coaching", schema = "public")
public class SesCoaching implements java.io.Serializable {
    @NotNull
    private Double idSesi;
    @NotNull
    private Estado estado;
    @NotNull
    private ProcCoaching procCoaching;
    private String accion;
    private String compromiso;
    private Date fecha;
    private String focoSesion;
    private Double hora;
    @NotNull
    private Double idHis;
    private String indicador;
    private String profundidad;

    public SesCoaching() {
    }

    public SesCoaching(Double idSesi, String accion, String compromiso,
        Estado estado, Date fecha, String focoSesion, Double hora,
        Double idHis, String indicador, ProcCoaching procCoaching,
        String profundidad) {
        this.idSesi = idSesi;
        this.estado = estado;
        this.procCoaching = procCoaching;
        this.accion = accion;
        this.compromiso = compromiso;
        this.fecha = fecha;
        this.focoSesion = focoSesion;
        this.hora = hora;
        this.idHis = idHis;
        this.indicador = indicador;
        this.profundidad = profundidad;
    }

    @Id
    @Column(name = "id_sesi", unique = true, nullable = false)
    public Double getIdSesi() {
        return this.idSesi;
    }

    public void setIdSesi(Double idSesi) {
        this.idSesi = idSesi;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proc_coaching_id_proc")
    public ProcCoaching getProcCoaching() {
        return this.procCoaching;
    }

    public void setProcCoaching(ProcCoaching procCoaching) {
        this.procCoaching = procCoaching;
    }

    @Column(name = "accion")
    public String getAccion() {
        return this.accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Column(name = "compromiso")
    public String getCompromiso() {
        return this.compromiso;
    }

    public void setCompromiso(String compromiso) {
        this.compromiso = compromiso;
    }

    @Column(name = "fecha")
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "foco_sesion")
    public String getFocoSesion() {
        return this.focoSesion;
    }

    public void setFocoSesion(String focoSesion) {
        this.focoSesion = focoSesion;
    }

    @Column(name = "hora")
    public Double getHora() {
        return this.hora;
    }

    public void setHora(Double hora) {
        this.hora = hora;
    }

    @Column(name = "id_his", nullable = false)
    public Double getIdHis() {
        return this.idHis;
    }

    public void setIdHis(Double idHis) {
        this.idHis = idHis;
    }

    @Column(name = "indicador")
    public String getIndicador() {
        return this.indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    @Column(name = "profundidad")
    public String getProfundidad() {
        return this.profundidad;
    }

    public void setProfundidad(String profundidad) {
        this.profundidad = profundidad;
    }
}
