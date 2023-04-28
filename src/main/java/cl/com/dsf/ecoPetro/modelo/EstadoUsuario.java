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
@Table(name = "estado_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoUsuario.findAll", query = "SELECT e FROM EstadoUsuario e"),
    @NamedQuery(name = "EstadoUsuario.findByIdEstadoUsuarios", query = "SELECT e FROM EstadoUsuario e WHERE e.idEstadoUsuarios = :idEstadoUsuarios"),
    @NamedQuery(name = "EstadoUsuario.findByNombreEstado", query = "SELECT e FROM EstadoUsuario e WHERE e.nombreEstado = :nombreEstado")})
public class EstadoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoUsuarios")
    private Integer idEstadoUsuarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NombreEstado")
    private String nombreEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoUsuario")
    private List<Usuario> usuarioList;

    public EstadoUsuario() {
    }

    public EstadoUsuario(Integer idEstadoUsuarios) {
        this.idEstadoUsuarios = idEstadoUsuarios;
    }

    public EstadoUsuario(Integer idEstadoUsuarios, String nombreEstado) {
        this.idEstadoUsuarios = idEstadoUsuarios;
        this.nombreEstado = nombreEstado;
    }

    public Integer getIdEstadoUsuarios() {
        return idEstadoUsuarios;
    }

    public void setIdEstadoUsuarios(Integer idEstadoUsuarios) {
        this.idEstadoUsuarios = idEstadoUsuarios;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @JsonbTransient
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
        if (!(object instanceof EstadoUsuario)) {
            return false;
        }
        EstadoUsuario other = (EstadoUsuario) object;
        if ((this.idEstadoUsuarios == null && other.idEstadoUsuarios != null) || (this.idEstadoUsuarios != null && !this.idEstadoUsuarios.equals(other.idEstadoUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.EstadoUsuario[ idEstadoUsuarios=" + idEstadoUsuarios + " ]";
    }
    
}
