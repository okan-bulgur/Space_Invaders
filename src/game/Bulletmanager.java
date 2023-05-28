package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.ListIterator;

import screens.GamePanel;

public class Bulletmanager {
	
	private Bullet bullet;
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private static int spriteCounter = 0;
	private static int spriteNum = 0;
	
	public Bulletmanager() {
	}

	public ArrayList<Bullet> getBullets(){
		return bullets;
	}
	
	public void createBullet(Character character) {
		Bullet newBullet = new Bullet(character);
		bullets.add(newBullet);
	}
	
	public void drawBullets(Graphics2D g2) {
		for(int i=0 ; i < bullets.size() ; i++) {
			bullet = bullets.get(i);
			if(bullet != null) {			
				if(spriteNum == 0) {
					g2.drawImage(bullet.getBulletImg(), bullet.getPosX() + bullet.getSizeWidth()/7, bullet.getPosY() - bullet.getSizeHeight()/3, bullet.getSizeWidth(), bullet.getSizeHeight(), null);		
				}
				else if(spriteNum == 1) {
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
					bullet.setPosY(bullet.getPosY() - bullet.getSpeed());		
					bullet.setCollisionArea();
					if(bullet.getPosY() <= 0 || bullet.getPosY() >= GamePanel.screenHeight) {
						bullets.remove(i);
						bullet = null;
					}
				}		
			}
		}
		
		spriteCounter++;
		if(spriteCounter > 13) {
			if(spriteNum == 1) {
				spriteNum = 0;
			}
			else {
				spriteNum = 1;
			}
			spriteCounter = 0;
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
