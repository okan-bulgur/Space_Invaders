package game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import screens.GamePanel;

public class Bullet extends Bulletmanager {

	private Character character;
	private int damage;
	private int speed;
	private int posX;
	private int posY;
	private int sizeWidth = GamePanel.tileSize;
	private int sizeHeight = GamePanel.tileSize;
	protected BufferedImage bulletImg;
	protected BufferedImage bulletImg2;
	protected Rectangle collisionArea;

	public Bullet(Character character) {
		setCharacter(character);
		setDamage(character.getDamage());
		setSpeed(character.getBulletSpeed());
		setPosX(character.getPosX());
		setPosY(character.getPosY());
		setBulletImg(character.getBulletImg(), character.getBulletImg2());
		setCollisionArea();
	}
	
	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
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
	
	public BufferedImage getBulletImg2() {
		return bulletImg2;
	}

	public void setBulletImg(BufferedImage bufferedImage, BufferedImage bufferedImage2) {
		this.bulletImg = bufferedImage;
		this.bulletImg2 = bufferedImage2;
	}

	public void setCollisionArea() {
		collisionArea = new Rectangle();
		collisionArea.x = posX + 10;
		collisionArea.y = posY;
		collisionArea.width = sizeWidth - 20;
		collisionArea.height = sizeHeight;
	}


}
