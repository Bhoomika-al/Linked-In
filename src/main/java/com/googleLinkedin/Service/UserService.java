package com.googleLinkedin.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.googleLinkedin.dao.UserDao;
import com.googleLinkedin.entity.User;
import com.googleLinkedin.responsestructure.ResponseStructure;

@Service
public class UserService {
	@Autowired
	UserDao dao;

	public ResponseEntity<?> saveUser(User u) {
		User savedUser = dao.saveUser(u);

//    rs.setStatus(201);
//    rs.setMessage("User Saved Successfully......");
//    rs.setBody(savedUser);
//    return ResponseEntity.status(201).body(new ResponseStructure(rs);
		return ResponseEntity.status(201).body(new ResponseStructure(201, "User Saved Successflly......", savedUser));
	}

	public ResponseEntity<?> findAllUser() {
		List<User> findUsers = dao.findAllUser();

		return ResponseEntity.status(200).body(new ResponseStructure(201, "find Successflly......", findUsers));
	}

	public ResponseEntity<?> findUserById(int id) {
		Optional<User> optional = dao.findUserById(id);

		if (optional.isPresent()) {
			User user = optional.get();
			return ResponseEntity.status(200).body(new ResponseStructure(200, "User found Successfully", user));
		} else {

			return ResponseEntity.status(404)
					.body(new ResponseStructure(404, "Invalid User Id, Unable to find User", null));
		}

	}

	public ResponseEntity<?> deleteUserById(int id) {
		Optional<User> optional = dao.findUserById(id);
		if (optional.isPresent()) {
			dao.deleteUserById(id);
			return ResponseEntity.status(200)
					.body(new ResponseStructure(200, "User Deleted Successfully", "User Deleted"));
		} else {
			return ResponseEntity.status(400)
					.body(new ResponseStructure(400, "Invalid User Id, Unable to Delete", "User Not Deleted"));
		}
	}

	public ResponseEntity<?> findUserByName(String name) {
		List<User> ul = dao.findUserByName(name);

		return ResponseEntity.status(200).body(new ResponseStructure(200, "User find Successfully", ul));

	}
}
