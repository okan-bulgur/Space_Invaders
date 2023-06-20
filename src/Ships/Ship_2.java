package Ships;

import Screens.GamePanel;

public class Ship_2 extends Ship{
	
	private String name = "Ship_2";
	private int health = 3;
	private int damage = 1;
	private int posX = GamePanel.tileSize * 11;
	private int posY = GamePanel.tileSize * 10;
	private String shootingType = "vertical_up";
	private int speedX = 4;
	private int speedY = 4;
	private int bulletSpeedX = 0;
	private int bulletSpeedY = 10;
	private int width = GamePanel.tileSize;
	private int height = GamePanel.tileSize;
	protected boolean isTakeDamage = false;
	protected int damageAnimationTime = 1500;
	
	private String shipImgPath = "/img/ship.png";
	private String shipBackFireImgPath1 = "/img/ship_back_fire_1.png";
	private String shipBackFireImgPath2 = "/img/ship_back_fire_2.png";
	private String bulletImgPath1 = "/img/bullet_player_1.png";
	private String bulletImgPath2 = "/img/bullet_player_2.png";
	private String damageBoostBulletImgPath1 = "/img/damageBoostBullet_1.png";
	private String damageBoostBulletImgPath2 = "/img/damageBoostBullet_2.png";
	private String speedBoostBulletImgPath1 = "/img/speedBoostBullet_1.png";
	private String speedBoostBulletImgPath2 = "/img/speedBoostBullet_2.png";

	public Ship_2() {
		setShipName(name);
		setHealth(health);
		setDamage(damage);
		setPosX(posX);
		setPosY(posY);
		setShootingType(shootingType);
		setSpeedX(speedX);
		setSpeedY(speedY);
		setBulletSpeedX(bulletSpeedX);
		setBulletSpeedY(bulletSpeedY);
		setSizeWidth(width);
		setSizeHeight(height);
		setCollisionArea();
		setIsTakeDamage(isTakeDamage);
		setDamageAnimationTime(damageAnimationTime);
		setShipImgPath(shipImgPath, shipBackFireImgPath1, shipBackFireImgPath2);
		setShipImg();
		setBulletImgPath(bulletImgPath1, bulletImgPath2);
		setDamageBoostBulletImgPath(damageBoostBulletImgPath1, damageBoostBulletImgPath2);
		setSpeedBoostBulletImgPath(speedBoostBulletImgPath1, speedBoostBulletImgPath2);
		setDefaultBulletImg();
	}
}
