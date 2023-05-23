package screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import game.Game;

public class GameStopScreen {
	
	public void gameOverScreen(Graphics2D g2) {
		g2.setColor(new Color(0,0,0,150));
		g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
		
		
		String text = "GAME OVER";
		int x = GamePanel.tileSize * 9;
		int y = GamePanel.tileSize * 6;
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));

		//shadow part
		g2.setColor(Color.RED);
		g2.drawString(text, x+4, y+4);
		
		//normal part
		g2.setColor(Color.WHITE);	
		g2.drawString(text, x, y);
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));
		g2.setColor(Color.WHITE);	
		g2.drawString("Your High Score: " + Game.gameManager.getPlayerManager().getUser().getHighScore(), x , y + GamePanel.tileSize);
		g2.drawString("Score: " + Game.gameManager.getPlayerManager().getPlayer().getScore(), x + GamePanel.tileSize * 2 , y + GamePanel.tileSize * 2);
		
	}
	
	public void finishScreen(Graphics2D g2) {
		g2.setColor(new Color(0,0,0,150));
		g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
		
		
		String text = "WON";
		int x = GamePanel.tileSize * 11;
		int y = GamePanel.tileSize * 6;
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));

		//shadow part
		g2.setColor(Color.GREEN);
		g2.drawString(text, x+4, y+4);
		
		//normal part
		g2.setColor(Color.WHITE);	
		g2.drawString(text, x, y);
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));
		g2.setColor(Color.WHITE);	
		g2.drawString("Your High Score: " + Game.gameManager.getPlayerManager().getUser().getHighScore(), x , y + GamePanel.tileSize);
		g2.drawString("Score: " + Game.gameManager.getPlayerManager().getPlayer().getScore(), x + GamePanel.tileSize * 2 , y + GamePanel.tileSize * 2);

	}
	
	public void pauseScreen(Graphics2D g2) {
		g2.setColor(new Color(0,0,0,150));
		g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
		
		
		String text = "PAUSE";
		int x = GamePanel.tileSize * 10;
		int y = GamePanel.tileSize * 6;
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));

		//shadow part
		g2.setColor(Color.GRAY);
		g2.drawString(text, x+4, y+4);
		
		//normal part
		g2.setColor(Color.WHITE);	
		g2.drawString(text, x, y);

	}
}
