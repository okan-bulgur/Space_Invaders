package users;

import java.util.HashMap;

public class UsersInfo extends UsersManager{

	private static HashMap <String, User> users = new HashMap <String, User> ();
	
	public boolean isValid(String username) {
		return users.containsKey(username);
	}
	
	public void addUser(String username, String password) throws UserInfoException {
		if(isValid(username)) {
			throw new UserInfoException("This username is used");
		}
		User newUser = new User(username, password, 0);
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
	
	public User getUser (String username) {
		return users.get(username);
	}
}