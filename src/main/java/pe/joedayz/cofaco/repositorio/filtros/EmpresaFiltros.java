package pe.joedayz.cofaco.repositorio.filtros;

import java.io.Serializable;

public class EmpresaFiltros implements Serializable {

    private static final long serialVersionUID = 1L;

    private String epmrRuc;
    private String emprRazonSocial;
    private String emprTipo;

    public String getEpmrRuc() {
        return epmrRuc;
    }

    public void setEpmrRuc(String epmrRuc) {
        this.epmrRuc = epmrRuc;
    }

    public String getEmprRazonSocial() {
        return emprRazonSocial;
    }

    public void setEmprRazonSocial(String emprRazonSocial) {
        this.emprRazonSocial = emprRazonSocial;
    }

    public String getEmprTipo() {
        return emprTipo;
    }

    public void setEmprTipo(String emprTipo) {
        this.emprTipo = emprTipo;
    }



}
