
package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.VUsuariorol;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface VUsuariorolSessionLocal {

    public void create(VUsuariorol vUsuariorol);

    public void edit(VUsuariorol vUsuariorol);

    public void remove(VUsuariorol vUsuariorol);

    public VUsuariorol find(Object id);

    public List<VUsuariorol> findAll();

    public List<VUsuariorol> findRange(int[] range);

    public int count();
}
