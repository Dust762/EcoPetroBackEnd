package cl.com.dsf.ecoPetro.service.viaje;

import cl.com.dsf.ecoPetro.modelo.Viaje;
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

@Path("/viajes")
@Stateless
public class ViajeRS {
    @Inject
    ViajeService vs;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Viaje> listarViajes() {
        return vs.mostrarViajes();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /viajes/{id}
    public Viaje encontrarViajePorId(@PathParam("id") int id) {
        return vs.encontrarViajePorId(new Viaje(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response crearViaje(Viaje c) {
        try {
            vs.crearViaje(c);
            
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
    public Response modificarViaje(@PathParam("id") int id, Viaje vMod) {
        try {
            Viaje v = vs.encontrarViajePorId(new Viaje(id));
            if (v != null) {
                vs.modificarViaje(v);
                return Response.ok().entity(vMod).build();
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
    public Response eliminarViajePorId(@PathParam("id") int id) {
        try {
            vs.eliminarViaje(new Viaje(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
