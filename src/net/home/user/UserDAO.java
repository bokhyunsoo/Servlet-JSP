package net.home.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3308/home_dev";
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
	
	public void insert(User user) throws SQLException{
		String sql = "insert into users values(?,?,?,?)";
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		
		pstmt.executeUpdate();
	}
	
}
