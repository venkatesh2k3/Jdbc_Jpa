package dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("done");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_Data", "root", "M1racle@123");
			Statement s = c.createStatement();
			int a = s.executeUpdate("insert into emp_role values (507,'r.lokam','5066','trainer')");
			System.out.println(a + " records affected");
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
