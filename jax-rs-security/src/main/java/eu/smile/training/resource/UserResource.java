package eu.smile.training.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eu.smile.training.entity.User;
import eu.smile.training.token.JwtControl;

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	private final static Map<String, User> users = new HashMap<String, User>();
	static {
		users.put("001", new User("001", "John", "Clees"));
		users.put("002", new User("002", "Eric", "Idle"));
		users.put("003", new User("003", "Michael", "Palin"));
		users.put("004", new User("004", "Terry", "Gilliam"));
		users.put("005", new User("005", "Terry", "Jones"));
		users.put("006", new User("006", "Graham", "Chapman"));
		users.put("007", new User("007", "James", "Bond"));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// on indique que cette methode est JWTcontrolable, donc on active la JWTcontrol class associé (JWtControlFilter)
	@JwtControl
	public Response getUsers() {
		return Response.ok(users.values()).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@JwtControl
	public Response getUser(@PathParam("id") String id) {
		if (users.containsKey(id)) {
			return Response.ok(users.get(id)).build();
		}
		return Response.noContent().build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@JwtControl
	public Response setUser(User user) {
		users.put(user.getId(), user);
		return Response.ok().build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@JwtControl
	public Response setUserById(@PathParam("id") String id, User user) {
		user.setId(id);
		users.put(id, user);
		return Response.ok().build();
	}

}
