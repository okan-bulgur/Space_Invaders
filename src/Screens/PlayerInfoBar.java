package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import Game.Game;
import Game.GameManager;
import Player.Player;

@SuppressWarnings("serial")
public class PlayerInfoBar extends Rectangle {
	
	private BufferedImage hearthImg;
	private BufferedImage goldImg;
	
	private Player player;
	
	public PlayerInfoBar(Player player) {
		this.player = player;
		try {
			hearthImg = ImageIO.read(getClass().getResourceAsStream("/img/hearth.png"));
			goldImg = ImageIO.read(getClass().getResourceAsStream("/img/gold_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.setFont(new Font("Arial", Font.BOLD, 30));
		
		// level part
		if(Game.gameManager.getLevelManager() != null) {
		g2.drawString("LEVEL " + Game.gameManager.getLevelManager().getGameLevel() + "   %" + Game.gameManager.getLevelManager().getLevelPercentage(), GamePanel.tileSize, 40);
		}
		
		// health part
		g2.drawImage(hearthImg, GamePanel.tileSize * 6, 5, GamePanel.tileSize, GamePanel.tileSize, null);
		g2.drawString("x" + String.valueOf(player.getShip().getHealth()), GamePanel.tileSize * 7 + 20 , 40);
		
		// score part
		g2.drawString("Score: " + String.valueOf(player.getScore()), GamePanel.tileSize * 10, 40);
		
		// user part
		g2.drawString("User: " + player.getUser().getUsername(), GamePanel.tileSize * 13, 40);
		
		// high score part
		g2.drawString("High Score: " + player.getUser().getHighScore(), GamePanel.tileSize * 16, 40);
		
		// gold part
		g2.drawImage(goldImg, GamePanel.tileSize * 20, 7, GamePanel.tileSize/2, GamePanel.tileSize/2, null);
		g2.drawString("" + player.getUser().getGoldAmount(), GamePanel.tileSize * 20 + 60, 40);
		
		// FPS part
		if(GameManager.gameThread != null) {
			g2.drawString("FPS: " + GameManager.gameThread.getFps(), GamePanel.tileSize * 22, 40);			
		}

	}
}