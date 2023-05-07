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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thege
 */
@Entity
@Table(name = "viajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v"),
    @NamedQuery(name = "Viaje.findByIdViajes", query = "SELECT v FROM Viaje v WHERE v.idViajes = :idViajes"),
    @NamedQuery(name = "Viaje.findByInicio", query = "SELECT v FROM Viaje v WHERE v.inicio = :inicio"),
    @NamedQuery(name = "Viaje.findByFinal1", query = "SELECT v FROM Viaje v WHERE v.final1 = :final1"),
    @NamedQuery(name = "Viaje.findByViatico", query = "SELECT v FROM Viaje v WHERE v.viatico = :viatico"),
    @NamedQuery(name = "Viaje.findByDistancia", query = "SELECT v FROM Viaje v WHERE v.distancia = :distancia")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idViajes")
    private Integer idViajes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Viatico")
    private int viatico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Distancia")
    private int distancia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKidViajes")
    private List<Guia> guiaList;
    @JoinColumn(name = "Inicio", referencedColumnName = "idDestinos")
    @ManyToOne(optional = false)
    private Destino inicio;
    @JoinColumn(name = "Final", referencedColumnName = "idDestinos")
    @ManyToOne(optional = false)
    private Destino final1;
    public Viaje() {
    }

    public Viaje(Integer idViajes) {
        this.idViajes = idViajes;
    }

    public Viaje(Integer idViajes, int viatico, int distancia) {
        this.idViajes = idViajes;
        this.viatico = viatico;
        this.distancia = distancia;
    }

    public Integer getIdViajes() {
        return idViajes;
    }

    public void setIdViajes(Integer idViajes) {
        this.idViajes = idViajes;
    }

    public Destino getFinal1() {
        return final1;
    }

    public void setFinal1(Destino final1) {
        this.final1 = final1;
    }

    public int getViatico() {
        return viatico;
    }

    public void setViatico(int viatico) {
        this.viatico = viatico;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @JsonbTransient
    public List<Guia> getGuiaList() {
        return guiaList;
    }

    public void setGuiaList(List<Guia> guiaList) {
        this.guiaList = guiaList;
    }

    public Destino getInicio() {
        return inicio;
    }

    public void setInicio(Destino inicio) {
        this.inicio = inicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViajes != null ? idViajes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.idViajes == null && other.idViajes != null) || (this.idViajes != null && !this.idViajes.equals(other.idViajes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.Viaje[ idViajes=" + idViajes + " ]";
    }
    
}
