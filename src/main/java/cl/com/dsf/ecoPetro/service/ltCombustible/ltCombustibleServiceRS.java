package cl.com.dsf.ecoPetro.service.ltCombustible;

import cl.com.dsf.ecoPetro.modelo.Ltcombustible;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/ltcombustibles")
@Stateless
public class ltCombustibleServiceRS {

    @Inject
    private ltCombustibleService lcs;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Ltcombustible> listarLtCombustibles() {
        return lcs.mostrarLtCombustibles();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /ltcombustibles/{id}
    public Ltcombustible encontrarLtCombustiblePorId(@PathParam("id") int id) {
        return lcs.encontrarLtCombustiblePorId(new Ltcombustible(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarLtCombustible(Ltcombustible lc) {
        try {
            lcs.agregarLtCombustible(lc);

            return Response.ok().entity(lc).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    final static String PHOTO_DIRECTORY = "D:\\fotosEcoPetro\\fotosCombustibles\\";

    //EXPERIMENTAL
    @POST
    @Path("fotoCombustible/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response agregarLtCombustible(@DefaultValue("true") @FormDataParam("enabled") boolean enabled,
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition datoArchivo, @PathParam("id") int id) throws IOException {
        File directorio = new File(PHOTO_DIRECTORY);
        if (!directorio.isDirectory()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            }else{
                System.out.println("No se pudo crear");
            }
        }
        String ubicacion = PHOTO_DIRECTORY + datoArchivo.getFileName();
        File objFile = new File(ubicacion);
        if (objFile.exists()) {
            objFile.delete();

        }
        saveToFile(uploadedInputStream, ubicacion);

        String output = "File uploaded via Jersey based RESTFul Webservice to: " + ubicacion;
        Ltcombustible lc = lcs.encontrarLtCombustiblePorId(new Ltcombustible(id));
        lc.setNombreFotoCarga(objFile.getName());
        lcs.modificarLtCombustible(lc);

        return Response.status(200).entity(output).build();
    }

    private void saveToFile(InputStream uploadedInputStream, String ubicacion) {
        try {
            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(ubicacion));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @GET
    @Path("fotoCombustible/{ubicacion}")
    @Produces({"image/png", "image/jpeg"})
    public Response retornarFotoCombustible(@PathParam("ubicacion") String ubicacion) {

        System.out.println(ubicacion);
        File foto = null;
        try {
            foto = new File(PHOTO_DIRECTORY + ubicacion);
        } catch (Exception e) {
            System.out.println("No existe el archivo");
        }

        if (foto.exists()) {
            ResponseBuilder r = Response.ok((Object) foto);
            r.header("Content-Disposition", "attachment; filename=" + foto.getName());
            return r.build();
        }
        System.out.println("No se encontro");
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarLtCombustible(@PathParam("id") int id, Ltcombustible lcMod) {
        try {
            Ltcombustible lc = lcs.encontrarLtCombustiblePorId(new Ltcombustible(id));
            if (lc != null) {
                lcs.modificarLtCombustible(lc);
                return Response.ok().entity(lcMod).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("Entro en error modificar");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

        }
    }

    @DELETE
    @Path("{id}")
    public Response eliminarLtCombustiblePorId(@PathParam("id") int id) {
        try {
            lcs.eliminarLtCombustible(new Ltcombustible(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }

}
