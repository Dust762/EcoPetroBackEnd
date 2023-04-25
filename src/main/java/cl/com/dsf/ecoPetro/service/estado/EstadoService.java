package cl.com.dsf.ecoPetro.service.estado;

import cl.com.dsf.ecoPetro.modelo.Estado;
import java.util.List;
import javax.ejb.Local;
@Local
public interface EstadoService {

    public List<Estado> mostrarEstados();

    public Estado encontrarEstadoPorId(Estado e);

    public void crearEstado(Estado e);

    public void modificarEstado(Estado e);

    public void eliminarEstado(Estado e);
}
