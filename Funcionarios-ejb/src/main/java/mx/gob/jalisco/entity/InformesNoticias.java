/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Entity
@Table(name = "InformesNoticias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformesNoticias.findAll", query = "SELECT i FROM InformesNoticias i"),
    @NamedQuery(name = "InformesNoticias.findByIdInforme", query = "SELECT i FROM InformesNoticias i WHERE i.idInforme = :idInforme"),
    @NamedQuery(name = "InformesNoticias.findByTitulo", query = "SELECT i FROM InformesNoticias i WHERE i.titulo = :titulo"),
    @NamedQuery(name = "InformesNoticias.findByTituloImagen", query = "SELECT i FROM InformesNoticias i WHERE i.tituloImagen = :tituloImagen")})
public class InformesNoticias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInforme")
    private Integer idInforme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "cuerpo")
    private String cuerpo;
    @Size(max = 45)
    @Column(name = "tituloImagen")
    private String tituloImagen;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categorias idCategoria;
    @JoinColumn(name = "funcionario", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuarios funcionario;

    public InformesNoticias() {
    }

    public InformesNoticias(Integer idInforme) {
        this.idInforme = idInforme;
    }

    public InformesNoticias(Integer idInforme, String titulo, String cuerpo) {
        this.idInforme = idInforme;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Integer getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(Integer idInforme) {
        this.idInforme = idInforme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getTituloImagen() {
        return tituloImagen;
    }

    public void setTituloImagen(String tituloImagen) {
        this.tituloImagen = tituloImagen;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Usuarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Usuarios funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInforme != null ? idInforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformesNoticias)) {
            return false;
        }
        InformesNoticias other = (InformesNoticias) object;
        if ((this.idInforme == null && other.idInforme != null) || (this.idInforme != null && !this.idInforme.equals(other.idInforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.gob.jalisco.entity.InformesNoticias[ idInforme=" + idInforme + " ]";
    }
    
}
