package users;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileManager {

	private UserManager userManager;
	
	public FileManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public void addHighScore(String username, int score) {
		deleteUserFromFile(username, "highScores.txt");
		
		File file = new File("highScores.txt");
		File tempFile = new File("highScores.txt" + ".tmp");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			String line;
			if(file.length() == 0) {
				writer.write(username + " " + score);
				writer.newLine();
			}
			while((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+"); // Split the line word by word
				int userScore = Integer.parseInt(words[1]);
				
				if(score > userScore) {
					writer.write(username + " " + score);
					writer.newLine();
				}
				writer.write(line);
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
	
	public int takeScoreExistUser(String username) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("highScores.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split("\\s+");
				if(words[0].equals(username)) {
					return Integer.parseInt(words[1]);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void loadExistingUser() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("users.txt"));
			String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                int highScore = takeScoreExistUser(words[0]);
                userManager.addUser(words[0], words[1], highScore);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UserInfoException e) {
			e.printStackTrace();
		}
	}
	
	public void addUserToFile(String username, String password) {
		 try {
			 	BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
	            String user = username + " " + password + "\n";
	            writer.write(user);
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	} 
}

