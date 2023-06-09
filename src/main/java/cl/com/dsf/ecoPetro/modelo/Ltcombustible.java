/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.com.dsf.ecoPetro.modelo;

import cl.com.dsf.ecoPetro.resources.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;
import static javax.json.bind.annotation.JsonbDateFormat.DEFAULT_FORMAT;
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
@Table(name = "ltcombustible")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ltcombustible.findAll", query = "SELECT l FROM Ltcombustible l"),
    @NamedQuery(name = "Ltcombustible.findByIdCombustible", query = "SELECT l FROM Ltcombustible l WHERE l.idCombustible = :idCombustible"),
    @NamedQuery(name = "Ltcombustible.findByLitrosTotales", query = "SELECT l FROM Ltcombustible l WHERE l.litrosTotales = :litrosTotales"),
    @NamedQuery(name = "Ltcombustible.findByNombreFotoCarga", query = "SELECT l FROM Ltcombustible l WHERE l.nombreFotoCarga = :nombreFotoCarga"),
    @NamedQuery(name = "Ltcombustible.findByFechaCarga", query = "SELECT l FROM Ltcombustible l WHERE l.fechaCarga = :fechaCarga")})
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
    @Column(name = "nombreFotoCarga")
    private String nombreFotoCarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCarga")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaCarga;
    @JoinColumn(name = "FK_idChofer", referencedColumnName = "Id_Usuario")
    @ManyToOne(optional = false)
    private Chofer fKidChofer;

    public Ltcombustible() {
    }

    public Ltcombustible(Integer idCombustible) {
        this.idCombustible = idCombustible;
    }

    public Ltcombustible(Integer idCombustible, int litrosTotales, String nombreFotoCarga, Date fechaCarga) {
        this.idCombustible = idCombustible;
        this.litrosTotales = litrosTotales;
        this.nombreFotoCarga = nombreFotoCarga;
        this.fechaCarga = fechaCarga;
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

    public String getNombreFotoCarga() {
        return nombreFotoCarga;
    }

    public void setNombreFotoCarga(String nombreFotoCarga) {
        this.nombreFotoCarga = nombreFotoCarga;
    }
    @JsonbDateFormat(value = "yyyy-MM-dd")
    public Date getFechaCarga() {
        return fechaCarga;
    }
    @JsonbDateFormat(value = "yyyy-MM-dd")
    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Chofer getFKidChofer() {
        return fKidChofer;
    }

    public void setFKidChofer(Chofer fKidChofer) {
        this.fKidChofer = fKidChofer;
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
