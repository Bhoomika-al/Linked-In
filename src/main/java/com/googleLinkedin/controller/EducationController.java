package com.googleLinkedin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.googleLinkedin.Service.EducationService;
import com.googleLinkedin.entity.Education;

@RestController
public class EducationController {
	@Autowired
	EducationService service;

	@PostMapping("/educations/{uid}")
	public ResponseEntity<?> saveEducation(@RequestBody Education e, @PathVariable int uid) {
		return service.saveEducation(e, uid);
	}

	@GetMapping("/educations")
	public ResponseEntity<?> findAllEducations() {
		return service.findAllEducations();
	}

	@GetMapping("/educations/{uid}")
	public ResponseEntity<?> findAllEducationsByUserId(@PathVariable int uid) {
		return service.findAllEducationsByUserId(uid);
	}

	@GetMapping("/educations/{id}")
	public ResponseEntity<?> findAllEducationsById(@PathVariable int id) {
		return service.findAllEducationsById(id);
	}
	
	@DeleteMapping("/educations/{id}")
	public ResponseEntity<?> deleteEducationsById(@PathVariable int id) {
		return service.deleteEducationsById(id);
	}
}
