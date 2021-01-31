package com.ytp.testing.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ytp.testing.model.User;
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from users u where u.status=?1")
	public List<User> getUserByStatus(String status);

}
