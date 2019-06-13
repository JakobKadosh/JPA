package com.yakov.Users.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yakov.Users.bean.User;
import com.yakov.Users.logic.UsersController;

@RequestMapping("/users")
@RestController
public class UserApi {
	
	@Autowired
	UsersController controller;
	@PostMapping
	public void creatUser(@RequestBody User user) throws Exception{
		controller.addUser(user);
	}
	
	@GetMapping
	public List<User>getAllUsers(){
		return controller.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") long id) {
		return controller.getUser(id);
	}
	

	@DeleteMapping("/{userId}")
	public void deleteUser(@RequestParam("userId")long id) {
		controller.deleteUser(id);
	}
}
