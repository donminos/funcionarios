
package mx.gob.jalisco.beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mx.gob.jalisco.catalog.Roles;
import mx.gob.jalisco.entity.DatosUsuario;
import mx.gob.jalisco.entity.Usuarios;
import mx.gob.jalisco.session.UsuariosSessionLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "registroBean")
@RequestScoped
public class RegistroBean {
    @EJB
    private UsuariosSessionLocal usuariosSession;
    
    private Usuarios usuario;    
    
    public RegistroBean() {
        usuario=new Usuarios();
        usuario.setDatosUsuario(new DatosUsuario());
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    public void createUser(){
        usuariosSession.create(usuario,Roles.USUARIO);
    }
    
}
