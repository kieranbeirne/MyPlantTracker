import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
//import net.proteanit.sql.DbUtils;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EmployeeInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	
	/**
	 * Create the frame.
	 */
	public EmployeeInfo() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Kieran");
		
//		try {
//			String query_name = "select * from EmployeeInfo where name=?";
//			PreparedStatement pst1 = connection.prepareStatement(query_name);
//			
//			
//			ResultSet rs = pst1.executeQuery();
//			lblNewLabel.setText("Welcome " + rs.toString());
//			
//			rs.close();
//			pst1.close();
//		}catch(Exception e4)
//		{
//			JOptionPane.showMessageDialog(null, e4);
//			
//		}
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(313, 22, 198, 69);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(152, 116, 536, 166);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		JButton btnLoadTable = new JButton("Load Plant Data");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from PlantTracker";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		btnLoadTable.setBounds(337, 339, 159, 23);
		contentPane.add(btnLoadTable);
		
		
		JLabel computerLogo2 = new JLabel("");
		Image computerLogoImage2 = new ImageIcon(this.getClass().getResource("/cactus.png")).getImage();
		computerLogoImage2 = computerLogoImage2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		computerLogo2.setIcon(new ImageIcon (computerLogoImage2));
		
		computerLogo2.setBounds(734, 392, 100, 139);
		contentPane.add(computerLogo2);
		
		JLabel computerLogo3 = new JLabel("");
		Image computerLogoImage3 = new ImageIcon(this.getClass().getResource("/plant64.png")).getImage();
		computerLogoImage3 = computerLogoImage3.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		computerLogo3.setIcon(new ImageIcon (computerLogoImage3));
		
		computerLogo3.setBounds(0, 348, 257, 226);
		contentPane.add(computerLogo3);
		
		JLabel computerLogo4 = new JLabel("");
		Image computerLogoImage4 = new ImageIcon(this.getClass().getResource("/hangingPlant.png")).getImage();
		computerLogoImage4 = computerLogoImage4.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
		computerLogo4.setIcon(new ImageIcon (computerLogoImage4));
		
		computerLogo4.setBounds(544, -86, 257, 226);
		contentPane.add(computerLogo4);
		
	}
}
