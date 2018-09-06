package pe.joedayz.cofaco.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import pe.joedayz.cofaco.modelo.Grupo;

public class GrupoRepositorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public List<Grupo> listarGrupos() {
		return entityManager.createQuery("from Grupo ", Grupo.class)
				.getResultList();
	}

	public Grupo obtenerGrupo(Long id) {

		return entityManager.find(Grupo.class, id);

	}
}
