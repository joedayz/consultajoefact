package pe.joedayz.cofaco.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pe.joedayz.cofaco.modelo.Empresa;
import pe.joedayz.cofaco.repositorio.EmpresaRepositorio;
import pe.joedayz.cofaco.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Empresa.class)
public class EmpresaConverter implements Converter{

	private EmpresaRepositorio empresaRepositorio;
	
	
	public EmpresaConverter(){
		this.empresaRepositorio = (EmpresaRepositorio) CDIServiceLocator.getBean(EmpresaRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Empresa retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.empresaRepositorio.buscarEmpresaPorCodigo(Long.valueOf(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			Empresa empresa = (Empresa) value;
			return empresa.getIdEmpresa()== null ? null :  empresa.getIdEmpresa().toString();
		}
		return "";
	}

}
