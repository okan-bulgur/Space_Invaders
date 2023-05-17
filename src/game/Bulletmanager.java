package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

public class Bulletmanager implements ICollision {
	
	private Bullet bullet;
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private BufferedImage bulletImg;
	
	public Bulletmanager() {
	}

	public ArrayList<Bullet> getBullets(){
		return bullets;
	}
	
	public void createBullet(Character character) {
		Bullet newBullet = new Bullet(character);
		bullets.add(newBullet);
	}
	
	public void getBulletImage() {
		try {
			bulletImg = ImageIO.read(getClass().getResourceAsStream("/img/ship_back_fire_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawCharacter(Graphics2D g2) {
		getBulletImage();
		Iterator<Bullet> itr = bullets.listIterator();
		while (itr.hasNext()) {
			bullet = itr.next();
			if(bullet != null) {
				g2.drawImage(bulletImg, bullet.getPosX() + bullet.getSizeWidth(), bullet.getPosY(), bullet.getSizeWidth(), bullet.getSizeHeight(), null);					
			}		
		}
	}
	
	public void update() {
		
		if(bullets.size() > 0) {
			Iterator<Bullet> itr = bullets.listIterator();
			while (itr.hasNext()) {
				bullet = itr.next();
				if(bullet != null) {
					bullet.setPosY(bullet.getPosY() - bullet.getSpeed());		
					bullet.setCollisionArea();
					if(bullet.getPosY() <= 0) {
						itr.remove();
						bullet = null;
						System.gc();
					}
				}
					
			}
		}
	}
	
	@Override
	public boolean isCollision(Rectangle area1, Rectangle area2) {
		if(area1.intersects(area2))
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
