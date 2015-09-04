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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "EvaluacionesCalificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionesCalificacion.findAll", query = "SELECT e FROM EvaluacionesCalificacion e"),
    @NamedQuery(name = "EvaluacionesCalificacion.findByIdEvaluacionesCalificacion", query = "SELECT e FROM EvaluacionesCalificacion e WHERE e.idEvaluacionesCalificacion = :idEvaluacionesCalificacion"),
    @NamedQuery(name = "EvaluacionesCalificacion.findByDescripcion", query = "SELECT e FROM EvaluacionesCalificacion e WHERE e.descripcion = :descripcion")})
public class EvaluacionesCalificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEvaluacionesCalificacion")
    private Short idEvaluacionesCalificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluado")
    private List<Calificaciones> calificacionesList;

    public EvaluacionesCalificacion() {
    }

    public EvaluacionesCalificacion(Short idEvaluacionesCalificacion) {
        this.idEvaluacionesCalificacion = idEvaluacionesCalificacion;
    }

    public EvaluacionesCalificacion(Short idEvaluacionesCalificacion, String descripcion) {
        this.idEvaluacionesCalificacion = idEvaluacionesCalificacion;
        this.descripcion = descripcion;
    }

    public Short getIdEvaluacionesCalificacion() {
        return idEvaluacionesCalificacion;
    }

    public void setIdEvaluacionesCalificacion(Short idEvaluacionesCalificacion) {
        this.idEvaluacionesCalificacion = idEvaluacionesCalificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Calificaciones> getCalificacionesList() {
        return calificacionesList;
    }

    public void setCalificacionesList(List<Calificaciones> calificacionesList) {
        this.calificacionesList = calificacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluacionesCalificacion != null ? idEvaluacionesCalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionesCalificacion)) {
            return false;
        }
        EvaluacionesCalificacion other = (EvaluacionesCalificacion) object;
        if ((this.idEvaluacionesCalificacion == null && other.idEvaluacionesCalificacion != null) || (this.idEvaluacionesCalificacion != null && !this.idEvaluacionesCalificacion.equals(other.idEvaluacionesCalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.gob.jalisco.entity.EvaluacionesCalificacion[ idEvaluacionesCalificacion=" + idEvaluacionesCalificacion + " ]";
    }
    
}
