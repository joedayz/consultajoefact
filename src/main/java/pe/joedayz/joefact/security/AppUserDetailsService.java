package pe.joedayz.joefact.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pe.joedayz.joefact.modelo.Grupo;
import pe.joedayz.joefact.modelo.Usuario;
import pe.joedayz.joefact.repositorio.UsuarioRepositorio;
import pe.joedayz.joefact.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService{

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioRepositorio usuarioRepositorio = CDIServiceLocator.getBean(UsuarioRepositorio.class);
		Usuario usuario = usuarioRepositorio.buscarUsuarioActivoPorEmail(email);
		UsuarioSistema user = null;
		if(usuario!=null){
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		for(Grupo grupo : usuario.getGrupos()){
			authorities.add(new SimpleGrantedAuthority(grupo.getNombreGrupo().toUpperCase()));
		}
		
		return authorities;
	}

}
