package com.cportal.database.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cportal.model.*;
import com.mysql.jdbc.CallableStatement;
public class DatabaseController {

	public static final int MYSQL_DUPLICATE_PK = 1062;
	private static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static String DATABASE_URL = "jdbc:mysql://localhost:3306/cportal";
	private static String DATABASE_USERNAME = "root";
	private static String DATABASE_PASSWORD = "success";

	// Checking Database connection establish or not
	public static void jdbcConnectionCheck() {
		Connection connection = null;

		try {
			Class.forName(DATABASE_DRIVER);

			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			if (connection != null) {
				System.out.println("CONNECTION ESTABLISHED!!!");
			} else {
				System.out.println("CONNECTION FAILURE!!!");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	public static boolean companyNewRegistration(User user){
		
		
		Connection connection=null;
		boolean exits=true;
		 try{
			 Class.forName(DATABASE_DRIVER);
			 connection=DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
			 CallableStatement statement=(CallableStatement) connection.prepareCall("{call newUserCompanyRegistration(?,?,?,?,?)}");
			 	statement.setString(1,user.getRegName());
				statement.setString(2, user.getRegComp());
				statement.setString(3, user.getRegEmail());
				statement.setString(4, user.getRegMobile());
				statement.setString(5, user.getReRegPwd());
				
				boolean s=statement.execute();
				
		 }
		 catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		 catch(SQLException sql){
			 if(sql.getErrorCode() == MYSQL_DUPLICATE_PK ){
			         exits=false;
			         return exits;
			    }
			 sql.printStackTrace();
			 
		 }finally {
				try {
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		
		
		
		return exits;
		
		
		
	}
	
	public static LoginCredential loginCheck(String username, String password){
		
		Connection connection = null;
		LoginCredential cr=null;
		try {
			// STEP 1
			Class.forName(DATABASE_DRIVER);
			
			String query= "select sUserName,companyName,email,userType from companyRegistration where email=? and password=?";
			// STEP 2 
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			PreparedStatement ps=connection.prepareStatement(query);
		
			ps.setString(1, username);
			ps.setString(2,password);
			// step 4
			
			ResultSet rs = ps.executeQuery();
			cr=new LoginCredential();
			if(rs != null) {
				while(rs.next()) {
					
					 cr.setsUserName( rs.getString("sUserName"));
					  cr.setCompanyName(rs.getString("companyName"));
					  cr.setEmail(rs.getString("email"));
					  cr.setUserType(rs.getString("userType"));
					
					
									
				}
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	return cr;
	}
	
	public static boolean editUserDetail(String EmailID){
		Connection connection = null;
		boolean updatestatus =false;
		EditUser edituser=null;
		try {
			// STEP 1
			Class.forName(DATABASE_DRIVER);
			
			String query= "select * from companyRegistration where email=?";
			// STEP 2 
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			PreparedStatement ps=connection.prepareStatement(query);
		
			ps.setString(1,EmailID);
			// step 4
			
			ResultSet rs = ps.executeQuery();
			edituser=new EditUser();
			if(rs != null) {
				while(rs.next()) {
					
					edituser.setPersonEmail(rs.getString(""));
					edituser.setPersonName(rs.getString(""));
					edituser.setPersonManager(rs.getString(""));
					edituser.setPersonPassword(rs.getString(""));
					edituser.setPersonDesignation(rs.getString(""));
					edituser.setPersonRole(rs.getString(""));
					
				}
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	return true;

			
		
	}
	
	public static void addUser(EditUser newuser){
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseController.jdbcConnectionCheck();
		/*User user=new User();
		user.setRegName("pradeep");
		user.setRegComp("anc.com");
		user.setRegEmail("pradeep@abc.com");
		user.setRegMobile("1234567890");
		user.setRegPwd("12345");
		DatabaseController.companyNewRegistration(user);*/
		LoginCredential cr= DatabaseController.loginCheck("farj.com", "12345");
		System.out.println(cr.getsUserName());
		System.out.println(cr.getCompanyName());
		System.out.println(cr.getUserType());

	}

}
