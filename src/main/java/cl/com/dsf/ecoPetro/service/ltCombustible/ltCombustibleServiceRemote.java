package cl.com.dsf.ecoPetro.service.ltCombustible;

import cl.com.dsf.ecoPetro.modelo.Ltcombustible;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ltCombustibleServiceRemote {
    public List<Ltcombustible> mostrarLtCombustibles();
    
    public Ltcombustible encontrarLtCombustiblePorId(Ltcombustible lc);
    
    public void agregarLtCombustible(Ltcombustible lc);
    
    public void modificarLtCombustible(Ltcombustible lc);
    
    public void eliminarLtCombustible(Ltcombustible lc);
}
