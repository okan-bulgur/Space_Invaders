package Users;

import java.util.ArrayList;

import Game.Game;

public class UserManager {

	private User user = null;
	
	public User createUser(String username, String password, int highScore, int goldAmount, ArrayList<String> ships, int rank) {
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
		ArrayList<String> ships = new ArrayList<>();
		ships.add("ship_1");
		User newUser = createUser(username, password, 0, 0, ships, 0);
		Game.fileManager.addUserInFile(newUser);
	}
	
	public void buyShip(String ship) {
		user.getShips().add(ship);
	}
}
