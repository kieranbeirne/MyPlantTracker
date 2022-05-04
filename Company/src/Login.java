import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Login {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = sqliteConnection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 239, 213));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Water Reminder");
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		usernameLabel.setBounds(189, 72, 66, 14);
		frame.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		passwordLabel.setBounds(189, 106, 66, 14);
		frame.getContentPane().add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(265, 68, 104, 23);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		loginButton.setHorizontalAlignment(SwingConstants.LEFT);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				try {
					String query = "select * from EmployeeInfo where Username=? and Password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usernameField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next())
					{
						count++;
					}
					if(count == 1)
					{
						//JOptionPane.showMessageDialog(null, "Signed in successfully.");
						frame.dispose();
						EmployeeInfo emplyInfo = new EmployeeInfo();
						emplyInfo.setVisible(true);

					}
					else if(count > 1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and password.");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and password is not correct. Try again");
					}
					
					rs.close();
					pst.close();
				}catch(Exception e4)
				{
					JOptionPane.showMessageDialog(null, e4);
					
				}
				}
		});
		loginButton.setBounds(265, 156, 104, 30);
		Image img = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		img = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		loginButton.setIcon(new ImageIcon (img));
		frame.getContentPane().add(loginButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 102, 104, 23);
		frame.getContentPane().add(passwordField);
		
		JLabel computerLogo = new JLabel("");
		Image computerLogoImage = new ImageIcon(this.getClass().getResource("/plants128.png")).getImage();
		computerLogoImage = computerLogoImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		computerLogo.setIcon(new ImageIcon (computerLogoImage));
		
		computerLogo.setBounds(32, 11, 257, 226);
		frame.getContentPane().add(computerLogo);
		
		
	}
}
