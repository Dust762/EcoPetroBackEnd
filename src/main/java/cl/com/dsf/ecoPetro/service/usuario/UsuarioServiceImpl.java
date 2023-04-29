package cl.com.dsf.ecoPetro.service.usuario;

import cl.com.dsf.ecoPetro.data.usuario.usuarioDao;
import cl.com.dsf.ecoPetro.modelo.Usuario;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;

@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class UsuarioServiceImpl implements UsuarioService, UsuarioServiceRemote, UsuarioWs {
    @Inject
    private usuarioDao ud;
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Usuario> mostrarUsuarios() {
        return ud.mostrarUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario u) {
        return ud.encontrarUsuarioPorId(u);
    }

    @Override
    public void agregarUsuario(Usuario u) {
        ud.agregarUsuario(u);
    }

    @Override
    public void modificarUsuario(Usuario u) {
        try {
            ud.modificarUsuario(u);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarUsuario(Usuario u) {
        ud.eliminarUsuario(u);
    }

}
