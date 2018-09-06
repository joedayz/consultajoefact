package pe.joedayz.cofaco.repositorio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.apache.commons.lang3.StringUtils;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pe.joedayz.cofaco.enums.TipoDocumentoEnum;
import pe.joedayz.cofaco.modelo.Cabecera;
import pe.joedayz.cofaco.repositorio.filtros.CabeceraFiltros;
import pe.joedayz.cofaco.repositorio.filtros.NotaCreditoFiltros;
import pe.joedayz.cofaco.security.Seguridad;

public class CabeceraRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    @Inject
    private Seguridad seguridad;

    public Cabecera buscarCabeceraPorDocuCodigo(Long docuCodigo) {
        return this.entityManager.find(Cabecera.class, docuCodigo);
    }

    @SuppressWarnings("unchecked")
    public List<Cabecera> listarCabecerasFiltradas(CabeceraFiltros filtros) {

        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cabecera.class);

        //==filtro de la empresa que se logueo 
        criteria.add(Restrictions.eq("emprNroruc", seguridad.getInternoEmpresa().getEpmrRuc()));
        System.out.println("empresa " + seguridad.getInternoEmpresa().getEpmrRuc());

        if (StringUtils.isNotBlank(filtros.getNumeroDocumento())) {
            criteria.add(Restrictions.ilike("docuNumero", filtros.getNumeroDocumento(), MatchMode.ANYWHERE));
            System.out.println("docuNumero " + filtros.getNumeroDocumento());
        }
        if (filtros.getTipoDocumento() != null) {
            if (filtros.getTipoDocumento().getIdTipoDocu() != null) {
                if (!filtros.getTipoDocumento().getIdTipoDocu().equals("00")) {
                    criteria.add(Restrictions.eq("docuTipodocumento", filtros.getTipoDocumento().getDocuTipoDocumento()));
                    System.out.println("docuTipodocumento " + filtros.getTipoDocumento().getDocuTipoDocumento());
                }
            }
        }
        if (StringUtils.isNotBlank(filtros.getClieRazonSocial())) {
            criteria.add(Restrictions.ilike("clieNombre", filtros.getClieRazonSocial(), MatchMode.ANYWHERE));
            System.out.println("clieNombre " + filtros.getClieRazonSocial());
        }

        if (StringUtils.isNotBlank(filtros.getClieRuc())) {
            criteria.add(Restrictions.eq("clieNumero", filtros.getClieRuc()));
            System.out.println("clieNumero " + filtros.getClieRuc());
        }

        if (filtros.getFechaInicio() != null && filtros.getFechaFin() != null) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String inicioDateStr = formatter.format(filtros.getFechaInicio());
            String finDateStr = formatter.format(filtros.getFechaFin());

            criteria.add(Restrictions.between("docuFecha", inicioDateStr, finDateStr));
            System.out.println("docuFecha " + inicioDateStr + "  --  " + finDateStr);
        }


        if(filtros.getCdr()!=null){
            String cdr = filtros.getCdr();
            if("0".equals(cdr)){
                criteria.add(Restrictions.eq("cdr", "0"));
            }
            if("1".equals(cdr)){
                criteria.add(Restrictions.neOrIsNotNull("cdr", "0"));
            }
            if("-1".equals(cdr)){

            }
        }

        if(filtros.getDocuProceStatus()!=null){
            String docuProceStatus = filtros.getDocuProceStatus();
            if (StringUtils.isNotBlank(filtros.getDocuProceStatus())) {
                criteria.add(Restrictions.eq("docuProceStatus", filtros.getDocuProceStatus()));
            }
        }



        return criteria.addOrder(Order.asc("docuNumero")).list();

    }

    public List<Cabecera> listarNotasCreditoFiltradas(NotaCreditoFiltros filtros) {


        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cabecera.class);


        criteria.add(Restrictions.eq("emprNroruc", seguridad.getInternoEmpresa().getEpmrRuc()));

        criteria.add(Restrictions.eq("docuTipodocumento", TipoDocumentoEnum.NOTA_CREDITO.getValue()));


        if (StringUtils.isNotBlank(filtros.getClieRazonSocial())) {
            criteria.add(Restrictions.ilike("clieNombre", filtros.getClieRazonSocial(), MatchMode.ANYWHERE));
            System.out.println("clieNombre " + filtros.getClieRazonSocial());
        }

        if (StringUtils.isNotBlank(filtros.getClieRuc())) {
            criteria.add(Restrictions.eq("clieNumero", filtros.getClieRuc()));
            System.out.println("clieNumero " + filtros.getClieRuc());
        }




        return criteria.addOrder(Order.asc("docuNumero")).list();

    }

    public Cabecera registrarNotaCredito(Cabecera notaCredito) {
        return entityManager.merge(notaCredito);
    }
    
    public Cabecera registrarBoleta(Cabecera boleta) {
        return entityManager.merge(boleta);
    }
}
