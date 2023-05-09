package screens;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.Game;
import users.UserInfoException;

public class UserFormScreen extends Screen {
	
	private static int height = 300;
	private static int width = 400;

	@Override
	public void createScreen() {
		screen = new JFrame();
		screen.setTitle("User Form");
		screen.setSize(width, height);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = createPanel();		
		screen.add(panel);
		
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);
	}
	
	private JPanel createPanel() {
		
		JLabel userNameLabel = new JLabel();
		userNameLabel.setText("Username");
		final JTextField usernameTextField = new JTextField(10);
		
		JLabel passwordLabel = new JLabel();
		passwordLabel.setText("Password");
		final JTextField passwordTextField = new JTextField(10);
		
		JButton logInBtn = new JButton("Sign in");
		JButton signUpBtn = new JButton("Sign Up");
		
		logInBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				try {
					Game.userManager.isMatch(username, password);
					Game.userManager.changeUser(Game.userManager.getUser(username));
 					JOptionPane.showMessageDialog(screen, username + " is log in");
					screen.dispose();
				} catch (UserInfoException e1) {
					JOptionPane.showMessageDialog(screen, e1.getMessage());
				}
			}
			
		});
		
		signUpBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String username = usernameTextField.getText();
					String password = passwordTextField.getText();
					
					if(username.equals("") || password.equals("")) {
						throw new UserInfoException("Username or password can't be a empty");
					}
					
					Game.userManager.addUser(username, password);
					screen.dispose();
				} catch (UserInfoException e1) {
					JOptionPane.showMessageDialog(screen, e1.getMessage());  
				}
			}
			
		});
		
		JPanel panel = new JPanel(new GridLayout(3,1));
		
		panel.add(userNameLabel);
		panel.add(usernameTextField);
		panel.add(passwordLabel);
		panel.add(passwordTextField);
		panel.add(logInBtn);
		panel.add(signUpBtn);
		
		return panel;		
	}
}
