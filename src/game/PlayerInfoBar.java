package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import screens.GamePanel;

public class PlayerInfoBar extends Rectangle {
	
	private BufferedImage hearthImg;
	
	private Player player;
	
	public PlayerInfoBar(Player player) {
		this.player = player;
		try {
			hearthImg = ImageIO.read(getClass().getResourceAsStream("/img/hearth.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.setFont(new Font("Consolas", Font.PLAIN, 30));
		
		// level part
		g2.drawString("LEVEL %" + Game.gameManager.levelManager.getGameLevel(), GamePanel.tileSize, 40);
		
		// health part
		g2.drawImage(hearthImg, GamePanel.tileSize * 5, 5, GamePanel.tileSize, GamePanel.tileSize, null);
		g2.drawString("x" + String.valueOf(player.getHealth()), GamePanel.tileSize * 6 + 20 , 40);
		
		// score part
		g2.drawString(String.valueOf(player.getScore()), GamePanel.tileSize * 12, 40);

	}
}