package pe.joedayz.joefact.repositorio;

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

import pe.joedayz.joefact.modelo.ResumendiaCab;
import pe.joedayz.joefact.repositorio.filtros.ResumenBoletasFiltros;
import pe.joedayz.joefact.security.Seguridad;

public class ResumenBoletasRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    @Inject
    private Seguridad seguridad;

    public ResumendiaCab buscarCabeceraPorDocuCodigo(Integer docuCodigo) {
        return this.entityManager.find(ResumendiaCab.class, docuCodigo);
    }

    @SuppressWarnings("unchecked")
    public List<ResumendiaCab> listarCabecerasFiltradas(ResumenBoletasFiltros filtros) {

        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(ResumendiaCab.class);

        //==filtro de la empresa que se logueo 
        criteria.add(Restrictions.eq("emprNroruc", seguridad.getInternoEmpresa().getEpmrRuc()));
        System.out.println("empresa " + seguridad.getInternoEmpresa().getEpmrRuc());

        if (StringUtils.isNotBlank(filtros.getIdentificadorResumen())) {
            criteria.add(Restrictions.ilike("resuIdentificador", filtros.getIdentificadorResumen(), MatchMode.ANYWHERE));
            System.out.println("resuIdentificador " + filtros.getIdentificadorResumen());
        }
        if (StringUtils.isNotBlank(filtros.getTipoResumen())) {
            criteria.add(Restrictions.eq("resuTipo", filtros.getTipoResumen()));
            System.out.println("resuTipo " + filtros.getTipoResumen());
        }
        if (StringUtils.isNotBlank(filtros.getNroTicket())) {
            criteria.add(Restrictions.ilike("nroticket", filtros.getNroTicket(), MatchMode.ANYWHERE));
            System.out.println("nroticket " + filtros.getNroTicket());
        }

        if (filtros.getFechaDocumento()!= null) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String fechaDocuDateStr = formatter.format(filtros.getFechaDocumento());

            criteria.add(Restrictions.eq("resuFechaDoc", fechaDocuDateStr));
            System.out.println("resuFechaDoc " + fechaDocuDateStr);
        }
        if (filtros.getFechaComunicacion()!= null) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String fechaDocuDateStr = formatter.format(filtros.getFechaComunicacion());

            criteria.add(Restrictions.eq("resuFechaCom", fechaDocuDateStr));
            System.out.println("resuFechaCom " + fechaDocuDateStr);
        }
        return criteria.addOrder(Order.desc("resuFechaDoc")).list();

    }

    public ResumendiaCab adicionarResumendiaCab(ResumendiaCab resumendiaCab) {
        return entityManager.merge(resumendiaCab);
    }

}
