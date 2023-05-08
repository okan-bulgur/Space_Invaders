package game;

import screens.MenuScreen;
import screens.ScreenManager;
import users.User;
import users.UsersInfo;

public class Game {
	
	public static UsersInfo usersInfo;
	public static ScreenManager screenManager;
	public static PlayerManager playerManager;
	public static User user = null;
	
	public Game() {
		usersInfo = new UsersInfo();
		screenManager = new ScreenManager();
		playerManager = new PlayerManager();
	}
    
	public static void main(String[] args) {
		
		Game game = new Game();
		
		screenManager.setScreen(new MenuScreen());
		
    }
    
}