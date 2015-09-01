package mx.gob.jalisco.beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mx.gob.jalisco.entity.Usuarios;
import mx.gob.jalisco.session.UsuariosSessionLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "seguimientoBean")
@RequestScoped
public class SeguimientoBean {

    @EJB
    private UsuariosSessionLocal usuariosSession;
    
    private Usuarios usuario;

    public SeguimientoBean() {
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

}
