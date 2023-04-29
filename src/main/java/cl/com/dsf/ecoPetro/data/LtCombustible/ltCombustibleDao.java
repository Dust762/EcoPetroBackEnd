package cl.com.dsf.ecoPetro.data.LtCombustible;

import cl.com.dsf.ecoPetro.modelo.Ltcombustible;
import java.util.List;

public interface ltCombustibleDao {
    public List<Ltcombustible> mostrarLtCombustibles();
    
    public Ltcombustible encontrarLtCombustiblePorId(Ltcombustible lc);
    
    public void agregarLtCombustible(Ltcombustible lc);
    
    public void modificarLtCombustible(Ltcombustible lc);
    
    public void eliminarLtCombustible(Ltcombustible lc);
}
