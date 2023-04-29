package cl.com.dsf.ecoPetro.service.carga;

import cl.com.dsf.ecoPetro.data.carga.cargaDao;
import cl.com.dsf.ecoPetro.modelo.Carga;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;

@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class CargaServiceImpl implements CargaService, CargaServiceRemote, CargaWs{
    @Inject
    private cargaDao cd;
    @Resource
    private SessionContext contexto;
    @Override
    public List<Carga> mostrarCargas() {
        return cd.mostrarCargas();
    }

    @Override
    public Carga encontrarCargaPorId(Carga c) {
        return cd.encontrarCargaPorId(c);
    }

    @Override
    public void crearCarga(Carga c) {
        cd.crearCarga(c);
    }

    @Override
    public void actualizarCarga(Carga c) {
        cd.actualizarCarga(c);
    }

    @Override
    public void eliminarCarga(Carga c) {
        try {
          cd.eliminarCarga(c);  
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }
    
}
