package pe.joedayz.joefact.repositorio.filtros;

import java.io.Serializable;

public class TipoDocumentoFiltros implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idTipoDocu;
    private String nombreTipoDocu;

    public String getIdTipoDocu() {
        return idTipoDocu;
    }

    public void setIdTipoDocu(String idTipoDocu) {
        this.idTipoDocu = idTipoDocu;
    }

    public String getNombreTipoDocu() {
        return nombreTipoDocu;
    }

    public void setNombreTipoDocu(String nombreTipoDocu) {
        this.nombreTipoDocu = nombreTipoDocu;
    }



}
