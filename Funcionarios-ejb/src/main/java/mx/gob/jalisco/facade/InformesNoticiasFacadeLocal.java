/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.facade;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.InformesNoticias;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface InformesNoticiasFacadeLocal {

    void create(InformesNoticias informesNoticias);

    void edit(InformesNoticias informesNoticias);

    void remove(InformesNoticias informesNoticias);

    InformesNoticias find(Object id);

    List<InformesNoticias> findAll();

    List<InformesNoticias> findRange(int[] range);

    int count();
    
}
