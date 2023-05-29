package level;

public class LevelManager extends Thread {
	private boolean isStop = false;
	private int levelPercentage = 0;
	private int levelCounter = 0;
	private int levelSpeed = 100;
	private final int FPS = 60;
	
	private int gameLevel;
	private Levels level;

	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval; 
		setLevelPercentage(0);
		createLevel();
		while (!isStop) {
			
			levelCounter++;
			if(levelCounter % levelSpeed == 0) {
				level.runLevel();
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
	
	public void createLevel() {
		switch (gameLevel) {
		case 1:
			setLevel(new Level1());
			break;
		case 2:
			setLevel(new Level2());
			break;
		case 3:
			setLevel(new Level3());
			break;
		default:
			break;
		}
	}
	
	public int getLevelPercentage() {
		return levelPercentage;
	}
	
	public void setLevelPercentage(int levelPercentage) {
		this.levelPercentage = levelPercentage;
	}
	
	public int getGameLevel() {
		return this.gameLevel;
	}
	
	public void setGameLevel(int gameLevel) {
		this.gameLevel = gameLevel;
	}
		
	public void levelStop() {
		isStop = true;
	}
	
	public void setLevel(Levels level) {
		this.level = level;
	}
	
	public Levels getLevel() {
		return level;
	}
}