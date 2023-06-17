package Level;

import Game.Game;
import Screens.GamePanel;

public class Level1 extends Levels{
	
	private int hitScore = 10;
	private int boostSpeedX = 0;
	private int boostSpeedY = 0;
	private int boostBulletDelay = 0;
	private int boostBulletSpeedX = 0;
	private int boostBulletSpeedY = 0;
	
	public Level1() {
		setHitScore(hitScore);
		setBoostSpeedX(boostSpeedX);
		setBoostSpeedY(boostSpeedY);
		setBoostBulletDelay(boostBulletDelay);
		setBoostBulletSpeedX(boostBulletSpeedX);
		setBoostBulletSpeedY(boostBulletSpeedY);
	}

	@Override
	public void runLevel() {
		level(Game.gameManager.getLevelManager().getLevelPercentage());
	}
	
	public void level(int levelPercentage) {
		switch (levelPercentage) {
		case 0:
			getAliensManager().createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			getObjectManager().createObject("healthBoost", 100, 100, 0, GamePanel.screenHeight * 2, 0, 1);
			getObjectManager().createObject("speedBoost", 500, 100, 0, GamePanel.screenHeight * 2, 0, 1);
			getObjectManager().createObject("bulletSpeedBoost", 900, 100, 0, GamePanel.screenHeight * 2, 0, 1);
			getObjectManager().createObject("damageBoost", 1300, 100, 0, GamePanel.screenHeight * 2, 0, 1);
			break;
		case 1:
			getAliensManager().createAlien("alien2", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 2:
			getAliensManager().createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			getObjectManager().createObject("speedBoost", 500, 100, 0, GamePanel.screenHeight * 2, 0, 1);
			break;
		case 3:
			getAliensManager().createAlien("alien2", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 4:
			getAliensManager().createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 5:
			getAliensManager().createAlien("alien2", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 6:
			getAliensManager().createAlien("alien1", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 7:
			getAliensManager().createAlien("alien2", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 8:
			getAliensManager().createAlien("alien1", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 9:
			getAliensManager().createAlien("alien2", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 10:
			getAliensManager().createAlien("alien1", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 11:
			getAliensManager().createAlien("alien2", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 15:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=2) {
				getAliensManager().createAlien("alien1", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize*2, 30, GamePanel.screenHeight * 2, 0, 1, 6, 6, 300 - boostBulletDelay);				
			}
			for(int j = 1; j < GamePanel.maxScreenCol ; j+=2) {
				getAliensManager().createAlien("alien2", j * GamePanel.tileSize, j * GamePanel.tileSize + GamePanel.tileSize*2, 30, GamePanel.screenHeight * 2, 0, 1, 4, 4, 200 - boostBulletDelay);				
			}
			break;
		case 17:
			getAliensManager().createAlien("alien3", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 300 - boostBulletDelay);
			break;
		case 18:
			getAliensManager().createAlien("alien3", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 300 - boostBulletDelay);
			break;	
		case 20:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=3) {
				getAliensManager().createAlien("alien2", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 5, 5, 300 - boostBulletDelay);				
			}	
			break;
		case 25:
			getAliensManager().createAlien("alien4", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 27:
			getAliensManager().createAlien("alien4", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 33:
			getAliensManager().createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 300 - boostBulletDelay);
			getAliensManager().createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 300 - boostBulletDelay);
			break;
		case 35:
			getAliensManager().createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 300 - boostBulletDelay);
			getAliensManager().createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 300 - boostBulletDelay);
			break;
		case 37:
			getAliensManager().createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 300 - boostBulletDelay);
			getAliensManager().createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 300 - boostBulletDelay);
			break;
		case 39:
			getAliensManager().createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 300 - boostBulletDelay);
			getAliensManager().createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 300 - boostBulletDelay);
			break;
		case 41:
			getAliensManager().createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 300 - boostBulletDelay);
			getAliensManager().createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 300 - boostBulletDelay);
			break;
		case 45: 
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=2) {
				getAliensManager().createAlien("alien1", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize*2, 30, GamePanel.screenHeight * 2, 0, 1, 6, 6, 300 - boostBulletDelay);				
			}
			for(int j = 1; j < GamePanel.maxScreenCol ; j+=2) {
				getAliensManager().createAlien("alien3", j * GamePanel.tileSize, j * GamePanel.tileSize + GamePanel.tileSize*2, 30, GamePanel.screenHeight * 2, 0, 1, 4, 4, 200 - boostBulletDelay);				
			}
			break;
		case 48:
			getAliensManager().createAlien("alien5", 0, 0, 0, GamePanel.screenHeight*2, 0, 1, 7, 7, 250 - boostBulletDelay);
			break;
		case 50:
			getAliensManager().createAlien("alien5", GamePanel.screenWidth - GamePanel.tileSize, 0, 0, GamePanel.screenHeight*2, 0, 1, 7, 7, 250 - boostBulletDelay);
			break;
		case 52:
			getAliensManager().createAlien("alien5", 0, 0, 0, GamePanel.screenHeight*2, 0, 1, 7, 7, 250 - boostBulletDelay);
			break;
		case 54:
			getAliensManager().createAlien("alien5", GamePanel.screenWidth - GamePanel.tileSize, 0, 0, GamePanel.screenHeight*2, 0, 1, 7, 7, 250 - boostBulletDelay);
			break;
		case 57:
			getAliensManager().createAlien("alien4", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 60:
			getAliensManager().createAlien("alien4", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 63:
			getAliensManager().createAlien("alien4", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 66:
			getAliensManager().createAlien("alien4", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 69:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=3) {
				getAliensManager().createAlien("alien2", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 5, 5, 250);				
			}	
			break;
		case 72:
			getAliensManager().createAlien("alien3", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 300 - boostBulletDelay);
			break;
		case 75:
			getAliensManager().createAlien("alien3", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 300 - boostBulletDelay);
			break;	
		case 78:
			getAliensManager().createAlien("alien6", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 82:
			getAliensManager().createAlien("alien6", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 86:
			getAliensManager().createAlien("alien6", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 90:
			getAliensManager().createAlien("alien6", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 93:
			getAliensManager().createAlien("alien4", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 250 - boostBulletDelay);
			break;
		case 94:
			getAliensManager().createAlien("alien6", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 250 - boostBulletDelay);
			break;
		case 95:
			getAliensManager().createAlien("alien4", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 250 - boostBulletDelay);
			break;
		case 96:
			getAliensManager().createAlien("alien6", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 250 - boostBulletDelay);
			break;
		default:
			break;
		}
	}
}
