package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateUsingJDBC {

	public static void main(String[] args) throws SQLException {
		//Register The driver
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				// Establish the database connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
				// Issue the database statement
				
				Statement statement = connection.createStatement();

			//execute querry
				
				int result = statement.executeUpdate("insert into student values(103,'Tom','computer');");
				if (result==1) {
					System.out.println("Database has been updated");
				}
				else System.out.println("Database not updated");
				//close the database connection
					
connection.close();
		
	}

}
