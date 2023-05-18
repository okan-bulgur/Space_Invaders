package game;

import java.util.ListIterator;

import screens.GamePanel;
import screens.GameScreen;
import users.User;

public class GameManager implements Runnable{
	
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
	private boolean exit = false;
	
	public GameManager() {
		bulletmanager = new Bulletmanager();
		playerManager = new PlayerManager(bulletmanager);
		aliensManager = new AliensManager(bulletmanager);		
		gameThread = new Thread(this);
	}
	
	public void createGameScreen() {
		gameScreen = new GameScreen(gamePanel);
	}
	
	public void startGame() {
		user = Game.userManager.getActiveUser();
		playerManager.setUser(user);
		playerManager.createPlayer();
		player = playerManager.getPlayer();
		gamePanel =  new GamePanel(playerManager, bulletmanager, aliensManager);
		
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
		gameThread.start(); 
	}
	
	public void stopGameThread() {
		gameThread.stop();
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
		ListIterator<Alien> alienItr = aliensManager.getAliens().listIterator();
		while (alienItr.hasNext()) {
			Alien alien = alienItr.next();
			
			if(playerManager.isCollision(alien.collisionArea, player.collisionArea)) {
				playerManager.takeDamage(1);
			}
			
			ListIterator<Bullet> bulletItr = bulletmanager.getBullets().listIterator();
			while (bulletItr.hasNext()) {
				Bullet bullet = bulletItr.next();
				if(aliensManager.isCollision(alien.collisionArea, bullet.collisionArea)) {
					aliensManager.takeDamage(alien, bullet.getDamage(), alienItr);	
					bulletItr.remove();
					playerManager.addScore();
				}
			}
		}
	}
}
