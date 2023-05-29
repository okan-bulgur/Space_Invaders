package Aliens;

import screens.GamePanel;

public class Alien6 extends Alien {
	
	private String aliensImg1 = "/img/alien_6_1.png";
	private String aliensImg2 = "/img/alien_6_2.png";
	private String bulletImg1 = "/img/bullet_6_1.png";
	private String bulletImg2 = "/img/bullet_6_2.png";
	private int health = 8;
	private int damage = 1;
	private int width = GamePanel.tileSize + 30;
	private int height = GamePanel.tileSize + 30;
	private String shootingType = "cross";
	
	public Alien6(int posX, int endPosX, int posY, int endPosY, int speedX, int speedY, int bulletSpeedX, int bulletSpeedY, int bulletDelay) {
		setAliensImg(aliensImg1, aliensImg2);
		setBulletImg(bulletImg1, bulletImg2);
		setHealth(health);
		setDamage(damage);			
		setSizeWidth(width);
		setSizeHeight(height);
		setShootingType(shootingType);
		setStartX(posX);
		setEndX(endPosX);
		setStartY(posY);
		setEndY(endPosY);
		setPosX(getStartX());
		setPosY(getStartY());
		setSpeedX(speedX);
		setSpeedY(speedY);
		setBulletSpeedX(bulletSpeedX);
		setBulletSpeedY(bulletSpeedY);
		setBulletCreateDelay(bulletDelay);
		setCollisionArea();
	}
}