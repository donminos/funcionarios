
package mx.gob.jalisco.beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.gob.jalisco.entity.InformesNoticias;
import mx.gob.jalisco.session.InformesNoticiasSessionLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "noticiasBean")
@RequestScoped
public class NoticiasBean {
    @EJB
    private InformesNoticiasSessionLocal informesNoticiasSession;
    
    private Integer noticiaId;
    
    private InformesNoticias noticia;

    public NoticiasBean() {
        noticia=new InformesNoticias();
    }

    public Integer getNoticiaId() {
        return noticiaId;
    }

    public void setNoticiaId(Integer noticiaId) {
        noticia=informesNoticiasSession.find(noticiaId);
        this.noticiaId = noticiaId;
    }
    
    public InformesNoticias getNoticia(){
        return noticia;
    }
        
    public void setNoticia(InformesNoticias noticia){
        this.noticia=noticia;
    }
    
    public void modificarNoticia(){
        InformesNoticias noticiatmp=informesNoticiasSession.find(noticiaId);
        noticiatmp.setCuerpo(noticia.getCuerpo());
        noticiatmp.setTitulo(noticia.getTitulo());
        informesNoticiasSession.edit(noticiatmp);
        FacesMessage message = new FacesMessage("Succesful", "Se ha actualizado");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
