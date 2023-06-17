package Level;

import Aliens.AliensManager;
import Game.Game;

public abstract class Levels{

	protected AliensManager aliensManager = Game.gameManager.getAliensManager();
	protected int hitScore;
	protected int boostSpeedX;
	protected int boostSpeedY;
	protected int boostBulletDelay;
	protected int boostBulletSpeedX;
	protected int boostBulletSpeedY;
	protected int boostTimeDelay;
	protected int maxSpeedX;
	protected int maxSpeedY;
	
	protected int[] objectMaxNum;
	
	public int[] getObjectMaxNum() {
		return objectMaxNum;
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
	
	public int getBoostTimeDelay() {
		return boostTimeDelay;
	}

	public void setBoostTimeDelay(int boostTimeDelay) {
		this.boostTimeDelay = boostTimeDelay;
	}

	public int getMaxSpeedX() {
		return maxSpeedX;
	}

	public void setMaxSpeedX(int maxSpeedX) {
		this.maxSpeedX = maxSpeedX;
	}

	public int getMaxSpeedY() {
		return maxSpeedY;
	}

	public void setMaxSpeedY(int maxSpeedY) {
		this.maxSpeedY = maxSpeedY;
	}
	
	public abstract void runLevel();
}
