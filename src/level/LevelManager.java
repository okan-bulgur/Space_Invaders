package level;

import game.AliensManager;

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
				setGameLevel(getGameLevel() + 1);
				if(gameLevel == 2) {
					aliensManager.createAlien("alien3");
				}
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
}