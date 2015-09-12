package mx.gob.jalisco.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.gob.jalisco.catalog.Evaluaciones;
import mx.gob.jalisco.entity.Calificaciones;
import mx.gob.jalisco.entity.EvaluacionesCalificacion;
import mx.gob.jalisco.session.CalificacionesSessionLocal;
import mx.gob.jalisco.session.EvaluacionesCalificacionSessionLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "panelControl")
@RequestScoped
public class PanelControl {
    @EJB
    private EvaluacionesCalificacionSessionLocal evaluacionesCalificacionSession;
    
    @EJB
    private CalificacionesSessionLocal calificacionesSession;
    
    private short evaluacion;
    
    public PanelControl() {
    }

    public short getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(short evaluacion) {
        this.evaluacion = evaluacion;
    }

    public List<EvaluacionesCalificacion> getEvaluaciones(){
        return evaluacionesCalificacionSession.findAll();
    }
    
    public List<Calificaciones> getCalificaciones() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        List<Calificaciones> calificaciones;
        if(request.isUserInRole("ADMINISTRADOR")){
            calificaciones = calificacionesSession.findCalifEstado(Evaluaciones.SINREVISAR);
        }else{
            calificaciones = calificacionesSession.findCalifEstado(Evaluaciones.ACEPTADO);
        }
        return calificaciones;
    }

    public void downloadFile(String data) {
        File file = new File("/home/ceasar/NetBeansProjects/Funcionarios/Funcionarios-web/src/main/webapp/resources/imagenes/" + data);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Content-Disposition", "attachment;filename=" + data);
        response.setContentLength((int) file.length());
        ServletOutputStream out = null;
        try {
            FileInputStream input = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            out = response.getOutputStream();
            int i = 0;
            while ((i = input.read(buffer)) != -1) {
                out.write(buffer);
                out.flush();
            }
            FacesContext.getCurrentInstance().getResponseComplete();
        } catch (IOException err) {
            err.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }
    public void cambiarCalificacion(Calificaciones calif){
        calif.setEvaluado(new EvaluacionesCalificacion(evaluacion));
        calificacionesSession.edit(calif);
        FacesMessage message = new FacesMessage("Succesful", "Se ha evaluado la calificacion del funcionario");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
