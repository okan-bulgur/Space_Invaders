package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import screens.GamePanel;
import users.User;

public class Player extends Character {
	
	private int score;
	private BufferedImage playerImg;
	private BufferedImage playerGhostImg;
	private BufferedImage playerBackFireImg;
	private BufferedImage playerBackFire2Img;
	private User user;
	
	public Player(User user) {
		this.user = user;
		setHealth(1);
		setScore(0);
		setPosX(100);
		setPosY(100);
		setSpeed(4);
		setDamage(1);
		setBulletSpeed(5);
		setSizeWidth(GamePanel.tileSize);
		setSizeHeight(GamePanel.tileSize);
		setCollisionArea();
		setPlayerImage();
		setBulletImg("/img/player_bullet_1.png");
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void setPlayerImage() {
		try {
			playerImg = ImageIO.read(getClass().getResourceAsStream("/img/ship.png"));
			playerGhostImg = ImageIO.read(getClass().getResource("/img/new_alien_1.png"));
			playerBackFireImg = ImageIO.read(getClass().getResourceAsStream("/img/ship_back_fire.png"));
			playerBackFire2Img = ImageIO.read(getClass().getResourceAsStream("/img/ship_back_fire_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getPlayerImg() {
		return playerImg;
	}
	
	public BufferedImage getPlayerGhostImage() {
		return playerGhostImg;
	}

	public BufferedImage getPlayerBackFireImg() {
		return playerBackFireImg;
	}

	public BufferedImage getPlayerBackFire2Img() {
		return playerBackFire2Img;
	}
	
}
