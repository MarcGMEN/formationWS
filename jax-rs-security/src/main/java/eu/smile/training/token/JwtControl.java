package eu.smile.training.token;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@javax.ws.rs.NameBinding
// on le garde jusuq'au RUNTIME
@Retention(RetentionPolicy.RUNTIME)
// a qui c'est imputable
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface JwtControl {

}
