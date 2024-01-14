package gui.beginner;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLoginForm implements ActionListener {
	//All required fields
	JFrame frame;
	//Labels
	JLabel userJLabel=new JLabel("Username");
	JLabel passwordJLabel=new JLabel("Password");
	//Fields
	JTextField userTextField=new JTextField();
	JPasswordField passwordField=new JPasswordField("************");
	//Buttons
	JButton loginButton=new JButton("Login");
	JButton resetButton=new JButton("Reset");

	//Check box
	JCheckBox showPassword=new JCheckBox("Show Password");

	//Constructor
	public UserLoginForm() {
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		addSctionEvent();
	}
	private void addSctionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);

	}
	private void addComponentsToFrame() {
		//userJLabel;		userTextField;		passwordField;		showPassword;		loginButton;		resetButton;
		frame.add(userJLabel);		
		frame.add(passwordJLabel);
		frame.add(userTextField);		
		frame.add(passwordField);
		frame.add(showPassword);		
		frame.add(loginButton);
		frame.add(resetButton);		

		//userTextField;		passwordField;		showPassword;		loginButton;		resetButton;
	}
	private void setLocationAndSize() {

		//userJLabel;		userTextField;		passwordField;		showPassword;		loginButton;		resetButton;

		userJLabel.setBounds(50,150,100,30);
		userJLabel.setForeground(Color.WHITE);
		passwordJLabel.setBounds(50,220,100,30);
		passwordJLabel.setForeground(Color.WHITE);

		userTextField.setBounds(150,150,150,30);
		passwordField.setBounds(150,220,150,30);
		showPassword.setBounds(150,250,150,30);
		loginButton.setBounds(50,300,100,30);
		resetButton.setBounds(200,300,100,30);
		/*userTextField;
		passwordField;
		showPassword;
		loginButton;
		resetButton;*/


	}
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("Login Form");
		frame.setBounds(10,10,380,600);
		//set color
		frame.getContentPane().setBackground(Color.gray);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==loginButton) {
			User myUser=new User(null,null);
			myUser.setUsername(userTextField.getText());
			myUser.setPassword(passwordField.getText());	
			myUser.login(myUser.getUsername(), myUser.getPassword());
		}
		if (e.getSource()==resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}
		if (e.getSource()==showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char)0);
			}
			else {
				passwordField.setEchoChar('*');
			}
		}
	}

	public static void main(String[] args) {
		UserLoginForm lgnfrmForm = new UserLoginForm();
	}
	
}
