package net.home.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class UserTest {
	
	public static User TEST_USER = new User("userId","password","name","userId@gmail.com");
	
	private UserDAO userDao;
	
	@Before
	public void setup() throws Exception {
		userDao = new UserDAO();
		userDao.removeUser(TEST_USER.getUserId());
	}
	
	@Test
	public void matchPassword() {
		/*User user = new User("userId", "password", "name", "userId@gmail.com");
		boolean result = user.matchPassword("password");*/
		assertTrue(TEST_USER.matchPassword("password"));
	}
	
	@Test
	public void notmatchPassword() {
		/*User user = new User("userId", "password", "name", "userId@gmail.com");
		boolean result = user.matchPassword("password");*/
		assertFalse(TEST_USER.matchPassword("password2"));
	}
	
	@Test
	public void login() throws Exception {
		
		User user = UserTest.TEST_USER;
		userDao.addUser(user);
		assertTrue(User.login(TEST_USER.getUserId(), TEST_USER.getPassword()));
	}
	
	@Test(expected=UserNotFoundException.class)
	public void loginWhenNotExistedUser() throws Exception {
		User.login("userId2", TEST_USER.getPassword());
	}
	
	@Test(expected=PasswordMismatchException.class)
	public void loginWhenPasswordMismatch() throws Exception {
		
		User user = UserTest.TEST_USER;
		UserDAO userDao = new UserDAO();
		userDao.addUser(user);
		
		User.login(TEST_USER.getUserId(), "password2");
	}
	
}
