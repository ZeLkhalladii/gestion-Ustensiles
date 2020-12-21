package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbInfo {
	private static String username = "root";
	private static String password = "mysql";
	private static String host = "jdbc:mysql://localhost/products?autoReconnect=true&useSSL=false"; //Cela désactivera SSL et supprimera également les erreurs SSL//
	
	public static Connection connDB() throws SQLException {
		return DriverManager.getConnection(host, username, password);
	}
}

