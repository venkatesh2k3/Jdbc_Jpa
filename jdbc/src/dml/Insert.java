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
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mySql","root","M1racle@123");
			System.out.println("done1");
		Statement s = c.createStatement();
		int a = s.executeUpdate("insert into employee values (503,'manoj',21)");
		System.out.println(a+" records affected");  

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
