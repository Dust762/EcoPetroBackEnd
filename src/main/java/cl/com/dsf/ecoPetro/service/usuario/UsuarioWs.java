package cl.com.dsf.ecoPetro.service.usuario;

import cl.com.dsf.ecoPetro.modelo.Usuario;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UsuarioWs {
    @WebMethod
    public List<Usuario> mostrarUsuarios();
}
