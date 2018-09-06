package pe.joedayz.joefact.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import pe.joedayz.joefact.jsf.FacesUtil;
import pe.joedayz.joefact.modelo.Cabecera;
import pe.joedayz.joefact.modelo.EstadoCabecera;
import pe.joedayz.joefact.modelo.Seguimiento;
import pe.joedayz.joefact.modelo.TipoDocumento;
import pe.joedayz.joefact.repositorio.SeguimientoRepositorio;
import pe.joedayz.joefact.repositorio.TipoDocumentoRepositorio;
import pe.joedayz.joefact.repositorio.filtros.CabeceraFiltros;
import pe.joedayz.joefact.service.CabeceraService;

@Named
@ViewScoped
public class VentaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CabeceraService cabeceraService;

    private List<Cabecera> ventasFiltradas;
    private List<Seguimiento> listaSeguimientos;
    private CabeceraFiltros filtros;

    private Cabecera cabeceraSeleccionada;

    private StreamedContent filePdf;
    private StreamedContent fileCdr;
    private StreamedContent fileXml;
    private StreamedContent fileZip;

    @Inject
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;

    @Inject
    private SeguimientoRepositorio seguimientoRepositorio;

    @PostConstruct
    public void init() {
        filtros = new CabeceraFiltros();
        //buscarCabeceraFiltros();
    }

    public void buscarCabeceraFiltros() {
        if (sonFiltrosValidos()) {
            ventasFiltradas = cabeceraService.listarCabecerasFiltradas(filtros);
        }

    }

    private boolean sonFiltrosValidos() {

        if ((filtros.getNumeroDocumento() == null || filtros.getNumeroDocumento().trim().equals(""))
                && (filtros.getClieRazonSocial() == null || filtros.getClieRazonSocial().trim().equals(""))
                && (filtros.getClieRuc() == null || filtros.getClieRuc().trim().equals(""))
                && (filtros.getFechaInicio() == null)
                && (filtros.getFechaFin() == null)
                && (filtros.getTipoDocumento() == null)) {
            FacesUtil.adicionarMensajeError("Es necesario ingresar un filtro para hacer la consulta.");
            return false;
        }

        if (filtros.getFechaInicio() == null && filtros.getFechaFin() != null) {
            FacesUtil.adicionarMensajeError("Es necesario ingresar la fecha de inicio.");
            return false;
        }
        if (filtros.getFechaInicio() != null && filtros.getFechaFin() == null) {
            FacesUtil.adicionarMensajeError("Es necesario ingresar la fecha final.");
            return false;
        }
        return true;
    }

    public CabeceraService getCabeceraService() {
        return cabeceraService;
    }

    public void setCabeceraService(CabeceraService cabeceraService) {
        this.cabeceraService = cabeceraService;
    }

    public List<Cabecera> getVentasFiltradas() {
        return ventasFiltradas;
    }

    public void setVentasFiltradas(List<Cabecera> ventasFiltradas) {
        this.ventasFiltradas = ventasFiltradas;
    }

    public CabeceraFiltros getFiltros() {
        return filtros;
    }

    public void setFiltros(CabeceraFiltros filtros) {
        this.filtros = filtros;
    }

    public Cabecera getCabeceraSeleccionada() {
        return cabeceraSeleccionada;
    }

    public void setCabeceraSeleccionada(Cabecera cabeceraSeleccionada) {
        this.cabeceraSeleccionada = cabeceraSeleccionada;
    }

    public StreamedContent getFilePdf() {
        System.out.println("existe dato " + cabeceraSeleccionada.getDocuLinkPdf());
        File Ffichero = new File(cabeceraSeleccionada.getDocuLinkPdf());
        if (Ffichero.exists()) {

            InputStream stream = null;
            try {
                stream = new FileInputStream(cabeceraSeleccionada.getDocuLinkPdf());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            filePdf = new DefaultStreamedContent(stream, "application/pdf", cabeceraSeleccionada.getEmprNroruc() + cabeceraSeleccionada.getDocuTipodocumento() + cabeceraSeleccionada.getDocuNumero() + ".pdf");
        }
        return filePdf;
    }

    public StreamedContent getFileCdr() {
        System.out.println("existe dato " + cabeceraSeleccionada.getDocuLinkCdr());
        File Ffichero = new File(cabeceraSeleccionada.getDocuLinkCdr());
        if (Ffichero.exists()) {

            InputStream stream = null;
            try {
                stream = new FileInputStream(cabeceraSeleccionada.getDocuLinkCdr());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            fileCdr = new DefaultStreamedContent(stream, "text/plain", cabeceraSeleccionada.getClieNumero() + cabeceraSeleccionada.getDocuTipodocumento() + cabeceraSeleccionada.getDocuNumero() + "cdr.xml");
        }
        return fileCdr;
    }

    public StreamedContent getFileZip() throws FileNotFoundException, IOException {
        try {

            //System.out.println("existe dato " + cabeceraSeleccionada.getDocuLinkCdr());
            String rutaZip = "/home/certificado/logs/fecha.zip";
            FileOutputStream fileOutputStream = null;
            fileOutputStream = new FileOutputStream(rutaZip);
            byte[] buffer = new byte[1024];
            FileOutputStream fout = fileOutputStream;

            ZipOutputStream zout = new ZipOutputStream(fout);

            for (Cabecera ventasFiltrada : ventasFiltradas) {

                if (ventasFiltrada.getDocuLinkXml() != null) {
                    //System.out.println("No existe dato " + ventasFiltrada.getDocuNumero());
                    File Ffichero = new File(ventasFiltrada.getDocuLinkXml());
                    if (Ffichero.exists()) {
                        if ("0".equals(ventasFiltrada.getCdr())) {
                            FileInputStream fin = new FileInputStream(ventasFiltrada.getDocuLinkXml());

                            zout.putNextEntry(new ZipEntry(ventasFiltrada.getDocuLinkXml()));
                            int length;

                            while ((length = fin.read(buffer)) > 0) {
                                zout.write(buffer, 0, length);
                            }

                            zout.closeEntry();

                            fin.close();
                        }

                    }
                }

            }
            zout.close();

            System.out.println("El archivo comprimido ha sido creado!");

            InputStream stream = null;
            try {
                stream = new FileInputStream(rutaZip);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            fileZip = new DefaultStreamedContent(stream, "zip", "xmlfiltrado.zip");
            return fileZip;
        } catch (IOException ioe) {
            System.out.println("IOException :" + ioe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public StreamedContent getFileXml() {
        System.out.println("existe dato " + cabeceraSeleccionada.getDocuLinkXml());
        File Ffichero = new File(cabeceraSeleccionada.getDocuLinkXml());
        if (Ffichero.exists()) {

            InputStream stream = null;
            try {
                stream = new FileInputStream(cabeceraSeleccionada.getDocuLinkXml());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            fileXml = new DefaultStreamedContent(stream, "text/plain", cabeceraSeleccionada.getClieNumero() + cabeceraSeleccionada.getDocuTipodocumento() + cabeceraSeleccionada.getDocuNumero() + "xml.xml");
        }
        return fileXml;
    }

    public EstadoCabecera[] getEstadoCabecera() {
        return EstadoCabecera.values();
    }

    public List<TipoDocumento> getTipoDocumentos() {
        return tipoDocumentoRepositorio.listarTipoDocumentos();
    }

    public void getSeguimientos(Integer docu_codigo) {
        listaSeguimientos = seguimientoRepositorio.listarSeguimientos(docu_codigo);
    }
    
    public void registraBajaBoleta() {
        System.out.println("existe dato "  );

        cabeceraSeleccionada.setItemEstadoBaja("3");
        cabeceraService.registrarBajaBoleta(cabeceraSeleccionada);
        FacesUtil.adicionarMensajeInfo("Resumen Baja : " + cabeceraSeleccionada.getDocuNumero()+ " Procesando.");
    }

    public List<Seguimiento> getListaSeguimientos() {
        return listaSeguimientos;
    }

    public void setListaSeguimientos(List<Seguimiento> listaSeguimientos) {
        this.listaSeguimientos = listaSeguimientos;
    }

}
