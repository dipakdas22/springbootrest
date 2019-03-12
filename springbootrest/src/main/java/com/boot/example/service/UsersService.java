package com.boot.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boot.example.entity.User;

@Service (value = "userService")
public class UsersService {
	 
	static HashMap<Integer,User> userMap=getUserMap();
 
 
	public UsersService() { 
		super();
 
		if(userMap==null)
		{
			userMap=new HashMap<Integer,User>();
			// Creating some objects of User while initializing
			User user1 = new User(1,"Ion User1", "1", "IR Org1");
			User user2 = new User(2,"Ion user2", "2", "IR Org2");
			User user3 = new User(3,"Ion user3", "ff80818161f5962b0161f5e21eb50001", "IR Org3");
 
			userMap.put(1,user1);
			userMap.put(2,user2);
			userMap.put(3,user3);
		}
	}
 
	public List<User> getAllUsers()
	{
		List<User> users = new ArrayList(userMap.values());
		return users;
	}
 
	public User getUser(int id)
	{
		User user= userMap.get(id);
		return user;
	}
	public User addUser(User user)
	{
		user.setId(getMaxId()+1);
		userMap.put(user.getId(), user);
		return user;
	}
 
	public User updateUser(User user)
	{ 
		if(user.getId()<=0)
			return null;
		userMap.put(user.getId(), user);
		return user;
 
	}
	public User deleteUser(int id)
	{
		return userMap.remove(id);
	}
 
	public static HashMap<Integer, User> getUserMap() {
		return userMap;
	}
 
	// Utility method to get max id
	public static int getMaxId()
	{ int max=0;
	for (int id:userMap.keySet()) { 
		if(max<=id)
			max=id;
 
	} 
	return max;
	}
}
