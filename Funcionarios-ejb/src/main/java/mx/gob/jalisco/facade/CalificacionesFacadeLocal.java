/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.facade;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.Calificaciones;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface CalificacionesFacadeLocal {

    void create(Calificaciones calificaciones);

    void edit(Calificaciones calificaciones);

    void remove(Calificaciones calificaciones);

    Calificaciones find(Object id);

    List<Calificaciones> findAll();

    List<Calificaciones> findRange(int[] range);

    int count();
    
}
