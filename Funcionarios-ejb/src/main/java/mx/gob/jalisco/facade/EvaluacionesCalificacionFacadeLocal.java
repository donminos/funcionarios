/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.facade;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.EvaluacionesCalificacion;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface EvaluacionesCalificacionFacadeLocal {

    void create(EvaluacionesCalificacion evaluacionesCalificacion);

    void edit(EvaluacionesCalificacion evaluacionesCalificacion);

    void remove(EvaluacionesCalificacion evaluacionesCalificacion);

    EvaluacionesCalificacion find(Object id);

    List<EvaluacionesCalificacion> findAll();

    List<EvaluacionesCalificacion> findRange(int[] range);

    int count();
    
}
