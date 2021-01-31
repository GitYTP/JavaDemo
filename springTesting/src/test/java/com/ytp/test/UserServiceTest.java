package com.ytp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ytp.test.models.User;
import com.ytp.test.repository.UserRepository;
import com.ytp.test.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;
	@Test
	void testGetAllUsers() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User(1,"alex","uk","aaa@gmail.com","active"),new User(101,"alex","uk","aaa@gmail.com","inactive")).collect(Collectors.toList()));
		assertEquals(2,userService.getAllUsers().size());
	}

	@Test
	void testSaveUsers() {
		List<User> user= new ArrayList<>(Arrays.asList(
				new User(1,"alex","uk","aaa@gmail.com","active"),
				new User(2,"akhil","usa","akh@gmail.com","inactive")));
		when(userRepository.saveAll(user)).thenReturn(user);
		assertEquals(user,userService.saveUsers(user));
	}
	@Test
	void testGetuserByStatus() {

		String status="inactive";

		userService.getuserByStatus(status);
		verify(userRepository).getUserByStatus(status);
	}
	@Test
	void testGetUserByAddress() {

		String address="ind";
		userService.getUserByAddress(address);
		verify(userRepository).getUserByAddress(address);
	}

}
