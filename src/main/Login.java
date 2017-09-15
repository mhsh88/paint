package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import loginCheck.LoginCheck;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtPassword;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblUserName = new JLabel("User Name:");
		panel_2.add(lblUserName);
		
		txtUsername = new JTextField();
		panel_2.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassWord = new JLabel("Pass Word:");
		panel_2.add(lblPassWord);
		
		
		txtPassword = new JPasswordField();
		
		panel_2.add(txtPassword);
		txtPassword.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_2);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userName = txtUsername.getText();
				String passWord = txtPassword.getText();
				LoginCheck login = new LoginCheck(userName, passWord);
				if(login.isAthorized()) {
					setVisible(false);
					new main.MainFrame(login.getUserName());
				}
				else {
					JOptionPane.showMessageDialog(null, "نام کاربری و رمز عبور اشتباه است!", "خطا" , JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		panel_1.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		panel_1.add(btnCancel);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
	}

}
