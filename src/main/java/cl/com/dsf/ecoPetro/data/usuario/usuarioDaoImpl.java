package cl.com.dsf.ecoPetro.data.usuario;

import cl.com.dsf.ecoPetro.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class usuarioDaoImpl implements usuarioDao {
    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;
    
    @Override
    public List<Usuario> mostrarUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario u) {
        return em.find(Usuario.class, u.getIdUsuario());
    }

    @Override
    public void agregarUsuario(Usuario u) {
        em.persist(u);
        em.flush();
    }

    @Override
    public void modificarUsuario(Usuario u) {
        em.merge(u);
    }

    @Override
    public void eliminarUsuario(Usuario u) {
        em.remove(em.merge(u));
    }
    
}
