package mx.gob.jalisco.beans;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mx.gob.jalisco.entity.InformesNoticias;
import mx.gob.jalisco.entity.Usuarios;
import mx.gob.jalisco.session.CalificacionesSessionLocal;
import mx.gob.jalisco.session.InformesNoticiasSessionLocal;
import mx.gob.jalisco.session.RolesSessionLocal;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "indexBean")
@RequestScoped
public class IndexBean implements Serializable {
    @EJB
    private RolesSessionLocal rolesSession;
    @EJB
    private CalificacionesSessionLocal calificacionesSession;
    @EJB
    private InformesNoticiasSessionLocal informesNoticiasSession;
    
    private List<InformesNoticias> informesnoticias;

    private PieChartModel livePieModel;

    public IndexBean() {
        livePieModel = new PieChartModel();
    }
/*
    public PieChartModel getLivePieModel() {
        Map<Usuarios, Float> calif = calificacionesSession.promedioCalificaciones();

        for (Entry<Usuarios, Float> e: calif.entrySet()) {
            Usuarios usu=(Usuarios)e.getKey();
            livePieModel.getData().put(usu.getDatosUsuario().getNombreCompleto(),(Number)e.getValue());
            System.out.println("[" + e.getKey() + "=" + e.getValue() + "]");
        }

        /*int random1 = (int) (Math.random() * 1000);
        int random2 = (int) (Math.random() * 1000);

        
        livePieModel.getData().put("Candidate 2", random2);

        livePieModel.setTitle("Calificacion de los Funcionarios");
        livePieModel.setLegendPosition("ne");
        return livePieModel;
    }

    public void setLivePieModel(PieChartModel livePieModel) {
        this.livePieModel = livePieModel;
    }*/

    public List<InformesNoticias> getInformesnoticias() {
        informesnoticias = informesNoticiasSession.findAll();
        Collections.sort(informesnoticias, new Comparator<InformesNoticias>() {
            @Override
            public int compare(InformesNoticias o1, InformesNoticias o2) {
                return o1.getFechaCreacion().compareTo(o2.getFechaCreacion());
            }
        });
        Collections.reverse(informesnoticias);
        return informesnoticias;
    }

    public void setInformesnoticias(List<InformesNoticias> informesnoticias) {
        this.informesnoticias = informesnoticias;
    }

}
