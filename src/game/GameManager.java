package game;

import screens.GamePanel;
import screens.GameScreen;
import users.User;

public class GameManager implements Runnable{
	
	private static final int originalTileSize = 16;
	private static final int scale = 3;
	protected static final int tileSize = originalTileSize * scale;
	protected static final int maxScreenCol = 16;
	protected static final int maxScreenRow = 12;
	protected static final int screeWidth = tileSize * maxScreenCol;
	protected static final int screenHeight = tileSize * maxScreenRow;
	
	protected static KeyHandler keyHandler = new KeyHandler();;
	
	private PlayerManager playerManager;
	private Bulletmanager bulletmanager;
	private AliensManager aliensManager;
	
	private GamePanel gamePanel;
	private GameScreen gameScreen;
	
	private User user;
	private Player player;
	private Alien alien;
	
	private final int FPS = 60;
	private Thread gameThread;
	
	public GameManager() {
		playerManager = new PlayerManager();
		aliensManager = new AliensManager();		
	}
	
	public void createGameScreen() {
		gameScreen = new GameScreen(gamePanel);
	}
	
	public void startGame() {
		user = Game.userManager.getActiveUser();
		playerManager.setUser(user);
		playerManager.createPlayer();
		player = playerManager.getPlayer();
		bulletmanager = new Bulletmanager(player);
		gamePanel =  new GamePanel(tileSize, maxScreenCol, maxScreenRow, playerManager, bulletmanager, aliensManager);
		
		aliensManager.createAlien("alien1");
				
		createGameScreen();
		Game.screenManager.setScreen(gameScreen);
		Game.screenManager.showScreen();
		gamePanel.addKeyListener(keyHandler);
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
			aliensManager.update();
			
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
