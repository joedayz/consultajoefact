package pe.joedayz.cofaco.modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cabecera")
public class Cabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "docu_codigo")
    private Integer docuCodigo;
    @Size(max = 200)
    @Column(name = "empr_razonsocial")
    private String emprRazonsocial;
    @Size(max = 6)
    @Column(name = "empr_ubigeo")
    private String emprUbigeo;
    @Size(max = 200)
    @Column(name = "empr_nombrecomercial")
    private String emprNombrecomercial;
    @Size(max = 200)
    @Column(name = "empr_direccion")
    private String emprDireccion;
    @Size(max = 200)
    @Column(name = "empr_provincia")
    private String emprProvincia;
    @Size(max = 200)
    @Column(name = "empr_departamento")
    private String emprDepartamento;
    @Size(max = 200)
    @Column(name = "empr_distrito")
    private String emprDistrito;
    @Size(max = 200)
    @Column(name = "empr_pais")
    private String emprPais;
    @Size(max = 11)
    @Column(name = "empr_nroruc")
    private String emprNroruc;
    @Size(max = 45)
    @Column(name = "empr_tipodoc")
    private String emprTipodoc;
    @Size(max = 45)
    @Column(name = "clie_numero")
    private String clieNumero;
    @Size(max = 45)
    @Column(name = "clie_tipodoc")
    private String clieTipodoc;
    @Size(max = 200)
    @Column(name = "clie_nombre")
    private String clieNombre;
    @Size(max = 45)
    @Column(name = "docu_fecha")
    private String docuFecha;
    @Size(max = 45)
    @Column(name = "docu_tipodocumento")
    private String docuTipodocumento;
    @Size(max = 45)
    @Column(name = "docu_numero")
    private String docuNumero;
    @Size(max = 45)
    @Column(name = "docu_moneda")
    private String docuMoneda;
    @Size(max = 45)
    @Column(name = "docu_gravada")
    private String docuGravada;
    @Size(max = 45)
    @Column(name = "docu_inafecta")
    private String docuInafecta;
    @Size(max = 45)
    @Column(name = "docu_exonerada")
    private String docuExonerada;
    @Size(max = 45)
    @Column(name = "docu_gratuita")
    private String docuGratuita;
    @Size(max = 45)
    @Column(name = "docu_descuento")
    private String docuDescuento;
    @Size(max = 45)
    @Column(name = "docu_subtotal")
    private String docuSubtotal;
    @Size(max = 45)
    @Column(name = "docu_total")
    private String docuTotal;
    @Size(max = 45)
    @Column(name = "docu_igv")
    private String docuIgv;
    @Size(max = 45)
    @Column(name = "tasa_igv")
    private String tasaIgv;
    @Size(max = 45)
    @Column(name = "docu_isc")
    private String docuIsc;
    @Size(max = 45)
    @Column(name = "tasa_isc")
    private String tasaIsc;
    @Size(max = 45)
    @Column(name = "docu_otrostributos")
    private String docuOtrostributos;
    @Size(max = 45)
    @Column(name = "tasa_otrostributos")
    private String tasaOtrostributos;
    @Size(max = 45)
    @Column(name = "rete_regi")
    private String reteRegi;
    @Size(max = 45)
    @Column(name = "rete_tasa")
    private String reteTasa;
    @Size(max = 45)
    @Column(name = "rete_total_elec")
    private String reteTotalElec;
    @Size(max = 45)
    @Column(name = "rete_total_rete")
    private String reteTotalRete;
    @Size(max = 45)
    @Column(name = "docu_otroscargos")
    private String docuOtroscargos;
    @Size(max = 45)
    @Column(name = "docu_percepcion")
    private String docuPercepcion;
    @Size(max = 45)
    @Column(name = "nota_motivo")
    private String notaMotivo;
    @Size(max = 45)
    @Column(name = "nota_sustento")
    private String notaSustento;
    @Size(max = 45)
    @Column(name = "nota_tipodoc")
    private String notaTipodoc;
    @Size(max = 45)
    @Column(name = "nota_documento")
    private String notaDocumento;
    @Size(max = 100)
    @Column(name = "hashcode")
    private String hashcode;
//    @Lob
//    @Column(name = "barcode")
//    private byte[] barcode;
    @Size(max = 200)
    @Column(name = "cdr")
    private String cdr;
    @Size(max = 5000)
    @Column(name = "cdr_nota")
    private String cdrNota;
    @Size(max = 2000)
    @Column(name = "cdr_observacion")
    private String cdrObservacion;
    @Size(max = 45)
    @Column(name = "docu_enviaws")
    private String docuEnviaws;
    @Size(max = 45)
    @Column(name = "docu_proce_status")
    private String docuProceStatus;
    @Column(name = "docu_proce_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docuProceFecha;
    
    @Size(max = 200)
    @Column(name = "docu_link_pdf")
    private String docuLinkPdf;
    
    @Size(max = 200)
    @Column(name = "docu_link_cdr")
    private String docuLinkCdr;

    @Size(max = 200)
    @Column(name = "docu_link_xml")
    private String docuLinkXml;

    @Column(name = "resu_identificador", length = 45)
    private String resuIdentificador;

    @Column(name = "item_estado_baja", length = 1)
    private String itemEstadoBaja;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docuCodigo")
    private Set<Detalle> detalleSet;

    public Cabecera() {
    }

    public Cabecera(Integer docuCodigo) {
        this.docuCodigo = docuCodigo;
    }

    public Integer getDocuCodigo() {
        return docuCodigo;
    }

    public void setDocuCodigo(Integer docuCodigo) {
        this.docuCodigo = docuCodigo;
    }

    public String getEmprRazonsocial() {
        return emprRazonsocial;
    }

    public void setEmprRazonsocial(String emprRazonsocial) {
        this.emprRazonsocial = emprRazonsocial;
    }

    public String getEmprUbigeo() {
        return emprUbigeo;
    }

    public void setEmprUbigeo(String emprUbigeo) {
        this.emprUbigeo = emprUbigeo;
    }

    public String getEmprNombrecomercial() {
        return emprNombrecomercial;
    }

    public void setEmprNombrecomercial(String emprNombrecomercial) {
        this.emprNombrecomercial = emprNombrecomercial;
    }

    public String getEmprDireccion() {
        return emprDireccion;
    }

    public void setEmprDireccion(String emprDireccion) {
        this.emprDireccion = emprDireccion;
    }

    public String getEmprProvincia() {
        return emprProvincia;
    }

    public void setEmprProvincia(String emprProvincia) {
        this.emprProvincia = emprProvincia;
    }

    public String getEmprDepartamento() {
        return emprDepartamento;
    }

    public void setEmprDepartamento(String emprDepartamento) {
        this.emprDepartamento = emprDepartamento;
    }

    public String getEmprDistrito() {
        return emprDistrito;
    }

    public void setEmprDistrito(String emprDistrito) {
        this.emprDistrito = emprDistrito;
    }

    public String getEmprPais() {
        return emprPais;
    }

    public void setEmprPais(String emprPais) {
        this.emprPais = emprPais;
    }

    public String getEmprNroruc() {
        return emprNroruc;
    }

    public void setEmprNroruc(String emprNroruc) {
        this.emprNroruc = emprNroruc;
    }

    public String getEmprTipodoc() {
        return emprTipodoc;
    }

    public void setEmprTipodoc(String emprTipodoc) {
        this.emprTipodoc = emprTipodoc;
    }

    public String getClieNumero() {
        return clieNumero;
    }

    public void setClieNumero(String clieNumero) {
        this.clieNumero = clieNumero;
    }

    public String getClieTipodoc() {
        return clieTipodoc;
    }

    public void setClieTipodoc(String clieTipodoc) {
        this.clieTipodoc = clieTipodoc;
    }

    public String getClieNombre() {
        return clieNombre;
    }

    public void setClieNombre(String clieNombre) {
        this.clieNombre = clieNombre;
    }

    public String getDocuFecha() {
        return docuFecha;
    }

    public void setDocuFecha(String docuFecha) {
        this.docuFecha = docuFecha;
    }

    public String getDocuTipodocumento() {
        return docuTipodocumento;
    }

    public void setDocuTipodocumento(String docuTipodocumento) {
        this.docuTipodocumento = docuTipodocumento;
    }

    public String getDocuNumero() {
        return docuNumero;
    }

    public void setDocuNumero(String docuNumero) {
        this.docuNumero = docuNumero;
    }

    public String getDocuMoneda() {
        return docuMoneda;
    }

    public void setDocuMoneda(String docuMoneda) {
        this.docuMoneda = docuMoneda;
    }

    public String getDocuGravada() {
        return docuGravada;
    }

    public void setDocuGravada(String docuGravada) {
        this.docuGravada = docuGravada;
    }

    public String getDocuInafecta() {
        return docuInafecta;
    }

    public void setDocuInafecta(String docuInafecta) {
        this.docuInafecta = docuInafecta;
    }

    public String getDocuExonerada() {
        return docuExonerada;
    }

    public void setDocuExonerada(String docuExonerada) {
        this.docuExonerada = docuExonerada;
    }

    public String getDocuGratuita() {
        return docuGratuita;
    }

    public void setDocuGratuita(String docuGratuita) {
        this.docuGratuita = docuGratuita;
    }

    public String getDocuDescuento() {
        return docuDescuento;
    }

    public void setDocuDescuento(String docuDescuento) {
        this.docuDescuento = docuDescuento;
    }

    public String getDocuSubtotal() {
        return docuSubtotal;
    }

    public void setDocuSubtotal(String docuSubtotal) {
        this.docuSubtotal = docuSubtotal;
    }

    public String getDocuTotal() {
        return docuTotal;
    }

    public void setDocuTotal(String docuTotal) {
        this.docuTotal = docuTotal;
    }

    public String getDocuIgv() {
        return docuIgv;
    }

    public void setDocuIgv(String docuIgv) {
        this.docuIgv = docuIgv;
    }

    public String getTasaIgv() {
        return tasaIgv;
    }

    public void setTasaIgv(String tasaIgv) {
        this.tasaIgv = tasaIgv;
    }

    public String getDocuIsc() {
        return docuIsc;
    }

    public void setDocuIsc(String docuIsc) {
        this.docuIsc = docuIsc;
    }

    public String getTasaIsc() {
        return tasaIsc;
    }

    public void setTasaIsc(String tasaIsc) {
        this.tasaIsc = tasaIsc;
    }

    public String getDocuOtrostributos() {
        return docuOtrostributos;
    }

    public void setDocuOtrostributos(String docuOtrostributos) {
        this.docuOtrostributos = docuOtrostributos;
    }

    public String getTasaOtrostributos() {
        return tasaOtrostributos;
    }

    public void setTasaOtrostributos(String tasaOtrostributos) {
        this.tasaOtrostributos = tasaOtrostributos;
    }

    public String getReteRegi() {
        return reteRegi;
    }

    public void setReteRegi(String reteRegi) {
        this.reteRegi = reteRegi;
    }

    public String getReteTasa() {
        return reteTasa;
    }

    public void setReteTasa(String reteTasa) {
        this.reteTasa = reteTasa;
    }

    public String getReteTotalElec() {
        return reteTotalElec;
    }

    public void setReteTotalElec(String reteTotalElec) {
        this.reteTotalElec = reteTotalElec;
    }

    public String getReteTotalRete() {
        return reteTotalRete;
    }

    public void setReteTotalRete(String reteTotalRete) {
        this.reteTotalRete = reteTotalRete;
    }

    public String getDocuOtroscargos() {
        return docuOtroscargos;
    }

    public void setDocuOtroscargos(String docuOtroscargos) {
        this.docuOtroscargos = docuOtroscargos;
    }

    public String getDocuPercepcion() {
        return docuPercepcion;
    }

    public void setDocuPercepcion(String docuPercepcion) {
        this.docuPercepcion = docuPercepcion;
    }

    public String getNotaMotivo() {
        return notaMotivo;
    }

    public void setNotaMotivo(String notaMotivo) {
        this.notaMotivo = notaMotivo;
    }

    public String getNotaSustento() {
        return notaSustento;
    }

    public void setNotaSustento(String notaSustento) {
        this.notaSustento = notaSustento;
    }

    public String getNotaTipodoc() {
        return notaTipodoc;
    }

    public void setNotaTipodoc(String notaTipodoc) {
        this.notaTipodoc = notaTipodoc;
    }

    public String getNotaDocumento() {
        return notaDocumento;
    }

    public void setNotaDocumento(String notaDocumento) {
        this.notaDocumento = notaDocumento;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

//    public byte[] getBarcode() {
//        return barcode;
//    }
//
//    public void setBarcode(byte[] barcode) {
//        this.barcode = barcode;
//    }

    public String getCdr() {
        return cdr;
    }

    public void setCdr(String cdr) {
        this.cdr = cdr;
    }

    public String getCdrNota() {
        return cdrNota;
    }

    public void setCdrNota(String cdrNota) {
        this.cdrNota = cdrNota;
    }

    public String getCdrObservacion() {
        return cdrObservacion;
    }

    public void setCdrObservacion(String cdrObservacion) {
        this.cdrObservacion = cdrObservacion;
    }

    public String getDocuEnviaws() {
        return docuEnviaws;
    }

    public void setDocuEnviaws(String docuEnviaws) {
        this.docuEnviaws = docuEnviaws;
    }

    public String getDocuProceStatus() {
        return docuProceStatus;
    }

    public void setDocuProceStatus(String docuProceStatus) {
        this.docuProceStatus = docuProceStatus;
    }

    public Date getDocuProceFecha() {
        return docuProceFecha;
    }

    public void setDocuProceFecha(Date docuProceFecha) {
        this.docuProceFecha = docuProceFecha;
    }

    public String getDocuLinkPdf() {
        return docuLinkPdf;
    }

    public void setDocuLinkPdf(String docuLinkPdf) {
        this.docuLinkPdf = docuLinkPdf;
    }

    public String getDocuLinkCdr() {
        return docuLinkCdr;
    }

    public void setDocuLinkCdr(String docuLinkCdr) {
        this.docuLinkCdr = docuLinkCdr;
    }

    public String getDocuLinkXml() {
        return docuLinkXml;
    }

    public void setDocuLinkXml(String docuLinkXml) {
        this.docuLinkXml = docuLinkXml;
    }

    public Set<Detalle> getDetalleSet() {
        return detalleSet;
    }

    public void setDetalleSet(Set<Detalle> detalleSet) {
        this.detalleSet = detalleSet;
    }

    public String getResuIdentificador() {
        return resuIdentificador;
    }

    public void setResuIdentificador(String resuIdentificador) {
        this.resuIdentificador = resuIdentificador;
    }

    public String getItemEstadoBaja() {
        return itemEstadoBaja;
    }

    public void setItemEstadoBaja(String itemEstadoBaja) {
        this.itemEstadoBaja = itemEstadoBaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docuCodigo != null ? docuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabecera)) {
            return false;
        }
        Cabecera other = (Cabecera) object;
        if ((this.docuCodigo == null && other.docuCodigo != null) || (this.docuCodigo != null && !this.docuCodigo.equals(other.docuCodigo))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Cabecera [docuCodigo=" + docuCodigo + ", emprRazonsocial=" + emprRazonsocial + ", emprUbigeo="
				+ emprUbigeo + ", emprNombrecomercial=" + emprNombrecomercial + ", emprDireccion=" + emprDireccion
				+ ", emprProvincia=" + emprProvincia + ", emprDepartamento=" + emprDepartamento + ", emprDistrito="
				+ emprDistrito + ", emprPais=" + emprPais + ", emprNroruc=" + emprNroruc + ", emprTipodoc="
				+ emprTipodoc + ", clieNumero=" + clieNumero + ", clieTipodoc=" + clieTipodoc + ", clieNombre="
				+ clieNombre + ", docuFecha=" + docuFecha + ", docuTipodocumento=" + docuTipodocumento + ", docuNumero="
				+ docuNumero + ", docuMoneda=" + docuMoneda + ", docuGravada=" + docuGravada + ", docuInafecta="
				+ docuInafecta + ", docuExonerada=" + docuExonerada + ", docuGratuita=" + docuGratuita
				+ ", docuDescuento=" + docuDescuento + ", docuSubtotal=" + docuSubtotal + ", docuTotal=" + docuTotal
				+ ", docuIgv=" + docuIgv + ", tasaIgv=" + tasaIgv + ", docuIsc=" + docuIsc + ", tasaIsc=" + tasaIsc
				+ ", docuOtrostributos=" + docuOtrostributos + ", tasaOtrostributos=" + tasaOtrostributos
				+ ", reteRegi=" + reteRegi + ", reteTasa=" + reteTasa + ", reteTotalElec=" + reteTotalElec
				+ ", reteTotalRete=" + reteTotalRete + ", docuOtroscargos=" + docuOtroscargos + ", docuPercepcion="
				+ docuPercepcion + ", notaMotivo=" + notaMotivo + ", notaSustento=" + notaSustento + ", notaTipodoc="
				+ notaTipodoc + ", notaDocumento=" + notaDocumento + ", hashcode=" + hashcode + ", barcode="
				//+ Arrays.toString(barcode) 
                        + ", cdr=" + cdr + ", cdrNota=" + cdrNota + ", docuEnviaws=" + docuEnviaws
				+ ", docuProceStatus=" + docuProceStatus + "]";
	}


    
}
