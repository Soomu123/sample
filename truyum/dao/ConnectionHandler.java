package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	private static Connection con = null;
	private static Properties props = new Properties();

	public static Connection getConnection()  {
		Connection con = null;
		try {
			FileInputStream fis = null;

			fis = new FileInputStream("C:\\Users\\J.SURENDRA\\Desktop\\webapplications\\truYum\\src\\connection.properties");

			props.load(fis);
			// load the Driver Class

			try {
				Class.forName(props.getProperty("db.classname"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} // create the connection now
			con = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.username"),
					props.getProperty("db.password"));
			// con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/truyum",prop);
			if (con != null) {
				System.out.println("connected to database");

			}

		} catch (SQLException e) {

			System.out.println("Not connected to the database");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Connection Properties file not found");
			e.printStackTrace();
		}
		return con;
	}

}
