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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Entity
@Table(name = "DatosUsuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosUsuario.findAll", query = "SELECT d FROM DatosUsuario d"),
    @NamedQuery(name = "DatosUsuario.findByIdDatosFuncionarios", query = "SELECT d FROM DatosUsuario d WHERE d.idDatosUsuario = :idDatosUsuario"),
    @NamedQuery(name = "DatosUsuario.findByNombre", query = "SELECT d FROM DatosUsuario d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DatosUsuario.findByApellidoP", query = "SELECT d FROM DatosUsuario d WHERE d.apellidoP = :apellidoP"),
    @NamedQuery(name = "DatosUsuario.findByApellidoM", query = "SELECT d FROM DatosUsuario d WHERE d.apellidoM = :apellidoM")})
public class DatosUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDatosUsuario")
    private Integer idDatosUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidoP")
    private String apellidoP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidoM")
    private String apellidoM;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios")
    @OneToOne(optional = false)
    private Usuarios idUsuarios;

    public DatosUsuario() {
    }

    public DatosUsuario(Integer idDatosUsuario) {
        this.idDatosUsuario = idDatosUsuario;
    }

    public DatosUsuario(Integer idDatosUsuario, String nombre, String apellidoP, String apellidoM) {
        this.idDatosUsuario = idDatosUsuario;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public Integer getIdDatosUsuario() {
        return idDatosUsuario;
    }

    public void setIdDatosUsuario(Integer idDatosUsuario) {
        this.idDatosUsuario = idDatosUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombreCompleto() {
        return this.nombre + " " + this.apellidoP + " " + this.apellidoM;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatosUsuario != null ? idDatosUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosUsuario)) {
            return false;
        }
        DatosUsuario other = (DatosUsuario) object;
        if ((this.idDatosUsuario == null && other.idDatosUsuario != null) || (this.idDatosUsuario != null && !this.idDatosUsuario.equals(other.idDatosUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.gob.jalisco.entity.DatosUsuario[ idDatosUsuario=" + idDatosUsuario + " ]";
    }

}
