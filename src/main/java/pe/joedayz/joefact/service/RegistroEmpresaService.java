package pe.joedayz.joefact.service;

import java.io.Serializable;

import javax.inject.Inject;

import pe.joedayz.joefact.modelo.Empresa;
import pe.joedayz.joefact.repositorio.EmpresaRepositorio;
import pe.joedayz.joefact.util.jpa.Transaccion;

public class RegistroEmpresaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepositorio empresaRepositorio;
	
	@Transaccion
	public Empresa registrarEmpresa(Empresa empresa){
		
		Empresa empresaExistente = empresaRepositorio.buscarEmpresaPorRuc(empresa.getEpmrRuc());
		
		if(empresaExistente!=null && !empresaExistente.equals(empresa)){
			throw new NegocioExcepciones("Ya existe un empresa con ese RUC, verificar"); 
		}
		
		return empresaRepositorio.adicionarEmpresa(empresa);
	}

}
