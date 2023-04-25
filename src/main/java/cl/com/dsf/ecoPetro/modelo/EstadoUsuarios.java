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
@Table(name = "estadousuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoUsuarios.findAll", query = "SELECT e FROM EstadoUsuarios e"),
    @NamedQuery(name = "EstadoUsuarios.findByIdEstadoUsuarios", query = "SELECT e FROM EstadoUsuarios e WHERE e.idEstadoUsuarios = :idEstadoUsuarios"),
    @NamedQuery(name = "EstadoUsuarios.findByNombreEstadi", query = "SELECT e FROM EstadoUsuarios e WHERE e.nombreEstadi = :nombreEstadi")})
public class EstadoUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoUsuarios")
    private Integer idEstadoUsuarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NombreEstadi")
    private String nombreEstadi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoUsuario")
    private List<Usuario> usuarioList;

    public EstadoUsuarios() {
    }

    public EstadoUsuarios(Integer idEstadoUsuarios) {
        this.idEstadoUsuarios = idEstadoUsuarios;
    }

    public EstadoUsuarios(Integer idEstadoUsuarios, String nombreEstadi) {
        this.idEstadoUsuarios = idEstadoUsuarios;
        this.nombreEstadi = nombreEstadi;
    }

    public Integer getIdEstadoUsuarios() {
        return idEstadoUsuarios;
    }

    public void setIdEstadoUsuarios(Integer idEstadoUsuarios) {
        this.idEstadoUsuarios = idEstadoUsuarios;
    }

    public String getNombreEstadi() {
        return nombreEstadi;
    }

    public void setNombreEstadi(String nombreEstadi) {
        this.nombreEstadi = nombreEstadi;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoUsuarios != null ? idEstadoUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoUsuarios)) {
            return false;
        }
        EstadoUsuarios other = (EstadoUsuarios) object;
        if ((this.idEstadoUsuarios == null && other.idEstadoUsuarios != null) || (this.idEstadoUsuarios != null && !this.idEstadoUsuarios.equals(other.idEstadoUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.EstadoUsuarios[ idEstadoUsuarios=" + idEstadoUsuarios + " ]";
    }
    
}
