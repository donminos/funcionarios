package mx.gob.jalisco.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mx.gob.jalisco.entity.Categorias;
import mx.gob.jalisco.session.CategoriasSessionLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "seguimientoBean")
@RequestScoped
public class SeguimientoBean {
    @EJB
    private CategoriasSessionLocal categoriasSession;
    

    public SeguimientoBean() {
    }
    
    public List<Categorias> getCategorias(){
        return categoriasSession.findAll();
    }
}
