package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Game.Game;
import Users.User;

public class ShipMartketScreen extends Screen implements IMenuBar {
	
	private JLabel goldCount;
	
	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.setTitle("Ship Market");
		screen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLayout(new BorderLayout());
		screen.setResizable(false);
		
		JPanel headerPanel = new JPanel();
		FlowLayout layout = new FlowLayout();
		layout.setHgap(50);
		headerPanel.setLayout(layout); 
		
		JLabel header = new JLabel("Ship Market");
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setFont(new Font("Verdana", Font.BOLD, 50));
		header.setForeground(Color.BLACK);
		headerPanel.add(header);
		
		goldCount = new JLabel("Gold: " + Game.userManager.getActiveUser().getGoldAmount());
		goldCount.setHorizontalAlignment(JLabel.CENTER);
		goldCount.setFont(new Font("Verdana", Font.BOLD, 40));
		goldCount.setForeground(Color.ORANGE);
		headerPanel.add(goldCount);
		
		screen.add(headerPanel, BorderLayout.NORTH);
		
		JPanel itemsPanel = itemPanel();
		screen.add(itemsPanel, BorderLayout.CENTER);
		
		createMenuBar();
				
		screen.setResizable(false);
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);		
	}
	
	public JPanel itemPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		GridLayout layout = new GridLayout(2,3);
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
                final long cost = (long) userJson.get("cost");
            	long health = (long) userJson.get("health");
            	long damage = (long) userJson.get("damage");
            	long speed = (long) userJson.get("speedX");
            	long bulletSpeed = (long) userJson.get("bulletSpeedX");
            	String shootingType = (String) userJson.get("shootingType");
            	String shipImgPath = (String) userJson.get("shipImgPath");
          
            	JPanel item = new JPanel();
            	GridBagLayout itemLayout = new GridBagLayout();
            	item.setLayout(itemLayout);
            	GridBagConstraints gbc = new GridBagConstraints();         
            	item.setBackground(Color.BLACK);

            	JPanel allShipProperties = new JPanel();
            	FlowLayout allShipPropertiesLayout = new FlowLayout();

            	allShipPropertiesLayout.setHgap(50);
            	allShipProperties.setLayout(allShipPropertiesLayout);
            	allShipProperties.setBounds(0, 0, 300, 500);
            	allShipProperties.setBackground(Color.BLACK);
            	
            	JPanel properties = new JPanel();
            	GridLayout propertiesLayout = new GridLayout(4,2);
            	properties.setLayout(propertiesLayout);          
            	properties.setBackground(Color.BLACK);
            	
            	BufferedImage shipImg = ImageIO.read(getClass().getResourceAsStream(shipImgPath));
            	ImageIcon icon = new ImageIcon(shipImg);
            	ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH));
            	JLabel imgLabel = new JLabel(scaledIcon);
            	
            	JLabel nameLabel = new JLabel("Name: " + shipName);
            	JLabel healthLabel = new JLabel("Health: " + (int)health);
            	JLabel damageLabel = new JLabel("Damage: " + (int)damage);
            	JLabel speedLabel = new JLabel("Speed: " + (int)speed);
            	JLabel bulletSpeedLabel = new JLabel("Bullet Speed: " + (int)bulletSpeed);
            	JLabel shootingTypeLabel = new JLabel("Shooting Type: " + shootingType);    	
            	JLabel costLabel = new JLabel("Cost: " + (int)cost);
            	
            	final JButton buyBtn = new JButton("BUY");   
            	
            	if(Game.userManager.getActiveUser().getShips().contains(shipName)) {
            		buyBtn.setEnabled(false);
            	}
            	
            	imgLabel.setHorizontalAlignment(JLabel.CENTER);
            	buyBtn.setHorizontalAlignment(JLabel.CENTER);
            	
            	nameLabel.setForeground(Color.WHITE);
            	healthLabel.setForeground(Color.WHITE);
            	damageLabel.setForeground(Color.WHITE);
            	speedLabel.setForeground(Color.WHITE);
            	bulletSpeedLabel.setForeground(Color.WHITE);
            	shootingTypeLabel.setForeground(Color.WHITE);
            	costLabel.setForeground(Color.WHITE);
            	buyBtn.setBackground(Color.LIGHT_GRAY);
            	
            	String fontType = "Verdana";
            	int fontSize = 12;
            	nameLabel.setFont(new Font(fontType, Font.PLAIN, fontSize));
            	healthLabel.setFont(new Font(fontType, Font.PLAIN, fontSize));
            	damageLabel.setFont(new Font(fontType, Font.PLAIN, fontSize));
            	speedLabel.setFont(new Font(fontType, Font.PLAIN, fontSize));
            	bulletSpeedLabel.setFont(new Font(fontType, Font.PLAIN, fontSize));
            	shootingTypeLabel.setFont(new Font(fontType, Font.PLAIN, fontSize-2));
            	costLabel.setFont(new Font(fontType, Font.BOLD, fontSize));
            	buyBtn.setFont(new Font(fontType, Font.BOLD, fontSize));
            	
            	properties.add(nameLabel);
            	properties.add(healthLabel);
            	properties.add(damageLabel);
            	properties.add(speedLabel);
            	properties.add(bulletSpeedLabel);
            	properties.add(shootingTypeLabel);
            	properties.add(costLabel);
            	
            	allShipProperties.add(imgLabel);
            	allShipProperties.add(properties);
            	
            	gbc.fill = GridBagConstraints.BOTH; 
            	gbc.gridx = 0;  
            	gbc.gridy = 0; 
                gbc.gridwidth = 3; 
                gbc.gridheight = 1; 
            	item.add(allShipProperties, gbc);
            	
            	gbc.gridx = 0;  
            	gbc.gridy = 2; 
                gbc.gridwidth = 3; 
                gbc.gridheight = 1; 
            	item.add(buyBtn, gbc);
            	
            	panel.add(item);
            	
            	buyBtn.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				Game.sound.buttonClickEffect();
        				User user = Game.userManager.getActiveUser();
        				if (user.getGoldAmount() >= (int) cost) {
        					user.setGoldAmount(user.getGoldAmount() - (int) cost);
        					goldCount.setText("Gold: " + Game.userManager.getActiveUser().getGoldAmount());
        					buyBtn.setEnabled(false);
        					Game.userManager.buyShip(shipName);        				
        					Game.fileManager.setNewPropertyOfUser(Game.userManager.getActiveUser());
						}
        				else {
        					JOptionPane.showMessageDialog(screen, "There are not enough money");
						}
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
