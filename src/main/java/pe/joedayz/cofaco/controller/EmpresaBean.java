package pe.joedayz.cofaco.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.joedayz.cofaco.modelo.Empresa;
import pe.joedayz.cofaco.repositorio.EmpresaRepositorio;
import pe.joedayz.cofaco.repositorio.filtros.EmpresaFiltros;

@Named
@ViewScoped
public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;




	@Inject
	private EmpresaRepositorio empresaRepositorio;

	private List<Empresa> empresasFiltrados;
	private EmpresaFiltros filtros;

	private Empresa empresaSeleccionado;


	@PostConstruct
	public void init(){
		filtros = new EmpresaFiltros();
		buscarEmpresaFiltros();
	}


	public void buscarEmpresaFiltros() {
		empresasFiltrados = empresaRepositorio.listarEmpresasFiltrados(filtros);

	}


	public Empresa getEmpresaSeleccionado() {
		return empresaSeleccionado;
	}

	public void setEmpresaSeleccionado(Empresa empresaSeleccionado) {
		this.empresaSeleccionado = empresaSeleccionado;
	}

	public EmpresaFiltros getFiltros() {
		return filtros;
	}

	public List<Empresa> getEmpresasFiltrados() {
		return empresasFiltrados;
	}
}
