package pe.joedayz.cofaco.service;

import java.io.Serializable;

import javax.inject.Inject;

import pe.joedayz.cofaco.modelo.Usuario;
import pe.joedayz.cofaco.repositorio.UsuarioRepositorio;
import pe.joedayz.cofaco.util.jpa.Transaccion;

public class RegistroUsuarioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepositorio usuarioRepositorio;
	
	@Transaccion
	public Usuario registrarUsuario(Usuario usuario){
		


		if(usuario.getIdeUsuario()!=null) {
			Usuario usuarioExistente = usuarioRepositorio.buscarUsuarioActivoOInactivoPorEmail(usuario.getEmail());
			if (usuarioExistente != null && !usuarioExistente.equals(usuario)) {
				throw new NegocioExcepciones("Ya existe un usuario con ese Email, verificar");
			}

			usuarioExistente = usuarioRepositorio.buscarUsuarioActivoOInactivoPorDni(usuario.getDni());

			if (usuarioExistente != null && !usuarioExistente.equals(usuario)) {
				throw new NegocioExcepciones("Ya existe un usuario con ese DNI, verificar");
			}
		}else{ //nuevo
			Usuario usuarioExistente = usuarioRepositorio.buscarUsuarioActivoOInactivoPorEmail(usuario.getEmail());
			if (usuarioExistente != null) {
				throw new NegocioExcepciones("Ya existe un usuario con ese Email, verificar");
			}

			usuarioExistente = usuarioRepositorio.buscarUsuarioActivoOInactivoPorDni(usuario.getDni());

			if (usuarioExistente != null ) {
				throw new NegocioExcepciones("Ya existe un usuario con ese DNI, verificar");
			}
		}


		return usuarioRepositorio.adicionarUsuario(usuario);
	}

}
