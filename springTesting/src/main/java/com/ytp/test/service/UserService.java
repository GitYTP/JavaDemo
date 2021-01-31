package com.ytp.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.ytp.test.models.User;
import com.ytp.test.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	public List<User> getAllUsers()
	{ 
		List<User> user=new ArrayList<User>();
		userRepository.findAll().forEach(book1 ->user.add(book1));
		return user;
	}
	public List<User> saveUsers(List<User> user)
	{ 

		return (List<User>) userRepository.saveAll(user);

	}
	public List<User> getuserByStatus(String status)
	{
		return  userRepository.getUserByStatus(status);

	}
	public List<User> getUserByAddress(String address)
	{
		return  userRepository.getUserByAddress(address);

	}
}

