package game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import users.User;

public class Player extends PlayerManager{
	
	private int health = 100;
	private int score = 0;
	private int posX = 100;
	private int posY = 100;
	private int speed = 4;
	private int damage = 10;
	private int bulletSpeed = 5;
	protected Rectangle collisionArea;
	private BufferedImage playerImg;
	private BufferedImage playerBackFireImg;
	private BufferedImage playerBackFire2Img;
	private User user;
	
	public Player(User user) {
		this.user = user;
		setPlayerImage();
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
	
	public void setPlayerImage() {
		try {
			playerImg = ImageIO.read(getClass().getResourceAsStream("/img/ship.png"));
			playerBackFireImg = ImageIO.read(getClass().getResourceAsStream("/img/ship_back_fire.png"));
			playerBackFire2Img = ImageIO.read(getClass().getResourceAsStream("/img/ship_back_fire_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getPlayerImg() {
		return playerImg;
	}

	public BufferedImage getPlayerBackFireImg() {
		return playerBackFireImg;
	}

	public BufferedImage getPlayerBackFire2Img() {
		return playerBackFire2Img;
	}
	
	/*
	public void setCollisionArea() {
		collisionArea.x = posX;
		collisionArea.y = posY;
		collisionArea.width = GameManager.tileSize;
		collisionArea.height = GameManager.tileSize;
	}	
	*/
}
