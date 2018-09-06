package pe.joedayz.cofaco.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;

import org.primefaces.model.StreamedContent;

import pe.joedayz.cofaco.jsf.FacesUtil;
import pe.joedayz.cofaco.modelo.ResumendiaCab;
import pe.joedayz.cofaco.repositorio.TipoDocumentoRepositorio;
import pe.joedayz.cofaco.repositorio.filtros.ResumenBoletasFiltros;
import pe.joedayz.cofaco.service.RegistroResumenBoletaService;

@Named
@ViewScoped
public class ResumenBoletasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RegistroResumenBoletaService cabeceraService;

    private List<ResumendiaCab> ventasFiltradas;
    private ResumenBoletasFiltros filtros;

    private ResumendiaCab cabeceraSeleccionada;
    private StreamedContent fileCdr;
    @Inject
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;

    @PostConstruct
    public void init() {
        filtros = new ResumenBoletasFiltros();
        //buscarCabeceraFiltros();
    }

    public void buscarCabeceraFiltros() {
        if (sonFiltrosValidos()) {
            ventasFiltradas = cabeceraService.listarCabecerasFiltradas(filtros);
        }

    }

    private boolean sonFiltrosValidos() {

        if ((filtros.getIdentificadorResumen() == null)) {
            FacesUtil.adicionarMensajeError("Es necesario ingresar un filtro para hacer la consulta.");
            return false;
        }

        return true;
    }

    public RegistroResumenBoletaService getCabeceraService() {
        return cabeceraService;
    }

    public void setCabeceraService(RegistroResumenBoletaService cabeceraService) {
        this.cabeceraService = cabeceraService;
    }

    public List<ResumendiaCab> getVentasFiltradas() {
        return ventasFiltradas;
    }

    public void setVentasFiltradas(List<ResumendiaCab> ventasFiltradas) {
        this.ventasFiltradas = ventasFiltradas;
    }

    public ResumenBoletasFiltros getFiltros() {
        return filtros;
    }

    public void setFiltros(ResumenBoletasFiltros filtros) {
        this.filtros = filtros;
    }

    public ResumendiaCab getCabeceraSeleccionada() {
        return cabeceraSeleccionada;
    }

    public void setCabeceraSeleccionada(ResumendiaCab cabeceraSeleccionada) {
        this.cabeceraSeleccionada = cabeceraSeleccionada;
    }

    public TipoDocumentoRepositorio getTipoDocumentoRepositorio() {
        return tipoDocumentoRepositorio;
    }

    public void setTipoDocumentoRepositorio(TipoDocumentoRepositorio tipoDocumentoRepositorio) {
        this.tipoDocumentoRepositorio = tipoDocumentoRepositorio;
    }

    public void extraerResumenBoleta() {

        cabeceraSeleccionada.setResuProceStatus("#");
        cabeceraService.registrarResumendiaCab(cabeceraSeleccionada);
        FacesUtil.adicionarMensajeInfo("Resumen Boleta : " + cabeceraSeleccionada.getResuIdentificador() + " Procesando.");
    }

    public void enviaResumenBoleta() {

        cabeceraSeleccionada.setResuProceStatus("N");
        cabeceraService.registrarResumendiaCab(cabeceraSeleccionada);
        FacesUtil.adicionarMensajeInfo("Resumen Boleta : " + cabeceraSeleccionada.getResuIdentificador() + " Procesando.");
    }

    public StreamedContent getFileCdr() {
        System.out.println("existe dato " + cabeceraSeleccionada.getCdrLink());
        File Ffichero = new File(cabeceraSeleccionada.getCdrLink());
        if (Ffichero.exists()) {

            InputStream stream = null;
            try {
                stream = new FileInputStream(cabeceraSeleccionada.getCdrLink());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            fileCdr = new DefaultStreamedContent(stream, "text/plain", cabeceraSeleccionada.getEmprNroruc() + cabeceraSeleccionada.getResuIdentificador() + "cdr.xml");
        }
        return fileCdr;
    }

}
