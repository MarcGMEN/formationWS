package eu.smile.training.application;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@ApplicationPath("api")
public class RestApplicationConfig extends ResourceConfig {

    public RestApplicationConfig() {
        packages("eu.smile.training");
        register(JacksonJsonProvider.class);
    }
}