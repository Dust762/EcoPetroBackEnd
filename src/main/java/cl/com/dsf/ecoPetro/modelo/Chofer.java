/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.com.dsf.ecoPetro.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thege
 */
@Entity
@Table(name = "choferes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chofer.findAll", query = "SELECT c FROM Chofer c"),
    @NamedQuery(name = "Chofer.findByIdUsuario", query = "SELECT c FROM Chofer c WHERE c.idUsuario = :idUsuario")})
public class Chofer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Usuario")
    private Integer idUsuario;
    @JoinColumn(name = "FK_IdCombustible", referencedColumnName = "idCombustible")
    @ManyToOne(optional = false)
    private Ltcombustible fKIdCombustible;
    @JoinColumn(name = "Id_Usuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "FK_idCamion", referencedColumnName = "idCamion")
    @ManyToOne(optional = false)
    private Camion fKidCamion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKIdChofer")
    private List<Guia> guiaList;

    public Chofer() {
    }

    public Chofer(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Ltcombustible getFKIdCombustible() {
        return fKIdCombustible;
    }

    public void setFKIdCombustible(Ltcombustible fKIdCombustible) {
        this.fKIdCombustible = fKIdCombustible;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Camion getFKidCamion() {
        return fKidCamion;
    }

    public void setFKidCamion(Camion fKidCamion) {
        this.fKidCamion = fKidCamion;
    }

    @XmlTransient
    public List<Guia> getGuiaList() {
        return guiaList;
    }

    public void setGuiaList(List<Guia> guiaList) {
        this.guiaList = guiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chofer)) {
            return false;
        }
        Chofer other = (Chofer) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.Chofer[ idUsuario=" + idUsuario + " ]";
    }
    
}
