package com.kn.jdbc3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCBatchProcessing {
	private static final String URL="jdbc:mysql://localhost:3306/university1";
    private static final String USER_NAME="root";
    private static final String PASSWORD="Mastan@8884644936";
   // private static final String CREATE_STUDENT_QUERRY="CREATE TABLE STUDENT9(ID INT,NAME VARCHAR(20), MARKS INT)";
	private static final	String QUERY1="UPDATE TRAINER SET GENDER = 'MALE' ID !=4";
	private static final   String QUERY2="UPDATE TRAINER SET NAME = 'XXX' WHERE ID=1";
	 
	public static void main(String[] args) {
		Connection con=null;
		Scanner scan= new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con= DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			
	        Statement stmt= con.createStatement();
	        
	        //----->A) Set autocommit as false
	        con.setAutoCommit(false);
	        
	        
	        //----B) Add tasks to batch
	        stmt.addBatch(QUERY1);//4 rows affected
	        stmt.addBatch(QUERY2);//1 rows affected
	        
	      //----c) Get count of records affected
	        
	       int[] countBatch= stmt.executeBatch();
	        for(int count : countBatch) {
	        	System.out.println(count + "rows affected");
	        	
	        	
	        }
	        con.commit();
	       
		} catch (ClassNotFoundException e) {
			
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
			}
		}

	}


	}


