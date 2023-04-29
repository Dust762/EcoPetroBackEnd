package cl.com.dsf.ecoPetro.data.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.Estadocamion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class estadoCamionDaoImpl implements estadoCamionDao {
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    @Override
    public List<Estadocamion> mostrarEstadoCamiones() {
        return em.createNamedQuery("Estadocamion.findAll").getResultList();
    }

    @Override
    public Estadocamion encontrarEstadoCamionPorId(Estadocamion ec) {
        return em.find(Estadocamion.class, ec.getIdEstadoCamion());
    }

    @Override
    public void agregarEstadoCamion(Estadocamion ec) {
        em.persist(ec);
        em.flush();
    }

    @Override
    public void modificarEstadoCamion(Estadocamion ec) {
        em.merge(ec);
    }

    @Override
    public void eliminarEstadoCamion(Estadocamion ec) {
        em.remove(em.merge(ec));
    }
    
}
