package game;

public class GameThread extends Thread{
	
	private GameManager gameManager;
	private boolean isStop = false;
	private final int FPS = 60;
	
	public GameThread(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval; 
		gameManager.levelManager.start();
		//int levelCounter = 0;
		
		
		while(!isStop) {
			
			gameManager.playerManager.update();
			gameManager.bulletmanager.update();
			gameManager.aliensManager.update();
			
			gameManager.gamePanel.repaint();
			gameManager.collisionDetector();
			gameManager.gameStatusChecker();
			
			/*
			levelCounter++;
			if(levelCounter % 100 == 0) {
				gameManager.setGameLevel(gameManager.getGameLevel() + 1);
			}
			*/
			
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
	
	public void gameStop() {
		isStop = true;
		gameManager.levelManager.levelStop();
		GameManager.gameThread = null;
	}

}
