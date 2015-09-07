/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import mx.gob.jalisco.entity.Usuarios;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "Funcionarios-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios findEmailUser(String email) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder.createQuery(Usuarios.class);
        Root<Usuarios> from = criteriaQuery.from(Usuarios.class);
        Predicate condition = criteriaBuilder.equal(from.get("privilegeLevel"), 5);
        criteriaQuery.select(from).where(condition).orderBy(criteriaBuilder.asc(from.get("userId")));

        Usuarios result = em.createQuery(criteriaQuery).getSingleResult();
        /*Query query = entityManager.createQuery("SELECT u FROM Usuarios u WHERE u.usuario = :usuario", Usuarios.class);
         query.setParameter("usuario", usuario.getUsuario());
         Usuarios u = (Usuarios) query.getSingleResult();*/
        return result;
    }

}
