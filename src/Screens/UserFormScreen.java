package Screens;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Game.Game;
import Users.UserInfoException;

public class UserFormScreen extends Screen {
	
	private static int height = 300;
	private static int width = 400;
	
	private final String gamePlayGuide = "\n1) Use W,A,S,D to move.\n2) Press Space to fire.\n3) There are 4 object \n   3.1) Boost of bullet's speed\n   3.2) Boost of bullet's damage\n   3.3)One life boost\n   3.4) Boost of ship's speed \n5) By collecting gold you can buy more advanced ship. \n6) You can see your health, score, username and highscore.\n7) You can see the high score table in the high score button on the new button.";

	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.setTitle("User Form");
		screen.setSize(width, height);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = createPanel();		
		screen.add(panel);
		
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);
	}
	
	private JPanel createPanel() {
		
		JLabel userNameLabel = new JLabel();
		userNameLabel.setText("Username");
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		final JTextField usernameTextField = new JTextField(10);
		userNameLabel.setForeground(Color.BLACK);
		
		JLabel passwordLabel = new JLabel();
		passwordLabel.setText("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		final JTextField passwordTextField = new JTextField(10);
		passwordLabel.setForeground(Color.BLACK);
		
		JButton logInBtn = new JButton("Log in");
		JButton signUpBtn = new JButton("Sign Up");
		
		logInBtn.setBackground(Color.BLACK);
		logInBtn.setForeground(Color.WHITE);
		signUpBtn.setBackground(Color.BLACK);
		signUpBtn.setForeground(Color.WHITE);
		
		logInBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Game.sound.buttonClickEffect();
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				try {
					Game.fileManager.logInUser(username, password);
 					JOptionPane.showMessageDialog(screen, "Hello " + username + gamePlayGuide);
					screen.dispose();
				} catch (UserInfoException e1) {
					Game.sound.messageEffect();
					JOptionPane.showMessageDialog(screen, e1.getMessage());
				}
			}
			
		});
		
		signUpBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Game.sound.buttonClickEffect();
				try {
					String username = usernameTextField.getText();
					String password = passwordTextField.getText();
					
					if(username.equals("") || password.equals("")) {
						throw new UserInfoException("Username or password can't be a empty");
					}
					Game.userManager.addUser(username, password);
					screen.dispose();
				} catch (UserInfoException e1) {
					Game.sound.messageEffect();
					JOptionPane.showMessageDialog(screen, e1.getMessage());  
				}
			}
			
		});
		
		GridLayout gridLayout = new GridLayout(3,1);
		gridLayout.setVgap(10);
		gridLayout.setHgap(10);
		
		
		JPanel panel = new JPanel(gridLayout);
		panel.setBackground(Color.WHITE);
		
		panel.add(userNameLabel);
		panel.add(usernameTextField);
		panel.add(passwordLabel);
		panel.add(passwordTextField);
		panel.add(logInBtn);
		panel.add(signUpBtn);
		
		return panel;		
	}
}
