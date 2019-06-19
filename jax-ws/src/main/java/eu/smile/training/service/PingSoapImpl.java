package eu.smile.training.service;

import javax.jws.WebService;

@WebService(
		endpointInterface = "eu.smile.training.service.PingSoap",
		serviceName="ping")
public class PingSoapImpl implements PingSoap {
	
	
	@Override
    public String ping() {
        return "the pong";
    }
}
