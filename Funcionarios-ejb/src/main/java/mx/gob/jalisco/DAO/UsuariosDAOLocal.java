/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.DAO;

import javax.ejb.Local;
import mx.gob.jalisco.entity.Usuarios;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
interface UsuariosDAOLocal {
    
    public Usuarios findEmailUser(String email);
}
