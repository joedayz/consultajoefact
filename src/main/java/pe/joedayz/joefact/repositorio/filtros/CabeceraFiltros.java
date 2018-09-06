package pe.joedayz.joefact.repositorio.filtros;

import java.io.Serializable;
import java.util.Date;
import pe.joedayz.joefact.modelo.TipoDocumento;

public class CabeceraFiltros implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date fechaInicio;

    private Date fechaFin;

    private String numeroDocumento;

    private String estado;
    private String clieRuc;
    private String clieRazonSocial;
    private TipoDocumento tipoDocumento ;
    
    private String cdr;
    private String docuProceStatus;


    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClieRuc() {
        return clieRuc;
    }

    public void setClieRuc(String clieRuc) {
        this.clieRuc = clieRuc;
    }

    public String getClieRazonSocial() {
        return clieRazonSocial;
    }

    public void setClieRazonSocial(String clieRazonSocial) {
        this.clieRazonSocial = clieRazonSocial;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCdr() {
        return cdr;
    }

    public void setCdr(String cdr) {
        this.cdr = cdr;
    }

    public String getDocuProceStatus() {
        return docuProceStatus;
    }

    public void setDocuProceStatus(String docuProceStatus) {
        this.docuProceStatus = docuProceStatus;
    }
}
