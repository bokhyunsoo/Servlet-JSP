package net.home.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public void addUser(User user) throws SQLException{
		String sql = "insert into users values(?,?,?,?)";
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		
		pstmt.executeUpdate();
	}

	public User findByUserId(String userId) throws SQLException {
		String sql = "select * from users where userId = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next()){
			return null;
		}
		
		return new User(rs.getString("userId"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email"));
	}

	public void removeUser(String userId) throws SQLException {
		String sql = "delete from users where userId = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, userId);
		
		pstmt.executeUpdate();
	}

	public void updateUser(User user) throws SQLException {
		String sql = "update users set password = ?, name = ?, email = ? where userId = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getUserId());
		
		pstmt.executeUpdate();
	}
	
}
