package cl.com.dsf.ecoPetro.service.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.Estado;
import cl.com.dsf.ecoPetro.modelo.Estadocamion;
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

@Path("/estadosCamiones")
@Stateless
public class EstadoCamionServiceRs {
    @Inject
    private EstadoCamionService ecs;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Estadocamion> listarEstados() {
        return ecs.mostrarEstadoCamiones();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /estadosCamiones/{id}
    public Estadocamion encontrarEstadoPorId(@PathParam("id") int id) {
        return ecs.encontrarEstadoPorId(new Estadocamion(id));
    }
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarEstadoCamion(Estadocamion ec) {
        try {
            ecs.crearEstadoCamion(ec);
            return Response.ok().entity(ec).build();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarEstadoCamion(@PathParam("id") int id, Estado eMod) {
        try {
            Estadocamion ec = ecs.encontrarEstadoPorId(new Estadocamion(id));
            if (ec != null) {
                ecs.modificarEstadoCamion(ec);
                return Response.ok().entity(eMod).build();
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
    public Response eliminarEstadoCamionPorId(@PathParam("id") int id) {
        try {
            ecs.eliminarEstadoCamion(new Estadocamion(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
