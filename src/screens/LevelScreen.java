package screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import game.GameManager;

public class LevelScreen extends Screen{

	private static int height = 600;
	private static int width = 800;
	
	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.setTitle("Levels");
		screen.setSize(width, height);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		screen.add(levelDisplay());
		
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);
	}
	
	public JPanel levelDisplay() {
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(3,1);
		panel.setLayout(layout);
		panel.setBackground(Color.BLACK);
		
		JButton level1 = new JButton("Level 1");
		level1.setHorizontalAlignment(JLabel.CENTER);
		level1.setFont(new Font("Verdana", Font.BOLD, 50));
		level1.setForeground(Color.WHITE);
		level1.setBackground(Color.BLACK);
		
		JButton level2 = new JButton("Level 2");
		level2.setHorizontalAlignment(JLabel.CENTER);
		level2.setFont(new Font("Verdana", Font.BOLD, 50));
		level2.setForeground(Color.WHITE);
		level2.setBackground(Color.BLACK);
		
		JButton level3 = new JButton("Level 3");
		level3.setHorizontalAlignment(JLabel.CENTER);
		level3.setFont(new Font("Verdana", Font.BOLD, 50));
		level3.setForeground(Color.WHITE);
		level3.setBackground(Color.BLACK);
		
		level1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.gameManager.setLevel(1);
				screen.dispose();
				Game.gameManager.startGame();
			}
		});
		
		level2.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.gameManager.setLevel(2);
				screen.dispose();
				Game.gameManager.startGame();
			}
		});
		
		level3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.gameManager.setLevel(3);
				screen.dispose();
				Game.gameManager.startGame();
			}
		});
		
		panel.add(level1);
		panel.add(level2);
		panel.add(level3);

		return panel;
	}

}
