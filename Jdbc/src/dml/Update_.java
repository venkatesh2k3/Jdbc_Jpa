package dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update_ {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("done");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mySql","root","M1racle@123");
		System.out.println("done1");
		PreparedStatement ps = c.prepareStatement("update employee set ename= 'venkatesh' where idemployee=503");
		ps.executeUpdate();

	}

}
