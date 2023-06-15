package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Game.Game;

public class NewHighScoreScreen {

	public void userNewHighScoreScreen(Graphics2D g2) {
		g2.setColor(new Color(0,0,0,0));
		g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
		
		String text = Game.userManager.getActiveUser().getUsername() + "'s NEW HIGH SCORE";
		int x = GamePanel.tileSize * 9;
		int y = GamePanel.tileSize * 12;
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));

		//shadow part
		g2.setColor(Color.BLUE);
		g2.drawString(text, x+4, y+4);
		
		//normal part
		g2.setColor(Color.WHITE);	
		g2.drawString(text, x, y);	
		
	}
}
