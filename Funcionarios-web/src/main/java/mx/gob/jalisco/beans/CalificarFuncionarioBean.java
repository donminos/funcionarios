package mx.gob.jalisco.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import mx.gob.jalisco.libs.GenerateRandomName;
import mx.gob.jalisco.session.UsuariosSessionLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "calificarFuncionarioBean")
@SessionScoped
public class CalificarFuncionarioBean implements Serializable {

    @EJB
    private UsuariosSessionLocal usuariosSession;

    @EJB
    private mx.gob.jalisco.session.CalificacionesSessionLocal calificacionesSession;

    private Part file;
    private int funcionario;

    public CalificarFuncionarioBean() {
    }

    public List<?> getFuncionarios() {
        return usuariosSession.findAll();
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void handleCrear() {
        try {
            GenerateRandomName random = new GenerateRandomName();
                Logger.getLogger(CalificarFuncionarioBean.class.getName()).log(Level.INFO, file.getContentType(), file.getContentType());
            if (file.getContentType().split("/")[1].equals("jpeg") || file.getContentType().split("/")[1].equals("mp4")) {
                file.write(random.Generate() + "." + file.getContentType().split("/")[1]);
                FacesMessage message = new FacesMessage("Succesful", "Good");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No es un tipo de archivo valido"));
            }
        } catch (IOException ex) {
            Logger.getLogger(CalificarFuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
