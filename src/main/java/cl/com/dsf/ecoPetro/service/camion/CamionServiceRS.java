
package cl.com.dsf.ecoPetro.service.camion;

import cl.com.dsf.ecoPetro.modelo.Camion;
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
@Path("/camiones")
@Stateless
public class CamionServiceRS {
    @Inject
    private CamionService cs;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Camion> listarPersonas() {
        return cs.listarCamiones();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /camiones/{id}
    public Camion encontrarCamionPorId(@PathParam("id") int id) {
        return cs.encontrarCamionPorId(new Camion(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarCamion(Camion c) {
        try {
            cs.registrarCamion(c);
            
            return Response.ok().entity(c).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarCamion(@PathParam("id") int id, Camion cMod) {
        try {
            Camion c = cs.encontrarCamionPorId(new Camion(id));
            if (c != null) {
                cs.actualizarCamion(c);
                return Response.ok().entity(cMod).build();
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
    public Response eliminarCamionPorId(@PathParam("id") int id) {
        try {
            cs.eliminarCamion(new Camion(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
