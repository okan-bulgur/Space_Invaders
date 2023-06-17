package Game;

import Screens.MenuScreen;
import Screens.ScreenManager;
import Users.FileManager;
import Users.UserManager;

public class Game {
	
	public static UserManager userManager;
	public static FileManager fileManager;
	public static GameManager gameManager;
	public static ScreenManager screenManager;
	public static Sound sound;
	
	public Game() {
		sound = new Sound();
		userManager = new UserManager();
		fileManager = new FileManager(userManager);
		gameManager = new GameManager();
		screenManager = new ScreenManager();
	}
    
	public static void main(String[] args) {
		
		Game game = new Game();
		
		fileManager.loadExistingUser();
		screenManager.setScreen(new MenuScreen());
		screenManager.showScreen();
    }
}