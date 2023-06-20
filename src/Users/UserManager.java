package Users;

import java.util.ArrayList;

import Game.Game;
import Ships.Ship;

public class UserManager {

	private User user = null;
	
	public User createUser(String username, String password, int highScore, int goldAmount, ArrayList<Ship> ships, int rank) {
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
		ArrayList<Ship> ships = new ArrayList<>();
		ships.add(new Ship("ship_1"));
		User newUser = createUser(username, password, 0, 0, ships, 0);
		Game.fileManager.addUserInFile(newUser);
	}
	
	public void buyShip(Ship ship) {
		user.getShips().add(ship);
	}
}
