package pe.joedayz.joefact.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pe.joedayz.joefact.modelo.ResumendiaCab;
import pe.joedayz.joefact.repositorio.ResumenBoletasRepositorio;
import pe.joedayz.joefact.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=ResumendiaCab.class)
public class ResumenBoletaConverter implements Converter{

	private ResumenBoletasRepositorio cabeceraRepositorio;
	
	
	public ResumenBoletaConverter(){
		this.cabeceraRepositorio = (ResumenBoletasRepositorio) CDIServiceLocator.getBean(ResumenBoletasRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ResumendiaCab retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.cabeceraRepositorio.buscarCabeceraPorDocuCodigo(new Integer(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			ResumendiaCab cabecera = (ResumendiaCab) value;
			return cabecera.getCodigo() == null ? null :  cabecera.getCodigo().toString();
		}
		return "";
	}

}
