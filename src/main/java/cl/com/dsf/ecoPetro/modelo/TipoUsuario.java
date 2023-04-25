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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thege
 */
@Entity
@Table(name = "tipo_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t"),
    @NamedQuery(name = "TipoUsuario.findByIdTipoUsuarios", query = "SELECT t FROM TipoUsuario t WHERE t.idTipoUsuarios = :idTipoUsuarios"),
    @NamedQuery(name = "TipoUsuario.findByNombre", query = "SELECT t FROM TipoUsuario t WHERE t.nombre = :nombre")})
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipo_Usuarios")
    private Integer idTipoUsuarios;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKTipoUsuario")
    private List<Usuario> usuarioList;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer idTipoUsuarios) {
        this.idTipoUsuarios = idTipoUsuarios;
    }

    public Integer getIdTipoUsuarios() {
        return idTipoUsuarios;
    }

    public void setIdTipoUsuarios(Integer idTipoUsuarios) {
        this.idTipoUsuarios = idTipoUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idTipoUsuarios != null ? idTipoUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.idTipoUsuarios == null && other.idTipoUsuarios != null) || (this.idTipoUsuarios != null && !this.idTipoUsuarios.equals(other.idTipoUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.TipoUsuario[ idTipoUsuarios=" + idTipoUsuarios + " ]";
    }
    
}
