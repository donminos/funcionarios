
package mx.gob.jalisco.session;

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
public interface CalificacionesSessionLocal {
    
    public void create(Calificaciones calificaciones);

    public void edit(Calificaciones calificaciones);

    public void remove(Calificaciones calificaciones);

    public Calificaciones find(Object id);
    
    public Map<Usuarios,Float> promedioCalificaciones();
    
    public List<Calificaciones> findForUser(Usuarios usuario);

    public List<Calificaciones> findAll();
    
    public List<Calificaciones> findCalifEstado(Evaluaciones eva);

    public List<Calificaciones> findRange(int[] range);

    public int count();
}
