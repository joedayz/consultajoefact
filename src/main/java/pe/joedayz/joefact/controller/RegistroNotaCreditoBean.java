package pe.joedayz.joefact.controller;

import pe.joedayz.joefact.jsf.FacesUtil;
import pe.joedayz.joefact.modelo.Cabecera;
import pe.joedayz.joefact.modelo.Detalle;
import pe.joedayz.joefact.modelo.Ubigeo;
import pe.joedayz.joefact.repositorio.UbigeoRepositorio;
import pe.joedayz.joefact.service.CabeceraService;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


@Named
@ViewScoped
public class RegistroNotaCreditoBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private CabeceraService cabeceraService;

    @Inject
    private UbigeoRepositorio ubigeoRepositorio;

    private Cabecera notaCredito;

    private Detalle detalle;

    private Set<Detalle> detalles;

    private List<Ubigeo> ubigeos = new ArrayList<>();


    public void inicializar() {

        if (this.notaCredito == null) {
            this.notaCredito = new Cabecera();
            this.detalle = new Detalle();

            detalles = new TreeSet<Detalle>();
            notaCredito.setDetalleSet(detalles);
        }
    }



    public void registrarNotaCredito() {
        this.notaCredito = cabeceraService.registrarNotaCredito(this.notaCredito);
        FacesUtil.adicionarMensajeInfo("La Nota de Crédito se registro correctamente");
    }


    public boolean isEditando() {
        return this.notaCredito.getDocuCodigo() != null;
    }




    public void agregarDetalle() {

        this.notaCredito.getDetalleSet().add(this.detalle);

        this.detalle = new Detalle();


    }

    public void eliminarDetalle(Detalle detalle) {

        this.notaCredito.getDetalleSet().remove(detalle);

    }



    //getters y setters


    public Cabecera getNotaCredito() {
        return notaCredito;
    }

    public void setNotaCredito(Cabecera notaCredito) {
        this.notaCredito = notaCredito;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Set<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<Detalle> detalles) {
        this.detalles = detalles;
    }

    public List<Ubigeo> getUbigeos() {

        return ubigeoRepositorio.listarUbigeo();
    }

    public void setUbigeos(List<Ubigeo> ubigeos) {
        this.ubigeos = ubigeos;
    }
}

