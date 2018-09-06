package pe.joedayz.joefact.repositorio;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import pe.joedayz.joefact.modelo.ResetRegistry;

public class ResetRegistryRepository implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	
	
	public ResetRegistry buscarPorToken(String token) {
		
		ResetRegistry resetRegistry;
		try{
			resetRegistry =  this.entityManager.createQuery("from ResetRegistry where token = :token", ResetRegistry.class)
					.setParameter("token", token).getSingleResult();
		}catch(NoResultException e){
			resetRegistry = null;
		}
		return resetRegistry;
	}
	
	public ResetRegistry grabar(ResetRegistry resetRegistry) {
		 return entityManager.merge(resetRegistry);
	}
}
