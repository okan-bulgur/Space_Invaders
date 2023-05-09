package game;

import screens.GamePanel;
import screens.GameScreen;
import users.User;

public class GameManager implements Runnable{
	
	private PlayerManager playerManager;
	private GamePanel gamePanel;
	private GameScreen gameScreen;
	private User user;
	private Player player;
	
	private final int FPS = 60;
	private Thread gameThread;
	
	public GameManager() {
		playerManager = new PlayerManager();
	}
	
	public void createGameScreen() {
		gameScreen = new GameScreen(gamePanel);
	}
	
	public void startGame() {
		user = Game.userManager.getActiveUser();
		playerManager.createPlayer(user);
		player = playerManager.getPlayer();
		gamePanel = new GamePanel(playerManager);
		
		createGameScreen();
		Game.screenManager.setScreen(gameScreen);
		Game.screenManager.showScreen();
		gamePanel.addKeyListener(playerManager.getKeyHandler());
		gamePanel.setFocusable(true);
		startGameThread();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start(); 
	}

	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval; 
		
		while(gameThread != null) {
			
			playerManager.update();
			
			gamePanel.repaint();
			
			
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
}
