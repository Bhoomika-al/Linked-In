package com.googleLinkedin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.googleLinkedin.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	// Custom  Query
//    @Query("select u from User u where u.name=?1")
//	List<User> findUserByName(String name);

	
	// method name convention
	List<User> findByName(String name);

}
