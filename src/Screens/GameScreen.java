package Screens;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameScreen extends Screen implements IMenuBar {
	
	private GamePanel gamePanel;
	
	public GameScreen(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.setTitle("Space Invaders");
		screen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLayout(new BorderLayout());
		screen.setResizable(false);
		
		createMenuBar();
		
		screen.add(gamePanel);
		screen.pack();
				
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);	
	}
}
