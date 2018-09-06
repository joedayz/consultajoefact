package pe.joedayz.joefact.controller;

import java.io.IOException;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Properties;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.outjected.email.api.MailMessage;

import pe.joedayz.joefact.jsf.FacesUtil;
import pe.joedayz.joefact.modelo.ResetRegistry;
import pe.joedayz.joefact.modelo.Usuario;
import pe.joedayz.joefact.repositorio.UsuarioRepositorio;
import pe.joedayz.joefact.service.ResetRegistryService;
import pe.joedayz.joefact.util.jpa.Transaccion;
import pe.joedayz.joefact.util.mail.Mailer;

@Named
@ViewScoped
public class RecuperarPasswordBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FacesContext facesContext;
    @Inject
    private HttpServletRequest request;

    @Inject
    private UsuarioRepositorio usuarioRepositorio;

    @Inject
    private ResetRegistryService resetRegistryService;

    private String email;

    @Inject
    private Mailer mailer;

    public void preRender() {

        if ("true".equals(request.getParameter("invalid"))) {
            FacesUtil.adicionarMensajeError("Email no es encontrado en nuestra base de datos.");
        }
        if ("true".equals(request.getParameter("errorEnviandoEmail"))) {
            FacesUtil.adicionarMensajeError("Error al enviar el email. Intentenlo en unos minutos.");
        }
        if ("true".equals(request.getParameter("valid"))) {
            FacesUtil.adicionarMensajeInfo("Por favor, busca en tu inbox el link para recuperar tu password.");
        }
    }

    @Transaccion
    public void recoverPassword() throws ServletException, IOException {

        Usuario usuario = usuarioRepositorio.buscarUsuarioActivoPorEmail(email);

        if (usuario == null) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/RecuperarPassword.xhtml?invalid=true");

            facesContext.responseComplete();
        }else {

            String token = generateSecurityToken();
            ResetRegistry recuperarRegistry = new ResetRegistry();

            recuperarRegistry.setUserName(email);
            recuperarRegistry.setToken(token);
            recuperarRegistry.setCreatedBy("easyfact");
            recuperarRegistry.setCreatedDate(new Date());

            resetRegistryService.registrarResetRegistry(recuperarRegistry);

            try {
                sendEmail(token, email);
            } catch (Exception e) {

                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/RecuperarPassword.xhtml?errorEnviandoEmail=true");
            }

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/RecuperarPassword.xhtml?valid=true");

            facesContext.responseComplete();
        }

    }

    private void sendEmail(String token, String email2) throws IOException {

        MailMessage mensaje = mailer.nuevoEmail();
        mensaje.to(email)
                .subject("EasyFact: Solicitud de recuperación de password")
                .bodyHtml(buildEmailTextBody(token))
                .send();

    }

    private String buildEmailTextBody(String token) throws IOException {
        String msg = "Por favor, haga clic en el siguiente link para recuperar su password "
                + buildChangePasswordPageUrl(token);

        return msg;
    }

    private String buildChangePasswordPageUrl(String token) throws IOException {
        Properties propiedades = new Properties();
        propiedades.load(getClass().getResourceAsStream("/mail.properties"));

        String result = request.getScheme() + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath() + "/CambiarPassword.xhtml?token=" + token;

//        String result = "http://" + propiedades.getProperty("mail.ipAddress")
//                + ":8080/ConsultaFacturacionElectronica/CambiarPassword.xhtml?token=" + token;
        
        return result.toString();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String generateSecurityToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();

        return token;
    }

}
