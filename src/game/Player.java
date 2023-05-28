package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import screens.GamePanel;
import users.User;

public class Player extends Character {
	
	private User user;
	private int score;
	private int ghostModeTime;
	private BufferedImage playerImg;
	private BufferedImage playerBackFireImg;
	private BufferedImage playerBackFire2Img;

	public Player(User user) {
		setUser(user);
		setShootingType("vertical_up");
		setHealth(3);
		setScore(0);
		setPosX(GamePanel.tileSize*11);
		setPosY(GamePanel.tileSize*10);
		setSpeed(4);
		setDamage(1);
		setBulletSpeedX(0);
		setBulletSpeedY(10);
		setSizeWidth(GamePanel.tileSize);
		setSizeHeight(GamePanel.tileSize);
		setCollisionArea();
		setPlayerImage();
		setBulletImg("/img/bullet_player_1.png", "/img/bullet_player_2.png");
		setGhostModeTime(1500);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getGhostModeTime() {
		return ghostModeTime;
	}

	public void setGhostModeTime(int ghostModeTime) {
		this.ghostModeTime = ghostModeTime;
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
	
}
