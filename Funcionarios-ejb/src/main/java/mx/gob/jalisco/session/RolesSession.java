
package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.gob.jalisco.entity.Roles;
import mx.gob.jalisco.facade.RolesFacadeLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class RolesSession implements RolesSessionLocal {
    @EJB
    private RolesFacadeLocal rolesFacade;

    @Override
    public void create(Roles roles) {
        rolesFacade.create(roles);
    }

    @Override
    public void edit(Roles roles) {
        rolesFacade.edit(roles);
    }

    @Override
    public void remove(Roles roles) {
        rolesFacade.remove(roles);
    }

    @Override
    public Roles find(Object id) {
        return rolesFacade.find(id);
    }

    @Override
    public List<Roles> findAll() {
        return rolesFacade.findAll();
    }

    @Override
    public List<Roles> findRange(int[] range) {
        return rolesFacade.findRange(range);
    }

    @Override
    public int count() {
        return rolesFacade.count();
    }
    
}
