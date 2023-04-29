package cl.com.dsf.ecoPetro.data.guia;

import cl.com.dsf.ecoPetro.modelo.Guia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
