package game;

import java.awt.Checkbox;
import java.util.ListIterator;

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
	
	private  Bulletmanager bulletmanager;
	private PlayerManager playerManager;
	private AliensManager aliensManager;
	
	private GamePanel gamePanel;
	private GameScreen gameScreen;
	
	private User user;
	private Player player;
	
	private final int FPS = 60;
	private Thread gameThread;
	
	public GameManager() {
		bulletmanager = new Bulletmanager();
		playerManager = new PlayerManager(bulletmanager);
		aliensManager = new AliensManager(bulletmanager);		
	}
	
	public void createGameScreen() {
		gameScreen = new GameScreen(gamePanel);
	}
	
	public void startGame() {
		user = Game.userManager.getActiveUser();
		playerManager.setUser(user);
		playerManager.createPlayer();
		player = playerManager.getPlayer();
		gamePanel =  new GamePanel(tileSize, maxScreenCol, maxScreenRow, playerManager, bulletmanager, aliensManager);
		
		aliensManager.createAlien("alien1");
		aliensManager.createAlien("alien2");
				
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
			
			collisionDetector();			
			
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
	
	public void collisionDetector() {
		ListIterator<Alien> itr1 = aliensManager.getAliens().listIterator();
		while (itr1.hasNext()) {
			Alien alien = itr1.next();
			ListIterator<Bullet> itr2 = bulletmanager.getBullets().listIterator();
			
			if(aliensManager.isCollision(alien.collisionArea, player.collisionArea)) {
				playerManager.takeDamage(1);
			}
			
			while (itr2.hasNext()) {
				Bullet bullet = itr2.next();
				if(aliensManager.isCollision(alien.collisionArea, bullet.collisionArea)) {
					aliensManager.takeDamage(alien, bullet.getDamage());
					playerManager.addScore();
					//System.out.println("health: "+alien.getHealth());
				}
			}
			
		}
		
	}
	
}
