package game;

import java.util.ArrayList;
import java.util.ListIterator;

import Aliens.Alien;
import Aliens.AliensManager;
import level.LevelManager;
import screens.GamePanel;
import screens.GameScreen;
import users.User;

public class GameManager{
	
	protected static KeyHandler keyHandler = new KeyHandler();;
	
	protected Bulletmanager bulletmanager = null;
	protected ShootingManager shootingManager = null;
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
		bulletmanager = new Bulletmanager();
		shootingManager = new ShootingManager();
		aliensManager = new AliensManager();	
		levelManager = new LevelManager();
		levelManager.setGameLevel(level);
		
		playerManager = new PlayerManager();
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
		ArrayList<Alien> aliens = aliensManager.getAliens();
		for(int i=0 ; i < aliens.size() ; i++) {
			Alien alien = aliens.get(i);
			
			if(playerManager.isCollision(alien.collisionArea, player.collisionArea)) {
				playerManager.takeDamage(1);
			}
			
			ArrayList<Bullet> bullets = bulletmanager.getBullets();
			for(int j=0 ; j < bullets.size() ; j++) {
				Bullet bullet = bullets.get(j);
				
				if(bullet.getCharacter() instanceof Alien) {
					if(playerManager.isCollision(bullet.collisionArea, player.collisionArea)) {
						playerManager.takeDamage(bullet.getDamage());
						bullets.remove(j);
					}
				}
				else if(bulletmanager.isCollision(bullet.collisionArea, alien.collisionArea)) {
					aliensManager.takeDamage(alien, bullet.getDamage());	
					bullets.remove(j);
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
	
	public Bulletmanager getBulletManager() {
		return bulletmanager;
	}
	
	public ShootingManager getShootingManager() {
		return shootingManager;
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
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
