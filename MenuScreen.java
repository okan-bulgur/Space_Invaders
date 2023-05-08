package screens;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuScreen extends Screen implements IMenuBar {

	private static int height = 600;
	private static int width = 800;

	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.setTitle("Sapce Invaders");
		screen.setSize(width, height);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLayout(new BorderLayout());
		
		createMenuBar();
		
		JLabel label = new JLabel("MENU SCREEN");
		screen.add(label, BorderLayout.CENTER);
				
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);		
	}

}
