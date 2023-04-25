package cl.com.dsf.ecoPetro.service.camion;

import cl.com.dsf.ecoPetro.data.camion.camionDao;
import cl.com.dsf.ecoPetro.modelo.Camion;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;

@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class CamionServiceImpl implements CamionService, CamionServiceRemote, CamionServiceWs{

    @Inject
    private camionDao cD;

    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Camion> listarCamiones() {
        return cD.mostrarCamiones();
    }

    @Override
    public Camion encontrarCamionPorId(Camion c) {
        return cD.encontrarCamionPorId(c);
    }

    @Override
    public Camion encontrarCamionPorPatente(Camion c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void registrarCamion(Camion c) {
        cD.crearCamion(c);
    }

    @Override
    public void actualizarCamion(Camion c) {
        try {
            cD.actualizarCamion(c);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarCamion(Camion c) {
        cD.eliminarCamion(c);
    }
    
}
