package cl.com.dsf.ecoPetro.service.guia;

import cl.com.dsf.ecoPetro.modelo.Dia;
import cl.com.dsf.ecoPetro.modelo.Guia;
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

@Path("/guias")
@Stateless
public class GuiaRS {
    @Inject
    GuiaService gs;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Guia> listarGuias() {
        return gs.mostrarGuias();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /guias/{id}
    public Guia encontrarGuiaPorNroGuia(@PathParam("id") int id) {
        return gs.encontrarGuiaPorNroGuia(new Guia(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarUsuario(Guia g) {
        try {
            gs.agregarGuia(g);
            
            return Response.ok().entity(g).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarGuia(@PathParam("id") int id, Guia gMod) {
        try {
            Guia g = gs.encontrarGuiaPorNroGuia(new Guia(id));
            if (g != null) {
                gs.modificarGuia(g);
                return Response.ok().entity(gMod).build();
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
    public Response eliminarGuiaPorNroGuia(@PathParam("id") int id) {
        try {
            gs.eliminarGuia(new Guia(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("mes/{mes}")
    public List<Guia> listarGuiasPorFechas(@PathParam("mes") String mes) {
        return gs.listarGuiasPorFecha(mes);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("consumoTotal/{mes}")
    public String totalConsumoMensual(@PathParam("mes") String mes) {
        return gs.totalConsumoMensual(mes);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("consumoSemanal/{mes}/{semana}")
    public List<Dia> totalConsumoSemanal(@PathParam("mes") String mes, @PathParam("semana") String semana){
        return gs.listarConsumoSemana(mes, semana);
    }
}
