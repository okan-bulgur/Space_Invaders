package Bullet;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Character;
import game.ICanCollision;
import screens.GamePanel;

public class Bullet extends Bulletmanager implements ICanCollision{

	private Character character;
	private int damage;
	private int speedX;
	private int speedY;
	private int posX;
	private int posY;
	private int sizeWidth = GamePanel.tileSize;
	private int sizeHeight = GamePanel.tileSize;
	protected BufferedImage bulletImg;
	protected BufferedImage bulletImg2;
	protected Rectangle collisionArea;

	public Bullet(Character character, int speedX, int speedY) {
		setCharacter(character);
		setDamage(character.getDamage());
		setSpeedX(speedX);
		setSpeedY(speedY);
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

	@Override
	public void setCollisionArea() {
		collisionArea = new Rectangle();
		collisionArea.x = posX + 10;
		collisionArea.y = posY;
		collisionArea.width = sizeWidth - 20;
		collisionArea.height = sizeHeight;
	}

	@Override
	public Rectangle getCollisionArea() {
		return collisionArea;
	}
}
