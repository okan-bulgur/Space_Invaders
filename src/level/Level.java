package level;

import Aliens.AliensManager;
import game.Game;
import screens.GamePanel;

public class Level{
	
	private int gameLevel = 0;
	private int hitScore = 0;
	private AliensManager aliensManager = null;
	
	public int getGameLevel() {
		return gameLevel;
	}

	public void setGameLevel(int gameLevel) {
		this.gameLevel = gameLevel;
	}
	
	public int getHitScore() {
		return hitScore;
	}
	
	public void setHitScore(int hitScore) {
		this.hitScore = hitScore;
	}
	
	public void runLevel(int levelPercentage) {
		aliensManager = Game.gameManager.getAliensManager();
		switch (gameLevel) {
		case 1:
			level1(levelPercentage);
			break;
		case 2:
			level2(levelPercentage);
			break;
		case 3:
			level3(levelPercentage);
			break;

		default:
			break;
		}
	}
	

	public void level1(int levelPercentage) {
		setHitScore(10);
		switch (levelPercentage) {
		case 0:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 5, 5 ,100);
			aliensManager.createAlien("alien4", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 5, 5 ,100);
			break;
			
		/*
		case 1:
			aliensManager.createAlien("alien5", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 5, 5 ,300);
			break;
		case 2:
			aliensManager.createAlien("alien5", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 5, 5, 300);
			break;
		case 3:
			aliensManager.createAlien("alien5", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 5, 5, 300);
			break;
		case 4:
			aliensManager.createAlien("alien5", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight / 2, 4, 2, 5, 5, 200);
			break;
		case 10:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=3) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 200);				
			}			
			break;
		case 20:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 200);				
			}
			for(int i = 1; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien3", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 450);				
			}
		case 30:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 300);	
			break;
		case 31:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 300);
			break;
		case 32:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 300);	
			break;
		case 33:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 300);	
			break;
		case 35:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 200);
			break;
		case 36:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 200);
			break;
		case 37:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 200);
			break;
		case 38:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 200);
			break;
		case 39:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight / 2, 4, 2, 100);
			break;
		case 45:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=3) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 150);				
			}			
			break;
		case 55:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 100);				
			}
			for(int i = 1; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien3", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 250);				
			}
		case 65:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 100);	
			break;
		case 66:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 2, 100);
			break;
		case 67:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 100);	
			break;
		case 68:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 2, 100);	
			break;
		case 72:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=5) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 50);				
			}
			break;
		case 74:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight / 2, 4, 2, 100);
			break;
		case 76:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight / 2, 4, 4, 100);
			break;
		case 80:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 200);
			break;
		case 81:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 200);
			break;
		case 82:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 200);
			break;
		case 86:
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 2, 2, 200);
			break;
		case 88:
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 2, 2, 200);
			break;
		case 90:
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 2, 2, 200);
			break;
		case 93:
			aliensManager.createAlien("alien2", GamePanel.screenWidth/5, GamePanel.screenWidth*2/5, GamePanel.screenHeight/5, GamePanel.screenHeight*2/5, 2, 2, 200);
			break;
		case 96:
			aliensManager.createAlien("alien2", GamePanel.screenWidth/4, GamePanel.screenWidth*2/4, GamePanel.screenHeight/4, GamePanel.screenHeight*2/4, 2, 2, 200);
			break;
		case 98:
			aliensManager.createAlien("alien2", GamePanel.screenWidth/3, GamePanel.screenWidth*2/3, GamePanel.screenHeight/3, GamePanel.screenHeight*2/3, 2, 2, 200);
			break;
		*/
		default:
			break;
		}
	}

	public void level2(int levelPercentage) {
		setHitScore(20);
		switch (levelPercentage) {
		/*
		case 0:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 250);
			break;
		case 1:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 250);
			break;
		case 2:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 250);
			break;
		case 3:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 250);
			break;
		case 4:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight / 2, 5, 2, 1500);
			break;
		case 10:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=3) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 2, 150);				
			}			
			break;
		case 20:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 2, 150);				
			}
			for(int i = 1; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien3", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 2, 400);				
			}
		case 30:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 250);	
			break;
		case 31:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 2, 250);
			break;
		case 32:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 250);	
			break;
		case 33:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 2, 250);	
			break;
		case 35:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 150);
			break;
		case 36:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 2, 150);
			break;
		case 37:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 1, 150);
			break;
		case 38:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 2, 150);
			break;
		case 39:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight / 2, 5, 3, 75);
			break;
		case 45:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=3) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 2, 125);				
			}			
			break;
		case 55:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 75);				
			}
			for(int i = 1; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien3", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 2, 200);				
			}
		case 65:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 2, 75);	
			break;
		case 66:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 3, 75);
			break;
		case 67:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 2, 75);	
			break;
		case 68:
			aliensManager.createAlien("alien3", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 3, 75);	
			break;
		case 72:
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=5) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 50);				
			}
			break;
		case 74:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight / 2, 4, 2, 100);
			break;
		case 76:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight / 2, 4, 4, 100);
			break;
		case 80:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 5, 2, 150);
			break;
		case 81:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 150);
			break;
		case 82:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 150);
			break;
		case 86:
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 2, 2, 150);
			break;
		case 88:
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 3, 2, 150);
			break;
		case 90:
			aliensManager.createAlien("alien3", GamePanel.screenWidth/2, GamePanel.screenWidth, 0, GamePanel.screenHeight * 2, 2, 2, 150);
			break;
		case 93:
			aliensManager.createAlien("alien2", GamePanel.screenWidth/5, GamePanel.screenWidth*2/5, GamePanel.screenHeight/5, GamePanel.screenHeight*2/5, 2, 3, 150);
			break;
		case 96:
			aliensManager.createAlien("alien2", GamePanel.screenWidth/4, GamePanel.screenWidth*2/4, GamePanel.screenHeight/4, GamePanel.screenHeight*2/4, 2, 3, 150);
			break;
		case 98:
			aliensManager.createAlien("alien2", GamePanel.screenWidth/3, GamePanel.screenWidth*2/3, GamePanel.screenHeight/3, GamePanel.screenHeight*2/3, 2, 3, 150);
			break;
			*/
		default:
			break;
		}
	}
	
	public void level3(int levelPercentage) {
		setHitScore(30);
		switch (levelPercentage) {

		default:
			break;
		}
	}
}
