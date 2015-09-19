/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.session;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.gob.jalisco.catalog.Roles;
import mx.gob.jalisco.entity.DatosUsuario;
import mx.gob.jalisco.entity.Usuarios;
import mx.gob.jalisco.facade.DatosUsuarioFacadeLocal;
import mx.gob.jalisco.facade.RolesFacadeLocal;
import mx.gob.jalisco.facade.UsuariosFacadeLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class UsuariosSession implements UsuariosSessionLocal {
    @EJB
    private DatosUsuarioFacadeLocal datosUsuarioFacade;
    @EJB
    private RolesFacadeLocal rolesFacade;
    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    

    @Override
    public void create(Usuarios usuarios,Roles rol) {
        List<mx.gob.jalisco.entity.Roles> listroles=new ArrayList();
        DatosUsuario datos=usuarios.getDatosUsuario();
        usuarios.setDatosUsuario(null);
        mx.gob.jalisco.entity.Roles rolusuario=rolesFacade.find(rol.getDato());
        listroles.add(rolusuario);
        usuarios.setRolesList(listroles);
        usuariosFacade.create(usuarios);
        datos.setIdUsuarios(usuarios);
        datosUsuarioFacade.create(datos);
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
        return usuariosFacade.findEmail(email);
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
