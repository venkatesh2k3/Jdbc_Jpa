package dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class Role{
	String euser1, epass, role;
	String hr = "hr";
	String t = "trainer";
	String i = "trainee";
	int opt, empid;
	void role() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your username:");
		euser1= sc.nextLine();
		System.out.println("enter your password");
		epass = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("done");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_Data", "root", "M1racle@123");
		System.out.println("done1");
		PreparedStatement ps = c.prepareStatement("select * from emp_role where ((euserid='"+euser1+"')&&(epass='"+epass+"'))");
		System.out.println("done1");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			role=rs.getString(4);
	}
		if (role.equals(hr)) {
			System.out.println("Enter your choice");
			System.out.println("1-Insert");
			System.out.println("2-Update");
			System.out.println("3-Delete");
			System.out.println("4-View");
			opt = sc.nextInt();

			switch (opt) {
			case 1:
				Scanner sc1 = new Scanner(System.in);
				System.out.println("enter firstname, lastname, role, id, phno");
				String efirstname = sc1.nextLine();
				String elastname = sc1.nextLine();
				String erole = sc1.nextLine();
				int eid = sc1.nextInt();
				long ephno = sc1.nextLong();
				String num = Long.toString(ephno);
				String fno = num.substring(5);
				String email = efirstname.charAt(0) + "." + elastname + "@intern.com";
				String euser = efirstname.charAt(0) + "." + elastname;
				String epass = efirstname.substring(0, 2) + elastname.substring(0, 2) + fno;
				PreparedStatement ps1 = c.prepareStatement("insert into Employee values (?,?,?,?,?,?,?,?,?)");
				System.out.println("done1");
				ps1.setInt(1, eid);
				ps1.setString(2, efirstname);
				ps1.setString(3, elastname);
				ps1.setLong(4, ephno);
				ps1.setString(5, erole);
				ps1.setString(6, email);
				ps1.setString(7, euser);
				ps1.setString(8, epass);
				ps1.setString(9, euser1);
				ps1.executeUpdate();
				PreparedStatement ps8 = c.prepareStatement("insert into emp_role values('"+eid+"','"+euser+"','"+epass+"','"+erole+"')");
				ps8.executeUpdate();
				System.out.println("done1");
				
				break;
			case 2:
				Scanner sc2 = new Scanner(System.in);
				System.out.println("enter upadte emp id");
				empid = sc2.nextInt();
				sc2.nextLine();
				System.out.println("enter which field to be upadate");
				System.out.println("eid, efirstname, elastname, ephno, erole, email, euserid, epass,addby");
				String str = sc2.nextLine();
				System.out.println("enter upadte value");
				String str1 = sc2.nextLine();
				PreparedStatement ps2 = c
						.prepareStatement("update Employee set " + str + "='" + str1 + "' where (eid=" + empid + ")");
				ps2.executeUpdate();
				PreparedStatement ps9 = c.prepareStatement("update emp_role set " + str + "='" + str1 + "' where (eid=" + empid +")");
				ps.executeUpdate();
				break;
			case 3:
				Scanner sc3 = new Scanner(System.in);
				System.out.println("enter delete emp id");
				empid = sc3.nextInt();
				sc3.nextLine();
				PreparedStatement ps3 = c
						.prepareStatement("delete from Employee where (eid=" + empid + ")");
				ps3.executeUpdate();
				break;
			case 4:
				Scanner sc4 = new Scanner(System.in);
				
				System.out.println("enter 1: Self details, 2: for emplopee details");
				int o= sc4.nextInt();
				if(o==1) { 
					PreparedStatement ps41 = c.prepareStatement("select * from Employee where (euserid='" + euser1  + "')");
					ResultSet rs9= ps41.executeQuery();
					
					while(rs9.next()) {
						String p=rs9.getLong(1)+rs9.getString(2)+rs9.getString(3)+rs9.getLong(4)+rs9.getString(5)+rs9.getString(6)+rs9.getString(7)+rs9.getString(8)+rs9.getString(9);
					System.out.println(p);
				}}
					else
					{
						PreparedStatement ps4 =c.prepareStatement("select * from Employee where (addby='" + role + "')");
						ResultSet rs9= ps4.executeQuery();
						
						while(rs9.next()) {
							String p=rs9.getLong(1)+rs9.getString(2)+rs9.getString(3)+rs9.getLong(4)+rs9.getString(5)+rs9.getString(6)+rs9.getString(7)+rs9.getString(8)+rs9.getString(9);
						System.out.println(p);
					
						
					}
				
		
			}}}
			else if (role.equals(t)) {
				Scanner sc6 = new Scanner(System.in);
				System.out.println("enter emp id to viewe");
				empid = sc6.nextInt();
				PreparedStatement ps41 = c.prepareStatement("select * from Employee where (eid=" + empid  + ")");
				ResultSet rs9= ps41.executeQuery();
				
				while(rs9.next()) {
					String p=rs9.getLong(1)+rs9.getString(2)+rs9.getString(3)+rs9.getLong(4)+rs9.getString(5)+rs9.getString(6)+rs9.getString(7)+rs9.getString(8)+rs9.getString(9);
				System.out.println(p);
			}
			}
			else if (role.equals(i)) {
				int ch;
				System.out.println("enter choice 1:update 2: view ur details"); 
				ch=sc.nextInt();
				sc.nextLine();
				switch (ch) {
				case 1:
					System.out.println("enter which field to be upadate");
					System.out.println("eid, efirstname, elastname, ephno, erole, email, euserid, epass");
					String str = sc.nextLine();
					System.out.println("enter upadte value");
					String str1 = sc.nextLine();
					PreparedStatement ps2 = c
							.prepareStatement("update Employee set " + str + "='" + str1 + "' where (eid=" + empid + ")");
					ps2.executeUpdate();
					break;
				case 2:
					PreparedStatement ps3 = c.prepareStatement("select * from Employee where (euserid=" + euser1  + ")");
					ResultSet rs9= ps3.executeQuery();
					
					while(rs9.next()) {
						String p=rs9.getLong(1)+rs9.getString(2)+rs9.getString(3)+rs9.getLong(4)+rs9.getString(5)+rs9.getString(6)+rs9.getString(7)+rs9.getString(8)+rs9.getString(9);
					
					ps3.executeQuery();
					break;
				}
			}
			
		}
			else 
			{
				System.out.println("invalid credentisals");
			}
	}
	}
	


public class Role_Base {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Role r = new Role();
		r.role();
	}

}
