package eu.smile.training.token;

import java.io.IOException;
import java.security.Key;

import javax.annotation.Priority;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Jwts;

@Provider
// on declare cette classe comme etant une JWControl
@JwtControl
// 
@Priority(Priorities.AUTHENTICATION)
public class JwtControlFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// codage du filtre
		String auth = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		if (auth == null || auth.isEmpty() || "undefined".equals(auth))  {
			requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
		} else {
			
			String token = auth.split("Bearer")[1];
			Key key = JwtFactory.getMyApiKey();
			try {	
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			}
			catch (Exception e) {
				requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
			}
		}
//		
	}
}
