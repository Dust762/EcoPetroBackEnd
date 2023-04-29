package cl.com.dsf.ecoPetro.data.chofer;

import cl.com.dsf.ecoPetro.modelo.Chofer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class choferDaoImpl implements choferDao {
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    
    @Override
    public List<Chofer> mostrarChoferes() {
        return em.createNamedQuery("Chofer.findAll").getResultList();
    }

    @Override
    public Chofer encontrarChoferPorId(Chofer c) {
        return em.find(Chofer.class, c.getIdUsuario());
    }

    @Override
    public void agregarChofer(Chofer c) {
        em.persist(c);
        em.flush();
    }

    @Override
    public void modificarChofer(Chofer c) {
        em.merge(c);
    }

    @Override
    public void eliminarChofer(Chofer c) {
        em.remove(em.merge(c));
    }
    
}
