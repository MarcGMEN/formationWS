package eu.smile.training.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import eu.smile.training.entity.User;
import eu.smile.training.entity.Users;

@WebService
@SOAPBinding(style = Style.RPC)
public interface UserService {

	@WebMethod
	Users getUsers();
	
	@WebMethod
	void addUser(User user);
}
