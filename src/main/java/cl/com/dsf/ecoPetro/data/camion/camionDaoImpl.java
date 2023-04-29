package cl.com.dsf.ecoPetro.data.camion;

import cl.com.dsf.ecoPetro.modelo.Camion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class camionDaoImpl implements camionDao{
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    @Override
    public List<Camion> mostrarCamiones() {
        return em.createNamedQuery("Camion.findAll").getResultList();
    }

    @Override
    public Camion encontrarCamionPorId(Camion c) {
        return em.find(Camion.class, c.getIdCamion());
    }

    @Override
    public void crearCamion(Camion c) {
        em.persist(c);
        em.flush();
    }

    @Override
    public void actualizarCamion(Camion c) {
        em.merge(c);
    }

    @Override
    public void eliminarCamion(Camion c) {
        em.remove(em.merge(c));
    }
    
}
