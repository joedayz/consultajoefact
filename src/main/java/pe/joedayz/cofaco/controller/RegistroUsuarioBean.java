package pe.joedayz.cofaco.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.joedayz.cofaco.jsf.FacesUtil;
import pe.joedayz.cofaco.modelo.Empresa;
import pe.joedayz.cofaco.modelo.Grupo;
import pe.joedayz.cofaco.modelo.TipoPersona;
import pe.joedayz.cofaco.modelo.Usuario;
import pe.joedayz.cofaco.repositorio.EmpresaRepositorio;
import pe.joedayz.cofaco.repositorio.GrupoRepositorio;
import pe.joedayz.cofaco.service.NegocioExcepciones;
import pe.joedayz.cofaco.service.RegistroUsuarioService;

@Named
@ViewScoped
public class RegistroUsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private GrupoRepositorio grupoRepositorio;

    @Inject
    private RegistroUsuarioService UsuarioService;

    @Inject
    private EmpresaRepositorio empresaRepositorio;

    private Usuario usuario;
    private List<Grupo> grupos = new ArrayList<>();
    private Grupo grupo;

    private List<Empresa> empresas = new ArrayList<>();

    public void inicializar() {

        grupos = grupoRepositorio.listarGrupos();

        if (this.usuario == null) {
            this.usuario = new Usuario();
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public TipoPersona[] getTiposPersona() {
        return TipoPersona.values();
    }

    public void registrarUsuario() {
        try {
            this.usuario = UsuarioService.registrarUsuario(this.usuario);
            limpiarFormulario();
            FacesUtil.adicionarMensajeInfo("El Usuario se registro correctamente");
        }catch (NegocioExcepciones ex){
            FacesUtil.adicionarMensajeError("El Usuario no se pudo registrar correctamente. " + ex.getMessage());
        }

    }

    private void limpiarFormulario() {
        usuario = new Usuario();

    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;

    }

    public boolean isEditando() {
        return (this.usuario != null && this.usuario.getIdeUsuario() != null);
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public List<Empresa> getEmpresas() {
        this.empresas = empresaRepositorio.listarEmpresas();
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public void eliminarGrupo() {

        List<Grupo> gruposUsuario = this.usuario.getGrupos();
        if (!gruposUsuario.isEmpty()) {

            if (gruposUsuario.contains(grupo)) {

                gruposUsuario.remove(grupo);
            }
        }

    }

    public void agregarGrupo() {

        List<Grupo> gruposUsuario = this.usuario.getGrupos();

        if (gruposUsuario.isEmpty()) {

            gruposUsuario.add(grupo);
        } else if (!gruposUsuario.contains(grupo)) {

            gruposUsuario.add(grupo);
        }

    }

    public void addMessage() {
        String summary = this.usuario.isActivo() ? "El usuario esta activo ahora." : "El usuario esta inactivo ahora.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

}
