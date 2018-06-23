package net.home.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.home.support.JdbcTemplate;
import net.home.support.PreparedStatementSetter;
import net.home.support.RowMapper;

public class UserDAO {
	
	public void addUser(User user) throws SQLException{
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			
			@Override
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getEmail());
				
			}
		};
		
		JdbcTemplate template = new JdbcTemplate();
		
		String sql= "insert into users values(?,?,?,?)";
		template.executeUpdate(sql, pss);
	}

	

	

	public User findByUserId(String userId) throws SQLException {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			
			@Override
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, userId);
				
			}
		};
		
		RowMapper rm = new RowMapper() {
			
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				
				return new User(rs.getString("userId"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email"));
			}
		};
		
		JdbcTemplate template = new JdbcTemplate();
		
		String sql = "select * from users where userId = ?";
		return (User) template.executeQuery(sql, pss, rm);
		
	}

	

	public void removeUser(String userId) throws SQLException {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			
			@Override
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, userId);
				
			}
		};
		
		JdbcTemplate template = new JdbcTemplate();
		
		String sql = "delete from users where userId = ?";
		template.executeUpdate(sql, pss);
		
	}

	public void executeUpdate(User user) throws SQLException {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			
			@Override
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getPassword());
				pstmt.setString(2, user.getName());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getUserId());
				
			}
		};
		
		
		JdbcTemplate template = new JdbcTemplate();
		
		String sql = "update users set password = ?, name = ?, email = ? where userId = ?";
		template.executeUpdate(sql, pss);
		
	}
	
}
