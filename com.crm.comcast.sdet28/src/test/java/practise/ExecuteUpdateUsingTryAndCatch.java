package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateUsingTryAndCatch {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into student values(103,'Tom','computer');");
			if (result==1) {
				System.out.println("Database has been updated");
			}
			else System.out.println("Database not updated");
		}
catch (Exception e) {
	}
finally {
	connection.close();
}
	}
}
