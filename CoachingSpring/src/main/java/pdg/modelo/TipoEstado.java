package pdg.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "TIPO_ESTADO", schema = "public")
public class TipoEstado implements java.io.Serializable {
    @NotNull
    private Double idTestado;
    @NotNull
    @NotEmpty
    @Size(max = 60)
    private String nombreTipoEstado;
    private Set<Estado> estados = new HashSet<Estado>(0);

    public TipoEstado() {
    }

    public TipoEstado(Double idTestado, Set<Estado> estados,
        String nombreTipoEstado) {
        this.idTestado = idTestado;
        this.nombreTipoEstado = nombreTipoEstado;
        this.estados = estados;
    }

    @Id
    @Column(name = "id_testado", unique = true, nullable = false)
    public Double getIdTestado() {
        return this.idTestado;
    }

    public void setIdTestado(Double idTestado) {
        this.idTestado = idTestado;
    }

    @Column(name = "nombre_tipo_estado", nullable = false)
    public String getNombreTipoEstado() {
        return this.nombreTipoEstado;
    }

    public void setNombreTipoEstado(String nombreTipoEstado) {
        this.nombreTipoEstado = nombreTipoEstado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoEstado")
    public Set<Estado> getEstados() {
        return this.estados;
    }

    public void setEstados(Set<Estado> estados) {
        this.estados = estados;
    }
}
