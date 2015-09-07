/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.gob.jalisco.DAO.UsuariosDAO;
import mx.gob.jalisco.entity.Usuarios;
import mx.gob.jalisco.facade.UsuariosFacadeLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class UsuariosSession implements UsuariosSessionLocal {
    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    @Override
    public void create(Usuarios usuarios) {
        usuariosFacade.create(usuarios);
    }

    @Override
    public void edit(Usuarios usuarios) {
        usuariosFacade.edit(usuarios);
    }

    @Override
    public void remove(Usuarios usuarios) {
        usuariosFacade.remove(usuarios);
    }

    @Override
    public Usuarios find(Object id) {
        return usuariosFacade.find(id);
    }
    
    @Override
    public Usuarios findEmail(String email) {
        return usuariosFacade.findEmailUser(email);
    }

    @Override
    public List<Usuarios> findAll() {
        return usuariosFacade.findAll();
    }

    @Override
    public List<Usuarios> findRange(int[] range) {
        return usuariosFacade.findRange(range);
    }

    @Override
    public int count() {
        return usuariosFacade.count();
    }
    
}
