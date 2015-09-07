/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.EvaluacionesCalificacion;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface EvaluacionesCalificacionSessionLocal {
        public void create(EvaluacionesCalificacion evaluacionesCalificacion);

    public void edit(EvaluacionesCalificacion evaluacionesCalificacion);

    public void remove(EvaluacionesCalificacion evaluacionesCalificacion);

    public EvaluacionesCalificacion find(Object id);

    public List<EvaluacionesCalificacion> findAll();

    public List<EvaluacionesCalificacion> findRange(int[] range);

    public int count();
}
