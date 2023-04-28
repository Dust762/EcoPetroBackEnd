package cl.com.dsf.ecoPetro.service.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.EstadoCamion;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EstadoCamionServiceWs {
    @WebMethod
    public List<EstadoCamion> mostrarEstadoCamiones();
}
