package mx.gob.jalisco.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mx.gob.jalisco.entity.Calificaciones;
import mx.gob.jalisco.session.CalificacionesSessionLocal;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "panelControl")
@RequestScoped
public class PanelControl {

    public enum Evaluacion {

        SINREVISAR((short)1),
        ACEPTADP((short)2),
        RECHAZADO((short)3);
        private short value; // Variable interna donde almacenaremos

        // Nuestro constructor nos fuerza a pasar parámetros al definir un nuevo tipo
        Evaluacion(short value) {
            this.value = value;
        }
        // Devuelve la capacidad del vaso
        public short getDato() {
            return value;
        }
    }
    @EJB
    private CalificacionesSessionLocal calificacionesSession;
    private StreamedContent file;
    public PanelControl() throws FileNotFoundException {//Esconder los archivos de las calificaciones y cargar para todos los demas 
        File archivo = new File("/home/ceasar/NetBeansProjects/Funcionarios/Funcionarios-web/src/main/webapp/resources/imagenes/QW8T2PBCGM867ONUXQMK28E8TL7MQTZEKXZOSBCZB.jpg");
        InputStream stream=new FileInputStream(archivo);
        file=new DefaultStreamedContent(stream,"",archivo.getName());
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
    public List<Calificaciones> getCalificaciones() {
        List<Calificaciones> calificaciones = calificacionesSession.findAll();
        List<Calificaciones> calificacionessincalificar = new ArrayList();
        for (Calificaciones calificacione : calificaciones) {
            if (Evaluacion.SINREVISAR.getDato() == calificacione.getEvaluado().getIdEvaluacionesCalificacion()) {
                calificacionessincalificar.add(calificacione);
            }
        }
        Collections.sort(calificacionessincalificar, new Comparator<Calificaciones>() {
            @Override
            public int compare(Calificaciones o1, Calificaciones o2) {
                return o1.getIdCalificaciones().compareTo(o2.getIdCalificaciones());
            }
        });
        Collections.reverse(calificacionessincalificar);
        return calificacionesSession.findAll();
    }

}
