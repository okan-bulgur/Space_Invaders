package screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.KeyHandler;
import game.Player;

public class GamePanel extends JPanel implements Runnable {
	
	private final int originalTileSize = 16;
	private final int scale = 3;
	
	private final int tileSize = originalTileSize * scale;
	private final int maxScreenCol = 16;
	private final int maxScreenRow = 12;
	private final int screeWidth = tileSize * maxScreenCol;
	private final int screenHeight = tileSize * maxScreenRow;
	
	private final int FPS = 60;
	
	private Player player;
	
	private Thread gameThread;
	private KeyHandler keyHandler = new KeyHandler();
	
	public GamePanel(Player player) {
		this.setPreferredSize(new Dimension(screeWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
		
		this.player = player;
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start(); 
	}

	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval; 
		
		while(gameThread != null) {
			
			update();
			
			repaint();
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime /= 1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void update() {
		
		if(keyHandler.isUpPress()) {
			player.setPosY(player.getPosY() - player.getSpeed());
		}
		if(keyHandler.isDownpress()) {
			player.setPosY(player.getPosY() + player.getSpeed());
		}
		if(keyHandler.isRightPress()) {
			player.setPosX(player.getPosX() + player.getSpeed());
		}
		if(keyHandler.isLeftpress()) {
			player.setPosX(player.getPosX() - player.getSpeed());
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.white);
		g2.fillRect(player.getPosX(), player.getPosY(), tileSize, tileSize);
		g2.dispose();
	}
 
}
