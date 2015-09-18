package mx.gob.jalisco.beans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import mx.gob.jalisco.catalog.Roles;
import mx.gob.jalisco.entity.Calificaciones;
import mx.gob.jalisco.entity.Usuarios;
import mx.gob.jalisco.libs.GenerateRandomName;
import mx.gob.jalisco.session.RolesSessionLocal;
import mx.gob.jalisco.session.UsuariosSessionLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "calificarFuncionarioBean")
@RequestScoped
public class CalificarFuncionarioBean {

    @EJB
    private RolesSessionLocal rolesSession;
    @EJB
    private UsuariosSessionLocal usuariosSession;
    @EJB
    private mx.gob.jalisco.session.CalificacionesSessionLocal calificacionesSession;

    private Part file;
    private String funcionario;
    private Calificaciones calificacion;

    public CalificarFuncionarioBean() {
        calificacion = new Calificaciones();
    }

    public List<Usuarios> getFuncionarios() {
        List<Usuarios> funcionarios = rolesSession.find(Roles.FUNCIONARIO.getDato()).getUsuariosList();
        return funcionarios;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
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
        try {
            this.construirArchivo();
            calificacionesSession.create(calificacion, funcionario, String.valueOf(request.getUserPrincipal()));
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
