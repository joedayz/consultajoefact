package pe.joedayz.cofaco.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.joedayz.cofaco.modelo.Cabecera;
import pe.joedayz.cofaco.repositorio.CabeceraRepositorio;
import pe.joedayz.cofaco.repositorio.filtros.CabeceraFiltros;
import pe.joedayz.cofaco.util.jpa.Transaccion;

public class CabeceraService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CabeceraRepositorio cabeceraRepositorio;
	
	public Cabecera buscarCabeceraPorDocuCodigo(Long docuCodigo){
		return cabeceraRepositorio.buscarCabeceraPorDocuCodigo(docuCodigo);
	}
	
	public List<Cabecera> listarCabecerasFiltradas(CabeceraFiltros filtros)  {
		return cabeceraRepositorio.listarCabecerasFiltradas(filtros);
	}


	@Transaccion
	public Cabecera registrarNotaCredito(Cabecera notaCredito) {

		Cabecera notaCreditoExistente = cabeceraRepositorio.
				buscarCabeceraPorDocuCodigo(Long.valueOf(notaCredito.getDocuCodigo()));

		if(notaCreditoExistente!=null && !notaCreditoExistente.equals(notaCredito)){
			throw new NegocioExcepciones("Ya existe una nota de crédito con ese número de documento, verificar");
		}



		return cabeceraRepositorio.registrarNotaCredito(notaCredito);

	}
        
	@Transaccion
	public Cabecera registrarBajaBoleta(Cabecera boleta) {

//		Cabecera boletaExistente = cabeceraRepositorio.
//				buscarCabeceraPorDocuCodigo(Long.valueOf(boleta.getDocuCodigo()));
//
//		if(boletaExistente!=null && !boletaExistente.equals(boleta)){
//			throw new NegocioExcepciones("Ya existe una nota de crédito con ese número de documento, verificar");
//		}
//                //boleta.setItemEstadoBaja("3");

		return cabeceraRepositorio.registrarBoleta(boleta);

	}
}
