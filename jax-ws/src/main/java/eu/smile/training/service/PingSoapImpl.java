package eu.smile.training.service;

import javax.jws.WebService;

@WebService(
		endpointInterface = "eu.smile.training.service.PingSoap",
		serviceName="toto")
public class PingSoapImpl implements PingSoap {
	
	
	@Override
    public String ping() {
        return "the pong";
    }
}
