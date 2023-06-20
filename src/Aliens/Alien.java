package Aliens;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.Character;

public class Alien extends Character {
	
	protected String type;
	protected int bulletCreateDelay;
	protected boolean isTakeDamage = false;
	protected int damageAnimationTime = 1000;
	protected BufferedImage aliensImg1;
	protected BufferedImage aliensImg2;
	
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
	
	public boolean isTakeDamage() {
		return isTakeDamage;
	}

	public void setTakeDamage() {
		new Thread (new Runnable() 
		{	
			@Override
			public void run()
		    {
		        try {
		        	isTakeDamage = true;
					Thread.sleep(damageAnimationTime);
					isTakeDamage = false;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		     
		    }
		}).start();
	}
}
