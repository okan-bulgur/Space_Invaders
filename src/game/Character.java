package game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Character  {
	
	protected int health;
	protected int posX;
	protected int posY;
	protected int speed;
	protected int damage;
	protected int bulletSpeed;
	protected int sizeWidth;
	protected int sizeHeight;
	protected BufferedImage bulletImg;
	protected Rectangle collisionArea;
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getBulletSpeed() {
		return bulletSpeed;
	}
	
	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}
	
	public void setSizeWidth(int width) {
		this.sizeWidth = width;
	}
	
	public int getSizeWidth() {
		return sizeWidth;
	}
	
	public void setSizeHeight(int height) {
		this.sizeHeight = height;
	}

	public int getSizeHeight() {
		return sizeHeight;
	}
	
	public BufferedImage getBulletImg() {
		return bulletImg;
	}

	public void setBulletImg(String bulletImg) {
		try {
			this.bulletImg = ImageIO.read(getClass().getResource(bulletImg));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setCollisionArea() {
		collisionArea = new Rectangle();
		collisionArea.x = posX;
		collisionArea.y = posY;
		collisionArea.width = sizeWidth;
		collisionArea.height = sizeHeight;
	}	
	
}
