package cl.com.dsf.ecoPetro.service.destino;

import cl.com.dsf.ecoPetro.modelo.Destino;
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

@Path("/destinos")
@Stateless
public class DestinoServiceRS {
    @Inject
    private DestinoService ds;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Destino> listarDestinos() {
        return ds.mostrarDestinos();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /destinos/{id}
    public Destino encontrarDestinoPorId(@PathParam("id") int id) {
        return ds.encontrarDestinoPorId(new Destino(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarDestino(Destino d) {
        try {
            ds.agregarDestino(d);
            return Response.ok().entity(d).build();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarDestino(@PathParam("id") int id, Destino dMod) {
        try {
            Destino d = ds.encontrarDestinoPorId(new Destino(id));
            if (d != null) {
                ds.modificarDestino(d);
                return Response.ok().entity(dMod).build();
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
    public Response eliminarDestinoPorId(@PathParam("id") int id) {
        try {
            ds.eliminarDestino(new Destino(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
