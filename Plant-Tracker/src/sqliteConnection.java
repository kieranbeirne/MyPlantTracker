import java.sql.*;
import javax.swing.*;
public class sqliteConnection {
	Connection conn = null;
	public static Connection dbConnector()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Kiera\\Desktop\\PersonalProjects\\PlantTracker\\firstSQLite.db");
			//JOptionPane.showMessageDialog(null, "Connection successful.");
			return conn;
		}catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, e1);
			return null;
		}
	}
}
