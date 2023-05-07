package cl.com.dsf.ecoPetro.service.destino;

import cl.com.dsf.ecoPetro.modelo.Destino;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DestinoService {
    public List<Destino> mostrarDestinos();
    
    public Destino encontrarDestinoPorId(Destino d);
    
    public void agregarDestino(Destino d);
    
    public void modificarDestino(Destino d);
    
    public void eliminarDestino(Destino d);
}
