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

	private static final int originalTileSize = 16;
	private static final int scale = 3;
	public static final int tileSize = originalTileSize * scale;
	private static final int maxScreenCol = 16;
	private static final int maxScreenRow = 12;
	public static final int screeWidth = tileSize * maxScreenCol;
	public static final int screenHeight = tileSize * maxScreenRow;
	
	private PlayerManager playerManager;
	private Bulletmanager bulletmanager;
	private AliensManager aliensManager;
	
	public GamePanel(PlayerManager playerManager, Bulletmanager bulletmanager, AliensManager aliensManager) {
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
