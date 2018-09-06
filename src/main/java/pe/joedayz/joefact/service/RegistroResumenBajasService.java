package pe.joedayz.joefact.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.joedayz.joefact.modelo.ResumendiaBaja;
import pe.joedayz.joefact.repositorio.ResumenBajasRepositorio;
import pe.joedayz.joefact.repositorio.filtros.ResumenBajasFiltros;
import pe.joedayz.joefact.util.jpa.Transaccion;

public class RegistroResumenBajasService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ResumenBajasRepositorio resumenBoletasRepositorio;
	
	public ResumendiaBaja buscarCabeceraPorDocuCodigo(Integer docuCodigo){
		return resumenBoletasRepositorio.buscarCabeceraPorDocuCodigo(docuCodigo);
	}
	
	public List<ResumendiaBaja> listarCabecerasFiltradas(ResumenBajasFiltros filtros)  {
		return resumenBoletasRepositorio.listarCabecerasFiltradas(filtros);
	}
        
	@Transaccion
	public ResumendiaBaja registrarResumendiaBaja(ResumendiaBaja resumendiaCab){
		
		return resumenBoletasRepositorio.adicionarResumendiaBaja(resumendiaCab);
	}

        

}
