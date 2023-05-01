/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.com.dsf.ecoPetro.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thege
 */
@Entity
@Table(name = "guias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guia.findAll", query = "SELECT g FROM Guia g"),
    @NamedQuery(name = "Guia.findByNroGuia", query = "SELECT g FROM Guia g WHERE g.nroGuia = :nroGuia"),
    @NamedQuery(name = "Guia.findByLtrConsumidos", query = "SELECT g FROM Guia g WHERE g.ltrConsumidos = :ltrConsumidos"),
    @NamedQuery(name = "Guia.findByFecha", query = "SELECT g FROM Guia g WHERE g.fecha = :fecha"),
    @NamedQuery(name = "Guia.findByMonthSelected", query = "SELECT g FROM Guia g WHERE g.fecha BETWEEN :fechaInicial AND :fechaFinal")
    })
public class Guia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NroGuia")
    private Integer nroGuia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LtrConsumidos")
    private int ltrConsumidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    @JsonbDateFormat(value = "yyyy/MM/dd")
    private Date fecha;
    @JoinColumn(name = "FK_idViajes", referencedColumnName = "idViajes")
    @ManyToOne(optional = false)
    private Viaje fKidViajes;
    @JoinColumn(name = "FK_IdCarga", referencedColumnName = "idCarga")
    @ManyToOne(optional = false)
    private Carga fKIdCarga;
    @JoinColumn(name = "FK_IdChofer", referencedColumnName = "Id_Usuario")
    @ManyToOne(optional = false)
    private Chofer fKIdChofer;

    public Guia() {
    }

    public Guia(Integer nroGuia) {
        this.nroGuia = nroGuia;
    }

    public Guia(Integer nroGuia, int ltrConsumidos, Date fecha) {
        this.nroGuia = nroGuia;
        this.ltrConsumidos = ltrConsumidos;
        this.fecha = fecha;
    }

    public Integer getNroGuia() {
        return nroGuia;
    }

    public void setNroGuia(Integer nroGuia) {
        this.nroGuia = nroGuia;
    }

    public int getLtrConsumidos() {
        return ltrConsumidos;
    }

    public void setLtrConsumidos(int ltrConsumidos) {
        this.ltrConsumidos = ltrConsumidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Viaje getFKidViajes() {
        return fKidViajes;
    }

    public void setFKidViajes(Viaje fKidViajes) {
        this.fKidViajes = fKidViajes;
    }

    public Carga getFKIdCarga() {
        return fKIdCarga;
    }

    public void setFKIdCarga(Carga fKIdCarga) {
        this.fKIdCarga = fKIdCarga;
    }

    public Chofer getFKIdChofer() {
        return fKIdChofer;
    }

    public void setFKIdChofer(Chofer fKIdChofer) {
        this.fKIdChofer = fKIdChofer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroGuia != null ? nroGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guia)) {
            return false;
        }
        Guia other = (Guia) object;
        if ((this.nroGuia == null && other.nroGuia != null) || (this.nroGuia != null && !this.nroGuia.equals(other.nroGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.com.dsf.ecoPetro.modelo.Guia[ nroGuia=" + nroGuia + " ]";
    }
    
}
