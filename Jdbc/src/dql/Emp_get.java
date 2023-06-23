package dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.ResultSetMetaData;

public class Emp_get {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter firstname, lastname, and Username");
		String efirstname="";
		efirstname= sc.nextLine();
		String elastname="" ;
		elastname = sc.nextLine();
		String euser ="";
		euser= sc.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("done");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_Data", "root", "M1racle@123");
		System.out.println("done1");
		PreparedStatement ps = c.prepareStatement("select *from Employee");
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rm = rs.getMetaData();
		for (int i = 2; i <= rm.getColumnCount() - 1; i++) {
			System.out.print(rm.getColumnName(i) + "		");

		}

		while (rs.next()) {
			System.out.println();
			if((rs.getString(2)).startsWith(efirstname)&&(rs.getString(3)).startsWith(elastname)&&(rs.getString(3)).startsWith(euser)) {
			System.out.println(rs.getString(2) + "			" + rs.getString(3) + "		" + rs.getLong(4) + "		"
					+ rs.getString(5) + "		" + rs.getString(6) + "	" + rs.getString(7));
		}
		}
	}

}
