package level;

public class LevelManager extends Thread {
	private boolean isStop = false;
	private int levelPercentage = 0;
	private int levelCounter = 0;
	private final int FPS = 60;
	
	private Level level;
	
	public LevelManager() {
		this.level = new Level();
	}
	
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval; 
		setLevelPercentage(0);
		while (!isStop) {
			
			levelCounter++;
			if(levelCounter % 100 == 0) {
				level.runLevel(getLevelPercentage());
				//levelDesign();
				setLevelPercentage(getLevelPercentage() + 1);
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
	
	public int getLevelPercentage() {
		return levelPercentage;
	}
	
	public void setLevelPercentage(int levelPercentage) {
		this.levelPercentage = levelPercentage;
	}
	
	public int getGameLevel() {
		return level.getGameLevel();
	}
	
	public void setGameLevel(int gameLevel) {
		level.setGameLevel(gameLevel);
	}
		
	public void levelStop() {
		isStop = true;
	}
	
	public Level getLevel() {
		return level;
	}
}