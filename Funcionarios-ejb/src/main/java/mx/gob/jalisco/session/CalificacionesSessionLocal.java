/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.Calificaciones;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface CalificacionesSessionLocal {
    
    public void create(Calificaciones calificaciones);

    public void edit(Calificaciones calificaciones);

    public void remove(Calificaciones calificaciones);

    public Calificaciones find(Object id);

    public List<Calificaciones> findAll();

    public List<Calificaciones> findRange(int[] range);

    public int count();
}
