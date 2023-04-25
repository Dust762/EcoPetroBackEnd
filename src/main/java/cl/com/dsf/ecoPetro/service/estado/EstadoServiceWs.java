package cl.com.dsf.ecoPetro.service.estado;

import cl.com.dsf.ecoPetro.modelo.Estado;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EstadoServiceWs {
    @WebMethod
    public List<Estado> mostrarEstados();
}
