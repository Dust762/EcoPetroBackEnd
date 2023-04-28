package cl.com.dsf.ecoPetro.data.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.EstadoCamion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class estadoCamionDaoImpl implements estadoCamionDao {
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    @Override
    public List<EstadoCamion> mostrarEstadoCamiones() {
        return em.createNamedQuery("Estadocamion.findAll").getResultList();
    }

    @Override
    public EstadoCamion encontrarEstadoCamionPorId(EstadoCamion ec) {
        return em.find(EstadoCamion.class, ec.getIdEstadoCamion());
    }

    @Override
    public void agregarEstadoCamion(EstadoCamion ec) {
        em.persist(ec);
        em.flush();
    }

    @Override
    public void modificarEstadoCamion(EstadoCamion ec) {
        em.merge(ec);
    }

    @Override
    public void eliminarEstadoCamion(EstadoCamion ec) {
        em.remove(em.merge(ec));
    }
    
}
