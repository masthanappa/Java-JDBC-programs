package com.kn.Jdbc5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Revison {
		 private static final String URL="jdbc:mysql://localhost:3306/university1";
         private static final String USER_NAME="root";
         private static final String PASSWORD="Mastan@8884644936";
		//private static final  String CREATE_TRAINER4_QUERRY="CREATE TABLE TRAINER4(ID INT,NAME VARCHAR(20),SALARY INT);";
	     private static final   String INSERT_TRAINER3_QUERY="INSERT INTO TRAINER VALUES(1,'Manu');";
		//private static final	String UPDATE_TRAINER4_QUERY="UPDATE TRAINER SET NAME='SOMU' WHERE NAME= 'Manu';";
        // private static final	String DELETE_TRAINER3_QUERY="DELETE FROM TRAINER WHERE ID = 1;";
         public static void main(String[] args)  {
			Connection con=null;
			try {
				//1. Load & Register  Driver
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				//FCQN(Fully Qualified class name) - Canonical Name
				System.out.println("====>Driver Loaded Registerd Succsfully !");
				//2. Establish the  Connection with Database 
				 con= DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				System.out.println("Connection Established Successfully==>"+con);
				
				//3. Create Statement Object
				Statement stmt= con.createStatement();
				
				
				//4. Send & Execute Query
				//stmt.execute(CREATE_TRAINER4_QUERRY);
				int rowsAffected= stmt.executeUpdate(INSERT_TRAINER4_QUERY);
				System.out.println("Trainer4 table created successfully !");
				//int rowsAffected= stmt.executeUpdate(CREATE_TRAINER4_QUERRY);
			
		
//			int rowsAffected= stmt.executeUpdate(UPDATE_TRAINER3_QUERY);
//				System.out.println(rowsAffected+"rowsAffected.");
//				
			//System.out.println("------>Trainer4 table created successfully !");

			
			} catch (ClassNotFoundException e) {
				System.out.println("-------> Driver Not Found");
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("-------->Faild to Established Connection");
				e.printStackTrace();
			}finally {
				//5.close the Connection
				try{
					if(con !=null) {
				}
					con.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
	}



	}


