package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Aliens extends AliensManager {

	private String type;
	private int health;
	private int speed;
	private int posX;
	private int posY;
	private int damage;
	private int bulletSpeed;
	private BufferedImage aliensImg1;
	private BufferedImage aliensImg2;
	
	public Aliens(String type) {
		setAlienByType(type);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
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
	
	public BufferedImage getAliensImg1() {
		return aliensImg1;
	}
	
	public BufferedImage getAliensImg2() {
		return aliensImg2;
	}
	
	public void setAliensImg(String img1Path, String img2Path) {
		try {
			aliensImg1 = ImageIO.read(getClass().getResourceAsStream(img1Path));
			aliensImg2 = ImageIO.read(getClass().getResourceAsStream(img2Path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setAlienByType(String type) {
		switch (type) {
			case "alien1":
				setAliensImg("/img/alien1.png", "/img/alien2.png");
				setHealth(100);
				setPosX(50);
				setPosY(50);
				setDamage(10);
				setSpeed(4);
				setBulletSpeed(5);			
				break;
		default:
			break;
		}
	}
}
