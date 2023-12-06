package com.kn.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicQueryJDBC {
	private static final String URL="jdbc:mysql://localhost:3306/university1";
    private static final String USER_NAME="root";
    private static final String PASSWORD="Mastan@8884644936";
   // private static final String CREATE_STUDENT_QUERRY="CREATE TABLE STUDENT9(ID INT,NAME VARCHAR(20), MARKS INT)";
	private static final	String INSERT_QUERY="INSERT INTO Emp1 VALUES(?,?,?);";
	private static final   String SELECT_QUERY="SELECT * FROM Emp1;";

	private static final	String UPDATE_QUERY="UPDATE EMP1 SET SALARY=(SALARY+10) WHERE ID=?;";
    private static final	String DELETE_QUERY="DELETE FROM EMP1  WHERE ID = ?;";
  

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con= DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			
		//PreparedStatement pstmt =	con.prepareStatement(INSERT_QUERY);
			System.out.println("Choose approprite option");
			System.out.println("1,To INSERT DATA");
			System.out.println("2,To SELECT DATA");
			System.out.println("3,To UPDATE DATA");
			System.out.println("4,To DELETE DATA");
			int option = scan.nextInt();
			switch (option){
			case 1:{
				insertEmpData(con,scan);
				break;
			} case 2:{
				readEmpData(con,scan);
				break;
			}case 3:{
				UpdateEmpData(con,scan);
				break;
			}case 4:{
				deleteEmpData(con,scan);
				break;
			}default :{
				System.out.println("Invalid Option");
			}
			}
		} catch (ClassNotFoundException e) {
			
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	private static void deleteEmpData(Connection con, Scanner scan) {
		try {
			PreparedStatement pstmt= con.prepareStatement(DELETE_QUERY);
			System.out.println("Enter ID Whose salary needs to be deleted=");
			int id = scan.nextInt();
			pstmt.setInt(1, id);
			
			pstmt.execute();
			System.out.println("Record for Emplyeee with id =" +id+", has been deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
}

	private static void UpdateEmpData(Connection con, Scanner scan) {
		try {
			PreparedStatement pstmt= con.prepareStatement(UPDATE_QUERY);
			System.out.println("Enter ID Whose salary needs to be updated=");
			int id = scan.nextInt();
			pstmt.setInt(1, id);
			
			pstmt.execute();
			System.out.println("Salary for Emplyeee with id =" +id+", has been updated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static void readEmpData(Connection con, Scanner scan) {
		try {
			PreparedStatement pstmt= con.prepareStatement(SELECT_QUERY);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("ID="+rs.getInt(1)+",NAME="+rs.getString(2)+" ,SALARY = "+rs.getDouble(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void insertEmpData(Connection con, Scanner scan) {
		System.out.println("Enter Id =");
		int id = scan.nextInt();
		System.out.println("Enter Name=");
		String name= scan.next();
		System.out.println("Enter Salary=");
	    double salary = scan.nextDouble();
		
		try {
		PreparedStatement pstmt =con.prepareStatement(INSERT_QUERY);
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setDouble(3, salary);
		pstmt.execute();
		System.out.println("Data insertrd succsfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
