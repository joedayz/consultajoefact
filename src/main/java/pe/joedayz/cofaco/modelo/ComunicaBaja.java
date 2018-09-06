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
@Table(name = "comunicabaja")
public class ComunicaBaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomunicabaja")
    private Integer idcomunicabaja;
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
    @Column(name = "resu_numero")
    private String resuNumero;
    @Size(max = 45)
    @Column(name = "resu_motivo")
    private String resuMotivo;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private ResumendiaBaja codigo;

    public ComunicaBaja() {
    }

    public ComunicaBaja(Integer idcomunicabaja) {
        this.idcomunicabaja = idcomunicabaja;
    }

    public Integer getIdcomunicabaja() {
        return idcomunicabaja;
    }

    public void setIdcomunicabaja(Integer idcomunicabaja) {
        this.idcomunicabaja = idcomunicabaja;
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

    public String getResuNumero() {
        return resuNumero;
    }

    public void setResuNumero(String resuNumero) {
        this.resuNumero = resuNumero;
    }

    public String getResuMotivo() {
        return resuMotivo;
    }

    public void setResuMotivo(String resuMotivo) {
        this.resuMotivo = resuMotivo;
    }

    public ResumendiaBaja getCodigo() {
        return codigo;
    }

    public void setCodigo(ResumendiaBaja codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomunicabaja != null ? idcomunicabaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComunicaBaja)) {
            return false;
        }
        ComunicaBaja other = (ComunicaBaja) object;
        if ((this.idcomunicabaja == null && other.idcomunicabaja != null) || (this.idcomunicabaja != null && !this.idcomunicabaja.equals(other.idcomunicabaja))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "ComunicaBaja [idcomunicabaja=" + idcomunicabaja + ", resuFecha=" + resuFecha + ", resuFila=" + resuFila
				+ ", resuTipodoc=" + resuTipodoc + ", resuSerie=" + resuSerie + ", resuNumero=" + resuNumero
				+ ", resuMotivo=" + resuMotivo + "]";
	}

 
    
}
