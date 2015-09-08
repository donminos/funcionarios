/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
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
        this.noticiaId = noticiaId;
    }
    
    public InformesNoticias getNoticia(){
        noticia=informesNoticiasSession.find(noticiaId);
        return noticia;
    }
    
    public void setNoticia(InformesNoticias noticia){
        this.noticia=noticia;
    }
    
    
    public void modificarNoticia(){
        informesNoticiasSession.edit(noticia);
    }
}
