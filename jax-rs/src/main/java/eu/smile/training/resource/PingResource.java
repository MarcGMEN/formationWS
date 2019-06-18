package eu.smile.training.resource;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
 

@Path("ping")
public class PingResource {

	@GET
	@Path("{id}")
    public String ping(@PathParam("id") Integer id) {
        return "pong "+id;
    }
	
	@GET
	public String ping() {
        return "pong default";
    }

}
