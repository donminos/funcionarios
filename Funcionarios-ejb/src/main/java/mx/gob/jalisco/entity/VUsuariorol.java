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
import javax.persistence.Id;
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
@Table(name = "vUsuariorol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VUsuariorol.findAll", query = "SELECT v FROM VUsuariorol v"),
    @NamedQuery(name = "VUsuariorol.findByIdUsuarios", query = "SELECT v FROM VUsuariorol v WHERE v.idUsuarios = :idUsuarios"),
    @NamedQuery(name = "VUsuariorol.findByCorreo", query = "SELECT v FROM VUsuariorol v WHERE v.correo = :correo"),
    @NamedQuery(name = "VUsuariorol.findByContrasena", query = "SELECT v FROM VUsuariorol v WHERE v.contrasena = :contrasena"),
    @NamedQuery(name = "VUsuariorol.findByIdRoles", query = "SELECT v FROM VUsuariorol v WHERE v.idRoles = :idRoles"),
    @NamedQuery(name = "VUsuariorol.findByDescripcion", query = "SELECT v FROM VUsuariorol v WHERE v.descripcion = :descripcion")})
public class VUsuariorol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarios")
    @Id
    private int idUsuarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRoles")
    private int idRoles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Descripcion")
    private String descripcion;

    public VUsuariorol() {
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
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

    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
