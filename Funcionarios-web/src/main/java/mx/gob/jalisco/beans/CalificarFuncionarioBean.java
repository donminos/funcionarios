package mx.gob.jalisco.beans;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import mx.gob.jalisco.entity.Calificaciones;
import mx.gob.jalisco.entity.EvaluacionesCalificacion;
import mx.gob.jalisco.entity.Usuarios;
import mx.gob.jalisco.libs.GenerateRandomName;
import mx.gob.jalisco.session.UsuariosSessionLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "calificarFuncionarioBean")
@RequestScoped
public class CalificarFuncionarioBean {

    @EJB
    private UsuariosSessionLocal usuariosSession;

    @EJB
    private mx.gob.jalisco.session.CalificacionesSessionLocal calificacionesSession;

    private Part file;
    private Integer funcionario;
    private Calificaciones calificacion;

    public CalificarFuncionarioBean() {
        calificacion = new Calificaciones();
    }

    public List<Usuarios> getFuncionarios() {
        return usuariosSession.findAll();
    }

    public Integer getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Integer funcionario) {
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
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        Usuarios usuario = usuariosSession.findEmail(String.valueOf(request.getUserPrincipal()));
        List<Calificaciones> listacalif = calificacionesSession.findForUser(usuario);
        try {
            for (Calificaciones calif : listacalif) {
                int añosDespues=1;//Años despues de la ultima evaluacion
                calif.getFechaEvaluacion().setYear(calif.getFechaEvaluacion().getYear() + añosDespues);
                if (calif.getFuncionarioEvaluado().getIdUsuarios() == funcionario && calif.getFechaEvaluacion().after(new Date())){
                    throw new Exception("Ya haz calificado a este funcionario");
                }
            }
            this.construirArchivo();
            calificacion.setIdUsuarios(usuario);
            calificacion.setFuncionarioEvaluado(usuariosSession.find(funcionario));
            calificacionesSession.create(calificacion);
            calificacion = new Calificaciones();
            FacesMessage message = new FacesMessage("Succesful", "Se ha mandado tu calificacion");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error Especifico", ex.getMessage()));
            Logger.getLogger(CalificarFuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void construirArchivo() throws Exception {
        if (file != null) {
            GenerateRandomName random = new GenerateRandomName();
            String archivo = file.getSubmittedFileName();
            String namefile = random.Generate() + "." + archivo.split("\\.")[1];
            Logger.getLogger(CalificarFuncionarioBean.class.getName()).log(Level.INFO, file.getSubmittedFileName(), file.getSubmittedFileName());
            if (archivo.split("\\.")[1].equals("jpg") || archivo.split("\\.")[1].equals("mp4") || archivo.split("\\.")[1].equals("pdf")) {
                file.write(namefile);
                calificacion.setArchivo(namefile);
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Tipo de archivo invalido"));
                throw new Exception("El nombre del archivo o extension son incorrectos");
            }
        }
    }
}
