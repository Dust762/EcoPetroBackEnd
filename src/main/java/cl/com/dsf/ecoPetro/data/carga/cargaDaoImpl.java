package cl.com.dsf.ecoPetro.data.carga;

import cl.com.dsf.ecoPetro.modelo.Carga;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class cargaDaoImpl implements cargaDao {
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    @Override
    public List<Carga> mostrarCargas() {
        return em.createNamedQuery("Carga.findAll").getResultList();
    }

    @Override
    public Carga encontrarCargaPorId(Carga c) {
        return em.find(Carga.class, c.getIdCarga());
    }

    @Override
    public void crearCarga(Carga c) {
        em.persist(c);
        em.flush();
    }

    @Override
    public void actualizarCarga(Carga c) {
        em.merge(c);
    }

    @Override
    public void eliminarCarga(Carga c) {
        em.remove(em.merge(c));
    }
    
}
