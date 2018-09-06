package pe.joedayz.joefact.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import pe.joedayz.joefact.modelo.TipoDocumento;

public class TipoDocumentoRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public TipoDocumento buscarTipoDocumentoPorCodigo(Long codigo) {
        return this.entityManager.find(TipoDocumento.class, codigo);
    }

    public List<TipoDocumento> listarTipoDocumentos() {
        return this.entityManager.createQuery("from TipoDocumento ", TipoDocumento.class)
                .getResultList();
    }


}
