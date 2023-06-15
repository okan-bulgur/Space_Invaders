package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Aliens.AliensManager;
import Bullet.Bulletmanager;
import Game.Game;
import Game.Sound;
import Player.PlayerManager;

public class GamePanel extends JPanel {

	private static final int originalTileSize = 16;
	public static final int scale = 5;
	public static final int tileSize = originalTileSize * scale;
	public static final int maxScreenCol = 24;
	public static final int maxScreenRow = 13;
	public static final int screenWidth = tileSize * maxScreenCol;
	public static final int screenHeight = tileSize * maxScreenRow;
	
	private PlayerInfoBar playerInfoBar;
	private GameStopScreen gameStopScreen;
	private NewHighScoreScreen newHighScoreScreen;
	protected Sound sound;
	
	private boolean gameOver = false;
	private boolean finish = false;
	private boolean newHighScoreUser = false;
	
	private BufferedImage backgroundImg;
	public static final int screenSpeed = 3;
	private int y = 0;
	
	public GamePanel() {
		try {
			backgroundImg = ImageIO.read(getClass().getResourceAsStream("/img/background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setLayout(new BorderLayout());
		
		this.sound = new Sound();
		this.playerInfoBar = new PlayerInfoBar(Game.gameManager.getPlayerManager().getPlayer());
		this.gameStopScreen = new GameStopScreen();
		this.newHighScoreScreen = new NewHighScoreScreen();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		slidingBackGround(g2);        
		Game.gameManager.getPlayerManager().drawCharacter(g2);
		Game.gameManager.getBulletManager().drawBullets(g2);
		Game.gameManager.getAliensManager().drawCharacter(g2);
		Game.gameManager.getObjectManager().drawObject(g2);
		
		playerInfoBar.draw(g2);
		
		if(gameOver) {
			gameStopScreen.gameOverScreen(g2);
		}
		else if(finish) {
			gameStopScreen.finishScreen(g2);
		}
		if(newHighScoreUser) {
			newHighScoreScreen.userNewHighScoreScreen(g2);
		}
		
		g2.dispose();
	}


	public void setGameOver(boolean check) {
		gameOver = check;
	}

	public boolean getGameOver() {
		return gameOver;
	}
	
	public void setFinish(boolean check) {
		finish = check;
	}
	
	public boolean getFinish() {
		return finish;
	}
	
	public void displayNewHighScoreUser() {
		new Thread(new Runnable() 
		{
			boolean checker = true;
			public void run() {
				while(checker) {
					newHighScoreUser = true;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					newHighScoreUser = false;
					checker = false;
				}
				
			}
		}).start();
	}
	
	public void slidingBackGround(Graphics2D g2) {
		g2.drawImage(backgroundImg, 0, y - GamePanel.screenHeight , GamePanel.screenWidth, GamePanel.screenHeight, null);
		g2.drawImage(backgroundImg, 0, y, GamePanel.screenWidth, GamePanel.screenHeight, null);

      	y += screenSpeed;
       
	   if (y >= getHeight() + 50) {
	       y = y - GamePanel.screenHeight;
	   }
	}
	
	public Sound getSound() {
		return sound;
	}
}
