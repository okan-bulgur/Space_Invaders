package game;

import java.awt.Graphics2D;

import users.User;

public class PlayerManager extends CharacterManager{
	
	private User user = null;
	private Player player = null;

	private static int spriteCounter = 0;
	private static int spriteNum = 0;
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void createPlayer () {
		player = new Player(user);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	@Override
	public void drawCharacter(Graphics2D g2) {
		g2.drawImage(player.getPlayerImg() , player.getPosX(), player.getPosY(), GameManager.tileSize, GameManager.tileSize, null);
		if(spriteNum == 0) {
			g2.drawImage(player.getPlayerBackFireImg() , player.getPosX()+13, player.getPosY()+39, GameManager.tileSize/2, GameManager.tileSize/2, null);			
		}
		else if(spriteNum == 1) {
			g2.drawImage(player.getPlayerBackFire2Img(), player.getPosX()+13, player.getPosY()+39, GameManager.tileSize/2, GameManager.tileSize/2, null);	
		}
	}
	
	@Override
	public void update() {
		
		if(GameManager.keyHandler.isUpPress()) {
			player.setPosY(player.getPosY() - player.getSpeed());
		}
		if(GameManager.keyHandler.isDownpress()) {
			player.setPosY(player.getPosY() + player.getSpeed());
		}
		if(GameManager.keyHandler.isRightPress()) {
			player.setPosX(player.getPosX() + player.getSpeed());
		}
		if(GameManager.keyHandler.isLeftpress()) {
			player.setPosX(player.getPosX() - player.getSpeed());
		}
		
		//player.setCollisionArea();
		
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
	
	public void takeDamage() {
		player.setHealth(player.getHealth() - 1);
		if(isDead()) {
			player = null;
			System.gc();
		}
	}
	
	public boolean isDead() {
		return player.getHealth() == 0;
	}

	@Override
	public void collisionDetector() {
		// TODO Auto-generated method stub
		
	}

}
