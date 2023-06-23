package dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamical_Insert {

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner (System.in);
			System.out.println("enter name, id, and phno");
			String ename=sc.nextLine();
			int idemployee=sc.nextInt();
			long ephno = sc.nextLong();
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("done");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mySql", "root", "M1racle@123");
			System.out.println("done1");
			PreparedStatement ps = c.prepareStatement("delete from employee where id=?");
			System.out.println("done1");
			ps.setInt(1, idemployee);
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
