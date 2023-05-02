package cl.com.dsf.ecoPetro.web;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

@ApplicationPath("ecoPetroAPI")
public class JAXRSActivator extends Application {
    /*
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        
        classes.add(MultiPartFeature.class);
        //classes.add(MultiPartResource.class);
        //classes.add(LoggingFilter.class);
        return classes;
    }
    */
}
