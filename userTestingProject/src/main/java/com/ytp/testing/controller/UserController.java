package com.ytp.testing.controller;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ytp.testing.model.User;
import com.ytp.testing.repository.UserRepository;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/getUsers")
	public List<User> getUsers()
	{
		List<User> user=new ArrayList<User>();
		userRepository.findAll().forEach(book1 ->user.add(book1));
		return user;
	}

	@PostMapping("/addUsers")  
	public List<User> saveAllUsers(@RequestBody List<User> user) {
		return (List<User>) userRepository.saveAll(user);
	}

	@GetMapping("/getUser/status/{status}")

	public List<User> getUserByStatus(@PathVariable String status)
	{
		return  userRepository.getUserByStatus(status);
	}

	@DeleteMapping("/removeUser/{user_id}")  
	public void deleteUser(@PathVariable int user_id)   
	{
		userRepository.deleteById(user_id);
	} 
}