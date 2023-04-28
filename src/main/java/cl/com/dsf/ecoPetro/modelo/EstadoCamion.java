/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.com.dsf.ecoPetro.modelo;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
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
 * @author thege
 */
@Entity
@Table(name = "estadocamion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoamion.findAll", query = "SELECT e FROM Estadocamion e"),
    @NamedQuery(name = "Estadocamion.findByIdEstadoCamion", query = "SELECT e FROM Estadocamion e WHERE e.idEstadoCamion = :idEstadoCamion"),
    @NamedQuery(name = "Estadocamion.findByNombreEstadoCamion", query = "SELECT e FROM Estadocamion e WHERE e.nombreEstadoCamion = :nombreEstadoCamion")})
public class EstadoCamion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoCamion")
    private Integer idEstadoCamion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NombreEstadoCamion")
    private String nombreEstadoCamion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKidEstadoCamion")
    private List<Camion> camionList;

    public EstadoCamion() {
    }

    public EstadoCamion(Integer idEstadoCamion) {
        this.idEstadoCamion = idEstadoCamion;
    }

    public EstadoCamion(Integer idEstadoCamion, String nombreEstadoCamion) {
        this.idEstadoCamion = idEstadoCamion;
        this.nombreEstadoCamion = nombreEstadoCamion;
    }

    public Integer getIdEstadoCamion() {
        return idEstadoCamion;
    }

    public void setIdEstadoCamion(Integer idEstadoCamion) {
        this.idEstadoCamion = idEstadoCamion;
    }

    public String getNombreEstadoCamion() {
        return nombreEstadoCamion;
    }

    public void setNombreEstadoCamion(String nombreEstadoCamion) {
        this.nombreEstadoCamion = nombreEstadoCamion;
    }

    @JsonbTransient
    public List<Camion> getCamionList() {
        return camionList;
    }

    public void setCamionList(List<Camion> camionList) {
        this.camionList = camionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCamion != null ? idEstadoCamion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCamion)) {
            return false;
        }
        EstadoCamion other = (EstadoCamion) object;
        if ((this.idEstadoCamion == null && other.idEstadoCamion != null) || (this.idEstadoCamion != null && !this.idEstadoCamion.equals(other.idEstadoCamion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.Estadocamion[ idEstadoCamion=" + idEstadoCamion + " ]";
    }
    
}
