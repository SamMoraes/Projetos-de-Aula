package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String HOST = "jdbc:mysql://localhost:3306/EXERCICIOAULA05?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "!Sup0rte";
	
	public static Connection getConnection() throws Exception{
		
		return DriverManager.getConnection(HOST, USER, PASSWORD);
	}
}
