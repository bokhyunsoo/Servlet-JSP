package net.home.db;

import static org.junit.Assert.*;

import org.junit.Test;

import net.home.user.User;
import net.home.user.UserTest;

public class DatabaseTest {

	@Test
	public void addAndFindWhenExisted() {
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		
		User dbUser = Database.findByUserId(user.getUserId());
		assertEquals(user, dbUser);
	}
	
	@Test
	public void addAndFindWhenNotExisted() {
		
		User dbUser = Database.findByUserId("userId2");
		assertNull(dbUser);
	}

}
