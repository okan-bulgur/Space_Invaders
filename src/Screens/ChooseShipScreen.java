package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Game.Game;
import Ships.Ship;

public class ChooseShipScreen extends Screen {
	
	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.setTitle("Ship Market");
		screen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLayout(new BorderLayout());
		screen.setResizable(false);
		
		JLabel header = new JLabel("Select Ship");
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setFont(new Font("Verdana", Font.BOLD, 50));
		header.setForeground(Color.BLACK);
		screen.add(header, BorderLayout.NORTH);
		
		JPanel shipListPanel = shipListPanel();
		screen.add(shipListPanel, BorderLayout.CENTER);
		screen.setResizable(false);
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);		
	}
	
	public JPanel shipListPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		GridLayout layout = new GridLayout(6,1);
		layout.setVgap(10);
		layout.setHgap(10);
		panel.setLayout(layout);
		
		JSONParser jsonParser = new JSONParser();
		File file = new File("ships.json");
		try {
        	FileReader fileReader = new FileReader(file);
        	BufferedReader reader = new BufferedReader(fileReader);
        	String line;
        	while ((line = reader.readLine()) != null) {
                Object obj = jsonParser.parse(line);
                JSONObject userJson = (JSONObject) obj;
                
                final String shipName = (String) userJson.get("name");
            	String shipImgPath = (String) userJson.get("shipImgPath");
          
            	if (!Game.userManager.getActiveUser().getShips().contains(shipName)) {
            		continue;
            	}
            	
            	BufferedImage shipImg = ImageIO.read(getClass().getResourceAsStream(shipImgPath));
            	ImageIcon icon = new ImageIcon(shipImg);
            	ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
            	
            	JButton selectBtn = new JButton();   
            	selectBtn.setIconTextGap(50);
            	selectBtn.setIcon(scaledIcon);
            	selectBtn.setText(shipName);	
            	
            	String fontType = "Verdana";
            	int fontSize = 20;
            	
            	selectBtn.setFont(new Font(fontType, Font.BOLD, fontSize));
            	selectBtn.setHorizontalAlignment(JLabel.CENTER);
            	selectBtn.setBackground(Color.LIGHT_GRAY); 
            	
            	panel.add(selectBtn);
            	
            	selectBtn.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				Game.sound.buttonClickEffect();   
        				Ship selectedShip = new Ship(shipName);
        				Game.userManager.getActiveUser().setActiveShip(selectedShip);
        				screen.dispose();
        				Game.gameManager.startGame();
        			}
        		});
        	}
        	
        	fileReader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
		
		return panel;
	}
}
