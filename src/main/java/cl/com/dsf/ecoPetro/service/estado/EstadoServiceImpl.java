package cl.com.dsf.ecoPetro.service.estado;

import cl.com.dsf.ecoPetro.data.estado.estadoDao;
import cl.com.dsf.ecoPetro.data.fallo.falloDao;
import cl.com.dsf.ecoPetro.modelo.Estado;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class EstadoServiceImpl implements EstadoService, EstadoServiceRemote, EstadoServiceWs {
    @Inject
    private estadoDao ed;
    @Inject
    private falloDao fd;
    @Resource
    private SessionContext contexto;
    @Override
    public List<Estado> mostrarEstados() {
        return ed.mostrarEstados();
    }

    @Override
    public Estado encontrarEstadoPorId(Estado e) {
        return ed.encontrarEstadoPorId(e);
    }

    @Override
    public void crearEstado(Estado e) {
        ed.crearEstado(e);
    }

    @Override
    public void modificarEstado(Estado e) {
        try {
            ed.modificarEstado(e);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarEstado(Estado e) {
        ed.eliminarEstado(e);
    }

    
}
