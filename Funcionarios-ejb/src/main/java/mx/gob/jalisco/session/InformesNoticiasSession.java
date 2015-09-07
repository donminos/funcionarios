/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.session;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.gob.jalisco.entity.InformesNoticias;
import mx.gob.jalisco.facade.InformesNoticiasFacadeLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class InformesNoticiasSession implements InformesNoticiasSessionLocal {
    @EJB
    private InformesNoticiasFacadeLocal informesNoticiasFacade;

    @Override
    public void create(InformesNoticias informesNoticias) {
        informesNoticias.setFechaCreacion(new Date());
        informesNoticias.setFechaModificacion(new Date());
        informesNoticiasFacade.create(informesNoticias);
    }

    @Override
    public void edit(InformesNoticias informesNoticias) {
        informesNoticiasFacade.edit(informesNoticias);
    }

    @Override
    public void remove(InformesNoticias informesNoticias) {
        informesNoticiasFacade.remove(informesNoticias);
    }

    @Override
    public InformesNoticias find(Object id) {
        return informesNoticiasFacade.find(id);
    }

    @Override
    public List<InformesNoticias> findAll() {
        return informesNoticiasFacade.findAll();
    }

    @Override
    public List<InformesNoticias> findRange(int[] range) {
        return informesNoticiasFacade.findRange(range);
    }

    @Override
    public int count() {
        return informesNoticiasFacade.count();
    }
}
