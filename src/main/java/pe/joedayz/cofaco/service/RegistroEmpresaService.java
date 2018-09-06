package pe.joedayz.cofaco.service;

import java.io.Serializable;

import javax.inject.Inject;

import pe.joedayz.cofaco.modelo.Empresa;
import pe.joedayz.cofaco.repositorio.EmpresaRepositorio;
import pe.joedayz.cofaco.util.jpa.Transaccion;

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
