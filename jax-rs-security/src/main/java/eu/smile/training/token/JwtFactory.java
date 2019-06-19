package eu.smile.training.token;

import java.security.Key;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JwtFactory {
	
	// Usually the API key must be read from your application configuration instead.
	private static Key myApiKey = MacProvider.generateKey();
	
	public static Key getMyApiKey() {
		return myApiKey;
	}

	@GET
	@Path("{login}")
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@PathParam("login") String login) {
		
		try {

			// Normally, login and password send by a @FormParam
			// Must normally authenticate the user with login/password here.
			// authenticate(login, password);

			// Create a token for the user with user login.
			String token = issueToken(login);

			System.out.println(token);
			// Return the token in http response header with Authorization field.
			return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();

		} catch (Exception e) {
			
			return Response.status(Status.UNAUTHORIZED).build();
		}
	}

	private String issueToken(String login) {
		Date actualTime = new Date();

		// Fix expiration to 10 minutes (600000 ms)
		String jwtToken = Jwts.builder().setSubject(login)
				.setIssuedAt(actualTime).setExpiration(new Date(actualTime.getTime() + 600000))
				.signWith(SignatureAlgorithm.HS512, myApiKey).compact();
		return jwtToken;
	}
}
