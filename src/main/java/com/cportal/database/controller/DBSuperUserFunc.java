package com.cportal.database.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

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
			System.out.println(connection);
			CallableStatement statement = (CallableStatement) connection
					.prepareCall("{CALL newUser_sp_CompanyUsers(?,?,?,?,?,?,?,?)}");
			statement.setString(1, superEmail);
			statement.setString(2, EditUser.getPersonName());
			statement.setString(3, EditUser.getPersonEmail());
			statement.setString(4, EditUser.getPersonPassword());
			statement.setString(5, EditUser.getPersonManager());
			statement.setString(6, EditUser.getPersonRole());
			statement.setString(7, EditUser.getPersonDesignation());
			statement.setString(8, "1");

			int insertStat = statement.executeUpdate();
			System.out.println("insertStat " + insertStat);
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

}
