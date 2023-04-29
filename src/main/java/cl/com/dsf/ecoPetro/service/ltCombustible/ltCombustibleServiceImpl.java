package cl.com.dsf.ecoPetro.service.ltCombustible;

import cl.com.dsf.ecoPetro.data.LtCombustible.ltCombustibleDao;
import cl.com.dsf.ecoPetro.modelo.Ltcombustible;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.inject.Inject;
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class ltCombustibleServiceImpl implements ltCombustibleService, ltCombustibleServiceRemote, ltCombustibleWs {
    @Inject
    private ltCombustibleDao lcd;
    
    @Resource
    private SessionContext contexto;
    @Override
    public List<Ltcombustible> mostrarLtCombustibles() {
        return lcd.mostrarLtCombustibles();
    }

    @Override
    public Ltcombustible encontrarLtCombustiblePorId(Ltcombustible lc) {
        return lcd.encontrarLtCombustiblePorId(lc);
    }

    @Override
    public void agregarLtCombustible(Ltcombustible lc) {
        lcd.agregarLtCombustible(lc);
    }

    @Override
    public void modificarLtCombustible(Ltcombustible lc) {
        
        try {
          lcd.modificarLtCombustible(lc);  
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarLtCombustible(Ltcombustible lc) {
        lcd.eliminarLtCombustible(lc);
    }
    
}
