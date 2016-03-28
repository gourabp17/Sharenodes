package com.cportal.database.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.cportal.config.ConfigDB;
import com.cportal.model.*;
import com.cportal.model.mailservice.MailGun;
import com.mysql.jdbc.CallableStatement;

public class DatabaseController {

	public static final int MYSQL_DUPLICATE_PK = 1062;
	
	

	public boolean companyNewRegistration(User user) {

		Connection connection = null;
		boolean exits = true;
		try {
			String uEmail = UUID.randomUUID().toString().replaceAll("-", "");
			String uCode = UUID.randomUUID().toString().replaceAll("-", "");

			connection = (ConfigDB.retrnConf()).getConnection();
			System.out.println(connection);
			CallableStatement statement = (CallableStatement) connection
					.prepareCall("{call newUser_sp_CompanyRegistration(?,?,?,?,?,?,?,?)}");
			statement.setString(1, user.getRegName());
			statement.setString(2, user.getRegComp());
			statement.setString(3, user.getRegEmail());
			statement.setString(4, user.getRegMobile());
			statement.setString(5, user.getReRegPwd());
			statement.setString(6, uEmail);
			statement.setString(7, uCode);
			statement.setString(8, "0");

			int insertStat = statement.executeUpdate();
			System.out.println("insertStat " + insertStat);
			if (insertStat > 0) {
				MailGun mg = new MailGun();
				mg.sendVerificationMail(user.getRegEmail(), uEmail, uCode);
				System.out.println("mail send " + insertStat);
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

	public LoginCredential loginCheck(String username, String password) {

		Connection connection = null;
		LoginCredential cr = null;
		try {
			connection = (ConfigDB.retrnConf()).getConnection();
			
			String query = "select s_user_name,company_name,company_email from registration_vw_sharenodes where company_email=? and login_password=?";

			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, password);
			// step 4

			ResultSet rs = ps.executeQuery();
			cr = new LoginCredential();
			if (rs != null) {
				while (rs.next()) {

					cr.setsUserName(rs.getString("s_user_name"));
					cr.setCompanyName(rs.getString("company_name"));
					cr.setEmail(rs.getString("company_email"));
					cr.setUserType("superUser");

				}
			}
			else{

				String query2 = "select user_name,user_company_name,user_email,user_designation from company_vw_users where company_email=? and login_password=?";

				PreparedStatement ps2 = connection.prepareStatement(query2);

				ps2.setString(1, username);
				ps2.setString(2, password);
				// step 4

				ResultSet rs2 = ps2.executeQuery();
				cr = new LoginCredential();
				if (rs2 != null) {
					while (rs2.next()) {

						cr.setsUserName(rs2.getString("user_name"));
						cr.setCompanyName(rs2.getString("user_company_name"));
						cr.setEmail(rs2.getString("user_email"));
						cr.setUserType(rs2.getString("user_designation"));

					}
				}
			}

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
		return cr;
	}

	public boolean editUserDetail(String EmailID) {
		Connection connection = null;
		EditUser edituser = null;
		try {
			// STEP 1
			
			String query = "select * from companyRegistration where email=?";
			// STEP 2
			connection = (ConfigDB.retrnConf()).getConnection();
			System.out.println(connection);
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, EmailID);
			// step 4

			ResultSet rs = ps.executeQuery();
			edituser = new EditUser();
			if (rs != null) {
				while (rs.next()) {

					edituser.setPersonEmail(rs.getString(""));
					edituser.setPersonName(rs.getString(""));
					edituser.setPersonManager(rs.getString(""));
					edituser.setPersonPassword(rs.getString(""));
					edituser.setPersonDesignation(rs.getString(""));
					edituser.setPersonRole(rs.getString(""));

				}
			}

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
		return true;

	}

	public void addUser(EditUser newuser) {

	}

	public boolean verifyUser(String email, String code) {
		Connection connection = null;
		boolean udpated = false;
		try {

			connection = (ConfigDB.retrnConf()).getConnection();
			System.out.println(connection);
			CallableStatement statement = (CallableStatement) connection
					.prepareCall("{call activate_sp_CompanyRegistration(?,?,?)}");

			statement.setString(1, email);
			statement.setString(2, code);
			statement.setString(3, "0");

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
}
