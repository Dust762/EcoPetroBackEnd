package cl.com.dsf.ecoPetro.data.viaje;

import cl.com.dsf.ecoPetro.modelo.Viaje;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class viajeDaoImpl implements viajeDao{
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    @Override
    public List<Viaje> mostrarViajes() {
        return em.createNamedQuery("Viaje.findAll").getResultList();
    }

    @Override
    public Viaje encontrarViajePorId(Viaje v) {
        return em.find(Viaje.class, v.getIdViajes());
    }

    @Override
    public void crearViaje(Viaje v) {
        em.persist(v);
        em.flush();
    }

    @Override
    public void modificarViaje(Viaje v) {
        em.merge(v);
    }

    @Override
    public void eliminarViaje(Viaje v) {
        em.remove(em.merge(v));
    }
    
}
