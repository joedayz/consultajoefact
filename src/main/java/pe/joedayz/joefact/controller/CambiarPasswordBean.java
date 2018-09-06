package pe.joedayz.joefact.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import pe.joedayz.joefact.jsf.FacesUtil;
import pe.joedayz.joefact.modelo.ResetRegistry;
import pe.joedayz.joefact.modelo.Usuario;
import pe.joedayz.joefact.repositorio.ResetRegistryRepository;
import pe.joedayz.joefact.repositorio.UsuarioRepositorio;
import pe.joedayz.joefact.util.jpa.Transaccion;

@Named
@ViewScoped
public class CambiarPasswordBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FacesContext facesContext;
    @Inject
    private HttpServletRequest request;

    private String password;

    private String confirmarPassword;

    private String token;

    @Inject
    ResetRegistryRepository resetRegistryRepository;

    @Inject
    UsuarioRepositorio usuarioRepositorio;

    public void preRender() {

        if ("true".equals(request.getParameter("invalid"))) {
            FacesUtil.adicionarMensajeError("El token es invalido. Por favor, solicitar un nuevo token.");
        }

        if ("true".equals(request.getParameter("expired"))) {
            FacesUtil.adicionarMensajeError("El link que estas usando tiene mas de un día y ya expiró; por favor, usa el Recuperar Passwordk nuevamente.");
        }

        if ("true".equals(request.getParameter("done"))) {
            FacesUtil.adicionarMensajeInfo("El password ha sido cambiado satisfactoriamente. Regresar al inicio nuevamente.");
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect(context.getRequestContextPath());
            } catch (IOException ex) {
                Logger.getLogger(CambiarPasswordBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.token = request.getParameter("token");

    }

    @Transaccion
    public void cambiarPassword() throws ServletException, IOException {

        ResetRegistry resetEntry = resetRegistryRepository.buscarPorToken(token);

        if (resetEntry == null) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/CambiarPassword.xhtml?invalid=true&token=" + token);
        }

        long startTime = new Date().getTime();
        long endTime = resetEntry.getCreatedDate().getTime();
        long minutesInMilli = 1000 * 60;
        long minutesInADay = 1440;

        long elapsedMins = (startTime - endTime) / minutesInMilli;

        if (elapsedMins > minutesInADay) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/CambiarPassword.xhtml?expired=true&token=" + token);
        }

        Usuario usuario = usuarioRepositorio.buscarUsuarioActivoPorEmail(resetEntry.getUserName());
        usuario.setPassword(getPassword());
        usuarioRepositorio.adicionarUsuario(usuario);

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/CambiarPassword.xhtml?done=true");

        facesContext.responseComplete();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

}
