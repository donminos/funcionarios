package mx.gob.jalisco.session;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.gob.jalisco.catalog.Evaluaciones;
import mx.gob.jalisco.entity.Calificaciones;
import mx.gob.jalisco.entity.EvaluacionesCalificacion;
import mx.gob.jalisco.entity.Usuarios;
import mx.gob.jalisco.facade.CalificacionesFacadeLocal;
import mx.gob.jalisco.facade.UsuariosFacadeLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class CalificacionesSession implements CalificacionesSessionLocal {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    @EJB
    private CalificacionesFacadeLocal calificacionesFacade;

    @Override
    public void create(Calificaciones calificaciones, String funcionarioemail, String usuarioemail) throws Exception {
        Usuarios usuario=usuariosFacade.findEmail(usuarioemail);
        Usuarios funcionario=usuariosFacade.findEmail(funcionarioemail);
        List<Calificaciones> listacalif = calificacionesFacade.findForUser(usuario);
        for (Calificaciones calif : listacalif) {
            int añosDespues = 1;//Años despues de la ultima evaluacion
            calif.getFechaEvaluacion().setYear(calif.getFechaEvaluacion().getYear() + añosDespues);
            if (Objects.equals(calif.getFuncionarioEvaluado(), funcionario) && calif.getFechaEvaluacion().after(new Date())) {
                throw new Exception("Ya haz calificado a este funcionario");
            }
        }
        calificaciones.setIdUsuarios(usuario);
        calificaciones.setFuncionarioEvaluado(funcionario);
        calificaciones.setEvaluado(new EvaluacionesCalificacion(Evaluaciones.SINREVISAR.getDato()));
        calificaciones.setFechaEvaluacion(new Date());
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
    public List<Calificaciones> findForUser(Usuarios usuario) {
        return calificacionesFacade.findForUser(usuario);
    }

    @Override
    public List<Calificaciones> findAll() {
        return calificacionesFacade.findAll();
    }

    @Override
    public List<Calificaciones> findCalifEstado(Evaluaciones eva) {
        return calificacionesFacade.findCalifEstado(eva);
    }

    @Override
    public List<Calificaciones> findRange(int[] range) {
        return calificacionesFacade.findRange(range);
    }

    @Override
    public int count() {
        return calificacionesFacade.count();
    }

    @Override
    public Map<Usuarios, Float> promedioCalificaciones() {
        return calificacionesFacade.promedioCalificaciones();
    }
}
