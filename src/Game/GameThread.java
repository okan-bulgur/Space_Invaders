package Game;

public class GameThread extends Thread{
	
	private GameManager gameManager;
	private boolean isStop = false;
	private final int x = 60;
	private int fps = 0;
	
	public GameThread(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	@Override
	public void run() {
		double drawInterval = 1000000000/x;
		double nextDrawTime = System.nanoTime() + drawInterval; 
		long lastTimeChecked = System.nanoTime();
		int frames = 0;
		
		gameManager.levelManager.start();
		
		while(!isStop) {
				
			gameManager.shipManager.update();
			gameManager.bulletmanager.update();
			gameManager.aliensManager.update();
			gameManager.objectManager.update();
			
			gameManager.gamePanel.repaint();
			gameManager.collisionDetector();
			gameManager.gameStatusChecker();			

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
			
			frames++;
			if(System.nanoTime() - lastTimeChecked >= 1000000000L) {
				fps = frames;
				frames = 0;
				lastTimeChecked = System.nanoTime();
			}
			
		}	
	}
	
	public void gameStop() {
		isStop = true;
		gameManager.levelManager.levelStop();
		GameManager.gameThread = null;
	}
	
	public int getFps() {
		return fps;
	}

}
