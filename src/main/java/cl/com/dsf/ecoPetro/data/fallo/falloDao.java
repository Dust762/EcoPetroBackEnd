package cl.com.dsf.ecoPetro.data.fallo;

import cl.com.dsf.ecoPetro.modelo.Fallo;
import java.util.List;

public interface falloDao {
    public List<Fallo> mostrarFallos();
    
    public Fallo encontrarFalloPorId(Fallo f);
    
    public void agregarFallo(Fallo f);
    
    public void modificarFallo(Fallo f);
    
    public void eliminarFallo(Fallo f);
}
