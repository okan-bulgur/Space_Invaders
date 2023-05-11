package game;

import screens.GamePanel;
import screens.GameScreen;
import users.User;

public class GameManager implements Runnable{
	
	private KeyHandler keyHandler;
	
	private PlayerManager playerManager;
	private Bulletmanager bulletmanager;
	private AliensManager aliensManager;
	
	private GamePanel gamePanel;
	private GameScreen gameScreen;
	
	private User user;
	private Player player;
	private Aliens alien;
	
	private final int FPS = 60;
	private Thread gameThread;
	
	public GameManager() {
		setKeyHandler(new KeyHandler());
		playerManager = new PlayerManager(keyHandler);
		aliensManager = new AliensManager();		
	}
	
	public void createGameScreen() {
		gameScreen = new GameScreen(gamePanel);
	}
	
	public void startGame() {
		user = Game.userManager.getActiveUser();
		playerManager.createPlayer(user);
		player = playerManager.getPlayer();
		bulletmanager = new Bulletmanager(keyHandler, player);
		gamePanel = new GamePanel(playerManager, bulletmanager, aliensManager);
		
		aliensManager.createAlien("alien1");
		alien = aliensManager.getAliens();
				
		createGameScreen();
		Game.screenManager.setScreen(gameScreen);
		Game.screenManager.showScreen();
		gamePanel.addKeyListener(getKeyHandler());
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
			bulletmanager.update();
			aliensManager.update(gamePanel.getWidth());
			
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
	
	public KeyHandler getKeyHandler() {
		return keyHandler;
	}

	public void setKeyHandler(KeyHandler keyHandler) {
		this.keyHandler = keyHandler;
	}
}
