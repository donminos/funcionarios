
package mx.gob.jalisco.facade;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import mx.gob.jalisco.catalog.Evaluaciones;
import mx.gob.jalisco.entity.Calificaciones;
import mx.gob.jalisco.entity.Usuarios;

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
    
    Map<Usuarios,Float> promedioCalificaciones();
    
    List<Calificaciones> findForUser(Usuarios usuario);

    List<Calificaciones> findAll();
    
    List<Calificaciones> findCalifEstado(Evaluaciones eva);

    List<Calificaciones> findRange(int[] range);

    int count();
    
}
