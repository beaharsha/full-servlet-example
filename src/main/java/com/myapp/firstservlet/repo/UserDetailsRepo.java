package com.myapp.firstservlet.repo;

import java.util.HashMap;
import java.util.Map;

import com.myapp.firstservlet.model.User;

public class UserDetailsRepo {

	private Map<String, User> userRepoMap ;
	private static UserDetailsRepo repoInstance;
	
	private UserDetailsRepo() {
		userRepoMap = new HashMap<>();
	}
	
	public static synchronized UserDetailsRepo getInstane() {
		if(repoInstance == null) {
			repoInstance = new UserDetailsRepo();
		}
		return repoInstance;
	}
	
	public boolean saveUser(User user) {
		System.out.println("saveuser "+user.getUserId());
		if(userRepoMap.containsKey(user.getUserId())) {
			return false;
		}
		else {
			userRepoMap.put(user.getUserId(), user);
			return true;
		}
	}
	
	public User getUser(String userId, String password) {
		if(userRepoMap.containsKey(userId)) {
			User user = userRepoMap.get(userId);
			if(password.equals(user.getPassword())) {
				return user;
			}
		}
			return null;
	}
}
