package eu.smile.training;

import javax.xml.ws.Endpoint;

import eu.smile.training.service.PingSoapImpl;
import eu.smile.training.service.UserServiceImpl;

public class SoapPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/pingService", new PingSoapImpl());
		Endpoint.publish("http://localhost:8080/userService", new UserServiceImpl());
	}
}
