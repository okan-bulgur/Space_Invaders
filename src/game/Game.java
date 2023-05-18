package game;

import screens.MenuScreen;
import screens.ScreenManager;
import users.UserManager;

public class Game {
	
	public static UserManager userManager;
	public static GameManager gameManager;
	public static ScreenManager screenManager;
	
	public Game() {
		userManager = new UserManager();
		gameManager = new GameManager();
		screenManager = new ScreenManager();
	}
    
	public static void main(String[] args) {
		
		Game game = new Game();
		
		screenManager.setScreen(new MenuScreen());
		screenManager.showScreen();
    }
}