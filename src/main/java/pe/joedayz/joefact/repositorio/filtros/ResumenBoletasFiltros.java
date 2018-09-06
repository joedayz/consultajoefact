package pe.joedayz.joefact.repositorio.filtros;

import java.io.Serializable;
import java.util.Date;

public class ResumenBoletasFiltros implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date fechaDocumento;

    private Date fechaComunicacion;

    private String identificadorResumen;

    private String tipoResumen;
    private String nroTicket;
    private String estatus;
    private String cdrLink;

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public Date getFechaComunicacion() {
        return fechaComunicacion;
    }

    public void setFechaComunicacion(Date fechaComunicacion) {
        this.fechaComunicacion = fechaComunicacion;
    }

    public String getIdentificadorResumen() {
        return identificadorResumen;
    }

    public void setIdentificadorResumen(String identificadorResumen) {
        this.identificadorResumen = identificadorResumen;
    }

    public String getTipoResumen() {
        return tipoResumen;
    }

    public void setTipoResumen(String tipoResumen) {
        this.tipoResumen = tipoResumen;
    }

    public String getNroTicket() {
        return nroTicket;
    }

    public void setNroTicket(String nroTicket) {
        this.nroTicket = nroTicket;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getCdrLink() {
        return cdrLink;
    }

    public void setCdrLink(String cdrLink) {
        this.cdrLink = cdrLink;
    }
    
 
}
