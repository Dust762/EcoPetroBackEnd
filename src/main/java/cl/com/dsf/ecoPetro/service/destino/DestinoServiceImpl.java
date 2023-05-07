package cl.com.dsf.ecoPetro.service.destino;

import cl.com.dsf.ecoPetro.data.destino.destinoDao;
import cl.com.dsf.ecoPetro.modelo.Destino;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class DestinoServiceImpl implements DestinoService, DestinoServiceRemote, DestinoServiceWs {
    @Inject
    private destinoDao dd;
    @Resource
    private SessionContext contexto;
    @Override
    public List<Destino> mostrarDestinos() {
        return dd.mostrarDestinos();
    }

    @Override
    public Destino encontrarDestinoPorId(Destino d) {
        return dd.encontrarDestinoPorId(d);
    }

    @Override
    public void agregarDestino(Destino d) {
        dd.agregarDestino(d);
    }

    @Override
    public void modificarDestino(Destino d) {
    try {
          dd.modificarDestino(d);  
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarDestino(Destino d) {
        dd.eliminarDestino(d);
    }
    
}
