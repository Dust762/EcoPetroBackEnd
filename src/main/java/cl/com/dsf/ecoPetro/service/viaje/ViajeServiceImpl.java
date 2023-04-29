package cl.com.dsf.ecoPetro.service.viaje;

import cl.com.dsf.ecoPetro.data.viaje.viajeDao;
import cl.com.dsf.ecoPetro.modelo.Viaje;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class ViajeServiceImpl implements ViajeService, ViajeServiceRemote, ViajeWs {
    @Inject
    private viajeDao vd;
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Viaje> mostrarViajes() {
        return vd.mostrarViajes();
    }

    @Override
    public Viaje encontrarViajePorId(Viaje v) {
        return vd.encontrarViajePorId(v);
    }

    @Override
    public void crearViaje(Viaje v) {
        vd.crearViaje(v);
    }

    @Override
    public void modificarViaje(Viaje v) {
        
        try {
          vd.modificarViaje(v);  
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarViaje(Viaje v) {
        vd.eliminarViaje(v);
    }
    
}
