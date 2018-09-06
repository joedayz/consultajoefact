package pe.joedayz.joefact.controller;

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

import pe.joedayz.joefact.jsf.FacesUtil;
import pe.joedayz.joefact.modelo.ResumendiaBaja;
import pe.joedayz.joefact.repositorio.ResumenBajasRepositorio;
import pe.joedayz.joefact.repositorio.filtros.ResumenBajasFiltros;
import pe.joedayz.joefact.service.RegistroResumenBajasService;

@Named
@ViewScoped
public class ResumenBajasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RegistroResumenBajasService cabeceraService;

    private List<ResumendiaBaja> ventasFiltradas;
    private ResumenBajasFiltros filtros;

    private ResumendiaBaja cabeceraSeleccionada;
    private StreamedContent fileCdr;
    @Inject
    private ResumenBajasRepositorio bajasRepositorio;

    @PostConstruct
    public void init() {
        filtros = new ResumenBajasFiltros();
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

    public RegistroResumenBajasService getCabeceraService() {
        return cabeceraService;
    }

    public void setCabeceraService(RegistroResumenBajasService cabeceraService) {
        this.cabeceraService = cabeceraService;
    }

    public List<ResumendiaBaja> getVentasFiltradas() {
        return ventasFiltradas;
    }

    public void setVentasFiltradas(List<ResumendiaBaja> ventasFiltradas) {
        this.ventasFiltradas = ventasFiltradas;
    }

    public ResumenBajasFiltros getFiltros() {
        return filtros;
    }

    public void setFiltros(ResumenBajasFiltros filtros) {
        this.filtros = filtros;
    }

    public ResumendiaBaja getCabeceraSeleccionada() {
        return cabeceraSeleccionada;
    }

    public void setCabeceraSeleccionada(ResumendiaBaja cabeceraSeleccionada) {
        this.cabeceraSeleccionada = cabeceraSeleccionada;
    }

    public void extraerResumenBaja() {

        cabeceraSeleccionada.setResuProceStatus("#");
        cabeceraService.registrarResumendiaBaja(cabeceraSeleccionada);
        FacesUtil.adicionarMensajeInfo("Resumen Baja : " + cabeceraSeleccionada.getResuIdentificador() + " Procesando.");
    }
    public void enviaResumenBoleta() {

        cabeceraSeleccionada.setResuProceStatus("N");
        cabeceraService.registrarResumendiaBaja(cabeceraSeleccionada);
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
            fileCdr = new DefaultStreamedContent(stream, "text/plain", cabeceraSeleccionada.getEmprNroruc()+ cabeceraSeleccionada.getResuIdentificador() + "cdr.xml");
        }
        return fileCdr;
    }

}
