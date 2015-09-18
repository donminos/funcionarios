package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.InformesNoticias;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface InformesNoticiasSessionLocal {

    public void create(InformesNoticias informesNoticias,String emailfuncionario);

    public void edit(InformesNoticias informesNoticias);

    public void remove(InformesNoticias informesNoticias);

    public InformesNoticias find(Object id);

    public List<InformesNoticias> findAll();

    public List<InformesNoticias> findRange(int[] range);

    public int count();
}
