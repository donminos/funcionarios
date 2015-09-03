/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Entity
@Table(name = "Calificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificaciones.findAll", query = "SELECT c FROM Calificaciones c"),
    @NamedQuery(name = "Calificaciones.findByIdCalificaciones", query = "SELECT c FROM Calificaciones c WHERE c.idCalificaciones = :idCalificaciones"),
    @NamedQuery(name = "Calificaciones.findByCalificacion", query = "SELECT c FROM Calificaciones c WHERE c.calificacion = :calificacion"),
    @NamedQuery(name = "Calificaciones.findByArchivo", query = "SELECT c FROM Calificaciones c WHERE c.archivo = :archivo"),
    @NamedQuery(name = "Calificaciones.findByFechaEvaluacion", query = "SELECT c FROM Calificaciones c WHERE c.fechaEvaluacion = :fechaEvaluacion")})
public class Calificaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCalificaciones")
    private Integer idCalificaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private short calificacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "justificacion")
    private String justificacion;
    @Size(max = 45)
    @Column(name = "archivo")
    private String archivo;
    @Column(name = "fechaEvaluacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEvaluacion;
    @JoinColumn(name = "funcionarioEvaluado", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuarios funcionarioEvaluado;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuarios idUsuarios;

    public Calificaciones() {
    }

    public Calificaciones(Integer idCalificaciones) {
        this.idCalificaciones = idCalificaciones;
    }

    public Calificaciones(Integer idCalificaciones, short calificacion, String justificacion) {
        this.idCalificaciones = idCalificaciones;
        this.calificacion = calificacion;
        this.justificacion = justificacion;
    }

    public Integer getIdCalificaciones() {
        return idCalificaciones;
    }

    public void setIdCalificaciones(Integer idCalificaciones) {
        this.idCalificaciones = idCalificaciones;
    }

    public short getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(short calificacion) {
        this.calificacion = calificacion;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Usuarios getFuncionarioEvaluado() {
        return funcionarioEvaluado;
    }

    public void setFuncionarioEvaluado(Usuarios funcionarioEvaluado) {
        this.funcionarioEvaluado = funcionarioEvaluado;
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
        hash += (idCalificaciones != null ? idCalificaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificaciones)) {
            return false;
        }
        Calificaciones other = (Calificaciones) object;
        if ((this.idCalificaciones == null && other.idCalificaciones != null) || (this.idCalificaciones != null && !this.idCalificaciones.equals(other.idCalificaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.gob.jalisco.entity.Calificaciones[ idCalificaciones=" + idCalificaciones + " ]";
    }
    
}
