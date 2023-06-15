package game;

import java.util.ArrayList;

import Aliens.Alien;
import Aliens.AliensManager;
import Bullet.Bullet;
import Bullet.Bulletmanager;
import Player.Player;
import Player.PlayerManager;
import level.LevelManager;
import screens.GamePanel;
import screens.GameScreen;
import users.User;

public class GameManager{
	
	protected KeyHandler keyHandler = null;
	
	protected Bulletmanager bulletmanager = null;
	protected ShootingManager shootingManager = null;
	protected PlayerManager playerManager = null;
	protected AliensManager aliensManager = null;
	protected LevelManager levelManager = null;
	protected AnimationManager animationManager = null;
	public static GameThread gameThread = null;	
	
	protected GamePanel gamePanel;
	private GameScreen gameScreen;
	
	private User user;
	private Player player;
	private int level = 0;	
	
	
	public GameManager() {
	}
	
	public void createGameScreen() {
		gameScreen = new GameScreen(gamePanel);
	}
	
	public void startGame() {
		keyHandler = new KeyHandler();
		gameThread = new GameThread(this);
		bulletmanager = new Bulletmanager();
		shootingManager = new ShootingManager();
		aliensManager = new AliensManager();	
		levelManager = new LevelManager();
		playerManager = new PlayerManager();
		animationManager = new AnimationManager();
		
		levelManager.setGameLevel(level);
		
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
		gamePanel.getSound().gameStartEffect();
	}
	
	public void collisionDetector() {
		ArrayList<Alien> aliens = aliensManager.getAliens();
		for(int i=0 ; i < aliens.size() ; i++) {
			Alien alien = aliens.get(i);
			
			if(playerManager.isCollision(alien.getCollisionArea(), player.getCollisionArea())) {
				playerManager.takeDamage(1);
			}
			
			ArrayList<Bullet> bullets = bulletmanager.getBullets();
			for(int j=0 ; j < bullets.size() ; j++) {
				Bullet bullet = bullets.get(j);
				
				if(bullet.getCharacter() instanceof Alien) {
					if(playerManager.isCollision(bullet.getCollisionArea(), player.getCollisionArea())) {
						playerManager.takeDamage(bullet.getDamage());
						bullets.remove(j);
					}
				}
				else if(bulletmanager.isCollision(bullet.getCollisionArea(), alien.getCollisionArea())) {
					aliensManager.takeDamage(alien, bullet.getDamage());	
					bullets.remove(j);
					playerManager.addScore();
					gamePanel.getSound().damageEffect();
				}
			}
		}	
	}
	
	public void gameStatusChecker() {
		if(player.getHealth() <= 0) {
			gamePanel.getSound().deathEffect();
			playerManager.changeHighScore(player.getUser(), player.getScore());
			gamePanel.getSound().gameOverEffect();
			gamePanel.setGameOver(true);
			GameManager.gameThread.gameStop();
			levelManager.levelStop();
			setLevelManager(null);
		}
		else if (levelManager.getLevelPercentage() == 100) {
			gamePanel.getSound().wonEffect();
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
	
	public Bulletmanager getBulletManager() {
		return bulletmanager;
	}
	
	public ShootingManager getShootingManager() {
		return shootingManager;
	}
	
	public LevelManager getLevelManager() {
		return levelManager;
	}
	
	public AnimationManager getAnimationManager() {
		return animationManager;
	}
	
	public KeyHandler getKeyHandler() {
		return keyHandler;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevelManager(LevelManager levelManager) {
		this.levelManager = levelManager;
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
