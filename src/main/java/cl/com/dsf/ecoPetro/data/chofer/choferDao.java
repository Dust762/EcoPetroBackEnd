package cl.com.dsf.ecoPetro.data.chofer;

import cl.com.dsf.ecoPetro.modelo.Chofer;
import java.util.List;

public interface choferDao {
    public List<Chofer> mostrarChoferes();
    
    public Chofer encontrarChoferPorId(Chofer c);
    
    public void agregarChofer(Chofer c);
    
    public void modificarChofer(Chofer c);
    
    public void eliminarChofer(Chofer c);
}
