package game;

import users.User;

public class PlayerManager {
	
	private User user = null;
	private Player player = null;
	
	private void changeUser(User user) {
		this.user = user;
	}
	
	private void createPlayer() {
		player = new Player(user);
	}
	
	private void drawPlayer() {
		
	}
	
	private void movement() {
		
	}
}
