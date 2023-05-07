package cl.com.dsf.ecoPetro.service.destino;

import cl.com.dsf.ecoPetro.modelo.Destino;
import java.util.List;
import javax.ejb.Remote;
@Remote
public interface DestinoServiceRemote {
    public List<Destino> mostrarDestinos();
    
    public Destino encontrarDestinoPorId(Destino d);
    
    public void agregarDestino(Destino d);
    
    public void modificarDestino(Destino d);
    
    public void eliminarDestino(Destino d);
}
