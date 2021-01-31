package com.ytp.testing;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.ytp.testing.controller.UserController;
import com.ytp.testing.model.User;
import com.ytp.testing.repository.UserRepository;
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
	public void saveAllUsersTest()
	{ 			
		User user1=new User();
		user1.setUserId(104);
		user1.setUserName("alex");
		user1.setAddress("uk");
		user1.setEmail("aaa@gmail.com");
		user1.setStatus("active");

		User user2=new User();
		user2.setUserId(112);
		user2.setUserName("meera");
		user2.setAddress("us");
		user2.setEmail("bbb@gmail.com");
		user2.setStatus("inactive");

		List<User> user=new ArrayList<>();
		user.add(user1);
		user.add(user2);
		when(userRepository.saveAll(user)).thenReturn(user);
		assertEquals(user,userController.saveAllUsers(user));
	}
	@Test
	public void getUserByStatusTest()
	{
		String status="inactive";
		userController.getUserByStatus(status);
		verify(userRepository).getUserByStatus(status);
	}		
	@Test
	public void deleteUserTest()
	{
		int user_id=100;
		userController.deleteUser(user_id);
		verify(userRepository,times(1)).deleteById(user_id);
	}
}


