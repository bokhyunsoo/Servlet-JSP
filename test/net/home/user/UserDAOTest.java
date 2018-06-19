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
		userDao.insert(UserTest.TEST_USER);
	}

}
