package cl.com.dsf.ecoPetro.service.carga;

import cl.com.dsf.ecoPetro.modelo.Carga;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CargaService {
    public List<Carga> mostrarCargas();
    
    public Carga encontrarCargaPorId(Carga c);
    
    public void crearCarga(Carga c);
    
    public void actualizarCarga(Carga c);
    
    public void eliminarCarga(Carga c);
}
