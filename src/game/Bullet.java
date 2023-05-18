package game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bullet extends Bulletmanager {

	private Character character;
	private int damage;
	private int speed;
	private int posX;
	private int posY;
	private int sizeWidth = GameManager.tileSize;
	private int sizeHeight = GameManager.tileSize;
	protected BufferedImage bulletImg;
	protected Rectangle collisionArea;

	public Bullet(Character character) {
		this.character = character;
		setDamage(character.getDamage());
		setSpeed(character.getBulletSpeed());
		setPosX(character.getPosX());
		setPosY(character.getPosY());
		setBulletImg(character.getBulletImg());
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
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
	
	public int getSizeWidth() {
		return sizeWidth;
	}
	
	public int getSizeHeight() {
		return sizeHeight;
	}
	
	public BufferedImage getBulletImg() {
		return bulletImg;
	}

	public void setBulletImg(BufferedImage bufferedImage) {
		this.bulletImg = bufferedImage;
	}

	public void setCollisionArea() {
		collisionArea = new Rectangle();
		collisionArea.x = posX;
		collisionArea.y = posY;
		collisionArea.width = sizeWidth;
		collisionArea.height = sizeHeight;
	}


}
