package cl.com.dsf.ecoPetro.service.usuario;

import cl.com.dsf.ecoPetro.modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
@Stateless
public class UsuarioRS {
    @Inject
    UsuarioService us;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> listarEstadosUsuarios() {
        return us.mostrarUsuarios();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /usuarios/{id}
    public Usuario encontrarUsuarioPorId(@PathParam("id") int id) {
        return us.encontrarUsuarioPorId(new Usuario(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarUsuario(Usuario u) {
        try {
            us.agregarUsuario(u);
            
            return Response.ok().entity(u).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarUsuario(@PathParam("id") int id, Usuario uMod) {
        try {
            Usuario u = us.encontrarUsuarioPorId(new Usuario(id));
            if (u != null) {
                us.modificarUsuario(u);
                return Response.ok().entity(uMod).build();
            }else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarUsuarioPorId(@PathParam("id") int id) {
        try {
            us.eliminarUsuario(new Usuario(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
