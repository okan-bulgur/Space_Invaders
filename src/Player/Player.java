package Player;

import Ships.Ship;
import Users.User;

public class Player {
	
	private User user;
	private Ship ship;
	
	private int score = 0;

	public Player(User user) {
		setUser(user);
		setShip(user.getActiveShip());
		setScore(score);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	
}
