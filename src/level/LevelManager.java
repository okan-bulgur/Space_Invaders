package level;

import game.AliensManager;
import screens.GamePanel;

public class LevelManager extends Thread {
	private boolean isStop = false;
	private int gameLevel = 0;
	private int levelCounter = 0;
	private final int FPS = 60;
	
	private AliensManager aliensManager;
	
	public LevelManager(AliensManager aliensManager) {
		this.aliensManager = aliensManager;
	}
	
	
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval; 
		while (!isStop) {
			
			levelCounter++;
			if(levelCounter % 100 == 0) {
				levelDesign();
				setGameLevel(getGameLevel() + 1);
			}
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime /= 1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getGameLevel() {
		return gameLevel;
	}
	
	public void setGameLevel(int gameLevel) {
		this.gameLevel = gameLevel;
	}
	
	public void levelStop() {
		isStop = true;
	}
	
	public void levelDesign() {
		
		switch (gameLevel) {
		case 0:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 300);
			break;
		case 1:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 300);
			break;
		case 2:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 300);
			break;
		case 3:
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 300);
			break;
		case 4:
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight / 2, 4, 2, 200);
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
		default:
			break;
		}
	}
}