package clientWS;

import fr.formation.client.ping.Ping;
import fr.formation.client.ping.User;
import fr.formation.client.ping.User_Service;
import fr.formation.client.ping.Users;

public class EntryPoint {

	public static void main(String... args) {
		Ping ping =new Ping();
		System.out.println(ping.getPingSoapImplPort().ping());
		
		Users users = new User_Service().getUserServiceImplPort().getUsers();
		for (User user : users.getUsers()) {
			System.out.println(user.getId()+" "+user.getFirstname()+" "+user.getLastname());
		}
		
		User user = new User();
		user.setId("008");
		user.setFirstname("Dupont");
		user.setLastname("Pierre");
		
		new User_Service().getUserServiceImplPort().addUser(user);
		System.out.println("new list");
		users = new User_Service().getUserServiceImplPort().getUsers();
		for (User user1 : users.getUsers()) {
			System.out.println(user1.getId()+" "+user1.getFirstname()+" "+user1.getLastname());
		}
		
	}

}
