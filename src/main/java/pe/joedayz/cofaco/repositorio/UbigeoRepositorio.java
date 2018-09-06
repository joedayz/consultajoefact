package pe.joedayz.cofaco.repositorio;

import pe.joedayz.cofaco.modelo.Ubigeo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class UbigeoRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public List<Ubigeo> listarUbigeo() {
        return this.entityManager.createQuery("from Ubigeo  ", Ubigeo.class)
                .getResultList();
    }
}
