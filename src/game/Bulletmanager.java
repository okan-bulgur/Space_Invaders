package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

public class Bulletmanager extends CharacterManager{
	
	private Bullet bullet;
	private ArrayList<Bullet> bullets;
	private BufferedImage bulletImg;
	
	private Player player;
	
	public Bulletmanager(Player player) {
		bullets = new ArrayList<Bullet>();
		this.player = player;
	}

	public Bullet createBullet() {
		return new Bullet(player);
	}
	
	public void getBulletImage() {
		try {
			bulletImg = ImageIO.read(getClass().getResourceAsStream("/img/ship_back_fire_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void drawCharacter(Graphics2D g2) {
		getBulletImage();
		Iterator<Bullet> itr = bullets.listIterator();
		while (itr.hasNext()) {
			bullet = itr.next();
			if(bullet != null) {
				g2.drawImage(bulletImg, bullet.getPosX() + GameManager.tileSize/3, bullet.getPosY(), GameManager.tileSize/3, GameManager.tileSize/3, null);					
			}		
		}
	}
	
	@Override
	public void update() {

		if(GameManager.keyHandler.isSpacepress()) {
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
						bullet = null;
						System.gc();
					}
				}
					
			}
		}
	}

	@Override
	public void collisionDetector() {
		// TODO Auto-generated method stub
		
	}
}
