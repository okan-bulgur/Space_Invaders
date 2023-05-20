package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import screens.GamePanel;

public class Alien extends Character {

	private String type;
	private int bulletCreateDelay;
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
				setBulletImg("/img/alien_bullet_2.png");
				setHealth(5);
				setPosX(50);
				setPosY(50);
				setDamage(1);
				setSpeed(4);
				setBulletCreateDelay(300);
				setBulletSpeed(-5);			
				setSizeWidth(GamePanel.tileSize);
				setSizeHeight(GamePanel.tileSize);
				setCollisionArea();
				break;
				
			case "alien2":
				setAliensImg("/img/alien_2_1.png", "/img/alien_2_2.png");
				setBulletImg("/img/alien_bullet_1.png");
				setHealth(5);
				setPosX(50);
				setPosY(200);
				setDamage(1);
				setSpeed(2);
				setBulletCreateDelay(200);
				setBulletSpeed(-5);			
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
