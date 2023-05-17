package screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.AliensManager;
import game.Bulletmanager;
import game.PlayerManager;

public class GamePanel extends JPanel {

	private final int tileSize;
	private final int maxScreenCol;
	private final int maxScreenRow;
	private final int screeWidth;
	private final int screenHeight;
	
	private PlayerManager playerManager;
	private Bulletmanager bulletmanager;
	private AliensManager aliensManager;
	
	public GamePanel(int tileSize, int maxScreenCol, int maxScreenRow, PlayerManager playerManager, Bulletmanager bulletmanager, AliensManager aliensManager) {
		this.tileSize = tileSize;
		this.maxScreenCol = maxScreenCol;
		this.maxScreenRow = maxScreenRow;
		this.screeWidth = tileSize * maxScreenCol;
		this.screenHeight = tileSize * maxScreenRow;
		
		this.setPreferredSize(new Dimension(screeWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		this.playerManager = playerManager;
		this.bulletmanager = bulletmanager;
		this.aliensManager = aliensManager;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		playerManager.drawCharacter(g2);
		bulletmanager.drawCharacter(g2);
		aliensManager.drawCharacter(g2);
		
		g2.dispose();
	}
}
