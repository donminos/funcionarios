package mx.gob.jalisco.beans;

import java.io.IOException;
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
import mx.gob.jalisco.entity.Categorias;
import mx.gob.jalisco.entity.InformesNoticias;
import mx.gob.jalisco.libs.GenerateRandomName;
import mx.gob.jalisco.session.CategoriasSessionLocal;
import mx.gob.jalisco.session.InformesNoticiasSessionLocal;
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
    @EJB
    private InformesNoticiasSessionLocal informesNoticiasSession;
    @EJB
    private CategoriasSessionLocal categoriasSession;

    private InformesNoticias informes;
    private Categorias categoria;
    private Part file;

    public SeguimientoBean() {
        informes = new InformesNoticias();
        categoria = new Categorias();
    }

    public List<Categorias> getCategorias() {
        return categoriasSession.findAll();
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public InformesNoticias getInformes() {
        return informes;
    }

    public void setInformes(InformesNoticias informes) {
        this.informes = informes;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public void crearNoticia() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            if (file != null && file.getSubmittedFileName().split("\\.")[1].equals("jpg")) {
                GenerateRandomName random = new GenerateRandomName();
                String namefile = random.Generate() + ".jpg";
                file.write("/informesNoticias/" + namefile);
                informes.setTituloImagen(namefile);
            } else {
                throw new Exception("Archivo invalido");
            }
        } catch (Exception ex) {
            Logger.getLogger(SeguimientoBean.class.getName()).log(Level.SEVERE, null, ex);
            context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
        informes.setCategoria(categoria);
        informesNoticiasSession.create(informes, String.valueOf(request.getUserPrincipal()));
        informes = new InformesNoticias();
        FacesMessage message = new FacesMessage("Succesful", "Se ha publicado la noticia");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
