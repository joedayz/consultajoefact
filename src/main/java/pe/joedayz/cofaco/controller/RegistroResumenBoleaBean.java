package pe.joedayz.cofaco.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.joedayz.cofaco.jsf.FacesUtil;
import pe.joedayz.cofaco.modelo.ResumendiaCab;
import pe.joedayz.cofaco.modelo.TipoDocumento;
import pe.joedayz.cofaco.repositorio.TipoDocumentoRepositorio;
import pe.joedayz.cofaco.repositorio.filtros.ResumenBoletasFiltros;
import pe.joedayz.cofaco.security.Seguridad;
import pe.joedayz.cofaco.service.RegistroResumenBoletaService;

@Named
@ViewScoped
public class RegistroResumenBoleaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private @Inject
    Seguridad seguridad;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Inject
    private RegistroResumenBoletaService boletaServiceService;
    @Inject
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;

    private ResumendiaCab resumendiaCab;
    private List<ResumendiaCab> listaResumedia;
    private ResumenBoletasFiltros filtros;

    public void inicializar() throws ParseException {

        if (this.resumendiaCab == null) {
            this.resumendiaCab = new ResumendiaCab();
            this.resumendiaCab.setEmprNroruc(getSeguridad().getInternoEmpresa().getEpmrRuc());
            this.resumendiaCab.setEmprRazonsocial(getSeguridad().getInternoEmpresa().getEmprRazonSocial());
            this.resumendiaCab.setResuTipo("RC");
            this.resumendiaCab.setResuProceStatus("#");
            this.resumendiaCab.setResuTipodoc("03");
            this.resumendiaCab.setVersion("1.1");
            this.resumendiaCab.setResuEstado("1");
            this.fechaEmisiom = new Date();
            this.fechaComunicacion = new Date();
//        } else {
//            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//            this.fechaEmisiom = formato.parse(this.resumendiaCab.getResuFechaDoc());
//            this.fechaComunicacion = formato.parse(this.resumendiaCab.getResuFechaCom());
        }

        //generaIdentificador();
    }

    public Seguridad getSeguridad() {
        return seguridad;
    }

    private Date fechaEmisiom;
    private Date fechaComunicacion;

    public ResumendiaCab getResumendiaCab() {
        return resumendiaCab;
    }

    public void setResumendiaCab(ResumendiaCab resumendiaCab) {
        this.resumendiaCab = resumendiaCab;
    }

    public void registrarResumendiaCab() {
        this.resumendiaCab.setResuFechaDoc(format.format(fechaEmisiom));
        this.resumendiaCab.setResuFechaCom(format.format(fechaComunicacion));
        this.resumendiaCab = boletaServiceService.registrarResumendiaCab(this.resumendiaCab);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("Se registro correctamente");
    }

    private void limpiarFormulario() {
        resumendiaCab = new ResumendiaCab();

    }

    public boolean isEditando() {
        return (this.resumendiaCab != null && this.resumendiaCab.getCodigo() != null);
    }

    public void generaIdentificador() {
        format.format(fechaComunicacion);
        filtros = new ResumenBoletasFiltros();
        filtros.setFechaComunicacion(fechaComunicacion);
        listaResumedia = boletaServiceService.listarCabecerasFiltradas(filtros);
        String correlativoStr = listaResumedia == null ? "00001" : String.format("%05d", listaResumedia.size() + 1);

        resumendiaCab.setResuIdentificador(resumendiaCab.getResuTipo() + "-" + format.format(fechaComunicacion).replaceAll("-", "") + "-" + correlativoStr);
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

    public List<TipoDocumento> getTipoDocumentos() {
        return tipoDocumentoRepositorio.listarTipoDocumentos();
    }

}
