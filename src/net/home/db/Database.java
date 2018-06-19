package net.home.db;

import java.util.HashMap;
import java.util.Map;

import net.home.user.User;

public class Database {
	private static  Map<String, User> users = new HashMap<String, User>();
	
	public static void addUser(User user){
		System.out.println("user : "+ user);
		users.put(user.getUserId(), user);
	}
}