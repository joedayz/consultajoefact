package pe.joedayz.joefact.controller;


import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import pe.joedayz.joefact.modelo.Cabecera;
import pe.joedayz.joefact.modelo.Seguimiento;
import pe.joedayz.joefact.repositorio.CabeceraRepositorio;
import pe.joedayz.joefact.repositorio.SeguimientoRepositorio;
import pe.joedayz.joefact.repositorio.filtros.NotaCreditoFiltros;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class NotaCreditoBean implements Serializable {

    private static final long serialVersionUID = 1L;


    private List<Cabecera> notaCreditoFiltradas;
    private NotaCreditoFiltros filtros;

    private Cabecera notaCreditoSeleccionada;


    private List<Seguimiento> listaSeguimientos;


    private StreamedContent filePdf;
    private StreamedContent fileCdr;
    private StreamedContent fileXml;

    @Inject
    private CabeceraRepositorio notaCreditoRepositorio;


    @Inject
    private SeguimientoRepositorio seguimientoRepositorio;

    @PostConstruct
    public void init() {
        filtros = new NotaCreditoFiltros();
        buscarNotaCreditoFiltros();
    }


    public void buscarNotaCreditoFiltros() {
        notaCreditoFiltradas = notaCreditoRepositorio.listarNotasCreditoFiltradas(filtros);
    }

    public void getSeguimientos(Integer docu_codigo) {
        listaSeguimientos = seguimientoRepositorio.listarSeguimientos(docu_codigo);
    }

    public StreamedContent getFilePdf() {
        System.out.println("existe dato " + notaCreditoSeleccionada.getDocuLinkPdf());
        File Ffichero = new File(notaCreditoSeleccionada.getDocuLinkPdf());
        if (Ffichero.exists()) {

            InputStream stream = null;
            try {
                stream = new FileInputStream(notaCreditoSeleccionada.getDocuLinkPdf());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            filePdf = new DefaultStreamedContent(stream, "application/pdf", notaCreditoSeleccionada.getEmprNroruc() + notaCreditoSeleccionada.getDocuTipodocumento() + notaCreditoSeleccionada.getDocuNumero() + ".pdf");
        }
        return filePdf;
    }

    public StreamedContent getFileCdr() {
        System.out.println("existe dato " + notaCreditoSeleccionada.getDocuLinkCdr());
        File Ffichero = new File(notaCreditoSeleccionada.getDocuLinkCdr());
        if (Ffichero.exists()) {

            InputStream stream = null;
            try {
                stream = new FileInputStream(notaCreditoSeleccionada.getDocuLinkCdr());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            fileCdr = new DefaultStreamedContent(stream, "text/plain", notaCreditoSeleccionada.getClieNumero() + notaCreditoSeleccionada.getDocuTipodocumento() + notaCreditoSeleccionada.getDocuNumero() + "cdr.xml");
        }
        return fileCdr;
    }

    public StreamedContent getFileXml() {
        System.out.println("existe dato " + notaCreditoSeleccionada.getDocuLinkXml());
        File Ffichero = new File(notaCreditoSeleccionada.getDocuLinkXml());
        if (Ffichero.exists()) {

            InputStream stream = null;
            try {
                stream = new FileInputStream(notaCreditoSeleccionada.getDocuLinkXml());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            fileXml = new DefaultStreamedContent(stream, "text/plain", notaCreditoSeleccionada.getClieNumero() + notaCreditoSeleccionada.getDocuTipodocumento() + notaCreditoSeleccionada.getDocuNumero() + "xml.xml");
        }
        return fileXml;
    }

    /* Getters y setters */

    public List<Cabecera> getNotaCreditoFiltradas() {
        return notaCreditoFiltradas;
    }

    public void setNotaCreditoFiltradas(List<Cabecera> notaCreditoFiltradas) {
        this.notaCreditoFiltradas = notaCreditoFiltradas;
    }

    public NotaCreditoFiltros getFiltros() {
        return filtros;
    }

    public void setFiltros(NotaCreditoFiltros filtros) {
        this.filtros = filtros;
    }

    public List<Seguimiento> getListaSeguimientos() {
        return listaSeguimientos;
    }

    public void setListaSeguimientos(List<Seguimiento> listaSeguimientos) {
        this.listaSeguimientos = listaSeguimientos;
    }
}
