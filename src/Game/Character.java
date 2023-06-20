package Game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Screens.GamePanel;

public abstract class Character implements ICanCollision {
	
	protected int health;
	protected int posX;
	protected int posY;
	protected int startX;
	protected int endX;
	protected int startY;
	protected int endY;
	protected int sizeWidth;
	protected int sizeHeight;
	protected int speedX;
	protected int speedY;
	protected int damage;
	protected int bulletSpeedX;
	protected int bulletSpeedY;
	protected boolean isTakeDamage;
	protected int damageAnimationTime;
	protected String shootingType;
	protected BufferedImage characterImg1;
	protected BufferedImage characterImg2;
	protected BufferedImage bulletImg1;
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

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getBulletSpeedX() {
		return bulletSpeedX;
	}
	
	public void setBulletSpeedX(int bulletSpeedX) {
		this.bulletSpeedX = bulletSpeedX;
	}
	
	public int getBulletSpeedY() {
		return bulletSpeedY;
	}
	
	public void setBulletSpeedY(int bulletSpeedY) {
		this.bulletSpeedY = bulletSpeedY;
	}
	
	public String getShootingType() {
		return shootingType;
	}

	public void setShootingType(String shootingType) {
		this.shootingType = shootingType;
	}
	
	public BufferedImage getCharacterImg1() {
		return characterImg1;
	}
	
	public BufferedImage getCharacterImg2() {
		return characterImg2;
	}

	public void setCharacterImg(String characterImg1, String characterImg2) {
		try {
			this.characterImg1 = ImageIO.read(getClass().getResource(characterImg1));
			this.characterImg2 = ImageIO.read(getClass().getResource(characterImg2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public BufferedImage getBulletImg1() {
		return bulletImg1;
	}
	
	public BufferedImage getBulletImg2() {
		return bulletImg2;
	}

	public void setBulletImg(String bulletImg1, String bulletImg2) {
		try {
			this.bulletImg1 = ImageIO.read(getClass().getResource(bulletImg1));
			this.bulletImg2 = ImageIO.read(getClass().getResource(bulletImg2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setCollisionArea() {
		collisionArea = new Rectangle();
		collisionArea.x = posX + GamePanel.tileSize/GamePanel.scale;
		collisionArea.y = posY + (GamePanel.tileSize/GamePanel.scale)*4;
		collisionArea.width = sizeWidth - (GamePanel.tileSize/GamePanel.scale)*2;
		collisionArea.height = sizeHeight - (GamePanel.tileSize/GamePanel.scale)*4;
	}	
	
	@Override
	public Rectangle getCollisionArea() {
		return collisionArea;
	}
}
