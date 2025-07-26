package com.googleLinkedin.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.googleLinkedin.dao.EducationDao;
import com.googleLinkedin.dao.UserDao;
import com.googleLinkedin.entity.Education;
import com.googleLinkedin.entity.User;
import com.googleLinkedin.responsestructure.ResponseStructure;

@Service
public class EducationService {
	@Autowired
	EducationDao educationDao;

	@Autowired
	UserDao userDao;

	public ResponseEntity<?> saveEducation(Education e, int uid) {
		Optional<User> optional = userDao.findUserById(uid);
		if (optional.isPresent()) {
			User u = optional.get();
			e.setUser(u);
			Education savedEducation = educationDao.saveEducation(e);
			ResponseStructure rs = new ResponseStructure(201, "Education Saved Successfully for" + u.getName(),
					savedEducation);
			return ResponseEntity.status(201).body(rs);
		} else {
			ResponseStructure rs = new ResponseStructure(400, "Education not saved Successfully for",
					"Education not saved");
			return ResponseEntity.status(400).body(rs);
		}

	}

	public ResponseEntity<?> findAllEducations() {
		List<Education> el = educationDao.findAllEducations();
		ResponseStructure rs = new ResponseStructure(200, "All Educatons Found Successfully", el);
		return ResponseEntity.status(200).body(rs);
	}

	public ResponseEntity<?> findAllEducationsByUserId(int uid) {
		List<Education> el = educationDao.findAllEducationsByUserId(uid);

		ResponseStructure rs = new ResponseStructure(200, "All Educations of The User Found Successfully", el);

		return ResponseEntity.status(200).body(rs);
	}

	public ResponseEntity<?> deleteEducationsById(int id) {

		Optional<Education> optional = educationDao.findAllEducationsById(id);
		if (optional.isPresent()) {
			educationDao.deleteEducationsById(id);
			return ResponseEntity.status(200)
					.body(new ResponseStructure(200, "User Deleted Successfully", "User Deleted"));
		} else {
			return ResponseEntity.status(400)
					.body(new ResponseStructure(400, "Invalid User Id, Unable to Delete", "User Not Deleted"));
		}
	}

	public ResponseEntity<?> findAllEducationsById(int id) {
		Optional<Education> optional = educationDao.findAllEducationsById(id);
		if (optional.isPresent()) {
			educationDao.findAllEducationsById(id);
			ResponseStructure rs = new ResponseStructure(200, "All Educations of The User Found Successfully", optional);

			return ResponseEntity.status(200).body(rs);
		}
		else {
			return ResponseEntity.status(400)
					.body(new ResponseStructure(400, "Invalid User Id, Unable to Delete", "User Not Deleted"));
		}
	}

	
	}

