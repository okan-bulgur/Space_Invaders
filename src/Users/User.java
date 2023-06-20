package Users;

import Ships.Ship;

public class User extends UserManager{
	
	private String username;
	private String password;
	private int highScore;
	private int goldAmount;
	private Ship[] ships;
	private int rank;
	
	public User(String username, String password, int highScore, int goldAmount, Ship[] ships, int rank) {
		setUsername(username);
		setPassword(password);
		setHighScore(highScore);
		setGoldAmount(goldAmount);
		setShips(ships);
		setRank(rank);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getHighScore() {
		return highScore;
	}
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public int getGoldAmount() {
		return goldAmount;
	}

	public void setGoldAmount(int goldAmount) {
		this.goldAmount = goldAmount;
	}

	public Ship[] getShips() {
		return ships;
	}

	public void setShips(Ship[] ships) {
		this.ships = ships;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
