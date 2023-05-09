package game;

import java.awt.Color;

import users.User;

public class Player extends PlayerManager{
	
	private int health = 100;
	private int score = 0;
	private int posX = 100;
	private int posY = 100;
	private int speed = 4;
	private int damage = 10;
	private int bulletSpeed = 5;
	private Color color = Color.white;
	private User user;
	
	public Player(KeyHandler keyHandler, User user) {
		super(keyHandler);
		this.user = user;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
