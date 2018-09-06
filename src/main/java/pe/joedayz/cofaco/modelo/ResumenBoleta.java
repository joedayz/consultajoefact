package pe.joedayz.cofaco.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "resumenboleta")
public class ResumenBoleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresumenboleta")
    private Integer idresumenboleta;
    @Size(max = 45)
    @Column(name = "resu_fecha")
    private String resuFecha;
    @Size(max = 45)
    @Column(name = "resu_fila")
    private String resuFila;
    @Size(max = 45)
    @Column(name = "resu_tipodoc")
    private String resuTipodoc;
    @Size(max = 45)
    @Column(name = "resu_serie")
    private String resuSerie;
    @Size(max = 45)
    @Column(name = "resu_inicio")
    private String resuInicio;
    @Size(max = 45)
    @Column(name = "resu_final")
    private String resuFinal;
    @Size(max = 45)
    @Column(name = "resu_gravada")
    private String resuGravada;
    @Size(max = 45)
    @Column(name = "resu_exonerada")
    private String resuExonerada;
    @Size(max = 45)
    @Column(name = "resu_inafecta")
    private String resuInafecta;
    @Size(max = 45)
    @Column(name = "resu_otcargos")
    private String resuOtcargos;
    @Size(max = 45)
    @Column(name = "resu_isc")
    private String resuIsc;
    @Size(max = 45)
    @Column(name = "resu_igv")
    private String resuIgv;
    @Size(max = 45)
    @Column(name = "resu_ottributos")
    private String resuOttributos;
    @Size(max = 45)
    @Column(name = "resu_total")
    private String resuTotal;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private ResumendiaCab codigo;

    public ResumenBoleta() {
    }

    public ResumenBoleta(Integer idresumenboleta) {
        this.idresumenboleta = idresumenboleta;
    }

    public Integer getIdresumenboleta() {
        return idresumenboleta;
    }

    public void setIdresumenboleta(Integer idresumenboleta) {
        this.idresumenboleta = idresumenboleta;
    }

    public String getResuFecha() {
        return resuFecha;
    }

    public void setResuFecha(String resuFecha) {
        this.resuFecha = resuFecha;
    }

    public String getResuFila() {
        return resuFila;
    }

    public void setResuFila(String resuFila) {
        this.resuFila = resuFila;
    }

    public String getResuTipodoc() {
        return resuTipodoc;
    }

    public void setResuTipodoc(String resuTipodoc) {
        this.resuTipodoc = resuTipodoc;
    }

    public String getResuSerie() {
        return resuSerie;
    }

    public void setResuSerie(String resuSerie) {
        this.resuSerie = resuSerie;
    }

    public String getResuInicio() {
        return resuInicio;
    }

    public void setResuInicio(String resuInicio) {
        this.resuInicio = resuInicio;
    }

    public String getResuFinal() {
        return resuFinal;
    }

    public void setResuFinal(String resuFinal) {
        this.resuFinal = resuFinal;
    }

    public String getResuGravada() {
        return resuGravada;
    }

    public void setResuGravada(String resuGravada) {
        this.resuGravada = resuGravada;
    }

    public String getResuExonerada() {
        return resuExonerada;
    }

    public void setResuExonerada(String resuExonerada) {
        this.resuExonerada = resuExonerada;
    }

    public String getResuInafecta() {
        return resuInafecta;
    }

    public void setResuInafecta(String resuInafecta) {
        this.resuInafecta = resuInafecta;
    }

    public String getResuOtcargos() {
        return resuOtcargos;
    }

    public void setResuOtcargos(String resuOtcargos) {
        this.resuOtcargos = resuOtcargos;
    }

    public String getResuIsc() {
        return resuIsc;
    }

    public void setResuIsc(String resuIsc) {
        this.resuIsc = resuIsc;
    }

    public String getResuIgv() {
        return resuIgv;
    }

    public void setResuIgv(String resuIgv) {
        this.resuIgv = resuIgv;
    }

    public String getResuOttributos() {
        return resuOttributos;
    }

    public void setResuOttributos(String resuOttributos) {
        this.resuOttributos = resuOttributos;
    }

    public String getResuTotal() {
        return resuTotal;
    }

    public void setResuTotal(String resuTotal) {
        this.resuTotal = resuTotal;
    }

    public ResumendiaCab getCodigo() {
        return codigo;
    }

    public void setCodigo(ResumendiaCab codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresumenboleta != null ? idresumenboleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenBoleta)) {
            return false;
        }
        ResumenBoleta other = (ResumenBoleta) object;
        if ((this.idresumenboleta == null && other.idresumenboleta != null) || (this.idresumenboleta != null && !this.idresumenboleta.equals(other.idresumenboleta))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "ResumenBoleta [idresumenboleta=" + idresumenboleta + ", resuFecha=" + resuFecha + ", resuFila="
				+ resuFila + ", resuTipodoc=" + resuTipodoc + ", resuSerie=" + resuSerie + ", resuInicio=" + resuInicio
				+ ", resuFinal=" + resuFinal + ", resuGravada=" + resuGravada + ", resuExonerada=" + resuExonerada
				+ ", resuInafecta=" + resuInafecta + ", resuOtcargos=" + resuOtcargos + ", resuIsc=" + resuIsc
				+ ", resuIgv=" + resuIgv + ", resuOttributos=" + resuOttributos + ", resuTotal=" + resuTotal + "]";
	}

 
    
}
