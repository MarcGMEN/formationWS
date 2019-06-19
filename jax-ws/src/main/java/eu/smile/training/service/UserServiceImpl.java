package eu.smile.training.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import eu.smile.training.entity.User;
import eu.smile.training.entity.Users;

@WebService(
		endpointInterface = "eu.smile.training.service.UserService",
		serviceName="user")
public class UserServiceImpl implements UserService {

	private static final Users users = new Users();
	
	private static final List<User> userList = new ArrayList<User>();
	static {
		userList.add(new User("001", "John", "Clees"));
		userList.add(new User("002", "Eric", "Idle"));
		userList.add(new User("003", "Michael", "Palin"));
		userList.add(new User("004", "Terry", "Gilliam"));
		userList.add(new User("005", "Terry", "Jones"));
		userList.add(new User("006", "Graham", "Chapman"));
		userList.add(new User("007", "James", "Bond"));
		users.setUsers(userList);
	}
	
	@Override
	public Users getUsers() {
		return users;
	}

	@Override
	public void addUser(User user) {
		users.getUsers().add(user);
	}
}
