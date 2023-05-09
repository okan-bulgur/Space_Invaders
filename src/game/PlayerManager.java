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
	private BufferedImage playerBackFireImg;
	private BufferedImage playerBackFire2Img;
	
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
	
	public void getPlayerImage() {
		try {
			playerImg = ImageIO.read(getClass().getResourceAsStream("/img/ship.png"));
			playerBackFireImg = ImageIO.read(getClass().getResourceAsStream("/img/ship_back_fire.png"));
			playerBackFire2Img = ImageIO.read(getClass().getResourceAsStream("/img/ship_back_fire_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawPlayer(Graphics2D g2, int tileSize) {
		getPlayerImage();
		g2.drawImage(playerImg, player.getPosX(), player.getPosY(), tileSize, tileSize, null);
		if(spriteNum == 0) {
			g2.drawImage(playerBackFireImg, player.getPosX()+13, player.getPosY()+39, tileSize/2, tileSize/2, null);			
		}
		else if(spriteNum == 1) {
			g2.drawImage(playerBackFire2Img, player.getPosX()+13, player.getPosY()+39, tileSize/2, tileSize/2, null);	
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
