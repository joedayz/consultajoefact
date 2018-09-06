package pe.joedayz.cofaco.service;

import java.io.Serializable;

import javax.inject.Inject;

import pe.joedayz.cofaco.modelo.ResetRegistry;
import pe.joedayz.cofaco.repositorio.ResetRegistryRepository;
import pe.joedayz.cofaco.util.jpa.Transaccion;

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
