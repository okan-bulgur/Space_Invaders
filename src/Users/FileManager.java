package Users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.io.BufferedWriter;

import Game.Game;

public class FileManager {
	
	
	@SuppressWarnings("unchecked")
	public void addUserInFile(User user) {
		JSONObject newUser = new JSONObject();
		newUser.put("Usermame", user.getUsername());
		newUser.put("Password", user.getPassword());
		newUser.put("HighScore", user.getHighScore());
		
		try {
			FileWriter fileWriter  = new FileWriter("users.json", true);
			fileWriter.write(newUser.toJSONString() + "\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public boolean userIsValid(String username) {
		JSONParser jsonParser = new JSONParser();
		File file = new File("users.json");

        try {
        	FileReader fileReader = new FileReader(file);
        	BufferedReader reader = new BufferedReader(fileReader);
        	String line;
        	while ((line = reader.readLine()) != null) {
                Object obj = jsonParser.parse(line);
                JSONObject userJson = (JSONObject) obj;
                String user_name = (String) userJson.get("Usermame");
                
                if(user_name.equals(username)) {
                	return true;
                }
        	}
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
	}
	
	@SuppressWarnings("resource")
	public void logInUser(String username, String password) throws UserInfoException {
        JSONParser jsonParser = new JSONParser();

        try {
        	FileReader fileReader = new FileReader("users.json");
        	BufferedReader reader = new BufferedReader(fileReader);
        	String line;
        	while ((line = reader.readLine()) != null) {
                Object obj = jsonParser.parse(line);
                JSONObject userJson = (JSONObject) obj;
                String username_1 = (String) userJson.get("Usermame");
                String password_1 = (String) userJson.get("Password");
                if(!userIsValid(username)){
                	throw new UserInfoException("There is not user");
                }
                if(username_1.equals(username) && password_1.equals(password)) {
                	long highScore_1 = (long) userJson.get("HighScore");
                	User user = new User(username, password, (int) highScore_1);
                	Game.userManager.changeUser(user);        
                	break;
                }
                else if (username_1.equals(username) && !password_1.equals(password)) {
                	throw new UserInfoException("Password is incorrect");
				}

        	}
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
	
	@SuppressWarnings({ "unchecked" })
	public void setNewHighScoreForUser(User user, int score) {
		JSONParser jsonParser = new JSONParser();
		File file = new File("users.json");
		File tempFile = new File("tempUsers.json");

        try {
        	FileReader fileReader = new FileReader(file);
        	FileWriter fileWriter = new FileWriter(tempFile);
        	BufferedReader reader = new BufferedReader(fileReader);
        	String line;
        	while ((line = reader.readLine()) != null) {
                Object obj = jsonParser.parse(line);
                JSONObject userJson = (JSONObject) obj;
                String username = (String) userJson.get("Usermame");
                
                if(username.equals(user.getUsername())) {
                	userJson.put("HighScore", score);
                }
                
                fileWriter.write(obj.toString() + "\n");
        	}
        	fileReader.close();
        	fileWriter.close();
        	
        	if (file.delete()) {
                tempFile.renameTo(file);
			}
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
	}
	
	public void addHighScore(String username, int score) {
		boolean isExist = false;
		deleteUserFromFile(username, "highScores.txt");
		
		File file = new File("highScores.txt");
		File tempFile = new File(file + ".tmp");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			String line;
			while((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+"); // Split the line word by word
				int userScore = Integer.parseInt(words[1]);
				
				if(score > userScore && !isExist) {
					writer.write(username + " " + score);
					writer.newLine();
					isExist = true;
				}
				writer.write(line);
				writer.newLine();
			}
			
			if(!isExist) {
				writer.write(username + " " + score);
				writer.newLine();
			}
			
			reader.close();
			writer.close();
			
			if (file.delete()) {
                tempFile.renameTo(file);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUserFromFile(String username, String fileName) {
		File file = new File(fileName);
		File tempFile = new File(fileName + ".tmp");
		
		try {			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				if(!words[0].equals(username)) {
					writer.write(line);
					writer.newLine();
				}
			}
			reader.close();
			writer.close();
			
			if (file.delete()) {
                tempFile.renameTo(file);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<String> takeTop5() {
		ArrayList<String> highScores = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("highScores.txt"));
			String line;
			int count = 8;
			while ((line = reader.readLine()) != null && count != 0) {
                highScores.add(line);
                count--;
            }
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return highScores;
	}
	
}

