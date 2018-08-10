package Runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String username = "root";
	private static final String password = "root";
	private static final String conn = "jdbc:mysql://localhost:3306/cdw_sapp";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp", "root" , "root");
	}

}
