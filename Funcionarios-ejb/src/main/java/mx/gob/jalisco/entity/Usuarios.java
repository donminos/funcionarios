/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Entity
@Table(name = "Usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuarios", query = "SELECT u FROM Usuarios u WHERE u.idUsuarios = :idUsuarios"),
    @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuarios")
    private Integer idUsuarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "contrasena")
    private String contrasena;
    @JoinTable(name = "UsuarioRol", joinColumns = {
        @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios")}, inverseJoinColumns = {
        @JoinColumn(name = "idRoles", referencedColumnName = "idRoles")})
    @ManyToMany
    private List<Roles> rolesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioEvaluado")
    private List<Calificaciones> calificacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private List<Calificaciones> calificacionesList1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private DatosUsuario datosUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<InformesNoticias> informesNoticiasList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Usuarios(Integer idUsuarios, String correo, String contrasena) {
        this.idUsuarios = idUsuarios;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @XmlTransient
    public List<Calificaciones> getCalificacionesList() {
        return calificacionesList;
    }

    public void setCalificacionesList(List<Calificaciones> calificacionesList) {
        this.calificacionesList = calificacionesList;
    }

    @XmlTransient
    public List<Calificaciones> getCalificacionesList1() {
        return calificacionesList1;
    }

    public void setCalificacionesList1(List<Calificaciones> calificacionesList1) {
        this.calificacionesList1 = calificacionesList1;
    }

    public DatosUsuario getDatosUsuario() {
        return datosUsuario;
    }

    public void setDatosUsuario(DatosUsuario datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    @XmlTransient
    public List<InformesNoticias> getInformesNoticiasList() {
        return informesNoticiasList;
    }

    public void setInformesNoticiasList(List<InformesNoticias> informesNoticiasList) {
        this.informesNoticiasList = informesNoticiasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarios != null ? idUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.gob.jalisco.entity.Usuarios[ idUsuarios=" + idUsuarios + " ]";
    }
    
}
