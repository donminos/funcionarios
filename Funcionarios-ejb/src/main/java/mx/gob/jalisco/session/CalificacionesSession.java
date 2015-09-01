
package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.gob.jalisco.entity.Calificaciones;
import mx.gob.jalisco.facade.CalificacionesFacadeLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class CalificacionesSession implements CalificacionesSessionLocal {
    @EJB
    private CalificacionesFacadeLocal calificacionesFacade;

    @Override
    public void create(Calificaciones calificaciones) {
        calificacionesFacade.create(calificaciones);
    }

    @Override
    public void edit(Calificaciones calificaciones) {
        calificacionesFacade.edit(calificaciones);
    }

    @Override
    public void remove(Calificaciones calificaciones) {
        calificacionesFacade.remove(calificaciones);
    }

    @Override
    public Calificaciones find(Object id) {
        return calificacionesFacade.find(id);
    }

    @Override
    public List<Calificaciones> findAll() {
        return calificacionesFacade.findAll();
    }

    @Override
    public List<Calificaciones> findRange(int[] range) {
        return calificacionesFacade.findRange(range);
    }

    @Override
    public int count() {
        return calificacionesFacade.count();
    }
}
