package com.cportal.database.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.json.JSONObject;

import com.cportal.config.ConfigDB;
import com.cportal.model.EditUser;
import com.cportal.model.User;
import com.cportal.model.mailservice.MailGun;
import com.mysql.jdbc.CallableStatement;

public class DBSuperUserFunc {
	public static final int MYSQL_DUPLICATE_PK = 1062;

	public boolean companyNewUser(EditUser EditUser, String superEmail) {

		Connection connection = null;
		boolean exits = false;
		try {

			connection = (ConfigDB.retrnConf()).getConnection();
			CallableStatement statement = (CallableStatement) connection
					.prepareCall("{CALL newUser_sp_CompanyUsers(?,?,?,?,?,?,?,?)}");
			statement.setString(1, superEmail);
			statement.setString(2, EditUser.getPersonName());
			statement.setString(3, EditUser.getPersonEmail());
			statement.setString(4, EditUser.getPersonPassword());
			statement.setString(5, EditUser.getPersonManager());
			statement.setString(6, EditUser.getPersonRole());
			statement.setString(7, EditUser.getPersonDesignation());
			statement.setString(8, "active");

			int insertStat = statement.executeUpdate();
			if (insertStat > 0) {
				exits = true;
			}
		} catch (SQLException sql) {
			if (sql.getErrorCode() == MYSQL_DUPLICATE_PK) {
				exits = false;
				return exits;
			}
			sql.printStackTrace();

		} finally {
			try {
				if (connection != null) {
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return exits;

	}

	public int noOfUser(String companyName) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int rowCount = 0;
		try {

			connection = (ConfigDB.retrnConf()).getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select count(*) from company_vw_users where user_company_name='"+companyName+"'");

			while (resultSet.next()) {
				rowCount= resultSet.getInt(1);
			}
		} catch (SQLException sql) {

			sql.printStackTrace();

		} finally {
			try {
				if (connection != null) {
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}
	public JSONObject listOfUser(String companyName, String to, String from) {
		int start=Integer.parseInt(to)-1;
		int end=Integer.parseInt(from)-1;
		JSONObject mergedJson = new JSONObject();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {

			connection = (ConfigDB.retrnConf()).getConnection();
			statement = connection.createStatement();
			String sqlStat= "select * from company_vw_users where user_company_name='"+companyName+"' ORDER BY user_name ASC LIMIT "+start+","+end+"";
			resultSet = statement.executeQuery(sqlStat);
			int count = 0;
			while (resultSet.next()) {
				JSONObject obj = new JSONObject();
				obj.put("Name", resultSet.getString("user_name").toUpperCase());
				obj.put("Email", resultSet.getString("user_email"));
				obj.put("Manager", resultSet.getString("user_manage_email"));
				obj.put("Role", resultSet.getString("user_role").toUpperCase());
				obj.put("Designation", resultSet.getString("user_designation").toUpperCase());
				obj.put("Status", resultSet.getString("statusCode").toUpperCase());
				mergedJson.put( Integer.toString(++count), obj);
			}
		} catch (SQLException sql) {

			sql.printStackTrace();

		} finally {
			try {
				if (connection != null) {
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mergedJson;
	}

	public JSONObject searchUser(String email, String companyName) {
		
		JSONObject obj = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {

			connection = (ConfigDB.retrnConf()).getConnection();
			statement = connection.createStatement();
			String sqlStat= "select * from company_vw_users where user_company_name='"+companyName+"' and user_email= '"+email+"'";
			resultSet = statement.executeQuery(sqlStat);
			while (resultSet.next()) {
				 obj = new JSONObject();
				obj.put("Name", resultSet.getString("user_name").toUpperCase());
				obj.put("Manager", resultSet.getString("user_manage_email"));
				obj.put("Role", resultSet.getString("user_role").toUpperCase());
				obj.put("Designation", resultSet.getString("user_designation").toUpperCase());
			}
		} catch (SQLException sql) {

			sql.printStackTrace();

		} finally {
			try {
				if (connection != null) {
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public boolean deleteUser(String email, String companyName) {
		Connection connection = null;
		boolean udpated = false;
		try {

			connection = (ConfigDB.retrnConf()).getConnection();
		CallableStatement statement = (CallableStatement) connection
					.prepareCall("{call delete_sp_CompanyUser(?,?,?)}");

			statement.setString(1, email);
			statement.setString(2, companyName);
			statement.setString(3, "active");

			int updateStat = statement.executeUpdate();
			if (updateStat > 0) {
				udpated = true;
			}
		} catch (SQLException e) {
			udpated = false;
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

		return udpated;
	}

	public boolean updateUser(EditUser editUser, String company) {
		Connection connection = null;
		StringBuffer statement= new StringBuffer();
		boolean udpated = false;
		try {

			connection = (ConfigDB.retrnConf()).getConnection();
		
			if(company!=null && editUser.getPersonEmail()!=null && !((editUser.getPersonEmail().trim()).isEmpty()))
			{
				statement.append("UPDATE  company_users SET ");
				
				if(editUser.getPersonName()!=null && !(editUser.getPersonName().trim().isEmpty())){
					statement.append("user_name= '").append(editUser.getPersonName()).append("', ");
				}
				if(editUser.getPersonPassword()!=null && !(editUser.getPersonPassword().trim().isEmpty())){
					statement.append("user_login_password= '").append(editUser.getPersonPassword()).append("', ");
				}
				if(editUser.getPersonManager()!=null && !(editUser.getPersonManager().trim().isEmpty())){
					statement.append("user_manage_email= '").append(editUser.getPersonManager()).append("', ");
				}
				if(editUser.getPersonRole()!=null && !(editUser.getPersonRole().trim().isEmpty())){
					statement.append("user_role= '").append(editUser.getPersonRole()).append("', ");
				}
				if(editUser.getPersonDesignation()!=null && !(editUser.getPersonDesignation().trim().isEmpty())){
					statement.append("user_designation= '").append(editUser.getPersonDesignation()).append("',");
				}
				statement.append(" user_email= '").append(editUser.getPersonEmail()).append("' where user_email='")
				.append(editUser.getPersonEmail()).append("' and user_company_name='").append(company).append("' and statusCode='active'");
			}
			CallableStatement calStatement = (CallableStatement) connection
					.prepareCall(statement.toString());

			int updateStat = calStatement.executeUpdate();
			if (updateStat > 0) {
				udpated = true;
			}
		} catch (SQLException e) {
			udpated = false;
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

		return udpated;
	}
}
