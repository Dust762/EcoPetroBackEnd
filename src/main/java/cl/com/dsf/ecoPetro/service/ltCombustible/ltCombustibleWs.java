package cl.com.dsf.ecoPetro.service.ltCombustible;

import cl.com.dsf.ecoPetro.modelo.Ltcombustible;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ltCombustibleWs {
    @WebMethod
    public List<Ltcombustible> mostrarLtCombustibles();
}
