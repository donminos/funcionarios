package mx.gob.jalisco.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import mx.gob.jalisco.entity.Calificaciones;
import mx.gob.jalisco.entity.Usuarios;
import mx.gob.jalisco.libs.GenerateRandomName;
import mx.gob.jalisco.session.UsuariosSessionLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "calificarFuncionarioBean")
@RequestScoped
public class CalificarFuncionarioBean{

    @EJB
    private UsuariosSessionLocal usuariosSession;

    @EJB
    private mx.gob.jalisco.session.CalificacionesSessionLocal calificacionesSession;

    private Part file;
    private Usuarios funcionario;
    private Calificaciones calificacion;

    public CalificarFuncionarioBean() {
        calificacion = new Calificaciones();
        funcionario = new Usuarios();
    }

    public List<Usuarios> getFuncionarios() {
        return usuariosSession.findAll();
    }

    public Usuarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Usuarios funcionario) {
        this.funcionario = funcionario;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Calificaciones getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificaciones calificacion) {
        this.calificacion = calificacion;
    }

    public void handleCrear() {
        try {
            if (file != null) {
                GenerateRandomName random = new GenerateRandomName();
                String namefile=random.Generate() + "." + file.getContentType().split("/")[1];
                Logger.getLogger(CalificarFuncionarioBean.class.getName()).log(Level.INFO, file.getContentType(), file.getContentType());
                if (file.getContentType().split("/")[1].equals("jpeg") || file.getContentType().split("/")[1].equals("mp4")) {
                    file.write(namefile);
                    calificacion.setArchivo(namefile);
                } else {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No es un tipo de archivo valido"));
                    new IOException("Error archivo");
                }
            }
            calificacion.setIdUsuarios(usuariosSession.find(funcionario.getIdUsuarios()));
            calificacion.setFuncionarioEvaluado(usuariosSession.find(funcionario.getIdUsuarios()));
            calificacionesSession.create(calificacion);
            calificacion = new Calificaciones();
            funcionario = new Usuarios();

            FacesMessage message = new FacesMessage("Succesful", "Se ha mandado tu calificacion");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (IOException ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Problema"));
            Logger.getLogger(CalificarFuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
