package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Game.Game;

public class HighScoreDisplay extends JPanel{
	
	public HighScoreDisplay() {
		/*
		this.setBackground(Color.BLACK);
		ArrayList<String> users = Game.fileManager.takeTop5();
		int count = 1;
		
		GridLayout layout = new GridLayout(10,1);
		this.setLayout(layout);
		
		JLabel header = new JLabel("HIGH SCORES");
		header.setFont(new Font("Bebas Neue", Font.PLAIN, 100));
		header.setForeground(Color.WHITE);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(header);
		
		for(String user : users) {
			JLabel label = new JLabel((count++) + " ) " + user);
			
			label.setFont(new Font("Bebas Neue", Font.PLAIN, 50));
			label.setForeground(Color.GREEN);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setVerticalAlignment(SwingConstants.CENTER);
			this.add(label);
		}
		this.validate();
		*/
	}
}
