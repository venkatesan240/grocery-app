package com.grocery.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	public  Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3308/grocery";
        String userName = "root";
        String password = "root";
        Connection connection=DriverManager.getConnection(url, userName, password);
		return connection;
       
	}
}
