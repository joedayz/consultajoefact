package pe.joedayz.joefact.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pe.joedayz.joefact.modelo.Seguimiento;

public class SeguimientoRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public Seguimiento buscarSeguimientoPorCodigo(Long codigo) {
        return this.entityManager.find(Seguimiento.class, codigo);
    }

    public List<Seguimiento> listarSeguimientos(Integer docu_codigo) {

        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Seguimiento.class);

        if (docu_codigo!=null) {
            criteria.add(Restrictions.eq("docuCodigo", docu_codigo));
        }
        return criteria.addOrder(Order.desc("idseguimiento")).list();

    }

}
