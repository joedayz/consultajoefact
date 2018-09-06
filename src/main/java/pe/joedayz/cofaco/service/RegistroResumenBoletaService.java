package pe.joedayz.cofaco.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.joedayz.cofaco.modelo.ResumendiaCab;
import pe.joedayz.cofaco.repositorio.ResumenBoletasRepositorio;
import pe.joedayz.cofaco.repositorio.filtros.ResumenBoletasFiltros;
import pe.joedayz.cofaco.util.jpa.Transaccion;

public class RegistroResumenBoletaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ResumenBoletasRepositorio resumenBoletasRepositorio;
	
	public ResumendiaCab buscarCabeceraPorDocuCodigo(Integer docuCodigo){
		return resumenBoletasRepositorio.buscarCabeceraPorDocuCodigo(docuCodigo);
	}
	
	public List<ResumendiaCab> listarCabecerasFiltradas(ResumenBoletasFiltros filtros)  {
		return resumenBoletasRepositorio.listarCabecerasFiltradas(filtros);
	}
        
	@Transaccion
	public ResumendiaCab registrarResumendiaCab(ResumendiaCab resumendiaCab){
		
		return resumenBoletasRepositorio.adicionarResumendiaCab(resumendiaCab);
	}

        

}
