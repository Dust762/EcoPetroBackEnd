/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.com.dsf.ecoPetro.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thege
 */
@Entity
@Table(name = "foto_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FotoUsuario.findAll", query = "SELECT f FROM FotoUsuario f"),
    @NamedQuery(name = "FotoUsuario.findByIdFotoUsuarios", query = "SELECT f FROM FotoUsuario f WHERE f.idFotoUsuarios = :idFotoUsuarios"),
    @NamedQuery(name = "FotoUsuario.findByFechaCargaFoto", query = "SELECT f FROM FotoUsuario f WHERE f.fechaCargaFoto = :fechaCargaFoto"),
    @NamedQuery(name = "FotoUsuario.findByRutaFotoUsuarios", query = "SELECT f FROM FotoUsuario f WHERE f.rutaFotoUsuarios = :rutaFotoUsuarios")})
public class FotoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFoto_Usuarios")
    private Integer idFotoUsuarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCargaFoto")
    @Temporal(TemporalType.DATE)
    @JsonbDateFormat(value = "yyyy/MM/dd")
    private Date fechaCargaFoto;
    @Size(max = 100)
    @Column(name = "rutaFotoUsuarios")
    private String rutaFotoUsuarios;
    @JoinColumn(name = "FK_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario fKidUsuario;

    public FotoUsuario() {
    }

    public FotoUsuario(Integer idFotoUsuarios) {
        this.idFotoUsuarios = idFotoUsuarios;
    }

    public FotoUsuario(Integer idFotoUsuarios, Date fechaCargaFoto) {
        this.idFotoUsuarios = idFotoUsuarios;
        this.fechaCargaFoto = fechaCargaFoto;
    }

    public Integer getIdFotoUsuarios() {
        return idFotoUsuarios;
    }

    public void setIdFotoUsuarios(Integer idFotoUsuarios) {
        this.idFotoUsuarios = idFotoUsuarios;
    }

    public Date getFechaCargaFoto() {
        return fechaCargaFoto;
    }

    public void setFechaCargaFoto(Date fechaCargaFoto) {
        this.fechaCargaFoto = fechaCargaFoto;
    }

    public String getRutaFotoUsuarios() {
        return rutaFotoUsuarios;
    }

    public void setRutaFotoUsuarios(String rutaFotoUsuarios) {
        this.rutaFotoUsuarios = rutaFotoUsuarios;
    }
    @JsonbTransient
    public Usuario getFKidUsuario() {
        return fKidUsuario;
    }

    public void setFKidUsuario(Usuario fKidUsuario) {
        this.fKidUsuario = fKidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFotoUsuarios != null ? idFotoUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotoUsuario)) {
            return false;
        }
        FotoUsuario other = (FotoUsuario) object;
        if ((this.idFotoUsuarios == null && other.idFotoUsuarios != null) || (this.idFotoUsuarios != null && !this.idFotoUsuarios.equals(other.idFotoUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.FotoUsuario[ idFotoUsuarios=" + idFotoUsuarios + " ]";
    }
    
}
