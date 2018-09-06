package pe.joedayz.joefact.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "resumendia_baja")
public class ResumendiaBaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 200)
    @Column(name = "empr_razonsocial")
    private String emprRazonsocial;
    @Size(max = 15)
    @Column(name = "empr_nroruc")
    private String emprNroruc;
    @Size(max = 15)
    @Column(name = "resu_fecha_doc")
    private String resuFechaDoc;
    @Size(max = 45)
    @Column(name = "resu_identificador")
    private String resuIdentificador;
    @Size(max = 2)
    @Column(name = "resu_tipo")
    private String resuTipo;
    @Size(max = 45)
    @Column(name = "resu_fecha_com")
    private String resuFechaCom;
    @Size(max = 45)
    @Column(name = "nroticket")
    private String nroticket;
    @Size(max = 45)
    @Column(name = "resu_proce_status")
    private String resuProceStatus;
    @Size(max = 4)
    @Column(name = "cdr_code")
    private String cdr;
    @Size(max = 20000)
    @Column(name = "cdr_nota")
    private String cdrNota;
    @Size(max = 2000)
    @Column(name = "cdr_texto")
    private String cdrObservacion;
    @Size(max = 200)
    @Column(name = "cdr_link")
    private String cdrLink;
    @Size(max = 2)
    @Column(name = "resu_tipodoc")
    private String resuTipodoc;
    @Size(max = 1)
    @Column(name = "resu_estado")
    private String resuEstado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo")
    private Set<ComunicaBaja> comunicabajaSet;

    public ResumendiaBaja() {
    }

    public ResumendiaBaja(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEmprRazonsocial() {
        return emprRazonsocial;
    }

    public void setEmprRazonsocial(String emprRazonsocial) {
        this.emprRazonsocial = emprRazonsocial;
    }

    public String getEmprNroruc() {
        return emprNroruc;
    }

    public void setEmprNroruc(String emprNroruc) {
        this.emprNroruc = emprNroruc;
    }

    public String getResuFechaDoc() {
        return resuFechaDoc;
    }

    public void setResuFechaDoc(String resuFechaDoc) {
        this.resuFechaDoc = resuFechaDoc;
    }

    public String getResuIdentificador() {
        return resuIdentificador;
    }

    public void setResuIdentificador(String resuIdentificador) {
        this.resuIdentificador = resuIdentificador;
    }

    public String getResuTipo() {
        return resuTipo;
    }

    public void setResuTipo(String resuTipo) {
        this.resuTipo = resuTipo;
    }

    public String getResuFechaCom() {
        return resuFechaCom;
    }

    public void setResuFechaCom(String resuFechaCom) {
        this.resuFechaCom = resuFechaCom;
    }

    public String getNroticket() {
        return nroticket;
    }

    public void setNroticket(String nroticket) {
        this.nroticket = nroticket;
    }

    public String getResuProceStatus() {
        return resuProceStatus;
    }

    public void setResuProceStatus(String resuProceStatus) {
        this.resuProceStatus = resuProceStatus;
    }

    public Set<ComunicaBaja> getComunicabajaSet() {
        return comunicabajaSet;
    }

    public void setComunicabajaSet(Set<ComunicaBaja> comunicabajaSet) {
        this.comunicabajaSet = comunicabajaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumendiaBaja)) {
            return false;
        }
        ResumendiaBaja other = (ResumendiaBaja) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    public String getCdr() {
        return cdr;
    }

    public void setCdr(String cdr) {
        this.cdr = cdr;
    }

    public String getCdrNota() {
        return cdrNota;
    }

    public void setCdrNota(String cdrNota) {
        this.cdrNota = cdrNota;
    }

    public String getCdrObservacion() {
        return cdrObservacion;
    }

    public void setCdrObservacion(String cdrObservacion) {
        this.cdrObservacion = cdrObservacion;
    }

    public String getCdrLink() {
        return cdrLink;
    }

    public void setCdrLink(String cdrLink) {
        this.cdrLink = cdrLink;
    }

    public String getResuTipodoc() {
        return resuTipodoc;
    }

    public void setResuTipodoc(String resuTipodoc) {
        this.resuTipodoc = resuTipodoc;
    }

    public String getResuEstado() {
        return resuEstado;
    }

    public void setResuEstado(String resuEstado) {
        this.resuEstado = resuEstado;
    }

    @Override
    public String toString() {
        return "ResumendiaBaja [codigo=" + codigo + ", emprRazonsocial=" + emprRazonsocial + ", emprNroruc="
                + emprNroruc + ", resuFechaDoc=" + resuFechaDoc + ", resuIdentificador=" + resuIdentificador + ", resuFechaCom="
                + resuFechaCom + "]";
    }

}
