package pe.joedayz.cofaco.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pe.joedayz.cofaco.modelo.Empresa;
import pe.joedayz.cofaco.repositorio.filtros.EmpresaFiltros;

public class EmpresaRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public Empresa buscarEmpresaPorCodigo(Long codigo) {
        return this.entityManager.find(Empresa.class, codigo);
    }

    public Empresa buscarEmpresaPorRuc(String ruc) {
        Empresa empresa;
        try {
            empresa = this.entityManager.createQuery("from Empresa where epmrRuc = :ruc and emprTipo = 'INTERNO' ", Empresa.class)
                    .setParameter("ruc", ruc)
                    .getSingleResult();

        } catch (NoResultException e) {
            empresa = null;
        }
        return empresa;
    }

    public List<Empresa> listarEmpresas() {
        return this.entityManager.createQuery("from Empresa ", Empresa.class)
                .getResultList();
    }

    public List<Empresa> listarEmpresasInternas() {
        return this.entityManager.createQuery("from Empresa where emprTipo = 'INTERNO' ", Empresa.class)
                .getResultList();
    }

    public List<Empresa> listarEmpresasExternos() {
        return this.entityManager.createQuery("from Empresa where emprTipo = 'EXTERNO' ", Empresa.class)
                .getResultList();
    }

    public Empresa adicionarEmpresa(Empresa empresa) {
        return entityManager.merge(empresa);
    }

    @SuppressWarnings("unchecked")
    public List<Empresa> listarEmpresasFiltrados(EmpresaFiltros empresaFiltros) {

        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Empresa.class);
        if (StringUtils.isNotBlank(empresaFiltros.getEpmrRuc())) {
            criteria.add(Restrictions.eq("epmrRuc", empresaFiltros.getEpmrRuc()));
        }

        if (StringUtils.isNotBlank(empresaFiltros.getEmprRazonSocial())) {
            criteria.add(Restrictions.ilike("emprRazonSocial", empresaFiltros.getEmprRazonSocial(),
                    MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("emprRazonSocial")).list();

    }

}
