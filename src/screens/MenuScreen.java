package screens;

import javax.swing.JFrame;

public class MenuScreen extends Screen implements IMenuBar {

	private static int height = 600;
	private static int width = 800;

	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.setTitle("Sapce Invaders");
		screen.setSize(width, height);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenuBar();
				
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);		
	}

}
