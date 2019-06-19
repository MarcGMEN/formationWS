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
			System.out.println(user);
		}
	}

}
