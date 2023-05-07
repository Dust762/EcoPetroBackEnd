
package cl.com.dsf.ecoPetro.data.destino;

import cl.com.dsf.ecoPetro.modelo.Destino;
import java.util.List;


public interface destinoDao {
    public List<Destino> mostrarDestinos();
    
    public Destino encontrarDestinoPorId(Destino d);
    
    public void agregarDestino(Destino d);
    
    public void modificarDestino(Destino d);
    
    public void eliminarDestino(Destino d);
}
