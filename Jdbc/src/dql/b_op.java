package dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

class Atm_ {
double bal,tbal, wd, dp;
int opt,count=1;

long acc_no1, acc_no, pin, pin1,tacc_no;

void atm_() throws ArithmeticException, ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "M1racle@123");
	//Scanner sc1 = new Scanner(System.in);
	Scanner sc = new Scanner(System.in);
	System.out.println("enter a/c no:");
	acc_no1 = sc.nextLong();
	System.out.println("enter your password");
	pin1 = sc.nextInt();
	PreparedStatement ps = c.prepareStatement("select * from atm_machine where ((acc_no ='"+acc_no1+"')&&(pin='"+pin1+"'))");
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
		acc_no=rs.getLong(1);
		pin=rs.getInt(2);
		bal=rs.getDouble(3);}
	while(count<3) {
	if (acc_no==acc_no1 && pin1==pin) {
		
		System.out.println("Enter your choice");
		System.out.println("1-Deposit");
		System.out.println("2-Withdraw");
		System.out.println("3-Balance Enquiry ");
		System.out.println("4-Transfer");
		System.out.println("5-exit");
		opt = sc.nextInt();
		switch (opt) {
		case 1:

			System.out.println("Please Enter Amount to deposit");
			dp = sc.nextInt();
			if (dp < 500) {
				System.out.println("Please enter more than 500");
				throw new ArithmeticException("invalid input");
			} else {
				bal += dp;
				System.out.println("Account Balance \n" + bal + "\n");
				PreparedStatement ps2 = c
						.prepareStatement("update atm_machine set bal= ? where acc_no=" + acc_no1 + "");
				ps2.setDouble(1, bal);
				ps2.executeUpdate();
				}
			break;

		case 2:
			System.out.println("Please Enter Amount to withdraw");
			wd = sc.nextInt();
			if (wd > bal) {
				System.out.println("insufficient balance ");
				throw new ArithmeticException("invalid amount");

			} else {
				PreparedStatement ps2 = c.prepareStatement("update atm_machine set bal= ? where acc_no=" + acc_no1 + "");
				ps2.setDouble(1, bal);
				ps2.executeUpdate();
				bal -= wd;
				System.out.println("Please collect your amount");
				PreparedStatement ps3 = c.prepareStatement("update atm_machine set bal= ? where acc_no=" + acc_no1 + "");
				ps3.setDouble(1, bal);
				ps3.executeUpdate();
			}
			break;

		case 3:

			System.out.println("Account Balance is  " + bal);
			break;

		case 4:
			System.out.println("Enter transfer a/c no:");
			tacc_no=sc.nextLong();
			System.out.println("Enter transfer amount:");
			double tamt = sc.nextDouble();
			PreparedStatement ps1 = c.prepareStatement("select * from atm_machine where acc_no =" + tacc_no + "");
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				tbal = rs1.getDouble(3);
			}
			if (bal > tamt) {
				tbal += tamt;
				bal -= tamt;
				System.out.println("current bal=" + bal+" 	");
				PreparedStatement ps4 =c.prepareStatement("update atm_machine set bal= ? where acc_no=" + acc_no1 + "");
				ps4.setDouble(1, bal);
				ps4.executeUpdate();
				PreparedStatement ps5 = c.prepareStatement("update atm_machine set bal= ? where acc_no=" + tacc_no + "");
				ps5.setDouble(1, tbal);
				ps5.executeUpdate();
			}
			break;
		case 5:
			System.out.println("Thank you for visiting");
			System.exit(0);
			//break;
		default:
			System.out.println("Invalid input, Please select between 1-4");
			atm_();

		}
	//System.exit(0);
	}
	 else {
		count++;
		atm_();
		System.out.println("Incorrect Password");
		//throw new ArithmeticException("invalid password");
		
		
	}}
	
	if(count==3)
	{
		System.exit(0);
	}
}}
public class b_op {

	public static void main(String[] args) throws ArithmeticException, ClassNotFoundException, SQLException {
		Atm_ at= new Atm_();
		at.atm_();

	}

}
