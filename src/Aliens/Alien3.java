package Aliens;

import screens.GamePanel;

public class Alien3 extends Alien {
	
	private String aliensImg1 = "/img/alien_3_1.png";
	private String aliensImg2 = "/img/alien_3_2.png";
	private String bulletImg1 = "/img/bullet_3_1.png";
	private String bulletImg2 = "/img/bullet_3_2.png";
	private int health = 6;
	private int damage = 1;
	private int width = GamePanel.tileSize;
	private int height = GamePanel.tileSize;
	private String shootingType = "vertical_double";
	
	public Alien3(int posX, int endPosX, int posY, int endPosY, int speedX, int speedY, int bulletSpeedX, int bulletSpeedY, int bulletDelay) {
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