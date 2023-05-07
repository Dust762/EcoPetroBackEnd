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
@Table(name = "destinos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destino.findAll", query = "SELECT d FROM Destino d"),
    @NamedQuery(name = "Destino.findByIdDestinos", query = "SELECT d FROM Destino d WHERE d.idDestinos = :idDestinos"),
    @NamedQuery(name = "Destino.findByNombre", query = "SELECT d FROM Destino d WHERE d.nombre = :nombre")})
public class Destino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDestinos")
    private Integer idDestinos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inicio")
    private List<Viaje> viajeList;

    public Destino() {
    }

    public Destino(Integer idDestinos) {
        this.idDestinos = idDestinos;
    }

    public Destino(Integer idDestinos, String nombre) {
        this.idDestinos = idDestinos;
        this.nombre = nombre;
    }

    public Integer getIdDestinos() {
        return idDestinos;
    }

    public void setIdDestinos(Integer idDestinos) {
        this.idDestinos = idDestinos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonbTransient
    public List<Viaje> getViajeList() {
        return viajeList;
    }

    public void setViajeList(List<Viaje> viajeList) {
        this.viajeList = viajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDestinos != null ? idDestinos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destino)) {
            return false;
        }
        Destino other = (Destino) object;
        if ((this.idDestinos == null && other.idDestinos != null) || (this.idDestinos != null && !this.idDestinos.equals(other.idDestinos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.Destino[ idDestinos=" + idDestinos + " ]";
    }
    
}
