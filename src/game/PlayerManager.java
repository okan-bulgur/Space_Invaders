package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import users.User;

public class PlayerManager implements ICollision{
	
	private User user = null;
	private Player player = null;
	private Bulletmanager bulletmanager;
	private boolean canCollision = true;
	private static int spriteCounter = 0;
	private static int spriteNum = 0;
	
	public PlayerManager(Bulletmanager bulletmanager) {
		this.bulletmanager = bulletmanager;
	}
	
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
	
	public void drawCharacter(Graphics2D g2) {
		if(canCollision) {
			g2.drawImage(player.getPlayerImg() , player.getPosX(), player.getPosY(), player.getSizeWidth(), player.getSizeHeight(), null);			
		}
		else {
			g2.drawImage(player.getPlayerGhostImage() , player.getPosX(), player.getPosY(), player.getSizeWidth(), player.getSizeHeight(), null);			
		}
		if(spriteNum == 0) {
			g2.drawImage(player.getPlayerBackFireImg() , player.getPosX()+13, player.getPosY()+39, player.getSizeWidth()/2, player.getSizeHeight()/2, null);			
		}
		else if(spriteNum == 1) {
			g2.drawImage(player.getPlayerBackFire2Img(), player.getPosX()+13, player.getPosY()+39, player.getSizeWidth()/2, player.getSizeHeight()/2, null);	
		}
	}
	
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
		if(GameManager.keyHandler.isSpacepress()) {
			bulletmanager.createBullet(player);	
		}
		
		player.setCollisionArea();
		
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
	
	public void addScore() {
		player.setScore(player.getScore()+10);
	}
	
	public void takeDamage(int damage) {
		player.setHealth(player.getHealth() - damage);
		if(isDead()) {
			GameManager.gameThread.gameStop();
		}
		
		new Thread(new Runnable()
		{
		    @Override
		    public void run()
		    {
		    	canCollision = false;
		        
		        try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		     
		        canCollision = true;
		    }
		}).start();
		
	}
	
	public boolean isDead() {
		return player.getHealth() == 0;
	}

	@Override
	public boolean isCollision(Rectangle area1, Rectangle area2) {
		if(area1.intersects(area2) && canCollision)
		{
		    return true;
		}
		return false;
	}

	@Override
	public void collisionDetector() {
		// TODO Auto-generated method stub
		
	}

}
