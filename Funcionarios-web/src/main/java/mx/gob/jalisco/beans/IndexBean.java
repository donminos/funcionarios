
package mx.gob.jalisco.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mx.gob.jalisco.entity.InformesNoticias;
import mx.gob.jalisco.session.InformesNoticiasSessionLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "indexBean")
@RequestScoped
public class IndexBean {
    @EJB
    private InformesNoticiasSessionLocal informesNoticiasSession;
    private List<InformesNoticias> informesnoticias;
    public IndexBean() {
        informesnoticias=informesNoticiasSession.findAll();
    }

    public List<InformesNoticias> getInformesnoticias() {
        return informesnoticias;
    }

    public void setInformesnoticias(List<InformesNoticias> informesnoticias) {
        this.informesnoticias = informesnoticias;
    }
    
}
