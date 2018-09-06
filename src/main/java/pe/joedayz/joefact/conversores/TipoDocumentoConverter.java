package pe.joedayz.joefact.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pe.joedayz.joefact.modelo.TipoDocumento;
import pe.joedayz.joefact.repositorio.TipoDocumentoRepositorio;
import pe.joedayz.joefact.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=TipoDocumento.class)
public class TipoDocumentoConverter implements Converter{

	private TipoDocumentoRepositorio tipoDocumentoRepositorio;
	
	
	public TipoDocumentoConverter(){
		this.tipoDocumentoRepositorio = (TipoDocumentoRepositorio) CDIServiceLocator.getBean(TipoDocumentoRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoDocumento retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.tipoDocumentoRepositorio.buscarTipoDocumentoPorCodigo(Long.valueOf(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			TipoDocumento tipoDocumento = (TipoDocumento) value;
			return tipoDocumento.getIdTipoDocu()== null ? null :  tipoDocumento.getIdTipoDocu().toString();
		}
		return "";
	}

}
