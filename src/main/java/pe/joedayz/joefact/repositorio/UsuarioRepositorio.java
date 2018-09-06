package pe.joedayz.joefact.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pe.joedayz.joefact.modelo.Usuario;
import pe.joedayz.joefact.repositorio.filtros.UsuarioFiltros;
import pe.joedayz.joefact.service.NegocioExcepciones;
import pe.joedayz.joefact.util.jpa.Transaccion;

public class UsuarioRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public Usuario buscarUsuarioporId(Long ideUsuario) {
        return this.entityManager.find(Usuario.class, ideUsuario);
    }

    public List<Usuario> listarVendedores() {
        return this.entityManager.createQuery("from Usuario", Usuario.class)
                .getResultList();
    }

    public Usuario buscarUsuarioActivoPorEmail(String email) {

        Usuario usuario;
        try {
            usuario = this.entityManager.createQuery("from Usuario where lower(email) = :email and activo=true", Usuario.class)
                    .setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
            usuario = null;
        }
        return usuario;
    }

    public Usuario buscarUsuarioActivoOInactivoPorEmail(String email) {

        Usuario usuario;
        try {
            usuario = this.entityManager.createQuery("from Usuario where lower(email) = :email ", Usuario.class)
                    .setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
            usuario = null;
        }
        return usuario;
    }


    public Usuario buscarUsuarioActivoPorDni(String dni) {

        Usuario usuario;
        try {
            usuario = this.entityManager.createQuery("from Usuario where lower(dni) = :dni and activo=true", Usuario.class)
                    .setParameter("dni", dni).getSingleResult();
        } catch (NoResultException e) {
            usuario = null;
        }
        return usuario;
    }

    public Usuario buscarUsuarioActivoOInactivoPorDni(String dni) {

        Usuario usuario;
        try {
            usuario = this.entityManager.createQuery("from Usuario where lower(dni) = :dni", Usuario.class)
                    .setParameter("dni", dni).getSingleResult();
        } catch (NoResultException e) {
            usuario = null;
        }
        return usuario;
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> listarUsuariosFiltrados(UsuarioFiltros usuarioFiltros) {

        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Usuario.class);
        if (StringUtils.isNotBlank(usuarioFiltros.getEmail())
                && StringUtils.isBlank(usuarioFiltros.getNombre())) {
            criteria.add(Restrictions.eq("email", usuarioFiltros.getEmail()));
        }

        if (StringUtils.isNotBlank(usuarioFiltros.getNombre())) {
            criteria.add(Restrictions.ilike("nombreUsuario", usuarioFiltros.getNombre(),
                    MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("nombreUsuario")).list();

    }

    @Transaccion
    public void removerUsuario(Usuario usuario) {

        try {
            usuario = obtenerUsuario(usuario.getIdeUsuario());
            entityManager.remove(usuario);
            entityManager.flush();
        } catch (PersistenceException e) {
            throw new NegocioExcepciones("El usuario no puede ser eliminado.");
        }

    }

    public Usuario obtenerUsuario(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    public Usuario adicionarUsuario(Usuario usuario) {
        return entityManager.merge(usuario);
    }

}
