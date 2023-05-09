package game;

import java.awt.Graphics2D;

import users.User;

public class PlayerManager {
	
	private Player player = null;
	private KeyHandler keyHandler;
	
	public PlayerManager() {
		setKeyHandler(new KeyHandler());
	}
	
	public void createPlayer(User user) {
		player = new Player(user);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void drawPlayer(Graphics2D g2, int tileSize) {
		g2.setColor(player.getColor());
		g2.fillRect(player.getPosX(), player.getPosY(), tileSize, tileSize);
	}
	
	public void update() {
		
		if(getKeyHandler().isUpPress()) {
			player.setPosY(player.getPosY() - player.getSpeed());
		}
		if(getKeyHandler().isDownpress()) {
			player.setPosY(player.getPosY() + player.getSpeed());
		}
		if(getKeyHandler().isRightPress()) {
			player.setPosX(player.getPosX() + player.getSpeed());
		}
		if(getKeyHandler().isLeftpress()) {
			player.setPosX(player.getPosX() - player.getSpeed());
		}
	}
	
	public KeyHandler getKeyHandler() {
		return keyHandler;
	}

	public void setKeyHandler(KeyHandler keyHandler) {
		this.keyHandler = keyHandler;
	}
}
