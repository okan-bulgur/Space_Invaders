package Users;

import Game.Game;

public class UserManager {

	private User user = null;
	
	public UserManager() {
	}
	
	public User createUser(String username, String password, int highScore) {
		return new User(username, password, highScore);
	}
	
	public void changeUser(User user) {
		this.user = user;
	}
	
	public User getActiveUser() {
		return user;
	}
	
	public void addUser(String username, String password, int highScore) throws UserInfoException {
		if(Game.fileManager.userIsValid(username)) {
			throw new UserInfoException("This username is used");
		}
		User newUser = createUser(username, password, highScore);
		Game.fileManager.addUserInFile(newUser);
	}
}
