package Bullet;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import Game.Character;
import Game.Game;
import Screens.GamePanel;

public class Bulletmanager {
	
	private Bullet bullet;
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	public ArrayList<Bullet> getBullets(){
		return bullets;
	}
	
	public void createBullet(Character character, int speedX, int speedY) {
		Bullet newBullet = new Bullet(character, speedX, speedY);
		bullets.add(newBullet);
	}
	
	public void drawBullets(Graphics2D g2) {
		for(int i=0 ; i < bullets.size() ; i++) {
			bullet = bullets.get(i);
			if(bullet != null) {			
				if(!Game.gameManager.getAnimationManager().isBulletAnimation()) {
					g2.drawImage(bullet.getBulletImg(), bullet.getPosX() + bullet.getSizeWidth()/7, bullet.getPosY() - bullet.getSizeHeight()/3, bullet.getSizeWidth(), bullet.getSizeHeight(), null);		
				}
				else if(Game.gameManager.getAnimationManager().isBulletAnimation()) {
					g2.drawImage(bullet.getBulletImg2(), bullet.getPosX() + bullet.getSizeWidth()/7, bullet.getPosY() - bullet.getSizeHeight()/3, bullet.getSizeWidth(), bullet.getSizeHeight(), null);	
				}
			}		
		}
	}
	
	public void update() {
		
		if(bullets.size() > 0) {
			for(int i=0 ; i < bullets.size() ; i++) {
				bullet = bullets.get(i);
				if(bullet != null) {
					bullet.setPosY(bullet.getPosY() - bullet.getSpeedY());		
					bullet.setPosX(bullet.getPosX() + bullet.getSpeedX());	
					bullet.setCollisionArea();
					if(bullet.getPosY() <= 0 || bullet.getPosY() >= GamePanel.screenHeight || bullet.getPosX() <= -50 || bullet.getPosX() >= GamePanel.screenWidth) {
						bullets.remove(i);
						bullet = null;
					}
				}		
			}
		}
	}
	
	public boolean isCollision(Rectangle area1, Rectangle area2) {
		if(area1.intersects(area2))
		{
		    return true;
		}
		return false;
	}
}
