package Screens;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HighScoresScreen extends Screen implements IMenuBar{
	
	private static int height = GamePanel.screenHeight;
	private static int width = GamePanel.screenWidth;

	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.setTitle("High Scores");
		screen.setSize(width, height);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel scorePanel = new HighScoreDisplay();
		screen.add(scorePanel);
		createMenuBar();

		
		screen.setVisible(true);
	}
}
