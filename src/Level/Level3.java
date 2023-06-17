package Level;

import Game.Game;
import Screens.GamePanel;

public class Level3 extends Levels{
	
	private int hitScore = 20;
	private int boostSpeedX = 3;
	private int boostSpeedY = 2;
	private int boostBulletDelay = 150;
	private int boostBulletSpeedX = 4;
	private int boostBulletSpeedY = 4;
	private int boostTimeDelay = 2000;
	private int maxSpeedX = 5;
	private int maxSpeedY = 5;
	
	public Level3() {
		this.objectMaxNum = new int[]{1, 2, 2, 2};
		setMaxSpeedX(maxSpeedX);
		setMaxSpeedY(maxSpeedY);
		setHitScore(hitScore);
		setBoostSpeedX(boostSpeedX);
		setBoostSpeedY(boostSpeedY);
		setBoostBulletDelay(boostBulletDelay);
		setBoostBulletSpeedX(boostBulletSpeedX);
		setBoostBulletSpeedY(boostBulletSpeedY);
		setBoostTimeDelay(boostTimeDelay);
	} 
	
	@Override
	public void runLevel() {
		level(Game.gameManager.getLevelManager().getLevelPercentage());
	}
	
	public void level(int levelPercentage) {
		switch (levelPercentage) {
		case 0:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 1:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 2:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 3:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 4:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 5:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 6:
			aliensManager.createAlien("alien1", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 7:
			aliensManager.createAlien("alien2", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 8:
			aliensManager.createAlien("alien1", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 9:
			aliensManager.createAlien("alien2", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 10:
			aliensManager.createAlien("alien1", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 11:
			aliensManager.createAlien("alien2", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 5, 1, 6, 6, 300 - boostBulletDelay);
			break;
		case 15:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien1", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize*2, 30, GamePanel.screenHeight * 2, 0, 1, 6, 6, 300 - boostBulletDelay);				
			}
			for(int j = 1; j < GamePanel.maxScreenCol ; j+=2) {
				aliensManager.createAlien("alien2", j * GamePanel.tileSize, j * GamePanel.tileSize + GamePanel.tileSize*2, 30, GamePanel.screenHeight * 2, 0, 1, 4, 4, 200 - boostBulletDelay);				
			}
			break;
		case 17:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 300 - boostBulletDelay);
			break;
		case 18:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 300 - boostBulletDelay);
			break;	
		case 20:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=3) {
				aliensManager.createAlien("alien2", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 5, 5, 300 - boostBulletDelay);				
			}	
			break;
		case 25:
			aliensManager.createAlien("alien4", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 27:
			aliensManager.createAlien("alien4", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 33:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 4, 4, 4, 4, 200 - boostBulletDelay);
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 4, 4, 4, 4, 200 - boostBulletDelay);
			break;
		case 35:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 4, 4, 4, 4, 200 - boostBulletDelay);
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 4, 4, 4, 4, 200 - boostBulletDelay);
			break;
		case 37:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 4, 4, 4, 4, 300 - boostBulletDelay);
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 4, 4, 4, 4, 200 - boostBulletDelay);
			break;
		case 39:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 4, 4, 4, 4, 200 - boostBulletDelay);
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 4, 4, 4, 4, 200 - boostBulletDelay);
			break;
		case 41:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 4, 4, 6, 6, 200 - boostBulletDelay);
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 4, 4, 4, 4, 200 - boostBulletDelay);
			break;
		case 45: 
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien1", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize*2, 30, GamePanel.screenHeight * 2, 0, 1, 6, 6, 300 - boostBulletDelay);				
			}
			for(int j = 1; j < GamePanel.maxScreenCol ; j+=2) {
				aliensManager.createAlien("alien3", j * GamePanel.tileSize, j * GamePanel.tileSize + GamePanel.tileSize*2, 30, GamePanel.screenHeight * 2, 0, 1, 4, 4, 200 - boostBulletDelay);				
			}
			break;
		case 48:
			aliensManager.createAlien("alien5", 0, 0, 0, GamePanel.screenHeight*2, 0, 1, 7, 7, 250 - boostBulletDelay);
			break;
		case 50:
			aliensManager.createAlien("alien5", GamePanel.screenWidth - GamePanel.tileSize, 0, 0, GamePanel.screenHeight*2, 0, 1, 7, 7, 250 - boostBulletDelay);
			break;
		case 52:
			aliensManager.createAlien("alien5", 0, 0, 0, GamePanel.screenHeight*2, 0, 1, 7, 7, 250 - boostBulletDelay);
			break;
		case 54:
			aliensManager.createAlien("alien5", GamePanel.screenWidth - GamePanel.tileSize, 0, 0, GamePanel.screenHeight*2, 0, 1, 7, 7, 250 - boostBulletDelay);
			break;
		case 57:
			aliensManager.createAlien("alien4", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 60:
			aliensManager.createAlien("alien4", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 63:
			aliensManager.createAlien("alien4", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 66:
			aliensManager.createAlien("alien4", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 69:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=3) {
				aliensManager.createAlien("alien2", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 5, 5, 250);				
			}	
			break;
		case 72:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 300 - boostBulletDelay);
			break;
		case 75:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 300 - boostBulletDelay);
			break;	
		case 78:
			aliensManager.createAlien("alien6", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 82:
			aliensManager.createAlien("alien6", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 86:
			aliensManager.createAlien("alien6", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 90:
			aliensManager.createAlien("alien6", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight*2, 1, 1, 5, 5, 300 - boostBulletDelay);
			break;
		case 93:
			aliensManager.createAlien("alien4", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 250 - boostBulletDelay);
			break;
		case 94:
			aliensManager.createAlien("alien6", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 250 - boostBulletDelay);
			break;
		case 95:
			aliensManager.createAlien("alien4", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 250 - boostBulletDelay);
			break;
		case 96:
			aliensManager.createAlien("alien6", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight/2, 5, 5, 7, 7, 250 - boostBulletDelay);
			break;
		default:
			break;
		}
	}
}
