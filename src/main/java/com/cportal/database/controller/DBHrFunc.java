package com.cportal.database.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

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
			statement.setDouble(5, lp.getEl());
			statement.setDouble(6, lp.getSl());
			statement.setDouble(7, lp.getCl());
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

	public LeavePolicy holidayDetails(String companyName) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		LeavePolicy obj = new LeavePolicy();

		try {

			connection = (ConfigDB.retrnConf()).getConnection();
			statement = connection.createStatement();
			String sqlStat = "select * from leave_vw_policy where company_name='" + companyName + "'";
			resultSet = statement.executeQuery(sqlStat);

			while (resultSet.next()) {
				obj.setHolidaylist(resultSet.getString("holidays_date"));
				obj.setLeave_unit(resultSet.getString("leave_unit"));
				if ("Hourly".equals(resultSet.getString("leave_unit"))) {
					obj.setSl(resultSet.getDouble("total_sick_leave"));
					obj.setEl(resultSet.getDouble("total_year_leave"));
					obj.setCl(resultSet.getDouble("total_casual_leave"));
				}
				else if ("Monthly".equals(resultSet.getString("leave_unit"))) {
					obj.setSl(resultSet.getDouble("total_sick_leave")*30);
					obj.setEl(resultSet.getDouble("total_year_leave")*30);
					obj.setCl(resultSet.getDouble("total_casual_leave")*30);
				}
				else if ("Yearly".equals(resultSet.getString("leave_unit"))) {
					obj.setSl(resultSet.getDouble("total_sick_leave")*365);
					obj.setEl(resultSet.getDouble("total_year_leave")*365);
					obj.setCl(resultSet.getDouble("total_casual_leave")*365);
				}
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
}
