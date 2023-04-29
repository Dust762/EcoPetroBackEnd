package cl.com.dsf.ecoPetro.data.carga;

import cl.com.dsf.ecoPetro.modelo.Carga;
import java.util.List;

public interface cargaDao {
   public List<Carga> mostrarCargas();
    
    public Carga encontrarCargaPorId(Carga c);
    
    public void crearCarga(Carga c);
    
    public void actualizarCarga(Carga c);
    
    public void eliminarCarga(Carga c); 
}
