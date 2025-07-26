package com.googleLinkedin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googleLinkedin.entity.User;
import com.googleLinkedin.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository repository;

	public User saveUser(User u) {

		return repository.save(u);
	}

	public List<User> findAllUser() {

		return repository.findAll();
	}

	public Optional<User> findUserById(int id) {

		return repository.findById(id);
	}

	public void deleteUserById(int id) {
		repository.deleteById(id);
	}

	public List<User> findUserByName(String name) {
		// return repository.findUserByName(name);
		return repository.findByName(name);
	}

}
