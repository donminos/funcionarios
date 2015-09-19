package mx.gob.jalisco.beans;

import java.io.IOException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author carlos
 */
@Named(value = "authenticationBean")
@RequestScoped
public class AuthenticationBean {

    private String usuario;
    private String contrasena;

    public AuthenticationBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        Principal userPrincipal;
        try {
            request.login(usuario, contrasena);
            userPrincipal = request.getUserPrincipal();
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Login Correcto del usuario ".concat(userPrincipal.getName()));
        } catch (ServletException ex) {
            context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No es un usuario valido"));
            Logger.getLogger(AuthenticationBean.class.getName()).log(Level.SEVERE, null, ex);
            this.logout();
        }
    }

    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        if (request.getUserPrincipal() != null) {
                request.getSession().invalidate();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se ha cerrado la sesion"));
                /*context.getExternalContext().redirect("/");*/
                System.out.println(request.getUserPrincipal());
        }
    }

}
