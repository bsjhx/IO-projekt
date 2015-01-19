package pl.polsl.platforma.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class LoginModuleUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton cancelButton;
	private JButton loginButton;
	private JButton registerButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginModuleUI frame = new LoginModuleUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginModuleUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 143);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(10, 11, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 36, 65, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(85, 8, 221, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 33, 221, 20);
		contentPane.add(passwordField);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 78, 65, 23);
		contentPane.add(cancelButton);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(214, 78, 92, 23);
		contentPane.add(loginButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 70, 211, -3);
		contentPane.add(separator);
		
		registerButton = new JButton("Register");
		registerButton.setBounds(85, 78, 119, 23);
		contentPane.add(registerButton);
	}
	
	public void addCancelListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
	
	public void addLoginListener(ActionListener a) {
		loginButton.addActionListener(a);
	}
	
	public void addRegisterListener(ActionListener a) {
		registerButton.addActionListener(a);
	}
	
	public String getLoginText() {
		return textField.getText();
	}
	
	public String getPasswordValue() {
		return passwordField.getText();
	}
}
