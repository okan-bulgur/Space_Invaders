package game;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import screens.GamePanel;
import users.User;

public class PlayerManager{
	
	private User user = null;
	private Player player = null;
	private Bulletmanager bulletmanager;
	private boolean canCollision = true;
	private int hitScore = 10;
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
		if(!canCollision && spriteNum == 0) {
			AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
			g2.setComposite(composite);
			g2.drawImage(player.getPlayerImg() , player.getPosX(), player.getPosY(), player.getSizeWidth(), player.getSizeHeight(), null);	
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); 
		}
		else {
			g2.drawImage(player.getPlayerImg() , player.getPosX(), player.getPosY(), player.getSizeWidth(), player.getSizeHeight(), null);			
		}
		if(spriteNum == 0) {
			g2.drawImage(player.getPlayerBackFireImg() , player.getPosX() + GamePanel.tileSize/3, player.getPosY() + GamePanel.tileSize - 10, player.getSizeWidth()/3, player.getSizeHeight()/3, null);			
		}
		else if(spriteNum == 1) {
			g2.drawImage(player.getPlayerBackFire2Img(), player.getPosX() + GamePanel.tileSize/3, player.getPosY() + GamePanel.tileSize - 10, player.getSizeWidth()/3, player.getSizeHeight()/3, null);	
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
		if(GameManager.keyHandler.isSpacepress() && canCollision) {
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
		player.setScore(player.getScore() + hitScore);
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
					Thread.sleep(player.getGhostModeTime());
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

	public boolean isCollision(Rectangle area1, Rectangle area2) {
		if(area1.intersects(area2) && canCollision)
		{
		    return true;
		}
		return false;
	}

	public void changeHighScore() {
		
	}
}
