package cl.com.dsf.ecoPetro.data.guia;

import cl.com.dsf.ecoPetro.modelo.Guia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

@Stateless
public class guiaDaoImpl implements guiaDao {
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    
    @Override
    public List<Guia> mostrarGuias() {
        return em.createNamedQuery("Guia.findAll").getResultList();
    }

    @Override
    public Guia encontrarGuiaPorNroGuia(Guia g) {
        return em.find(Guia.class, g.getNroGuia());
    }

    @Override
    public void agregarGuia(Guia g) {
        em.persist(g);
        em.flush();
    }

    @Override
    public void modificarGuia(Guia g) {
        em.merge(g);
    }

    @Override
    public void eliminarGuia(Guia g) {
        em.remove(em.merge(g));
    }

    @Override
    public List<Guia> listarGuiasPorFecha(String mes) {
        String strInicial = "2023/"+mes+"/1";
        String strFinal = "2023/"+mes+"/31";
        Date d1 = null,d2 = null;
        try {
            d1 = new SimpleDateFormat("yyyy/MM/dd").parse(strInicial);
            d2 = new SimpleDateFormat("yyyy/MM/dd").parse(strFinal);
            
        } catch (ParseException ex) {
            Logger.getLogger(guiaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return em.createNamedQuery("Guia.findByMonthSelected").setParameter("fechaInicial", d1 ,TemporalType.DATE)
                .setParameter("fechaFinal", d2, TemporalType.DATE).getResultList();
    }
    
}
