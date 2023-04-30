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
@Table(name = "cargas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carga.findAll", query = "SELECT c FROM Carga c"),
    @NamedQuery(name = "Carga.findByIdCarga", query = "SELECT c FROM Carga c WHERE c.idCarga = :idCarga"),
    @NamedQuery(name = "Carga.findByTonelaje", query = "SELECT c FROM Carga c WHERE c.tonelaje = :tonelaje"),
    @NamedQuery(name = "Carga.findByTipo", query = "SELECT c FROM Carga c WHERE c.tipo = :tipo")})
public class Carga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarga")
    private Integer idCarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tonelaje")
    private int tonelaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKIdCarga")
    private List<Guia> guiaList;

    public Carga() {
    }

    public Carga(Integer idCarga) {
        this.idCarga = idCarga;
    }

    public Carga(Integer idCarga, int tonelaje, String tipo) {
        this.idCarga = idCarga;
        this.tonelaje = tonelaje;
        this.tipo = tipo;
    }

    public Integer getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(Integer idCarga) {
        this.idCarga = idCarga;
    }

    public int getTonelaje() {
        return tonelaje;
    }

    public void setTonelaje(int tonelaje) {
        this.tonelaje = tonelaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonbTransient
    public List<Guia> getGuiaList() {
        return guiaList;
    }

    public void setGuiaList(List<Guia> guiaList) {
        this.guiaList = guiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarga != null ? idCarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carga)) {
            return false;
        }
        Carga other = (Carga) object;
        if ((this.idCarga == null && other.idCarga != null) || (this.idCarga != null && !this.idCarga.equals(other.idCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.Carga[ idCarga=" + idCarga + " ]";
    }
    
}
