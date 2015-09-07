package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.Usuarios;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface UsuariosSessionLocal {

    public void create(Usuarios usuarios);

    public void edit(Usuarios usuarios);

    public void remove(Usuarios usuarios);

    public Usuarios find(Object id);
    
    public Usuarios findEmail(String email);

    public List<Usuarios> findAll();

    public List<Usuarios> findRange(int[] range);

    public int count();
}
