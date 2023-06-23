package dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Using_Switch {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner (System.in);
		System.out.println("enter firstname, lastname, role, id, phno");
		String efirstname=sc.nextLine();
		String elastname=sc.nextLine();
		String erole =sc.nextLine();
		int eid=sc.nextInt();
		long ephno = sc.nextLong();
		String num = Long.toString(ephno);
		String num1 = "+91 "+Long.toString(ephno);
		String fno=num.substring(5);
		String email=efirstname.charAt(0 )+"."+elastname+"@intern.com";
		String euser=efirstname.charAt(0)+"."+elastname;
		String epass =efirstname.substring(0,2)+elastname.substring(0,2)+fno;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("done");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_Data", "root", "M1racle@123");
		PreparedStatement ps = c.prepareStatement("insert into Employee values (?,?,?,?,?,?,?,?)");
			System.out.println("done1");
			ps.setInt(1, eid);
			ps.setString(2, efirstname);
			ps.setString(3, elastname);
			ps.setString(4,num1);
			ps.setString(5,erole);
			ps.setString(6,email);
			ps.setString(7, euser);
			ps.setNString(8, epass);
			ps.executeUpdate();
					
		
}

}
