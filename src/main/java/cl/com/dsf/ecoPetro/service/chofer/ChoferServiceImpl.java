package cl.com.dsf.ecoPetro.service.chofer;

import cl.com.dsf.ecoPetro.data.chofer.choferDao;
import cl.com.dsf.ecoPetro.modelo.Chofer;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;

@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class ChoferServiceImpl implements ChoferService, ChoferServiceRemote, ChoferWs{
    @Inject
    private choferDao cd;
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Chofer> mostrarChoferes() {
        return cd.mostrarChoferes();
    }

    @Override
    public Chofer encontrarChoferPorId(Chofer c) {
        return cd.encontrarChoferPorId(c);
    }

    @Override
    public void agregarChofer(Chofer c) {
        cd.agregarChofer(c);
    }

    @Override
    public void modificarChofer(Chofer c) {
        try {
            cd.modificarChofer(c);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarChofer(Chofer c) {
        cd.eliminarChofer(c);
    }
    
}
