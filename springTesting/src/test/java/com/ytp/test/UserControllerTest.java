package com.ytp.test;

import static org.junit.Assert.assertEquals;
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

import com.ytp.test.contoller.UserController;
import com.ytp.test.models.User;
import com.ytp.test.repository.UserRepository;
import com.ytp.test.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private UserController userController;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void getUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User(1,"alex","uk","aaa@gmail.com","active"),new User(101,"alex","uk","aaa@gmail.com","inactive")).collect(Collectors.toList()));
		assertEquals(2,userController.getUsers().size());
	}
	@Test
	public void saveAllBooksTest()
	{ 
		List<User> user= new ArrayList<>(Arrays.asList(
				new User(1,"alex","uk","aaa@gmail.com","active"),
				new User(2,"akhil","usa","akh@gmail.com","inactive")));
		when(userRepository.saveAll(user)).thenReturn(user);
		assertEquals(user,userController.saveAllBooks(user));
	}
	@Test
	public void getUserByStatusTest()
	{
		String status="inactive";		
		userController.getUserByStatus(status);
		verify(userRepository).getUserByStatus(status);
	}
	@Test
	public void  getUserByAddressTest()
	{
		String address="ind";
		userController.getUserByAddress(address);
		verify(userRepository).getUserByAddress(address);
	}
}


