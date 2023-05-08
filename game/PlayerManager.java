package game;

import users.User;

public class PlayerManager {
	
	private Player player = null;
	
	public void createPlayer(User user) {
		player = new Player(user);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	private void drawPlayer() {
		
	}
	
	private void movement() {
		
	}
}
