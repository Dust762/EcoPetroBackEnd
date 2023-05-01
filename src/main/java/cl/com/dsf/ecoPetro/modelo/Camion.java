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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "camiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camion.findAll", query = "SELECT c FROM Camion c"),
    @NamedQuery(name = "Camion.findByIdCamion", query = "SELECT c FROM Camion c WHERE c.idCamion = :idCamion"),
    @NamedQuery(name = "Camion.findByPatente", query = "SELECT c FROM Camion c WHERE c.patente = :patente"),
    @NamedQuery(name = "Camion.findByMarca", query = "SELECT c FROM Camion c WHERE c.marca = :marca"),
    @NamedQuery(name = "Camion.findByCapacidad", query = "SELECT c FROM Camion c WHERE c.capacidad = :capacidad")})
public class Camion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCamion")
    private Integer idCamion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "Patente")
    private String patente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Capacidad")
    private short capacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKidCamion")
    private List<Chofer> choferList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKIdCamion")
    private List<Fallo> falloList;
    @JoinColumn(name = "FK_idEstadoCamion", referencedColumnName = "idEstadoCamion")
    @ManyToOne(optional = false)
    private Estadocamion fKidEstadoCamion;

    public Camion() {
    }

    public Camion(Integer idCamion) {
        this.idCamion = idCamion;
    }

    public Camion(Integer idCamion, String patente, String marca, short capacidad) {
        this.idCamion = idCamion;
        this.patente = patente;
        this.marca = marca;
        this.capacidad = capacidad;
    }

    public Integer getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(Integer idCamion) {
        this.idCamion = idCamion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    
    public List<Chofer> getChoferList() {
        return choferList;
    }

    public void setChoferList(List<Chofer> choferList) {
        this.choferList = choferList;
    }

    @JsonbTransient
    public List<Fallo> getFalloList() {
        return falloList;
    }

    public void setFalloList(List<Fallo> falloList) {
        this.falloList = falloList;
    }
    @JsonbTransient
    public Estadocamion getFKidEstadoCamion() {
        return fKidEstadoCamion;
    }

    public void setFKidEstadoCamion(Estadocamion fKidEstadoCamion) {
        this.fKidEstadoCamion = fKidEstadoCamion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCamion != null ? idCamion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.idCamion == null && other.idCamion != null) || (this.idCamion != null && !this.idCamion.equals(other.idCamion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.Camion[ idCamion=" + idCamion + " ]";
    }
    
}
