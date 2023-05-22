package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import screens.GamePanel;

public class Alien extends Character {

	private String type;
	private int bulletCreateDelay;
	private int speedX;
	private int speedY;
	private BufferedImage aliensImg1;
	private BufferedImage aliensImg2;
	
	public Alien(String type) {
		setAlienByType(type);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getBulletCreateDelay() {
		return bulletCreateDelay;
	}

	public void setBulletCreateDelay(int bulletCreateDelay) {
		this.bulletCreateDelay = bulletCreateDelay;
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
				setAliensImg("/img/alien_1_1.png", "/img/alien_1_2.png");
				setBulletImg("/img/bullet_2_1.png", "/img/bullet_2_2.png");
				setHealth(5);
				setStartX(0);
				setEndX(GamePanel.screenWidth/2);
				setStartY(0);
				setEndY(GamePanel.screenHeight * 2);
				setPosX(getStartX());
				setPosY(getStartY());
				setDamage(1);
				setSpeedX(4);
				setSpeedY(1);
				setBulletCreateDelay(300);
				setBulletSpeed(-5);			
				setSizeWidth(GamePanel.tileSize);
				setSizeHeight(GamePanel.tileSize);
				setCollisionArea();
				break;
				
			case "alien2":
				setAliensImg("/img/alien_2_1.png", "/img/alien_2_2.png");
				setBulletImg("/img/bullet_4_1.png", "/img/bullet_4_2.png");
				setHealth(5);
				setStartX(GamePanel.screenWidth/2);
				setEndX(GamePanel.screenWidth);
				setStartY(GamePanel.tileSize * 5);
				setEndY(GamePanel.tileSize * 10);
				setSizeWidth(GamePanel.tileSize);
				setSizeHeight(GamePanel.tileSize);
				setPosX(getStartX());
				setPosY(getStartY());
				setDamage(1);
				setSpeedX(4);
				setSpeedY(2);
				setBulletCreateDelay(200);
				setBulletSpeed(-5);		
				setCollisionArea();
				break;
				
			case "alien3":
				setAliensImg("/img/alien_3_1.png", "/img/alien_3_2.png");
				setBulletImg("/img/bullet_3_1.png", "/img/bullet_3_2.png");
				setHealth(5);
				setStartX(0);
				setEndX(GamePanel.screenWidth);
				setStartY(0);
				setEndY(0);
				setPosX(getStartX());
				setPosY(getStartY());
				setDamage(1);
				setSpeedX(5);
				setSpeedY(0);
				setBulletCreateDelay(400);
				setBulletSpeed(-7);			
				setSizeWidth(GamePanel.tileSize);
				setSizeHeight(GamePanel.tileSize);
				setCollisionArea();
				break;
		default:
			break;
		}
		setType(type);
	}

}
