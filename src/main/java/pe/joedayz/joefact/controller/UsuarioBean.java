package pe.joedayz.joefact.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.joedayz.joefact.jsf.FacesUtil;
import pe.joedayz.joefact.modelo.Usuario;
import pe.joedayz.joefact.repositorio.UsuarioRepositorio;
import pe.joedayz.joefact.repositorio.filtros.UsuarioFiltros;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;




	@Inject
	private UsuarioRepositorio usuarioRepositorio;

	private List<Usuario> usuariosFiltrados;
	private UsuarioFiltros filtros;

	private Usuario usuarioSeleccionado;


	@PostConstruct
	public void init(){
		filtros = new UsuarioFiltros();
		buscarUsuarioFiltros();
	}


	public void buscarUsuarioFiltros() {
		usuariosFiltrados = usuarioRepositorio.listarUsuariosFiltrados(filtros);

	}

	public void eliminarUsuario() {

		usuarioRepositorio.removerUsuario(usuarioSeleccionado);

		try {
			usuariosFiltrados.remove(usuarioSeleccionado);
			FacesUtil.adicionarMensajeInfo("Usuario " + usuarioSeleccionado.getNombreUsuario() + " eliminado.");
		}catch (Exception ex){
			FacesUtil.adicionarMensajeError("Usuario " + usuarioSeleccionado.getNombreUsuario() + " no puede ser eliminado. Tiene información relacionada");
		}
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public UsuarioFiltros getFiltros() {
		return filtros;
	}

	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}
}
