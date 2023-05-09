package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

public class Bulletmanager {
	
	private Bullet bullet;
	private ArrayList<Bullet> bullets;
	private BufferedImage bulletImg;
	
	private KeyHandler keyHandler;
	private Player player;
	
	public Bulletmanager(KeyHandler keyHandler, Player player) {
		bullets = new ArrayList<Bullet>();
		this.keyHandler = keyHandler;
		this.player = player;
	}

	public Bullet createBullet() {
		return new Bullet(null, player);
	}
	
	public void getBulletImage() {
		try {
			bulletImg = ImageIO.read(getClass().getResourceAsStream("/img/ship_back_fire_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawBullet(Graphics2D g2, int tileSize) {
		getBulletImage();
		Iterator<Bullet> itr = bullets.listIterator();
		while (itr.hasNext()) {
			bullet = itr.next();
			if(bullet != null) {
				g2.drawImage(bulletImg, bullet.getPosX() + tileSize/3, bullet.getPosY(), tileSize/3, tileSize/3, null);					
			}		
		}
	}
	
	public void update() {

		if(keyHandler.isSpacepress()) {
			Bullet newBullet = createBullet();	
			bullets.add(newBullet);
		}
		
		if(bullets.size() > 0) {
			Iterator<Bullet> itr = bullets.listIterator();
			while (itr.hasNext()) {
				bullet = itr.next();
				if(bullet != null) {
					bullet.setPosY(bullet.getPosY() - bullet.getSpeed());		
					if(bullet.getPosY() <= 0) {
						itr.remove();
						System.out.println("b1: " + bullet + " size: " + bullets.size());
						bullet = null;
						System.gc();
					}
				}
					
			}
		}
	}
	
	
	
}
