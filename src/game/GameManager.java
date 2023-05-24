package game;

import java.util.ListIterator;

import level.LevelManager;
import screens.GamePanel;
import screens.GameScreen;
import users.User;

public class GameManager{
	
	protected static KeyHandler keyHandler = new KeyHandler();;
	
	protected Bulletmanager bulletmanager = null;
	protected PlayerManager playerManager = null;
	protected AliensManager aliensManager = null;
	protected LevelManager levelManager = null;
	
	protected GamePanel gamePanel;
	private GameScreen gameScreen;
	
	private User user;
	private Player player;
	
	private int level = 0;
	
	public static GameThread gameThread = null;	
	
	public GameManager() {
	}
	
	public void createGameScreen() {
		gameScreen = new GameScreen(gamePanel);
	}
	
	public void startGame() {
		gameThread = new GameThread(this);
		levelManager = new LevelManager();
		levelManager.setGameLevel(level);
		bulletmanager = new Bulletmanager();
		aliensManager = new AliensManager(bulletmanager);	
		
		playerManager = new PlayerManager(bulletmanager);
		user = Game.userManager.getActiveUser();
		playerManager.setUser(user);
		playerManager.createPlayer();
		player = playerManager.getPlayer();
		
		gamePanel =  new GamePanel(playerManager, bulletmanager, aliensManager);
				
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
		if(player.getHealth() <= 0) {
			playerManager.changeHighScore(player.getUser(), player.getScore());
			gamePanel.setGameOver(true);
			GameManager.gameThread.gameStop();
			levelManager.levelStop();
			setLevelManager(null);
		}
		else if (levelManager.getLevelPercentage() == 100) {
			playerManager.changeHighScore(player.getUser(), player.getScore());
			gamePanel.setFinish(true);
			GameManager.gameThread.gameStop();
		}
	}
	
	public PlayerManager getPlayerManager() {
		return playerManager;
	}
	
	public AliensManager getAliensManager() {
		return aliensManager;
	}
	
	public LevelManager getLevelManager() {
		return levelManager;
	}
	
	public void setLevelManager(LevelManager levelManager) {
		this.levelManager = levelManager;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
