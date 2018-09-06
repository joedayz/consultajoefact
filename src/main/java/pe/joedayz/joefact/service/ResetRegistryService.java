package pe.joedayz.joefact.service;

import java.io.Serializable;

import javax.inject.Inject;

import pe.joedayz.joefact.modelo.ResetRegistry;
import pe.joedayz.joefact.repositorio.ResetRegistryRepository;
import pe.joedayz.joefact.util.jpa.Transaccion;

public class ResetRegistryService implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ResetRegistryRepository resetRegistryRepository;
	
	
	@Transaccion
	public ResetRegistry registrarResetRegistry(ResetRegistry resetRegistry){
		
		
		return resetRegistryRepository.grabar(resetRegistry);
	}
}
