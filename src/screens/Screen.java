package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import game.Game;
import game.GameManager;

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
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.dispose();
				setScreen(new MenuScreen());
				showScreen();
				setScreen(new UserFormScreen());
				showScreen();
			}
		});
		
		playGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
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
				screen.dispose();
				Game.gameManager.startGame();
			}
		});
		
		highScore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.dispose();
				setScreen(new HighScoresScreen());
				showScreen();
			}
		});
		
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(screen, "Okan Bulgur 20200702017");
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
