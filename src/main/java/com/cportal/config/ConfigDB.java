package com.cportal.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConfigDB {
	private static ConfigDB cdb = null;
	private static String DATABASE_DRIVER;
	private static String DATABASE_URL;
	private static String DATABASE_USERNAME;
	private static String DATABASE_PASSWORD;
	private static Connection connection;
	private static String BASEURL;

	public static String getBASEURL() {
		return BASEURL;
	}

	public static void setBASEURL(String bASEURL) {
		BASEURL = bASEURL;
	}

	private static String getDATABASE_DRIVER() {
		return DATABASE_DRIVER;
	}

	private static void setDATABASE_DRIVER(String dATABASE_DRIVER) {
		DATABASE_DRIVER = dATABASE_DRIVER;
	}

	private static String getDATABASE_URL() {
		return DATABASE_URL;
	}

	private static void setDATABASE_URL(String dATABASE_URL) {
		DATABASE_URL = dATABASE_URL;
	}

	private static String getDATABASE_USERNAME() {
		return DATABASE_USERNAME;
	}

	private static void setDATABASE_USERNAME(String dATABASE_USERNAME) {
		DATABASE_USERNAME = dATABASE_USERNAME;
	}

	private static String getDATABASE_PASSWORD() {
		return DATABASE_PASSWORD;
	}

	private static void setDATABASE_PASSWORD(String dATABASE_PASSWORD) {
		DATABASE_PASSWORD = dATABASE_PASSWORD;
	}

	public Connection getConnection() {
		try {
			Class.forName(getDATABASE_DRIVER());

			connection = null;
			connection = DriverManager.getConnection(getDATABASE_URL(), getDATABASE_USERNAME(), getDATABASE_PASSWORD());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	private ConfigDB() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("/tmp/sharenodes/prop/configDB.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			setDATABASE_URL(prop.getProperty("DATABASE_URL"));
			setDATABASE_USERNAME(prop.getProperty("DATABASE_USERNAME"));
			setDATABASE_DRIVER(prop.getProperty("DATABASE_DRIVER"));
			setDATABASE_PASSWORD(prop.getProperty("DATABASE_PASSWORD"));
			setBASEURL(prop.getProperty("BASEURL"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static ConfigDB retrnConf() {
		if (cdb == null) {
			cdb = new ConfigDB();
		}
		return cdb;
	}

}