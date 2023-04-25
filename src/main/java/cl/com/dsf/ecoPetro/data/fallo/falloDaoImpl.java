package cl.com.dsf.ecoPetro.data.fallo;

import cl.com.dsf.ecoPetro.modelo.Fallo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class falloDaoImpl implements falloDao{
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    
    @Override
    public List<Fallo> mostrarFallos() {
        return em.createNamedQuery("Fallo.findAll").getResultList();
    }

    @Override
    public Fallo encontrarFalloPorId(Fallo f) {
        return em.find(Fallo.class, f.getIdFallos());
    }

    @Override
    public void agregarFallo(Fallo f) {
        em.persist(f);
        em.flush();
    }

    @Override
    public void modificarFallo(Fallo f) {
        em.merge(f);
    }

    @Override
    public void eliminarFallo(Fallo f) {
        em.remove(em.merge(f));
    }
    
}
