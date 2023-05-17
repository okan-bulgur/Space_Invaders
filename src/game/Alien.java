package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Alien extends Character {

	private String type;
	private BufferedImage aliensImg1;
	private BufferedImage aliensImg2;
	
	public Alien(String type) {
		setAlienByType(type);
		setCollisionArea();
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
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
				setHealth(5);
				setPosX(50);
				setPosY(50);
				setDamage(1);
				setSpeed(4);
				setBulletSpeed(5);			
				setSizeWidth(GameManager.tileSize);
				setSizeHeight(GameManager.tileSize);
				break;
			case "alien2":
				setAliensImg("/img/alien1.png", "/img/alien2.png");
				setHealth(5);
				setPosX(50);
				setPosY(200);
				setDamage(1);
				setSpeed(2);
				setBulletSpeed(5);			
				setSizeWidth(GameManager.tileSize);
				setSizeHeight(GameManager.tileSize);
				break;
		default:
			break;
		}
		setType(type);
	}

}
