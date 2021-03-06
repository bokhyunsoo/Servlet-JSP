package net.home.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.home.support.jdbc.JdbcTemplate;
import net.home.support.jdbc.PreparedStatementSetter;
import net.home.support.jdbc.RowMapper;

public class UserDAO {

	public void addUser(User user) {
		JdbcTemplate template = new JdbcTemplate();
		String sql = "insert into users values(?,?,?,?)";
		template.executeUpdate(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
	}

	public User findByUserId(String userId)  {
		RowMapper<User> rm = new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs) throws SQLException {

				return new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
			}
		};

		JdbcTemplate template = new JdbcTemplate();
		String sql = "select * from users where userId = ?";
		return template.executeQuery(sql, rm, userId);

	}

	public void removeUser(String userId) {
		JdbcTemplate template = new JdbcTemplate();
		String sql = "delete from users where userId = ?";
		template.executeUpdate(sql, userId);

	}

	public void executeUpdate(User user) {
		JdbcTemplate template = new JdbcTemplate();
		String sql = "update users set password = ?, name = ?, email = ? where userId = ?";
		template.executeUpdate(sql, user.getPassword(), user.getName(), user.getEmail(), user.getUserId());

	}

	public List<User> findUsers() {
		RowMapper<User> rm = new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs) throws SQLException {

				return new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
			}
		};

		JdbcTemplate template = new JdbcTemplate();
		String sql = "select * from users";
		return template.list(sql, rm);
	}

}
