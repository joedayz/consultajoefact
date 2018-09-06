/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.cofaco.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author oswaldo
 */
@Entity
@Table(name = "seguimiento")
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idseguimiento")
    private Integer idseguimiento;
    @Size(max = 50)
    @Column(name = "idExterno")
    private String idExterno;
    @Column(name = "docu_codigo")
    private Integer docuCodigo;
    @Column(name = "fecha_seguimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSeguimiento;
    @Size(max = 45)
    @Column(name = "estado_seguimiento")
    private String estadoSeguimiento;
    @Size(max = 4)
    @Column(name = "cdr_code")
    private String cdrCode;
    @Size(max = 5000)
    @Column(name = "cdr_nota")
    private String cdrNota;
    @Size(max = 5000)
    @Column(name = "cdr_observacion")
    private String cdrObservacion;

    public Seguimiento() {
    }

    public Seguimiento(Integer idseguimiento) {
        this.idseguimiento = idseguimiento;
    }

    public Integer getIdseguimiento() {
        return idseguimiento;
    }

    public void setIdseguimiento(Integer idseguimiento) {
        this.idseguimiento = idseguimiento;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public Integer getDocuCodigo() {
        return docuCodigo;
    }

    public void setDocuCodigo(Integer docuCodigo) {
        this.docuCodigo = docuCodigo;
    }

    public Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public String getEstadoSeguimiento() {
        return estadoSeguimiento;
    }

    public void setEstadoSeguimiento(String estadoSeguimiento) {
        this.estadoSeguimiento = estadoSeguimiento;
    }

    public String getCdrCode() {
        return cdrCode;
    }

    public void setCdrCode(String cdrCode) {
        this.cdrCode = cdrCode;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idseguimiento != null ? idseguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.idseguimiento == null && other.idseguimiento != null) || (this.idseguimiento != null && !this.idseguimiento.equals(other.idseguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.joedayz.modelo.Seguimiento[ idseguimiento=" + idseguimiento + " ]";
    }
    
}
