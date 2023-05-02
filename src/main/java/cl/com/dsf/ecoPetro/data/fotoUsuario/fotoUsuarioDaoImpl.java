package cl.com.dsf.ecoPetro.data.fotoUsuario;

import cl.com.dsf.ecoPetro.modelo.FotoUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class fotoUsuarioDaoImpl implements fotoUsuarioDao{
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    @Override
    public List<FotoUsuario> mostrarFotoUsuarios() {
        return em.createNamedQuery("FotoUsuario.findAll").getResultList();
    }

    @Override
    public FotoUsuario encontrarFotoUsuarioPorId(FotoUsuario fu) {
        return em.find(FotoUsuario.class, fu.getIdFotoUsuarios());
    }

    @Override
    public void agregarFotoUsuario(FotoUsuario fu) {
        em.persist(fu);
        em.flush();
    }

    @Override
    public void actualizarFotoUsuario(FotoUsuario fu) {
        em.merge(fu);
    }

    @Override
    public void eliminarFotoUsuario(FotoUsuario fu) {
        em.remove(fu);
    }
    
}
