package com.ytp.test.contoller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ytp.test.models.User;
import com.ytp.test.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/getUsers")
	public List<User> getUsers()
	{
		return userService.getAllUsers();
	}

	@PostMapping("/addUsers")  
	public List<User> saveAllBooks(@RequestBody List<User> user) {
		return userService.saveUsers(user);
	}
	@GetMapping("/getUser/status/{status}")

	public List<User> getUserByStatus(@PathVariable String status)
	{
		return (List<User>) userService.getuserByStatus(status);
	}
	@GetMapping("/getUser/address/{address}")

	public List<User> getUserByAddress(@PathVariable String address)
	{
		return (List<User>) userService.getUserByAddress(address);
	}
}