package screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import game.GameManager;

public class MenuScreen extends Screen implements IMenuBar, MouseListener {
	
	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.addMouseListener(this);
		screen.setTitle("Sapce Invaders");
		screen.setSize(800, 600);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = menuPanel();
		screen.add(panel);
		createMenuBar();
				
		screen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);		
	}
	
	public JPanel menuPanel() {
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(2,1);
		panel.setLayout(layout);
		panel.setBackground(Color.BLACK);
		BufferedImage header;
		try {
			header = ImageIO.read(getClass().getResourceAsStream("/img/spaceInvaderHeader.png"));
			JLabel headerLabel = new JLabel(new ImageIcon(header));
			panel.add(headerLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel playLabel = new JLabel("Click To Play");
		playLabel.setHorizontalAlignment(JLabel.CENTER);
		playLabel.setFont(new Font("Verdana", Font.BOLD, 50));
		playLabel.setForeground(Color.WHITE);
		panel.add(playLabel);
		
		return panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(GameManager.gameThread != null) {
			GameManager.gameThread.gameStop();
		}
		
		if(Game.userManager.getActiveUser() == null) {
			screen.dispose();
			setScreen(new MenuScreen());
			showScreen();
			setScreen(new UserFormScreen());
			showScreen();
			return;
		}
		setScreen(new LevelScreen());
		showScreen();
		screen.dispose();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
