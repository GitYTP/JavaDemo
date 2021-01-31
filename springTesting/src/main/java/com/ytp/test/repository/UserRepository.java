package com.ytp.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ytp.test.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u from users u where u.status=?1")
	public List<User> getUserByStatus(String status);

	@Query("select u from users u where address=?1 order by user_name desc")
	public List<User> getUserByAddress(String address);


}
