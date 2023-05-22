package game;

import java.util.ListIterator;

import level.LevelManager;
import screens.GamePanel;
import screens.GameScreen;
import users.User;

public class GameManager{
	
	protected static KeyHandler keyHandler = new KeyHandler();;
	
	protected Bulletmanager bulletmanager;
	protected PlayerManager playerManager;
	protected AliensManager aliensManager;
	protected LevelManager levelManager;
	
	protected GamePanel gamePanel;
	private GameScreen gameScreen;
	
	private User user;
	private Player player;
	
	private int gameLevel;
	
	public static GameThread gameThread = null;
	
	public GameManager() {
	}
	
	public void createGameScreen() {
		gameScreen = new GameScreen(gamePanel);
	}
	
	public void startGame() {
		bulletmanager = new Bulletmanager();
		playerManager = new PlayerManager(bulletmanager);
		aliensManager = new AliensManager(bulletmanager);	
		levelManager = new LevelManager(aliensManager);
		gameThread = new GameThread(this);
		
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
			playerManager.changeHighScore(player.getUser(), player.getScore());
			gamePanel.setGameOver(true);
			GameManager.gameThread.gameStop();
		}
		else if (levelManager.getGameLevel() == 100) {
			playerManager.changeHighScore(player.getUser(), player.getScore());
			gamePanel.setFinish(true);
			GameManager.gameThread.gameStop();
		}
	}

	/*
	public int getGameLevel() {
		return gameLevel;
	}

	public void setGameLevel(int gameLevel) {
		this.gameLevel = gameLevel;
	}
	*/
}
