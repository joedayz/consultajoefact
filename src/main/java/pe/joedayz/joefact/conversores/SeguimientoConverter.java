package pe.joedayz.joefact.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pe.joedayz.joefact.modelo.Seguimiento;
import pe.joedayz.joefact.repositorio.SeguimientoRepositorio;
import pe.joedayz.joefact.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Seguimiento.class)
public class SeguimientoConverter implements Converter{

	private SeguimientoRepositorio repositorio;
	
	
	public SeguimientoConverter(){
		this.repositorio = (SeguimientoRepositorio) CDIServiceLocator.getBean(SeguimientoRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Seguimiento retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.repositorio.buscarSeguimientoPorCodigo(Long.valueOf(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			Seguimiento seguimiento = (Seguimiento) value;
			return seguimiento.getIdseguimiento()== null ? null :  seguimiento.getIdseguimiento().toString();
		}
		return "";
	}

}
