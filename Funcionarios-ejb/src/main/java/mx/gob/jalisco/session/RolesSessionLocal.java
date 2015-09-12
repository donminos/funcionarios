package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.Roles;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface RolesSessionLocal {

    public void create(Roles roles);

    public void edit(Roles roles);

    public void remove(Roles roles);

    public Roles find(Object id);

    public List<Roles> findAll();

    public List<Roles> findRange(int[] range);

    public int count();
}
