/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.facade;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.catalog.Roles;
import mx.gob.jalisco.entity.VUsuariorol;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface VUsuariorolFacadeLocal {

    void create(VUsuariorol vUsuariorol);

    void edit(VUsuariorol vUsuariorol);

    void remove(VUsuariorol vUsuariorol);

    VUsuariorol find(Object id);

    List<VUsuariorol> findAll();
     
    List<VUsuariorol> findRange(int[] range);

    int count();
    
}
