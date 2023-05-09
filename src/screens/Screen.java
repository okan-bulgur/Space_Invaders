package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import game.Game;

public abstract class Screen extends ScreenManager implements IScreen{
	
	protected JFrame screen;

	public abstract void createScreen();
	
	public void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		
		JMenuItem register = new JMenuItem("Register");
		JMenuItem playGame = new JMenuItem("Play Game");
		JMenuItem highScore = new JMenuItem("High Score");
		JMenuItem quit = new JMenuItem("Quit");
		
		JMenuItem about = new JMenuItem("About");
		
		register.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				screen.dispose();
				setScreen(new MenuScreen());
				showScreen();
				setScreen(new UserFormScreen());
				showScreen();
			}
		});
		
		playGame.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {					
					if(Game.userManager.getActiveUser() == null) {
						throw new NotLogInException("No user is logged in.");
					}
					screen.dispose();
					Game.gameManager.startGame();
					
				} catch (NotLogInException e1) {
					JOptionPane.showMessageDialog(screen, e1.getMessage() , "", JOptionPane.ERROR_MESSAGE);
					screen.dispose();
					setScreen(new MenuScreen());
					showScreen();
				}
			}
		});
		
		highScore.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				screen.dispose();
				setScreen(new HighScoresScreen());
				showScreen();
			}
		});
		
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		fileMenu.add(register);
		fileMenu.add(playGame);
		fileMenu.add(highScore);
		fileMenu.add(quit);
		
		helpMenu.add(about);
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		screen.setJMenuBar(menuBar);
	}

}
