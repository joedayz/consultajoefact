package pe.joedayz.cofaco.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pe.joedayz.cofaco.modelo.Cabecera;
import pe.joedayz.cofaco.repositorio.CabeceraRepositorio;
import pe.joedayz.cofaco.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Cabecera.class)
public class CabeceraConverter implements Converter{

	private CabeceraRepositorio cabeceraRepositorio;
	
	
	public CabeceraConverter(){
		this.cabeceraRepositorio = (CabeceraRepositorio) CDIServiceLocator.getBean(CabeceraRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cabecera retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.cabeceraRepositorio.buscarCabeceraPorDocuCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			Cabecera cabecera = (Cabecera) value;
			return cabecera.getDocuCodigo() == null ? null :  cabecera.getDocuCodigo().toString();
		}
		return "";
	}

}
