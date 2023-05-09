package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import users.User;

public class PlayerManager {
	
	private Player player = null;
	private KeyHandler keyHandler;
	private BufferedImage playerImg;
	
	public PlayerManager() {
		setKeyHandler(new KeyHandler());
	}
	
	public void createPlayer(User user) {
		player = new Player(user);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void getPlayerImage() {
		try {
			playerImg = ImageIO.read(getClass().getResourceAsStream("/img/ship.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawPlayer(Graphics2D g2, int tileSize) {
		getPlayerImage();
		g2.drawImage(playerImg, player.getPosX(), player.getPosY(), tileSize, tileSize, null);
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
