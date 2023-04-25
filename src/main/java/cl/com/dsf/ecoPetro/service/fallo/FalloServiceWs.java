
package cl.com.dsf.ecoPetro.service.fallo;

import cl.com.dsf.ecoPetro.modelo.Fallo;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface FalloServiceWs {
    @WebMethod
    public List<Fallo> mostrarFallos();
}
