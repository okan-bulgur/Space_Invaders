package game;

public class Bullet extends Bulletmanager {

	private int damage = 10;
	private int speed = 5;
	private int posX;
	private int posY;

	public Bullet(Player player) {
		super(player);
		setDamage(player.getDamage());
		setSpeed(player.getBulletSpeed());
		setPosX(player.getPosX());
		setPosY(player.getPosY());
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
