package users;

public class User extends UsersManager{
	
	private String username;
	private String password;
	private int highScore;
	
	public User(String username, String password, int highScore) {
		setUsername(username);
		setPassword(password);
		setHighScore(highScore);
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
	
	
}
