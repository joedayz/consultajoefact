/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.cofaco.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author oswaldo
 */
@Entity
@Table(name = "tipo_documento")
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ide_tipo_documento", nullable = false)
    private Long idTipoDocu;

    @Size(max = 45)
    @Column(name = "nombre_docu", nullable = false)
    private String nombreTipoDocu;

    @Size(max = 45)
    @Column(name = "docu_tipodocumento", nullable = false)
    private String docuTipoDocumento;


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.idTipoDocu);
        return hash;
    }


    public Long getIdTipoDocu() {
        return idTipoDocu;
    }

    public void setIdTipoDocu(Long idTipoDocu) {
        this.idTipoDocu = idTipoDocu;
    }

    public String getNombreTipoDocu() {
        return nombreTipoDocu;
    }

    public void setNombreTipoDocu(String nombreTipoDocu) {
        this.nombreTipoDocu = nombreTipoDocu;
    }


    public String getDocuTipoDocumento() {
        return docuTipoDocumento;
    }

    public void setDocuTipoDocumento(String docuTipoDocumento) {
        this.docuTipoDocumento = docuTipoDocumento;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoDocumento other = (TipoDocumento) obj;
        if (!Objects.equals(this.idTipoDocu, other.idTipoDocu)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoDocumento{" + "idTipoDocu=" + idTipoDocu + ", nombreTipoDocu=" + nombreTipoDocu + '}';
    }

}
