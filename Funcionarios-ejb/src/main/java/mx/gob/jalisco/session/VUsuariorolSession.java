
package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.gob.jalisco.entity.VUsuariorol;
import mx.gob.jalisco.facade.VUsuariorolFacadeLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class VUsuariorolSession implements VUsuariorolSessionLocal {
    @EJB
    private VUsuariorolFacadeLocal vUsuariorolFacade;

    @Override
    public void create(VUsuariorol vUsuariorol) {
        vUsuariorolFacade.create(vUsuariorol);
    }

    @Override
    public void edit(VUsuariorol vUsuariorol) {
        vUsuariorolFacade.edit(vUsuariorol);
    }

    @Override
    public void remove(VUsuariorol vUsuariorol) {
        vUsuariorolFacade.remove(vUsuariorol);
    }

    @Override
    public VUsuariorol find(Object id) {
        return vUsuariorolFacade.find(id);
    }

    @Override
    public List<VUsuariorol> findAll() {
        return vUsuariorolFacade.findAll();
    }

    @Override
    public List<VUsuariorol> findRange(int[] range) {
        return vUsuariorolFacade.findRange(range);
    }

    @Override
    public int count() {
        return vUsuariorolFacade.count();
    }
}
