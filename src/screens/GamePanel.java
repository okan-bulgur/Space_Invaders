package screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.Player;
import game.PlayerManager;

public class GamePanel extends JPanel {
	
	private final int originalTileSize = 16;
	private final int scale = 3;
	
	private final int tileSize = originalTileSize * scale;
	private final int maxScreenCol = 16;
	private final int maxScreenRow = 12;
	private final int screeWidth = tileSize * maxScreenCol;
	private final int screenHeight = tileSize * maxScreenRow;
	
	private PlayerManager playerManager;
	
	public GamePanel(PlayerManager playerManager) {
		this.setPreferredSize(new Dimension(screeWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.playerManager = playerManager;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		playerManager.drawPlayer(g2, tileSize);
		
		g2.dispose();
	}
 
}
