package game;

import java.awt.Graphics2D;

import users.User;

public class PlayerManager {
	
	private Player player = null;
	private KeyHandler keyHandler;
	
	private static int spriteCounter = 0;
	private static int spriteNum = 0;
	
	public PlayerManager(KeyHandler keyHandler) {
		this.keyHandler = keyHandler;
	}
	
	public void createPlayer(User user) {
		player = new Player(null, user);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void drawPlayer(Graphics2D g2, int tileSize) {
		g2.drawImage(player.getPlayerImg() , player.getPosX(), player.getPosY(), tileSize, tileSize, null);
		if(spriteNum == 0) {
			g2.drawImage(player.getPlayerBackFireImg() , player.getPosX()+13, player.getPosY()+39, tileSize/2, tileSize/2, null);			
		}
		else if(spriteNum == 1) {
			g2.drawImage(player.getPlayerBackFire2Img(), player.getPosX()+13, player.getPosY()+39, tileSize/2, tileSize/2, null);	
		}
	}
	
	public void update() {
		
		if(keyHandler.isUpPress()) {
			player.setPosY(player.getPosY() - player.getSpeed());
		}
		if(keyHandler.isDownpress()) {
			player.setPosY(player.getPosY() + player.getSpeed());
		}
		if(keyHandler.isRightPress()) {
			player.setPosX(player.getPosX() + player.getSpeed());
		}
		if(keyHandler.isLeftpress()) {
			player.setPosX(player.getPosX() - player.getSpeed());
		}
		
		spriteCounter++;
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum = 0;
			}
			else {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
}
