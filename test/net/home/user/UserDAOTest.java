package net.home.user;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {
	
	private UserDAO userDao;
	
	@Before
	public void setup() {
		userDao = new UserDAO();
	}
	
	@Test
	public void connection(){
		Connection con = userDao.getConnection();
		assertNotNull(con);
	}
	
	@Test
	public void insert() throws Exception {
		userDao.addUser(UserTest.TEST_USER);
	}
	
	@Test
	public void findByUserId() throws Exception {
		User user = userDao.findByUserId("userId");
		assertEquals(UserTest.TEST_USER, user);
	}

}
