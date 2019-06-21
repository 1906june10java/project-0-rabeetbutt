package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;


public class ConnectionUtil {
	
	private static final Logger LOGGER = Logger.getLogger(ConnectionUtil.class);
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@myrevaturerds.clsahk4l5bqo.us-east-1.rds.amazonaws.com:1521:ORCL";
		String username = "BANK_DB";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	public static void main(String[] args) {
		
		try {
			getConnection();
			LOGGER.info("Connection successful");
		}
		catch (SQLException e) {
			LOGGER.error("Could not connect.");
		}
	}
}
