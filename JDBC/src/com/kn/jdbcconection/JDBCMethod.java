package com.kn.jdbcconection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCMethod {
	private static final String URL="jdbc:mysql://localhost:3306/university1";
    private static final String USER_NAME="root";
    private static final String PASSWORD="Mastan@8884644936";
	private static final	String INSERT_QUERY="INSERT INTO emp2 VALUES(?,?,?);";
    private static final   String SELECT_QUERY="SELECT * FROM emp2;";
	private static final	String UPDATE_QUERY="UPDATE emp2 SET NAME='Ram' WHERE NAME= 'RamBabu';";
    private static final	String DELETE_QUERY="DELETE FROM emp2  WHERE ID = 2;";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection con=null;
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				
				con= DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				
				Statement stmt= con.createStatement();
				System.out.println("1,To Insert data");
				System.out.println("2,To Read data");
				System.out.println("3,To Update data");
				System.out.println("4,To Delete data");
		       int option= scan.nextInt();
			    switch (option) {
			    case 1 :{
			 //To insert data
			    	createData(con,INSERT_QUERY,scan);
			      break; 
			    }
			    case 2:{
			    //To ReadData
				JDBCMethod jd= new JDBCMethod();
				jd.readData(stmt, SELECT_QUERY);
				break;
			    }
			    case 3:{
			    	//Update Data
			    	updateData(stmt,UPDATE_QUERY);
			    	break;
			    }
			 
			    case 4:{
			    	//delete
			    	deleteData(stmt,DELETE_QUERY);
			    	break;
			    }
			     default:
			    	 throw new IllegalArgumentException("UnExcepeted value:" + option);
			    }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (scan != null) {
					 scan.close();
				}
			}
		}
	//Insert
		private static void createData (Connection con, String insertQuery,Scanner scan) {
			
			try {
				System.out.println("Enter value for ID=");
				int id =scan.nextInt();
				System.out.println("Enter value for Name=");
				String name=scan.next();
				System.out.println("Enter value for Salary");
				double salary=scan.nextDouble();
				
				
				PreparedStatement pstmt=con.prepareStatement(INSERT_QUERY);
				 pstmt.setInt(1,id);
		       pstmt.setString(2,name);
			       pstmt.setDouble(3,salary);
			       pstmt.execute();
			

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if (con!= null) {
					 
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			}
		}
	
	
     //Select
	static ResultSet readData(Statement stmt, String SelectQuery) {
		try {
			ResultSet rs = stmt.executeQuery(SelectQuery);
			while(rs.next()){
				System.out.println("ID="+rs.getInt(1)+",NAME="+rs.getString(2)+" ,SALARY = "+rs.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

		//Update
		private static void updateData (Statement stmt, String UpdateQuery) {
			
			try {
				int rows_Affected=stmt.executeUpdate(UpdateQuery);
				System.out.println(rows_Affected+"rows_Affected");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		//Delete 
			private static void deleteData (Statement stmt, String DeleteQuery) {
				
				try {
					int rows_Affected=stmt.executeUpdate(DeleteQuery);
					System.out.println(rows_Affected+"rows_Affected");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
		}

