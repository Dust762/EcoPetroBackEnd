/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.com.dsf.ecoPetro.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thege
 */
@Entity
@Table(name = "fallos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fallo.findAll", query = "SELECT f FROM Fallo f"),
    @NamedQuery(name = "Fallo.findByIdFallos", query = "SELECT f FROM Fallo f WHERE f.idFallos = :idFallos"),
    @NamedQuery(name = "Fallo.findByDescripcion", query = "SELECT f FROM Fallo f WHERE f.descripcion = :descripcion")})
public class Fallo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFallos")
    private Integer idFallos;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "FK_IdEstado", referencedColumnName = "idEstado")
    @OneToOne(optional = false)
    private Estado fKIdEstado;
    @JoinColumn(name = "FK_IdCamion", referencedColumnName = "idCamion")
    @ManyToOne(optional = false)
    private Camion fKIdCamion;

    public Fallo() {
    }

    public Fallo(Integer idFallos) {
        this.idFallos = idFallos;
    }

    public Integer getIdFallos() {
        return idFallos;
    }

    public void setIdFallos(Integer idFallos) {
        this.idFallos = idFallos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getFKIdEstado() {
        return fKIdEstado;
    }

    public void setFKIdEstado(Estado fKIdEstado) {
        this.fKIdEstado = fKIdEstado;
    }

    public Camion getFKIdCamion() {
        return fKIdCamion;
    }

    public void setFKIdCamion(Camion fKIdCamion) {
        this.fKIdCamion = fKIdCamion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFallos != null ? idFallos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fallo)) {
            return false;
        }
        Fallo other = (Fallo) object;
        if ((this.idFallos == null && other.idFallos != null) || (this.idFallos != null && !this.idFallos.equals(other.idFallos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.Fallo[ idFallos=" + idFallos + " ]";
    }
    
}
