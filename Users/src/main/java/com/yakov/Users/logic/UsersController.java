package com.yakov.Users.logic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yakov.Users.bean.User;
import com.yakov.Users.dao.IUserDao;

@Controller
public class UsersController {
	@Autowired
	IUserDao usersDao;
	
	public User getUser(long id) {
			User user=usersDao.findById(id).get();
			return user;
	}
	
	public void addUser(User user) throws Exception {
		List<User> usersList=usersDao.findByName(user.getName());
		if(usersList.size()!=0) {
			throw new Exception("User exists already");
		}
		usersDao.save(user);
	}
	
	public void updateUser(User user) {
		usersDao.save(user);
	}
	
	public void deleteUser(long id) {
	User user=getUser(id);
	usersDao.delete(user);
	}
	
	public List<User>getAllUsers(){
		List<User>users=new ArrayList<>();
		usersDao.findAll().forEach(user ->users.add(user));
		return users;
	}
}
