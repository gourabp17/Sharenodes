package com.cportal.database.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.cportal.config.ConfigDB;
import com.cportal.model.EditUser;
import com.cportal.model.LeavePolicy;
import com.mysql.jdbc.CallableStatement;

public class DBHrFunc {
	public boolean updateHoliday(LeavePolicy lp) {
		Connection connection = null;
		boolean udpated = false;
		try {

			connection = (ConfigDB.retrnConf()).getConnection();
		CallableStatement statement = (CallableStatement) connection
					.prepareCall("{call cmp_leave_sp_policy(?,?,?,?,?,?,?,?)}");

			statement.setString(1, lp.getcName());
			statement.setString(2, lp.getcEmail());
			statement.setString(3, lp.getCurrent_year());
			statement.setString(4, lp.getHolidaylist());
			statement.setString(5, lp.getEl());
			statement.setString(6, lp.getSl());
			statement.setString(7, lp.getCl());
			statement.setString(8, lp.getLeave_unit());

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
