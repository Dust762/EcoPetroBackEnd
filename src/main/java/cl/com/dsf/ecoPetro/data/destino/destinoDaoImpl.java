package cl.com.dsf.ecoPetro.data.destino;

import cl.com.dsf.ecoPetro.modelo.Destino;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class destinoDaoImpl implements destinoDao{
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    
    @Override
    public List<Destino> mostrarDestinos() {
        return em.createNamedQuery("Destino.findAll").getResultList();
    }

    @Override
    public Destino encontrarDestinoPorId(Destino d) {
        return em.find(Destino.class, d.getIdDestinos());
    }

    @Override
    public void agregarDestino(Destino d) {
        em.persist(d);
        em.flush();
    }

    @Override
    public void modificarDestino(Destino d) {
        em.merge(d);
    }

    @Override
    public void eliminarDestino(Destino d) {
        em.remove(em.merge(d));
    }
    
}
