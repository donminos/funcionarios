/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.gob.jalisco.entity.EvaluacionesCalificacion;
import mx.gob.jalisco.facade.EvaluacionesCalificacionFacadeLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class EvaluacionesCalificacionSession implements EvaluacionesCalificacionSessionLocal {
    @EJB
    private EvaluacionesCalificacionFacadeLocal evaluacionesCalificacionFacade;

    @Override
    public void create(EvaluacionesCalificacion evaluacionesCalificacion) {
        evaluacionesCalificacionFacade.create(evaluacionesCalificacion);
    }

    @Override
    public void edit(EvaluacionesCalificacion evaluacionesCalificacion) {
        evaluacionesCalificacionFacade.edit(evaluacionesCalificacion);
    }

    @Override
    public void remove(EvaluacionesCalificacion evaluacionesCalificacion) {
        evaluacionesCalificacionFacade.remove(evaluacionesCalificacion);
    }

    @Override
    public EvaluacionesCalificacion find(Object id) {
        return evaluacionesCalificacionFacade.find(id);
    }

    @Override
    public List<EvaluacionesCalificacion> findAll() {
        return evaluacionesCalificacionFacade.findAll();
    }

    @Override
    public List<EvaluacionesCalificacion> findRange(int[] range) {
        return evaluacionesCalificacionFacade.findRange(range);
    }

    @Override
    public int count() {
        return evaluacionesCalificacionFacade.count();
    }

}
