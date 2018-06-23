package net.home.support;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3308/home_dev?serverTimezone=UTC";
		String id = "root";
		String pw = "password";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url,id,pw);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
}
