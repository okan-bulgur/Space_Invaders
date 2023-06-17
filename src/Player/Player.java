package Player;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.Character;
import Screens.GamePanel;
import Users.User;

public class Player extends Character {
	
	private User user;
	private BufferedImage playerImg;
	private BufferedImage playerBackFireImg;
	private BufferedImage playerBackFire2Img;
	
	private int health = 3;
	private int score = 0;
	private int posX = GamePanel.tileSize * 11;
	private int posY = GamePanel.tileSize * 10;
	private int speedX = 4;
	private int speedY = 4;
	private int damage = 1;
	private int bulletSpeedX = 0;
	private int bulletSpeedY = 10;
	private int width = GamePanel.tileSize;
	private int height = GamePanel.tileSize;
	private String bulletImgPath1 = "/img/bullet_player_1.png";
	private String bulletImgPath2 = "/img/bullet_player_2.png";
	private String damageBoostBulletImgPath1 = "/img/damageBoostBullet_1.png";
	private String damageBoostBulletImgPath2 = "/img/damageBoostBullet_2.png";
	private String speedBoostBulletImgPath1 = "/img/speedBoostBullet_1.png";
	private String speedBoostBulletImgPath2 = "/img/speedBoostBullet_2.png";
	private int ghostModeTime = 1500;
	private boolean canCollision = true;

	public Player(User user) {
		setUser(user);
		setShootingType("vertical_up");
		setHealth(health);
		setScore(score);
		setPosX(posX);
		setPosY(posY);
		setSpeedX(speedX);
		setSpeedY(speedY);
		setDamage(damage);
		setBulletSpeedX(bulletSpeedX);
		setBulletSpeedY(bulletSpeedY);
		setSizeWidth(width);
		setSizeHeight(height);
		setCollisionArea();
		setPlayerImage();
		setBulletImg(bulletImgPath1, bulletImgPath2);
		setGhostModeTime(ghostModeTime);
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
	
	public String getBulletImgPath1() {
		return bulletImgPath1;
	}
	
	public String getBulletImgPath2() {
		return bulletImgPath2;
	}
	
	public String getDamageBoostBulletImgPath1() {
		return damageBoostBulletImgPath1;
	}
	
	public String getDamageBoostBulletImgPath2() {
		return damageBoostBulletImgPath2;
	}
	
	public String getSpeedBoostBulletImgPath1() {
		return speedBoostBulletImgPath1;
	}
	
	public String getSpeedBoostBulletImgPath2() {
		return speedBoostBulletImgPath2;
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

	public boolean getCanCollision() {
		return canCollision;
	}

	public void setCanCollision(boolean canCollision) {
		this.canCollision = canCollision;
	}
	
}
