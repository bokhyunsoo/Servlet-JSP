package net.home.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.home.user.User;
import net.home.user.UserDAO;

public abstract class JdbcTemplate {
	
	public Connection getConnection() {
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
	
	public void insert(String sql) throws SQLException{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			setParameters(pstmt);
			
			pstmt.executeUpdate();
		}finally{
			
			if (pstmt != null){
				pstmt.close();
			}
			
			if (conn != null){
				conn.close();
			}
		}
	}
	
	public abstract void setParameters(PreparedStatement pstmt) throws SQLException;
	
}
