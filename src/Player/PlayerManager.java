package Player;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import game.Game;
import screens.GamePanel;
import users.User;

public class PlayerManager{
	
	private User user = null;
	private Player player = null;
	private int bulletDelayCounter = 0;
	private int bulletChecker = 0;
	private boolean highScoreChecker = true;
	
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
		if(!player.getCanCollision() && !Game.gameManager.getAnimationManager().isPlayerAnimation()) {
			AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
			g2.setComposite(composite);
			g2.drawImage(player.getPlayerImg() , player.getPosX(), player.getPosY(), player.getSizeWidth(), player.getSizeHeight(), null);	
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); 
		}
		else {
			g2.drawImage(player.getPlayerImg() , player.getPosX(), player.getPosY(), player.getSizeWidth(), player.getSizeHeight(), null);			
		}
		if(!Game.gameManager.getAnimationManager().isPlayerAnimation()) {
			g2.drawImage(player.getPlayerBackFireImg() , player.getPosX() + GamePanel.tileSize/3, player.getPosY() + GamePanel.tileSize, player.getSizeWidth()/3, player.getSizeHeight()/3, null);			
		}
		else if(Game.gameManager.getAnimationManager().isPlayerAnimation()) {
			g2.drawImage(player.getPlayerBackFire2Img(), player.getPosX() + GamePanel.tileSize/3, player.getPosY() + GamePanel.tileSize, player.getSizeWidth()/3, player.getSizeHeight()/3, null);	
		}
	}
	
	public void update() {
				
		playerControl();
		player.setCollisionArea();
		
		bulletDelayCounter++;
		if(bulletDelayCounter > 6) {
			if(bulletChecker == 1) {
				bulletChecker = 0;
			}
			else {
				bulletChecker = 1;
			}
			bulletDelayCounter = 0;
		}
	}
	
	public void playerControl() {
		if(Game.gameManager.getKeyHandler().isUpPress() && (player.getPosY() - player.getSpeedY()) > 0 ) {
			player.setPosY(player.getPosY() - player.getSpeedY());
		}
		if(Game.gameManager.getKeyHandler().isDownpress() && (player.getPosY() + player.getSpeedY() + player.getSizeHeight() * 1.2 < GamePanel.screenHeight) ) {
			player.setPosY(player.getPosY() + player.getSpeedY());
		}
		if(Game.gameManager.getKeyHandler().isRightPress() && (player.getPosX() + player.getSpeedX() + player.getSizeWidth() < GamePanel.screenWidth) ) {
			player.setPosX(player.getPosX() + player.getSpeedX());
		}
		if(Game.gameManager.getKeyHandler().isLeftpress() && (player.getPosX() - player.getSpeedX()) > 0 ) {
			player.setPosX(player.getPosX() - player.getSpeedX());
		}
		if(Game.gameManager.getKeyHandler().isSpacepress() && player.getCanCollision() && bulletDelayCounter == 1) {
			Game.gameManager.getShootingManager().shooting(player);
		}
	}
	
	public void addScore() {
		player.setScore(player.getScore() + Game.gameManager.getLevelManager().getLevel().getHitScore());
		if(player.getScore() > user.getHighScore() && highScoreChecker) {
			Game.gameManager.getGamePanel().getSound().newHighscoreEffect();
			Game.gameManager.getGamePanel().displayNewHighScoreUser();
			highScoreChecker = false;
		}

	}
	
	public void takeDamage(int damage) {
		Game.gameManager.getGamePanel().getSound().playerDamageEffect();
		player.setHealth(player.getHealth() - damage);
		new Thread(new Runnable()
		{
		    @Override
		    public void run()
		    {
		    	player.setCanCollision(false);
		        
		        try {
					Thread.sleep(player.getGhostModeTime());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		     
		        player.setCanCollision(true);
		    }
		}).start();
		
	}
	
	public boolean isDead() {
		return player.getHealth() == 0;
	}

	public boolean isCollision(Rectangle area1, Rectangle area2) {
		if(area1.intersects(area2) && player.getCanCollision())
		{
		    return true;
		}
		return false;
	}

	public void changeHighScore(User user, int score) {
		if(user.getHighScore() < score) {
			user.setHighScore(score);
			Game.fileManager.addHighScore(user.getUsername(), score);
		}
	}
	
}
