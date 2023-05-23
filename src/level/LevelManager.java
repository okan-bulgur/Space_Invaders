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
			if(levelCounter % 50 == 0) {
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
		/*
		if(gameLevel == 0) {
			aliensManager.createAlien("alien1", 0, GamePanel.screenWidth/2, 0, GamePanel.screenHeight * 2, 4, 1, 300);
			aliensManager.createAlien("alien2", 0, GamePanel.screenWidth, 0, GamePanel.screenHeight / 2, 4, 2, 200);
		}
		*/
		if(gameLevel == 0) {
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=3) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 200);				
			}
		}
		if(gameLevel == 5) {
			for(int i = 0; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien4", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 200);				
			}
			for(int i = 1; i < GamePanel.maxScreenCol ; i+=2) {
				aliensManager.createAlien("alien3", i * GamePanel.tileSize, i * GamePanel.tileSize + GamePanel.tileSize, 30, GamePanel.screenHeight * 2, 0, 1, 450);				
			}
		}
	}
}