package cl.com.dsf.ecoPetro.data.usuarioEstado;

import cl.com.dsf.ecoPetro.modelo.EstadoUsuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class estadoUsuarioDaoImpl implements estadoUsuarioDao {
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    
    
    @Override
    public List<EstadoUsuario> mostrarEstadosUsuarios() {
        return em.createNamedQuery("EstadoUsuario.findAll").getResultList();
    }

    @Override
    public EstadoUsuario encontrarEstadoUsuarioPorId(EstadoUsuario eu) {
        return em.find(EstadoUsuario.class, eu.getIdEstadoUsuarios());
    }

    @Override
    public void agregarEstadoUsuario(EstadoUsuario eu) {
        em.persist(eu);
        em.flush();
    }

    @Override
    public void modificarEstadoUsuario(EstadoUsuario eu) {
        em.merge(eu);
    }

    @Override
    public void eliminarEstadoUsuario(EstadoUsuario eu) {
        em.remove(em.merge(eu));
    }
    
}
