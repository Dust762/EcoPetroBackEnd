package cl.com.dsf.ecoPetro.service.fotoUsuario;

import cl.com.dsf.ecoPetro.modelo.FotoUsuario;
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
//Se debe cambiar los metodos de acceso, para el uso de media (muulti_form_data)
@Path("/fotousuarios")
@Stateless
public class FotoUsuarioServiceRS {
    @Inject
    private FotoUsuarioService fus;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<FotoUsuario> listarFotoUsuarios() {
        return fus.mostrarFotoUsuarios();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /fotousuarios/{id}
    public FotoUsuario encontrarFotoUsuarioPorId(@PathParam("id") int id) {
        return fus.encontrarFotoUsuarioPorId(new FotoUsuario(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarFotoUsuario(FotoUsuario fu) {
        try {
            fus.agregarFotoUsuario(fu);
            return Response.ok().entity(fu).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response actualizarFotoUsuario(@PathParam("id") int id, FotoUsuario fuMod) {
        try {
            FotoUsuario fu = fus.encontrarFotoUsuarioPorId(new FotoUsuario(id));
            if (fu != null) {
                fus.actualizarFotoUsuario(fu);
                return Response.ok().entity(fuMod).build();
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
    public Response eliminarFotoUsuarioPorId(@PathParam("id") int id) {
        try {
            fus.eliminarFotoUsuario(new FotoUsuario(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
