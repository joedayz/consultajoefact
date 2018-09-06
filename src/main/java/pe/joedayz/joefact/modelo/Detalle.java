package pe.joedayz.joefact.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "detalle")
public class Detalle implements Serializable, Comparable<Detalle> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle")
    private Integer iddetalle;
    @Size(max = 45)
    @Column(name = "docu_moneda")
    private String docuMoneda;
    @Size(max = 45)
    @Column(name = "item_moneda")
    private String itemMoneda;
    @Size(max = 45)
    @Column(name = "item_orden")
    private String itemOrden;
    @Size(max = 45)
    @Column(name = "item_unidad")
    private String itemUnidad;
    @Size(max = 45)
    @Column(name = "item_cantidad")
    private String itemCantidad;
    @Size(max = 45)
    @Column(name = "item_codproducto")
    private String itemCodproducto;
    @Size(max = 45)
    @Column(name = "item_descripcion")
    private String itemDescripcion;
    @Size(max = 45)
    @Column(name = "item_afectacion")
    private String itemAfectacion;
    @Size(max = 45)
    @Column(name = "item_pventa")
    private String itemPventa;
    @Size(max = 45)
    @Column(name = "item_ti_subtotal")
    private String itemTiSubtotal;
    @Size(max = 45)
    @Column(name = "item_ti_igv")
    private String itemTiIgv;
    @Size(max = 45)
    @Column(name = "rete_rela_tipo_docu")
    private String reteRelaTipoDocu;
    @Size(max = 45)
    @Column(name = "rete_rela_nume_docu")
    private String reteRelaNumeDocu;
    @Size(max = 45)
    @Column(name = "rete_rela_fech_docu")
    private String reteRelaFechDocu;
    @Size(max = 45)
    @Column(name = "rete_rela_tipo_moneda")
    private String reteRelaTipoMoneda;
    @Size(max = 45)
    @Column(name = "rete_rela_total_original")
    private String reteRelaTotalOriginal;
    @Size(max = 45)
    @Column(name = "rete_rela_fecha_pago")
    private String reteRelaFechaPago;
    @Size(max = 45)
    @Column(name = "rete_rela_numero_pago")
    private String reteRelaNumeroPago;
    @Size(max = 45)
    @Column(name = "rete_rela_importe_pagado_original")
    private String reteRelaImportePagadoOriginal;
    @Size(max = 45)
    @Column(name = "rete_rela_tipo_moneda_pago")
    private String reteRelaTipoMonedaPago;
    @Size(max = 45)
    @Column(name = "rete_importe_retenido_nacional")
    private String reteImporteRetenidoNacional;
    @Size(max = 45)
    @Column(name = "rete_importe_neto_nacional")
    private String reteImporteNetoNacional;
    @Size(max = 45)
    @Column(name = "rete_tipo_moneda_referencia")
    private String reteTipoMonedaReferencia;
    @JoinColumn(name = "docu_codigo", referencedColumnName = "docu_codigo")
    @ManyToOne(optional = false)
    private Cabecera docuCodigo;

    public Detalle() {
    }

    public Detalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Integer getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public String getDocuMoneda() {
        return docuMoneda;
    }

    public void setDocuMoneda(String docuMoneda) {
        this.docuMoneda = docuMoneda;
    }

    public String getItemMoneda() {
        return itemMoneda;
    }

    public void setItemMoneda(String itemMoneda) {
        this.itemMoneda = itemMoneda;
    }

    public String getItemOrden() {
        return itemOrden;
    }

    public void setItemOrden(String itemOrden) {
        this.itemOrden = itemOrden;
    }

    public String getItemUnidad() {
        return itemUnidad;
    }

    public void setItemUnidad(String itemUnidad) {
        this.itemUnidad = itemUnidad;
    }

    public String getItemCantidad() {
        return itemCantidad;
    }

    public void setItemCantidad(String itemCantidad) {
        this.itemCantidad = itemCantidad;
    }

    public String getItemCodproducto() {
        return itemCodproducto;
    }

    public void setItemCodproducto(String itemCodproducto) {
        this.itemCodproducto = itemCodproducto;
    }

    public String getItemDescripcion() {
        return itemDescripcion;
    }

    public void setItemDescripcion(String itemDescripcion) {
        this.itemDescripcion = itemDescripcion;
    }

    public String getItemAfectacion() {
        return itemAfectacion;
    }

    public void setItemAfectacion(String itemAfectacion) {
        this.itemAfectacion = itemAfectacion;
    }

    public String getItemPventa() {
        return itemPventa;
    }

    public void setItemPventa(String itemPventa) {
        this.itemPventa = itemPventa;
    }

    public String getItemTiSubtotal() {
        return itemTiSubtotal;
    }

    public void setItemTiSubtotal(String itemTiSubtotal) {
        this.itemTiSubtotal = itemTiSubtotal;
    }

    public String getItemTiIgv() {
        return itemTiIgv;
    }

    public void setItemTiIgv(String itemTiIgv) {
        this.itemTiIgv = itemTiIgv;
    }

    public String getReteRelaTipoDocu() {
        return reteRelaTipoDocu;
    }

    public void setReteRelaTipoDocu(String reteRelaTipoDocu) {
        this.reteRelaTipoDocu = reteRelaTipoDocu;
    }

    public String getReteRelaNumeDocu() {
        return reteRelaNumeDocu;
    }

    public void setReteRelaNumeDocu(String reteRelaNumeDocu) {
        this.reteRelaNumeDocu = reteRelaNumeDocu;
    }

    public String getReteRelaFechDocu() {
        return reteRelaFechDocu;
    }

    public void setReteRelaFechDocu(String reteRelaFechDocu) {
        this.reteRelaFechDocu = reteRelaFechDocu;
    }

    public String getReteRelaTipoMoneda() {
        return reteRelaTipoMoneda;
    }

    public void setReteRelaTipoMoneda(String reteRelaTipoMoneda) {
        this.reteRelaTipoMoneda = reteRelaTipoMoneda;
    }

    public String getReteRelaTotalOriginal() {
        return reteRelaTotalOriginal;
    }

    public void setReteRelaTotalOriginal(String reteRelaTotalOriginal) {
        this.reteRelaTotalOriginal = reteRelaTotalOriginal;
    }

    public String getReteRelaFechaPago() {
        return reteRelaFechaPago;
    }

    public void setReteRelaFechaPago(String reteRelaFechaPago) {
        this.reteRelaFechaPago = reteRelaFechaPago;
    }

    public String getReteRelaNumeroPago() {
        return reteRelaNumeroPago;
    }

    public void setReteRelaNumeroPago(String reteRelaNumeroPago) {
        this.reteRelaNumeroPago = reteRelaNumeroPago;
    }

    public String getReteRelaImportePagadoOriginal() {
        return reteRelaImportePagadoOriginal;
    }

    public void setReteRelaImportePagadoOriginal(String reteRelaImportePagadoOriginal) {
        this.reteRelaImportePagadoOriginal = reteRelaImportePagadoOriginal;
    }

    public String getReteRelaTipoMonedaPago() {
        return reteRelaTipoMonedaPago;
    }

    public void setReteRelaTipoMonedaPago(String reteRelaTipoMonedaPago) {
        this.reteRelaTipoMonedaPago = reteRelaTipoMonedaPago;
    }

    public String getReteImporteRetenidoNacional() {
        return reteImporteRetenidoNacional;
    }

    public void setReteImporteRetenidoNacional(String reteImporteRetenidoNacional) {
        this.reteImporteRetenidoNacional = reteImporteRetenidoNacional;
    }

    public String getReteImporteNetoNacional() {
        return reteImporteNetoNacional;
    }

    public void setReteImporteNetoNacional(String reteImporteNetoNacional) {
        this.reteImporteNetoNacional = reteImporteNetoNacional;
    }

    public String getReteTipoMonedaReferencia() {
        return reteTipoMonedaReferencia;
    }

    public void setReteTipoMonedaReferencia(String reteTipoMonedaReferencia) {
        this.reteTipoMonedaReferencia = reteTipoMonedaReferencia;
    }

    public Cabecera getDocuCodigo() {
        return docuCodigo;
    }

    public void setDocuCodigo(Cabecera docuCodigo) {
        this.docuCodigo = docuCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalle != null ? iddetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.iddetalle == null && other.iddetalle != null) || (this.iddetalle != null && !this.iddetalle.equals(other.iddetalle))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Detalle [iddetalle=" + iddetalle + ", docuMoneda=" + docuMoneda + ", itemMoneda=" + itemMoneda
				+ ", itemOrden=" + itemOrden + ", itemUnidad=" + itemUnidad + ", itemCantidad=" + itemCantidad
				+ ", itemCodproducto=" + itemCodproducto + ", itemDescripcion=" + itemDescripcion + ", itemAfectacion="
				+ itemAfectacion + ", itemPventa=" + itemPventa + ", itemTiSubtotal=" + itemTiSubtotal + ", itemTiIgv="
				+ itemTiIgv + ", reteRelaTipoDocu=" + reteRelaTipoDocu + ", reteRelaNumeDocu=" + reteRelaNumeDocu
				+ ", reteRelaFechDocu=" + reteRelaFechDocu + ", reteRelaTipoMoneda=" + reteRelaTipoMoneda
				+ ", reteRelaTotalOriginal=" + reteRelaTotalOriginal + ", reteRelaFechaPago=" + reteRelaFechaPago
				+ ", reteRelaNumeroPago=" + reteRelaNumeroPago + ", reteRelaImportePagadoOriginal="
				+ reteRelaImportePagadoOriginal + ", reteRelaTipoMonedaPago=" + reteRelaTipoMonedaPago
				+ ", reteImporteRetenidoNacional=" + reteImporteRetenidoNacional + ", reteImporteNetoNacional="
				+ reteImporteNetoNacional + ", reteTipoMonedaReferencia=" + reteTipoMonedaReferencia + ", docuCodigo="
				+ docuCodigo + "]";
	}


    @Override
    public int compareTo(Detalle det) {
        if(this.iddetalle == det.iddetalle)
            return 0;
        else
            return this.iddetalle>det.iddetalle ?1 : -1;

    }
}
