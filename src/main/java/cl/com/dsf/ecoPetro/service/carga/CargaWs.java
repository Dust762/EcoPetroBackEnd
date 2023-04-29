package cl.com.dsf.ecoPetro.service.carga;

import cl.com.dsf.ecoPetro.modelo.Carga;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface CargaWs {
    @WebMethod
    public List<Carga> mostrarCargas();
    
}
