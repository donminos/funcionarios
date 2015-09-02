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
@Table(name = "DatosFuncionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosFuncionarios.findAll", query = "SELECT d FROM DatosFuncionarios d"),
    @NamedQuery(name = "DatosFuncionarios.findByIdDatosFuncionarios", query = "SELECT d FROM DatosFuncionarios d WHERE d.idDatosFuncionarios = :idDatosFuncionarios"),
    @NamedQuery(name = "DatosFuncionarios.findByNombre", query = "SELECT d FROM DatosFuncionarios d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DatosFuncionarios.findByApellidoP", query = "SELECT d FROM DatosFuncionarios d WHERE d.apellidoP = :apellidoP"),
    @NamedQuery(name = "DatosFuncionarios.findByApellidoM", query = "SELECT d FROM DatosFuncionarios d WHERE d.apellidoM = :apellidoM")})
public class DatosFuncionarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDatosFuncionarios")
    private Integer idDatosFuncionarios;
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

    public DatosFuncionarios() {
    }

    public DatosFuncionarios(Integer idDatosFuncionarios) {
        this.idDatosFuncionarios = idDatosFuncionarios;
    }

    public DatosFuncionarios(Integer idDatosFuncionarios, String nombre, String apellidoP, String apellidoM) {
        this.idDatosFuncionarios = idDatosFuncionarios;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public Integer getIdDatosFuncionarios() {
        return idDatosFuncionarios;
    }

    public void setIdDatosFuncionarios(Integer idDatosFuncionarios) {
        this.idDatosFuncionarios = idDatosFuncionarios;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatosFuncionarios != null ? idDatosFuncionarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosFuncionarios)) {
            return false;
        }
        DatosFuncionarios other = (DatosFuncionarios) object;
        if ((this.idDatosFuncionarios == null && other.idDatosFuncionarios != null) || (this.idDatosFuncionarios != null && !this.idDatosFuncionarios.equals(other.idDatosFuncionarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.gob.jalisco.entity.DatosFuncionarios[ idDatosFuncionarios=" + idDatosFuncionarios + " ]";
    }
    
}