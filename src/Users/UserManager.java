package Users;

import Game.Game;
import Ships.Ship;

public class UserManager {

	private User user = null;
	
	public UserManager() {
	}
	
	public User createUser(String username, String password, int highScore, int goldAmount, Ship[] ships, int rank) {
		return new User(username, password, highScore, goldAmount, ships, rank);
	}
	
	public void changeUser(User user) {
		this.user = user;
	}
	
	public User getActiveUser() {
		return user;
	}
	
	public void addUser(String username, String password) throws UserInfoException {
		if(Game.fileManager.userIsValid(username)) {
			throw new UserInfoException("This username is used");
		}
		User newUser = createUser(username, password, 0, 0, null, 0);
		Game.fileManager.addUserInFile(newUser);
	}
}
