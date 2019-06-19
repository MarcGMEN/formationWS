package eu.smile.training.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class User {

	private String id;
	private String firstname;
	private String lastname;

	@JsonCreator
	public User(@JsonProperty("id") String id, @JsonProperty("firstname") String firstname,
			@JsonProperty("lastname") String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
