package pe.joedayz.joefact.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.joedayz.joefact.modelo.ResumendiaCab;
import pe.joedayz.joefact.repositorio.ResumenBoletasRepositorio;
import pe.joedayz.joefact.repositorio.filtros.ResumenBoletasFiltros;
import pe.joedayz.joefact.util.jpa.Transaccion;

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
