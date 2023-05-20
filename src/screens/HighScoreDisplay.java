package screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.Game;

public class HighScoreDisplay extends JPanel{
	
	public HighScoreDisplay() {
		ArrayList<String> users = Game.fileManager.takeTop5();
		int count = 1;
		
		GridLayout layout = new GridLayout(10,1);
		layout.setVgap(5);
		this.setLayout(layout);
		
		JLabel header = new JLabel("HIGH SCORE");
		header.setFont(new Font("Bebas Neue", Font.PLAIN, 100));
		header.setForeground(Color.RED);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(header);
		
		for(String user : users) {
			JLabel label = new JLabel((count++) + " ) " + user);
			
			label.setFont(new Font("Bebas Neue", Font.PLAIN, 50));
			label.setForeground(Color.BLACK);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setVerticalAlignment(SwingConstants.CENTER);
			this.add(label);
		}
		this.validate();
	}
}
