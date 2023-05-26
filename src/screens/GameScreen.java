package screens;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import game.GameManager;


public class GameScreen extends Screen implements IMenuBar, MouseListener {
	
	private static int height = 600;
	private static int width = 800;
	
	private boolean isPause = false;
	
	private GamePanel gamePanel;
	
	public GameScreen(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.addMouseListener(this);
		screen.setTitle("Space Invaders");
		screen.setSize(width, height);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		int pauseBtnUpY = 100;
		int pauseBtnBottomY = 70;
		int pauseBtnRightX = 1780;
		int pauseBtnLeftX = 1770;
		
		if(!isPause && e.getX() <= pauseBtnRightX && e.getX() >= pauseBtnLeftX && e.getY() <= pauseBtnUpY && e.getY() >= pauseBtnBottomY) {
			isPause = true;
			gamePanel.setPause(isPause);
			GameManager.gameThread.gamePause();
		}
		else if(isPause) {
			isPause = false;
			gamePanel.setPause(isPause);
			GameManager.gameThread.gameResume();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
