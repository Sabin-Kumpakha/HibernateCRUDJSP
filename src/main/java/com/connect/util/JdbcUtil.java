package com.connect.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	
	private JdbcUtil() {
		//default Constructor
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException, IOException {
//		String dbLocation = "D:\Backend with Java , Spring\Eclipse workspace4(Hibernate)\JDBCMVCApp\src\main\java\com\connect\properties\db.properties";
//		HikariConfig config = new HikariConfig(dbLocation);
//		HikariDataSource dataSource = new HikariDataSource(config);
//			Connection connection = dataSource.getConnection();
//			return connection;
		return physicalConnection();
		}

	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		String dbLocation = "D:\\Backend with Java , Spring\\Eclipse workspace4(Hibernate)\\JDBCMVCApp\\src\\main\\java\\com\\connect\\properties\\db.properties";
		FileInputStream fis = new FileInputStream(dbLocation);
		Properties properties = new Properties();
		properties.load(fis);
		
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
