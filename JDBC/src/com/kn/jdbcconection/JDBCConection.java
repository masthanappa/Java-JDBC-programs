package com.kn.jdbcconection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConection {

	public static void main(String[] args)  {
		String URL="jdbc:mysql://localhost:3306/university1";
		String USER_NAME="root";
		String PASSWORD="Mastan@8884644936";
//		String CREATE_STUDENT_QUERRY="CREATE TABLE STUDENT10(ID INT,NAME VARCHAR(20), MARKS INT)";
//        String INSERT_STUDENT_QUERY="INSERT INTO STUDENT9 VALUES(1,'Manu',100);";
//		String UPDATE_STUDENT_QUERY="UPDATE STUDENT9 SET NAME='SOMU' WHERE NAME= 'Manu';";
		String DELETE_STUDENT_QUERY="DELETE FROM STUDENT9 WHERE ID = 1;";
		
		try {
			//1. Load & Register  Driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//FCQN(Fully Qualified class name) - Canonical Name
			System.out.println("====>Driver Loaded Registerd Succsfully !");
			//2. Establish the  Connection with Database 
			Connection con= DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("Connection Established Successfully==>"+con);
			
			//3. Create Statement Object
			Statement stmt= con.createStatement();
			
			
			//4. Send & Execute Query
//			stmt.execute(CREATE_STUDENT_QUERRY);
			//int rowsAffected= stmt.executeUpdate(INSERT_STUDENT_QUERY);
			//int rowsAffected= stmt.executeUpdate(UPDATE_STUDENT_QUERY);
			int rowsAffected= stmt.executeUpdate(DELETE_STUDENT_QUERY);
			System.out.println(rowsAffected+"rowsAffected.");
			
			System.out.println("------>Student9 table created successfully !");
		} catch (ClassNotFoundException e) {
			System.out.println("-------> Driver Not Found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("-------->Faild to Established Connection");
			e.printStackTrace();
		}
	}
	}
