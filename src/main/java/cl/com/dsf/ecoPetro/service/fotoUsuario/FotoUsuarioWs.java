package cl.com.dsf.ecoPetro.service.fotoUsuario;

import cl.com.dsf.ecoPetro.modelo.FotoUsuario;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface FotoUsuarioWs {
    @WebMethod
    public List<FotoUsuario> mostrarFotoUsuarios();
}
