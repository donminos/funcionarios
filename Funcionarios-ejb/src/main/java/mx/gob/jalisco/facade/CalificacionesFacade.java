/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.gob.jalisco.entity.Calificaciones;
import mx.gob.jalisco.entity.Usuarios;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class CalificacionesFacade extends AbstractFacade<Calificaciones> implements CalificacionesFacadeLocal {

    @PersistenceContext(unitName = "Funcionarios-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalificacionesFacade() {
        super(Calificaciones.class);
    }

    @Override
    public List<Calificaciones> findForUser(Usuarios usuario) {
        Query query = em.createQuery("SELECT c FROM Calificaciones c WHERE c.idUsuarios.idUsuarios = :usuario order by c.fechaEvaluacion desc", Calificaciones.class);
        query.setParameter("usuario", usuario.getIdUsuarios());
        List<Calificaciones> calificaciones = (List<Calificaciones>) query.getResultList();
        return calificaciones;
    }

}
