package cl.com.dsf.ecoPetro.service.tipoUsuario;

import cl.com.dsf.ecoPetro.data.tipoUsuario.tipoUsuarioDao;
import cl.com.dsf.ecoPetro.modelo.TipoUsuario;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;

@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class TipoUsuarioServiceImpl implements TipoUsuarioService, TipoUsuarioServiceRemote, TipoUsuarioWs{
    @Inject
    private tipoUsuarioDao tud;
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<TipoUsuario> mostrarTiposUsuarios() {
        return tud.mostrarTiposUsuarios();
    }

    @Override
    public TipoUsuario encontrarTipoUsuarioPorId(TipoUsuario tu) {
        return tud.encontrarTipoUsuarioPorId(tu);
    }

    @Override
    public void agregarTipoUsuario(TipoUsuario tu) {
        tud.agregarTipoUsuario(tu);
    }

    @Override
    public void modificarTipoUsuario(TipoUsuario tu) {
        try {
            tud.modificarTipoUsuario(tu);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
        
    }

    @Override
    public void eliminarTipoUsuario(TipoUsuario tu) {
        tud.eliminarTipoUsuario(tu);
    }
    
}
