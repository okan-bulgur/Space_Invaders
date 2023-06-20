package Ships;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.Character;

public class Ship extends Character {
	
	protected boolean isTakeDamage;
	protected int damageAnimationTime;
	
	protected String shipName;
	
	protected BufferedImage shipImg;
	protected BufferedImage shipBackFireImg1;
	protected BufferedImage shipBackFireImg2;
	
	protected String shipImgPath;
	protected String shipBackFireImgPath1;
	protected String shipBackFireImgPath2;
	protected String bulletImgPath1;
	protected String bulletImgPath2;
	protected String damageBoostBulletImgPath1;
	protected String damageBoostBulletImgPath2;
	protected String speedBoostBulletImgPath1;
	protected String speedBoostBulletImgPath2;
	
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
	public String getShipName() {
		return shipName;
	}
	
	public void setShipImgPath(String shipImgPath, String shipBackFireImgPath1, String shipBackFireImgPath2) {
		this.shipImgPath = shipImgPath;
		this.shipBackFireImgPath1 = shipBackFireImgPath1;
		this.shipBackFireImgPath2 = shipBackFireImgPath2;
	}
	
	public void setBulletImgPath(String bulletImgPath1, String bulletImgPath2) {
		this.bulletImgPath1 = bulletImgPath1;
		this.bulletImgPath2 = bulletImgPath2;
	}
		
	public void setDamageBoostBulletImgPath(String damageBoostBulletImgPath1, String damageBoostBulletImgPath2) {
		this.damageBoostBulletImgPath1 = damageBoostBulletImgPath1;
		this.damageBoostBulletImgPath2 = damageBoostBulletImgPath2;
	}
	
	public void setSpeedBoostBulletImgPath(String speedBoostBulletImgPath1, String speedBoostBulletImgPath2) {
		this.speedBoostBulletImgPath1 = speedBoostBulletImgPath1;
		this.speedBoostBulletImgPath2 = speedBoostBulletImgPath2;
	}
	
	public void setShipImg() {
		try {
			shipImg = ImageIO.read(getClass().getResourceAsStream(shipImgPath));
			shipBackFireImg1 = ImageIO.read(getClass().getResourceAsStream(shipBackFireImgPath1));
			shipBackFireImg2 = ImageIO.read(getClass().getResourceAsStream(shipBackFireImgPath2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getShipImg() {
		return shipImg;
	}

	public BufferedImage getShipBackFireImg1() {
		return shipBackFireImg1;
	}
	
	public BufferedImage getShipBackFireImg2() {
		return shipBackFireImg2;
	}
	
	public void setDefaultBulletImg() {
		setBulletImg(bulletImgPath1, bulletImgPath2);
	}
	
	public void setDamageBoostBulletImg() {
		setBulletImg(damageBoostBulletImgPath1, damageBoostBulletImgPath2);
	}
	
	public void setSpeedBoostBulletImg() {
		setBulletImg(speedBoostBulletImgPath1, speedBoostBulletImgPath2);
	}
	
	public void setDamageAnimationTime(int damageAnimationTime) {
		this.damageAnimationTime = damageAnimationTime;
	}
	
	public void setIsTakeDamage(boolean isTakeDamage) {
		this.isTakeDamage = isTakeDamage;
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