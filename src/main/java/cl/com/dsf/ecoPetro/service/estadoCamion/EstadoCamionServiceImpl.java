package cl.com.dsf.ecoPetro.service.estadoCamion;

import cl.com.dsf.ecoPetro.data.estadoCamion.estadoCamionDao;
import cl.com.dsf.ecoPetro.modelo.Estadocamion;
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
    public List<Estadocamion> mostrarEstadoCamiones() {
        return ecd.mostrarEstadoCamiones();
    }

    @Override
    public Estadocamion encontrarEstadoPorId(Estadocamion ec) {
        return ecd.encontrarEstadoCamionPorId(ec);
    }

    @Override
    public void crearEstadoCamion(Estadocamion ec) {
        ecd.agregarEstadoCamion(ec);
    }

    @Override
    public void modificarEstadoCamion(Estadocamion ec) {
        try {
            ecd.modificarEstadoCamion(ec);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarEstadoCamion(Estadocamion ec) {
        ecd.eliminarEstadoCamion(ec);
    }
    
    
}
