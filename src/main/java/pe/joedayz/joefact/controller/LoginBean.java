package pe.joedayz.joefact.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.joedayz.joefact.jsf.FacesUtil;
import pe.joedayz.joefact.modelo.Empresa;
import pe.joedayz.joefact.repositorio.EmpresaRepositorio;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Inject
	private FacesContext facesContext;
	@Inject
	private HttpServletRequest request;
	@Inject
	private HttpServletResponse response;

	@Inject
	private EmpresaRepositorio empresaRepositorio;

	private String email;
	private String password;
	private String internoEmpresa;
	private List<Empresa> empresasInternas = new ArrayList<>();

	public void preRender() {

		if ("true".equals(request.getParameter("invalid"))) {
			FacesUtil.adicionarMensajeError("Email o password son incorrectos.");
		}
	}

	public void login() throws ServletException, IOException {
		if(email!=null && email.trim().equals("")){
			FacesUtil.adicionarMensajeError("Ingrese su email");
		}
		else if(password!=null && password.trim().equals("")){
			FacesUtil.adicionarMensajeError("Ingrese su password");
		}else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
			dispatcher.forward(request, response);

			facesContext.responseComplete();
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInternoEmpresa() {
		return internoEmpresa;
	}

	public void setInternoEmpresa(String internoEmpresa) {
		this.internoEmpresa = internoEmpresa;
	}

	public List<Empresa> getEmpresasInternas() {
		this.empresasInternas = empresaRepositorio.listarEmpresasInternas();
		return empresasInternas;
	}

	public void setEmpresasInternas(List<Empresa> empresasInternas) {
		this.empresasInternas = empresasInternas;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
