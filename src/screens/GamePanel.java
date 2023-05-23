package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.AliensManager;
import game.Bulletmanager;
import game.PlayerInfoBar;
import game.PlayerManager;

public class GamePanel extends JPanel {

	private static final int originalTileSize = 16;
	public static final int scale = 5;
	public static final int tileSize = originalTileSize * scale;
	public static final int maxScreenCol = 24;
	public static final int maxScreenRow = 13;
	public static final int screenWidth = tileSize * maxScreenCol;
	public static final int screenHeight = tileSize * maxScreenRow;
	
	private PlayerManager playerManager;
	private Bulletmanager bulletmanager;
	private AliensManager aliensManager;	
	private PlayerInfoBar playerInfoBar;
	private GameStopScreen gameStopScreen;
	
	private boolean gameOver = false;
	private boolean finish = false;
	private boolean pause = false;
	
	public GamePanel(PlayerManager playerManager, Bulletmanager bulletmanager, AliensManager aliensManager) {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setLayout(new BorderLayout());
		
		this.playerManager = playerManager;
		this.bulletmanager = bulletmanager;
		this.aliensManager = aliensManager;
		this.playerInfoBar = new PlayerInfoBar(playerManager.getPlayer());
		this.gameStopScreen = new GameStopScreen();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		playerManager.drawCharacter(g2);
		bulletmanager.drawCharacter(g2);
		aliensManager.drawCharacter(g2);
		playerInfoBar.draw(g2);
		
		if(gameOver) {
			gameStopScreen.gameOverScreen(g2);
		}
		else if(finish) {
			gameStopScreen.finishScreen(g2);
		}
		else if(pause) {
			gameStopScreen.pauseScreen(g2);
		}
		
		
		g2.dispose();
	}


	public void setGameOver(boolean check) {
		gameOver = check;
	}

	public void setFinish(boolean check) {
		finish = check;
	}

	public void setPause(boolean check) {
		pause = check;
	}
	
	public boolean getGameOver() {
		return gameOver;
	}

	public boolean getFinish() {
		return finish;
	}

	public boolean getPause() {
		return pause;
	}
	
}
