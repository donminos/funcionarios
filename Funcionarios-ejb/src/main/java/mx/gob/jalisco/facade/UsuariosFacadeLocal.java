/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.facade;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.catalog.Roles;
import mx.gob.jalisco.entity.Usuarios;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);
    
    Usuarios findEmail(String email);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
}
