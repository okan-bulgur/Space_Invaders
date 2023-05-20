package game;

import java.util.ListIterator;

import screens.GamePanel;
import screens.GameScreen;
import users.User;

public class GameManager{
	
	protected static KeyHandler keyHandler = new KeyHandler();;
	
	protected Bulletmanager bulletmanager;
	protected PlayerManager playerManager;
	protected AliensManager aliensManager;
	
	protected GamePanel gamePanel;
	private GameScreen gameScreen;
	
	private User user;
	private Player player;
	
	public static GameThread gameThread;
	
	public GameManager() {
		bulletmanager = new Bulletmanager();
		playerManager = new PlayerManager(bulletmanager);
		aliensManager = new AliensManager(bulletmanager);	
		gameThread = new GameThread(this);
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
		gameThread.start();
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
				
				if(bullet.getCharacter() instanceof Alien) {
					if(playerManager.isCollision(bullet.collisionArea, player.collisionArea)) {
						playerManager.takeDamage(bullet.getDamage());
						bulletItr.remove();
					}
				}
				else if(bulletmanager.isCollision(bullet.collisionArea, alien.collisionArea)) {
					aliensManager.takeDamage(alien, bullet.getDamage(), alienItr);	
					bulletItr.remove();
					playerManager.addScore();
				}
			}
		}
	}
	
	public void gameStatusChecker() {
		if(player.getHealth() == 0) {
			GamePanel.setGameOver(true);
			GameManager.gameThread.gameStop();
		}
		else if (aliensManager.getAliens().size() == 0) {
			GamePanel.setFinish(true);
			GameManager.gameThread.gameStop();
		}
	}
}
