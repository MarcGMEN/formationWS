package eu.smile.training.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import eu.smile.training.entity.User;

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	final static Logger logger = Logger.getLogger("User");

	private final static Map<String, User> users = new HashMap<String, User>();

	private static int index;

	static {
		users.put("001", new User("001", "John", "Clees"));
		users.put("002", new User("002", "Eric", "Idle"));
		users.put("003", new User("003", "Michael", "Palin"));
		users.put("004", new User("004", "Terry", "Gilliam"));
		users.put("005", new User("005", "Terry", "Jones"));
		users.put("006", new User("006", "Graham", "Chapman"));
		users.put("007", new User("007", "James", "Bond"));

		index = 7;
	}

	/**
	 * Service REST de recupération d'utisiteuyr par identifiant
	 * 
	 * @param id Identifiant recherché
	 * @return Utilisateur trouvé, au format JSON, ou chaine vide si pas trouvé
	 */
	@GET
	@Path("{id}")
	public Response getUser(@PathParam("id") String id) {
		logger.info("user avec id " + id);
		if (users.containsKey(id)) {
			return Response.ok(users.get(id)).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@GET
	public Response getUsers() {
		logger.info("users");
		return Response.ok(users.values()).build();
	}

	@POST
	public Response setUser(User user) {
		if (user != null) {
			logger.info("user JSON " + user);
			users.put(user.getId(), user);
			logger.info("new user " + user);
			return Response.ok().build();
		} else {
			logger.info("user null");
			return Response.noContent().build();
		}

	}

	@PUT
	@Path("{id}")
	public Response setUserById(@PathParam("id") String id,User user) {
		if (user != null) {
			logger.info("user JSON " + user);
			user.setId(id);
			users.put(id, user);
			logger.info("new user " + user);
			return Response.ok().build();
		} else {
			logger.info("user null");
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response setUserById(@PathParam("id") String id) {
			users.remove(id);
			return Response.ok().build();
	}

}
