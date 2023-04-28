package cl.com.dsf.ecoPetro.service.usuarioEstado;

import cl.com.dsf.ecoPetro.data.usuarioEstado.estadoUsuarioDao;
import cl.com.dsf.ecoPetro.modelo.EstadoUsuario;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class EstadoUsuarioServiceImpl implements  EstadoUsuarioService, EstadoUsuarioServiceRemote, EstadoUsuarioWs{
    @Inject
    private estadoUsuarioDao eud;
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<EstadoUsuario> mostrarEstadosUsuarios() {
        return eud.mostrarEstadosUsuarios();
    }

    @Override
    public EstadoUsuario encontrarEstadoUsuarioPorId(EstadoUsuario eu) {
        return eud.encontrarEstadoUsuarioPorId(eu);
    }

    @Override
    public void agregarEstadoUsuario(EstadoUsuario eu) {
        eud.agregarEstadoUsuario(eu);
    }

    @Override
    public void modificarEstadoUsuario(EstadoUsuario eu) {
        
        try {
            eud.modificarEstadoUsuario(eu);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarEstadoUsuario(EstadoUsuario eu) {
        eud.eliminarEstadoUsuario(eu);
    }
    
}
