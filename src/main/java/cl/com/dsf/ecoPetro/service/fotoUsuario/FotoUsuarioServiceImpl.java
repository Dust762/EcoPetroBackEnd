package cl.com.dsf.ecoPetro.service.fotoUsuario;

import cl.com.dsf.ecoPetro.data.fotoUsuario.fotoUsuarioDao;
import cl.com.dsf.ecoPetro.modelo.FotoUsuario;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;

@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class FotoUsuarioServiceImpl implements FotoUsuarioService, FotoUsuarioServiceRemote, FotoUsuarioWs{
    @Inject
    private fotoUsuarioDao fud;
    @Resource
    private SessionContext contexto;
    @Override
    public List<FotoUsuario> mostrarFotoUsuarios() {
        return fud.mostrarFotoUsuarios();
    }

    @Override
    public FotoUsuario encontrarFotoUsuarioPorId(FotoUsuario fu) {
        return fud.encontrarFotoUsuarioPorId(fu);
    }

    @Override
    public void agregarFotoUsuario(FotoUsuario fu) {
        fud.agregarFotoUsuario(fu);
    }

    @Override
    public void actualizarFotoUsuario(FotoUsuario fu) {
        try {
            fud.actualizarFotoUsuario(fu);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarFotoUsuario(FotoUsuario fu) {
        fud.eliminarFotoUsuario(fu);
    }
    
}
