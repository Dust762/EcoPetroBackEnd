package cl.com.dsf.ecoPetro.service.fallo;

import cl.com.dsf.ecoPetro.modelo.Fallo;
import java.util.List;
import javax.ejb.Local;
@Local
public interface FalloService {
    public List<Fallo> mostrarFallos();
    
    public Fallo encontrarFalloPorId(Fallo f);
    
    public void agregarFallo(Fallo f);
    
    public void modificarFallo(Fallo f);
    
    public void eliminarFallo(Fallo f);
}
