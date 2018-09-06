package pe.joedayz.cofaco.repositorio.filtros;

import java.io.Serializable;

public class NotaCreditoFiltros implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clieRuc;
    private String clieRazonSocial;

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
}
