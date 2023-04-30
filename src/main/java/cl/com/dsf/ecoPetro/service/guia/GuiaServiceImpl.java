package cl.com.dsf.ecoPetro.service.guia;

import cl.com.dsf.ecoPetro.data.guia.guiaDao;
import cl.com.dsf.ecoPetro.modelo.Guia;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class GuiaServiceImpl implements GuiaService, GuiaServiceRemote, GuiaWs {
    @Inject
    private guiaDao gd;
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Guia> mostrarGuias() {
        return gd.mostrarGuias();
    }

    @Override
    public Guia encontrarGuiaPorNroGuia(Guia g) {
        return gd.encontrarGuiaPorNroGuia(g);
    }

    @Override
    public void agregarGuia(Guia g) {
        gd.agregarGuia(g);
    }

    @Override
    public void modificarGuia(Guia g) {
        try {
            gd.modificarGuia(g);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarGuia(Guia g) {
        gd.eliminarGuia(g);
    }
    
    @Override
    public List<Guia> listarGuiasPorFecha(String mes){
        return gd.listarGuiasPorFecha(mes);
    }
}
