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
@Table(name = "tipo_documento", schema = "public")
public class TipoDocumento implements java.io.Serializable {
    @NotNull
    private Double idDoc;
    @NotNull
    @NotEmpty
    @Size(max = 60)
    private String tdocNombre;
    private Set<Coachee> coachees = new HashSet<Coachee>(0);
    private Set<Coach> coaches = new HashSet<Coach>(0);

    public TipoDocumento() {
    }

    public TipoDocumento(Double idDoc, Set<Coachee> coachees,
        Set<Coach> coaches, String tdocNombre) {
        this.idDoc = idDoc;
        this.tdocNombre = tdocNombre;
        this.coachees = coachees;
        this.coaches = coaches;
    }

    @Id
    @Column(name = "id_doc", unique = true, nullable = false)
    public Double getIdDoc() {
        return this.idDoc;
    }

    public void setIdDoc(Double idDoc) {
        this.idDoc = idDoc;
    }

    @Column(name = "tdoc_nombre", nullable = false)
    public String getTdocNombre() {
        return this.tdocNombre;
    }

    public void setTdocNombre(String tdocNombre) {
        this.tdocNombre = tdocNombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDocumento")
    public Set<Coachee> getCoachees() {
        return this.coachees;
    }

    public void setCoachees(Set<Coachee> coachees) {
        this.coachees = coachees;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDocumento")
    public Set<Coach> getCoaches() {
        return this.coaches;
    }

    public void setCoaches(Set<Coach> coaches) {
        this.coaches = coaches;
    }
}
