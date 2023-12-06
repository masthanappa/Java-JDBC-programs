package com.kn.jdbc4;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class StudentJDBCDemo {
	private static final String URL="jdbc:mysql://localhost:3306/university1";
    private static final String USER_NAME="root";
    private static final String PASSWORD="Mastan@8884644936";
	public static void main(String[] args) {
		Connection con =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			
			Student s1= new Student(2, "Arun", 95);
			Student s2= new Student(3, "Ashok", 80);
			
			DBHandler.insertData(con, s1);
			DBHandler.insertData(con, s2);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}

}
