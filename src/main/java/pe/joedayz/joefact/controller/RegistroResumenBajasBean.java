package pe.joedayz.joefact.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.joedayz.joefact.jsf.FacesUtil;
import pe.joedayz.joefact.modelo.ResumendiaBaja;
import pe.joedayz.joefact.repositorio.filtros.ResumenBajasFiltros;
import pe.joedayz.joefact.security.Seguridad;
import pe.joedayz.joefact.service.RegistroResumenBajasService;

@Named
@ViewScoped
public class RegistroResumenBajasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private @Inject
    Seguridad seguridad;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Inject
    private RegistroResumenBajasService boletaServiceService;

    private ResumendiaBaja resumendiaCab;
    private List<ResumendiaBaja> listaResumedia;
    private ResumenBajasFiltros filtros;

    public void inicializar() {

        if (this.resumendiaCab == null) {
            this.resumendiaCab = new ResumendiaBaja();
        }
        this.resumendiaCab.setEmprNroruc(getSeguridad().getInternoEmpresa().getEpmrRuc());
        this.resumendiaCab.setEmprRazonsocial(getSeguridad().getInternoEmpresa().getEmprRazonSocial());
        this.resumendiaCab.setResuTipo("RA");
        this.resumendiaCab.setResuProceStatus("#");
        this.fechaEmisiom = new Date();
        this.fechaComunicacion = new Date();

        //generaIdentificador();
    }

    public Seguridad getSeguridad() {
        return seguridad;
    }

    private Date fechaEmisiom;
    private Date fechaComunicacion;

    public ResumendiaBaja getResumendiaBaja() {
        return resumendiaCab;
    }

    public void setResumendiaBaja(ResumendiaBaja resumendiaCab) {
        this.resumendiaCab = resumendiaCab;
    }

    public void registrarResumendiaBaja() {
        this.resumendiaCab.setResuFechaDoc(format.format(fechaEmisiom));
        this.resumendiaCab.setResuFechaCom(format.format(fechaComunicacion));
        this.resumendiaCab = boletaServiceService.registrarResumendiaBaja(this.resumendiaCab);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("Se registro correctamente");
    }

    private void limpiarFormulario() {
        resumendiaCab = new ResumendiaBaja();

    }

    public boolean isEditando() {
        return (this.resumendiaCab != null && this.resumendiaCab.getCodigo() != null);
    }

    public void generaIdentificador() {
        format.format(fechaEmisiom);
        filtros = new ResumenBajasFiltros();
        filtros.setFechaComunicacion(fechaComunicacion);
        listaResumedia = boletaServiceService.listarCabecerasFiltradas(filtros);
        String correlativoStr = listaResumedia == null ? "00001" : String.format("%05d", listaResumedia.size() + 1);

        resumendiaCab.setResuIdentificador(resumendiaCab.getResuTipo() + "-" + format.format(fechaEmisiom).replaceAll("-", "") + "-" + correlativoStr);
    }

    public Date getFechaEmisiom() {
        return fechaEmisiom;
    }

    public void setFechaEmisiom(Date fechaEmisiom) {
        this.fechaEmisiom = fechaEmisiom;
    }

    public Date getFechaComunicacion() {
        return fechaComunicacion;
    }

    public void setFechaComunicacion(Date fechaComunicacion) {
        this.fechaComunicacion = fechaComunicacion;
    }

}
