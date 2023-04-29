package cl.com.dsf.ecoPetro.data.tipoUsuario;

import cl.com.dsf.ecoPetro.modelo.TipoUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class tipoUsuarioDaoImpl implements tipoUsuarioDao{
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    
    @Override
    public List<TipoUsuario> mostrarTiposUsuarios() {
        return em.createNamedQuery("TipoUsuario.findAll").getResultList();
    }

    @Override
    public TipoUsuario encontrarTipoUsuarioPorId(TipoUsuario tu) {
        return em.find(TipoUsuario.class, tu.getIdTipoUsuarios());
    }

    @Override
    public void agregarTipoUsuario(TipoUsuario tu) {
        em.persist(tu);
    }

    @Override
    public void modificarTipoUsuario(TipoUsuario tu) {
        em.persist(tu);
    }

    @Override
    public void eliminarTipoUsuario(TipoUsuario tu) {
        em.remove(em.merge(tu));
    }
    
}
