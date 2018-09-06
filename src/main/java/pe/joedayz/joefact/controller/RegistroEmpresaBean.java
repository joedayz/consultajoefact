package pe.joedayz.joefact.controller;

import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.joedayz.joefact.jsf.FacesUtil;
import pe.joedayz.joefact.modelo.TipoPersona;
import pe.joedayz.joefact.modelo.Empresa;
import pe.joedayz.joefact.service.RegistroEmpresaService;

@Named
@ViewScoped
public class RegistroEmpresaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RegistroEmpresaService EmpresaService;

    private Empresa empresa;


    public void inicializar() {


        if (this.empresa == null) {
            this.empresa = new Empresa();
        }

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public TipoPersona[] getTiposPersona() {
        return TipoPersona.values();
    }

    public void registrarEmpresa() {
        this.empresa = EmpresaService.registrarEmpresa(this.empresa);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("El Empresa se registro correctamente");
    }

    private void limpiarFormulario() {
        empresa = new Empresa();

    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;

    }

    public boolean isEditando() {
        return (this.empresa != null && this.empresa.getIdEmpresa() != null);
    }

}
