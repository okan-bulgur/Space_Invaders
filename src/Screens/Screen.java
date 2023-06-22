package Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Game.Game;
import Game.GameManager;

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
		JMenuItem shipMarket = new JMenuItem("Ship Market");
		JMenuItem quit = new JMenuItem("Quit");
		
		JMenuItem about = new JMenuItem("About");
		
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.sound.buttonClickEffect();
				if(GameManager.gameThread != null) {
					GameManager.gameThread.gameStop();
				}
				screen.dispose();
				Game.userManager.changeUser(null);
				setScreen(new MenuScreen());
				showScreen();
				setScreen(new UserFormScreen());
				showScreen();
			}
		});
		
		playGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				Game.sound.buttonClickEffect();
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
				setScreen(new LevelScreen());
				showScreen();
			}
		});
		
		highScore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.sound.buttonClickEffect();
				if(GameManager.gameThread != null) {
					GameManager.gameThread.gameStop();
				}
				screen.dispose();
				setScreen(new HighScoresScreen());
				showScreen();
			}
		});
		
		shipMarket.addActionListener(new ActionListener() {
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
				Game.sound.buttonClickEffect();
				screen.dispose();
				setScreen(new ShipMartketScreen());
				showScreen();
			}
		});
		
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.sound.buttonClickEffect();
				System.exit(0);
			}
		});
		
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.sound.buttonClickEffect();
				JOptionPane.showMessageDialog(screen, "Okan Bulgur 20200702017\nokan.bulgur@std.yeditepe.edu.tr");
			}
		});
		
		fileMenu.add(register);
		fileMenu.add(playGame);
		fileMenu.add(highScore);
		fileMenu.add(shipMarket);
		fileMenu.add(quit);
		
		helpMenu.add(about);
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		screen.setJMenuBar(menuBar);
	}

}
