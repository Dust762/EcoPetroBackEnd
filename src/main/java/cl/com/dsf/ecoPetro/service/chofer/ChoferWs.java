package cl.com.dsf.ecoPetro.service.chofer;

import cl.com.dsf.ecoPetro.modelo.Chofer;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface ChoferWs {
    @WebMethod
    public List<Chofer> mostrarChoferes();
    
}
