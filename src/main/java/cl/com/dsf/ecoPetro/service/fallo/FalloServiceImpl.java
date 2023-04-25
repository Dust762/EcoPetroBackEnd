package cl.com.dsf.ecoPetro.service.fallo;

import cl.com.dsf.ecoPetro.data.fallo.falloDao;
import cl.com.dsf.ecoPetro.modelo.Fallo;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;

@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class FalloServiceImpl implements FalloService, FalloServiceRemote, FalloServiceWs{
    @Inject
    private falloDao fd;
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Fallo> mostrarFallos() {
        return fd.mostrarFallos();
    }

    @Override
    public Fallo encontrarFalloPorId(Fallo f) {
        return fd.encontrarFalloPorId(f);
    }

    @Override
    public void agregarFallo(Fallo f) {
        fd.agregarFallo(f);
    }

    @Override
    public void modificarFallo(Fallo f) {
        try {
            fd.modificarFallo(f);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarFallo(Fallo f) {
        fd.eliminarFallo(f);
    }
    
}
