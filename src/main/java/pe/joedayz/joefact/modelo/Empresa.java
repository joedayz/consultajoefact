/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.joefact.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author oswaldo
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idEmpresa;
    private String epmrRuc;
    private String emprRazonSocial;
    private TipoEmpresaApp emprTipo;

    @Id
    @GeneratedValue
    @Column(name = "ide_empresa", nullable = false, length = 10)
    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @NotBlank
    @Column(name = "empr_ruc", nullable = false, unique = true,length = 11)
    public String getEpmrRuc() {
        return epmrRuc;
    }

    public void setEpmrRuc(String epmrRuc) {
        this.epmrRuc = epmrRuc;
    }

    @NotBlank
    @Column(name = "empr_razon_social", nullable = false, length = 150)
    public String getEmprRazonSocial() {
        return emprRazonSocial;
    }

    public void setEmprRazonSocial(String emprRazonSocial) {
        this.emprRazonSocial = emprRazonSocial;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "empr_tipo", nullable = false, length = 50)
    public TipoEmpresaApp getEmprTipo() {
        return emprTipo;
    }

    public void setEmprTipo(TipoEmpresaApp emprTipo) {
        this.emprTipo = emprTipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
        return result;
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
        final Empresa other = (Empresa) obj;
        if (idEmpresa == null) {
            if (other.idEmpresa != null) {
                return false;
            }
        } else if (!idEmpresa.equals(other.idEmpresa)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", epmrRuc=" + epmrRuc + ", emprRazonSocial=" + emprRazonSocial + ", emprTipo=" + emprTipo + '}';
    }

}
