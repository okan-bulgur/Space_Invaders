package game;

import screens.GamePanel;
import screens.GameScreen;
import users.User;

public class GameManager {
	
	private GamePanel gamePanel;
	private GameScreen gameScreen;
	private User user;
	private Player player;
	
	public GameManager() {
		
		user = Game.userManager.getActiveUser();
		Game.playerManager.createPlayer(user);
		player = Game.playerManager.getPlayer();
		this.gamePanel = new GamePanel(player);
	}
	
	public void createGameScreen() {
		gameScreen = new GameScreen(gamePanel);
	}
	
	public GameScreen getGameScreen() {
		createGameScreen();
		return gameScreen;
	}
	
	public void startGame() {
		
	}

}
