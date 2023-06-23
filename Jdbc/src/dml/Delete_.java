package dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("done");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mySql", "root", "M1racle@123");
			Statement s = c.createStatement();
			int a = s.executeUpdate("delete from employee where idemployee = 504");
			System.out.println(a + " records affected");
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	

}
}
