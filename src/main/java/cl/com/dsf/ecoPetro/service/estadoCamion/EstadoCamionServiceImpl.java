package cl.com.dsf.ecoPetro.service.estadoCamion;

import cl.com.dsf.ecoPetro.data.estadoCamion.estadoCamionDao;
import cl.com.dsf.ecoPetro.modelo.EstadoCamion;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;

@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class EstadoCamionServiceImpl implements EstadoCamionService, EstadoCamionServiceRemote, EstadoCamionServiceWs{
    @Inject
    private estadoCamionDao ecd;
    
    @Resource
    private SessionContext contexto;

    @Override
    public List<EstadoCamion> mostrarEstadoCamiones() {
        return ecd.mostrarEstadoCamiones();
    }

    @Override
    public EstadoCamion encontrarEstadoPorId(EstadoCamion ec) {
        return ecd.encontrarEstadoCamionPorId(ec);
    }

    @Override
    public void crearEstadoCamion(EstadoCamion ec) {
        ecd.agregarEstadoCamion(ec);
    }

    @Override
    public void modificarEstadoCamion(EstadoCamion ec) {
        try {
            ecd.modificarEstadoCamion(ec);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarEstadoCamion(EstadoCamion ec) {
        ecd.eliminarEstadoCamion(ec);
    }
    
    
}
