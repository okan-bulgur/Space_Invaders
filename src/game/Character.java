package game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import screens.GamePanel;

public abstract class Character  {
	
	protected int health;
	protected int startX;
	protected int endX;
	protected int startY;
	protected int endY;
	protected int posX;
	protected int posY;
	protected int speed;
	protected int damage;
	protected int bulletSpeed;
	protected int sizeWidth;
	protected int sizeHeight;
	protected BufferedImage bulletImg;
	protected BufferedImage bulletImg2;
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
	
	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}	
	
	public BufferedImage getBulletImg() {
		return bulletImg;
	}
	
	public BufferedImage getBulletImg2() {
		return bulletImg2;
	}

	public void setBulletImg(String bulletImg, String bulletImg2) {
		try {
			this.bulletImg = ImageIO.read(getClass().getResource(bulletImg));
			this.bulletImg2 = ImageIO.read(getClass().getResource(bulletImg2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setCollisionArea() {
		collisionArea = new Rectangle();
		collisionArea.x = posX + GamePanel.tileSize/GamePanel.scale;
		collisionArea.y = posY + GamePanel.tileSize/GamePanel.scale;
		collisionArea.width = sizeWidth - GamePanel.tileSize/GamePanel.scale;
		collisionArea.height = sizeHeight - GamePanel.tileSize/GamePanel.scale;
	}
	
}
