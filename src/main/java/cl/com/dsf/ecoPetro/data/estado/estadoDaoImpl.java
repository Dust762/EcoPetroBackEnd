package cl.com.dsf.ecoPetro.data.estado;

import cl.com.dsf.ecoPetro.modelo.Estado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class estadoDaoImpl implements estadoDao{
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    
    @Override
    public List<Estado> mostrarEstados() {
        return em.createNamedQuery("Estado.findAll").getResultList();
    }

    @Override
    public Estado encontrarEstadoPorId(Estado e) {
        return em.find(Estado.class, e.getIdEstado());
    }

    @Override
    public void crearEstado(Estado e) {
        em.persist(e);
        em.flush();
    }

    @Override
    public void modificarEstado(Estado e) {
        em.merge(e);
    }

    @Override
    public void eliminarEstado(Estado e) {
        em.remove(em.merge(e));
    }
    
}
