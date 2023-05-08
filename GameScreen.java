package screens;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import game.Game;
import game.Player;
import users.User;

public class GameScreen extends Screen implements IMenuBar {
	
	private static int height = 600;
	private static int width = 800;
	
	private User user = Game.user;
	private Player player;
	
	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.setTitle("Sapce Invaders");
		screen.setSize(width, height);
		screen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLayout(new BorderLayout());
		
		createMenuBar();
		
		player = new Player(user);
		GamePanel gamePanel = new GamePanel(player);
		screen.add(gamePanel);
		gamePanel.startGameThread();
		screen.pack();
				
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);	
	}
}
