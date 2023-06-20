package Ships;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import Game.Game;
import Objects.Object;
import Screens.GamePanel;

public class ShipManager {
	
	Ship ship = null;
	
	private int bulletDelayCounter = 0;
	private int bulletChecker = 0;
	
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public Ship getShip() {
		return ship;
	}
	
	public void drawCharacter(Graphics2D g2) {
		if(ship.isTakeDamage() && !Game.gameManager.getAnimationManager().isPlayerAnimation()) {
			AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
			g2.setComposite(composite);
			g2.drawImage(ship.getShipImg() , ship.getPosX(), ship.getPosY(), ship.getSizeWidth(), ship.getSizeHeight(), null);	
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); 
		}
		else {
			g2.drawImage(ship.getShipImg() , ship.getPosX(), ship.getPosY(), ship.getSizeWidth(), ship.getSizeHeight(), null);			
		}
		if(!Game.gameManager.getAnimationManager().isPlayerAnimation()) {
			g2.drawImage(ship.getShipBackFireImg1() , ship.getPosX() + GamePanel.tileSize/3, ship.getPosY() + GamePanel.tileSize, ship.getSizeWidth()/3, ship.getSizeHeight()/3, null);			
		}
		else if(Game.gameManager.getAnimationManager().isPlayerAnimation()) {
			g2.drawImage(ship.getShipBackFireImg2(), ship.getPosX() + GamePanel.tileSize/3, ship.getPosY() + GamePanel.tileSize, ship.getSizeWidth()/3, ship.getSizeHeight()/3, null);	
		}
	}
	
	public void update() {
		
		shipControl();
		ship.setCollisionArea();
		
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
	
	public void shipControl() {
		if(Game.gameManager.getKeyHandler().isUpPress() && (ship.getPosY() - ship.getSpeedY()) > 0 ) {
			ship.setPosY(ship.getPosY() - ship.getSpeedY());
		}
		if(Game.gameManager.getKeyHandler().isDownpress() && (ship.getPosY() + ship.getSpeedY() + ship.getSizeHeight() * 1.2 < GamePanel.screenHeight) ) {
			ship.setPosY(ship.getPosY() + ship.getSpeedY());
		}
		if(Game.gameManager.getKeyHandler().isRightPress() && (ship.getPosX() + ship.getSpeedX() + ship.getSizeWidth() < GamePanel.screenWidth) ) {
			ship.setPosX(ship.getPosX() + ship.getSpeedX());
		}
		if(Game.gameManager.getKeyHandler().isLeftpress() && (ship.getPosX() - ship.getSpeedX()) > 0 ) {
			ship.setPosX(ship.getPosX() - ship.getSpeedX());
		}
		if(Game.gameManager.getKeyHandler().isSpacepress() && !ship.isTakeDamage() && bulletDelayCounter == 1) {
			Game.gameManager.getShootingManager().shooting(ship);
		}
	}
	
	public void takeDamage(int damage) {
		Game.sound.playerDamageEffect();
		ship.setTakeDamage();
		ship.setHealth(ship.getHealth() - damage);
	}
	
	public boolean isDead() {
		return ship.getHealth() == 0;
	}

	public boolean isCollision(Rectangle area1, Rectangle area2) {
		if(area1.intersects(area2) && !ship.isTakeDamage())
		{
		    return true;
		}
		return false;
	}
	
	public void boostHealth(Object object) {
		ship.setHealth(ship.getHealth() + object.getBoost());
	}
	
	public void boostSpeed(final Object object) {
		ship.setSpeedX(ship.getSpeedX() + object.getBoost());
		ship.setSpeedY(ship.getSpeedY() + object.getBoost());
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				ship.setSpeedX(ship.getSpeedX() - object.getBoost());
				ship.setSpeedY(ship.getSpeedY() - object.getBoost());
			}
		};

		timer.schedule(task, object.getBoostTime());
	}
	
	public void boostBulletSpeed(final Object object) {
		ship.setBulletSpeedX(ship.getBulletSpeedX() + object.getBoost());
		ship.setBulletSpeedY(ship.getBulletSpeedY() + object.getBoost());
		ship.setSpeedBoostBulletImg();
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				ship.setDefaultBulletImg();
				ship.setBulletSpeedX(ship.getBulletSpeedX() - object.getBoost());
				ship.setBulletSpeedY(ship.getBulletSpeedY() - object.getBoost());
			}
		};

		timer.schedule(task, object.getBoostTime());
	}
	
	public void boostDamage(final Object object) {
		ship.setDamage(ship.getDamage() + object.getBoost());
		ship.setDamageBoostBulletImg();
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				ship.setDefaultBulletImg();
				ship.setDamage(ship.getDamage() - object.getBoost());
			}
		};
		
		timer.schedule(task, object.getBoostTime());
	}

}
