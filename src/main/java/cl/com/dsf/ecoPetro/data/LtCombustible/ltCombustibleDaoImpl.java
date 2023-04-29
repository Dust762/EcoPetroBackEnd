package cl.com.dsf.ecoPetro.data.LtCombustible;

import cl.com.dsf.ecoPetro.modelo.Ltcombustible;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class ltCombustibleDaoImpl implements ltCombustibleDao {
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    @Override
    public List<Ltcombustible> mostrarLtCombustibles() {
        return em.createNamedQuery("Ltcombustible.findAll").getResultList();
    }

    @Override
    public Ltcombustible encontrarLtCombustiblePorId(Ltcombustible lc) {
        return em.find(Ltcombustible.class, lc.getIdCombustible());
    }

    @Override
    public void agregarLtCombustible(Ltcombustible lc) {
        em.persist(lc);
        em.flush();
    }

    @Override
    public void modificarLtCombustible(Ltcombustible lc) {
        em.merge(lc);
    }

    @Override
    public void eliminarLtCombustible(Ltcombustible lc) {
        em.remove(em.merge(lc));
    }
    
}
