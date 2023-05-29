package level;

import Aliens.AliensManager;
import game.Game;

public abstract class Levels{

	private AliensManager aliensManager = Game.gameManager.getAliensManager();
	private int hitScore;
	private int boostSpeedX;
	private int boostSpeedY;
	private int boostBulletDelay;
	private int boostBulletSpeedX;
	private int boostBulletSpeedY;
	
	public AliensManager getAliensManager() {
		return aliensManager;
	}

	public void setAliensManager(AliensManager aliensManager) {
		this.aliensManager = aliensManager;
	}

	public int getHitScore() {
		return hitScore;
	}
	
	public void setHitScore(int hitScore) {
		this.hitScore = hitScore;
	}
	
	public int getBoostSpeedX() {
		return boostSpeedX;
	}

	public void setBoostSpeedX(int boostSpeedX) {
		this.boostSpeedX = boostSpeedX;
	}

	public int getBoostSpeedY() {
		return boostSpeedY;
	}

	public void setBoostSpeedY(int boostSpeedY) {
		this.boostSpeedY = boostSpeedY;
	}

	public int getBoostBulletDelay() {
		return boostBulletDelay;
	}

	public void setBoostBulletDelay(int boostBulletDelay) {
		this.boostBulletDelay = boostBulletDelay;
	}

	public int getBoostBulletSpeedX() {
		return boostBulletSpeedX;
	}

	public void setBoostBulletSpeedX(int boostBulletSpeedX) {
		this.boostBulletSpeedX = boostBulletSpeedX;
	}

	public int getBoostBulletSpeedY() {
		return boostBulletSpeedY;
	}

	public void setBoostBulletSpeedY(int boostBulletSpeedY) {
		this.boostBulletSpeedY = boostBulletSpeedY;
	}

	public abstract void runLevel();
}
