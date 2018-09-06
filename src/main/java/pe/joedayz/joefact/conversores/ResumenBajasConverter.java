package pe.joedayz.joefact.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pe.joedayz.joefact.modelo.ResumendiaBaja;
import pe.joedayz.joefact.repositorio.ResumenBajasRepositorio;
import pe.joedayz.joefact.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=ResumendiaBaja.class)
public class ResumenBajasConverter implements Converter{

	private ResumenBajasRepositorio cabeceraRepositorio;
	
	
	public ResumenBajasConverter(){
		this.cabeceraRepositorio = (ResumenBajasRepositorio) CDIServiceLocator.getBean(ResumenBajasRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ResumendiaBaja retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.cabeceraRepositorio.buscarCabeceraPorDocuCodigo(new Integer(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			ResumendiaBaja cabecera = (ResumendiaBaja) value;
			return cabecera.getCodigo() == null ? null :  cabecera.getCodigo().toString();
		}
		return "";
	}

}
