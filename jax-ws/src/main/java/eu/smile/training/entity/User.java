package eu.smile.training.entity;

import javax.xml.bind.annotation.XmlType;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlElement // pour parse en XML
@XmlType(propOrder={"id","lastname","firstname"}) // Optional : just to fix XML fields order
public class User {

	private String id;
	private String firstname;
	private String lastname;

	public User() {
		super();
	}

	public User(String id, String firstname, String lastname) {
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}