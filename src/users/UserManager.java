package users;

import java.util.HashMap;

public class UserManager {
	
	protected static HashMap <String, User> users = new HashMap <String, User> ();
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
	
	public User getUser (String username) {
		return users.get(username);
	}
	
	public boolean isValid(String username) {
		return users.containsKey(username);
	}
	
	public void addUser(String username, String password) throws UserInfoException {
		if(isValid(username)) {
			throw new UserInfoException("This username is used");
		}
		User newUser = createUser(username, password, 0);
		users.put(username, newUser);
	}
	
	public boolean isMatch(String username, String password) throws UserInfoException {
		if(!isValid(username)) {
			throw new UserInfoException("Username is incorrect");
		}
		String userPassword = users.get(username).getPassword();
		if(password == null || !userPassword.equals(password)) {
			throw new UserInfoException("Password is incorrect");
		}
		return true;
	}
}
