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
@Table(name = "ltcombustible")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ltcombustible.findAll", query = "SELECT l FROM Ltcombustible l"),
    @NamedQuery(name = "Ltcombustible.findByIdCombustible", query = "SELECT l FROM Ltcombustible l WHERE l.idCombustible = :idCombustible"),
    @NamedQuery(name = "Ltcombustible.findByLitrosTotales", query = "SELECT l FROM Ltcombustible l WHERE l.litrosTotales = :litrosTotales"),
    @NamedQuery(name = "Ltcombustible.findByRutaFotoCargas", query = "SELECT l FROM Ltcombustible l WHERE l.rutaFotoCargas = :rutaFotoCargas")})
public class Ltcombustible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCombustible")
    private Integer idCombustible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LitrosTotales")
    private int litrosTotales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RutaFotoCargas")
    private String rutaFotoCargas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKIdCombustible")
    private List<Chofer> choferList;

    public Ltcombustible() {
    }

    public Ltcombustible(Integer idCombustible) {
        this.idCombustible = idCombustible;
    }

    public Ltcombustible(Integer idCombustible, int litrosTotales, String rutaFotoCargas) {
        this.idCombustible = idCombustible;
        this.litrosTotales = litrosTotales;
        this.rutaFotoCargas = rutaFotoCargas;
    }

    public Integer getIdCombustible() {
        return idCombustible;
    }

    public void setIdCombustible(Integer idCombustible) {
        this.idCombustible = idCombustible;
    }

    public int getLitrosTotales() {
        return litrosTotales;
    }

    public void setLitrosTotales(int litrosTotales) {
        this.litrosTotales = litrosTotales;
    }

    public String getRutaFotoCargas() {
        return rutaFotoCargas;
    }

    public void setRutaFotoCargas(String rutaFotoCargas) {
        this.rutaFotoCargas = rutaFotoCargas;
    }

    @JsonbTransient
    public List<Chofer> getChoferList() {
        return choferList;
    }

    public void setChoferList(List<Chofer> choferList) {
        this.choferList = choferList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCombustible != null ? idCombustible.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ltcombustible)) {
            return false;
        }
        Ltcombustible other = (Ltcombustible) object;
        if ((this.idCombustible == null && other.idCombustible != null) || (this.idCombustible != null && !this.idCombustible.equals(other.idCombustible))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.Ltcombustible[ idCombustible=" + idCombustible + " ]";
    }
    
}
