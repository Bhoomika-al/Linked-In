package com.googleLinkedin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googleLinkedin.entity.Education;
import com.googleLinkedin.repository.EducationRepository;

@Repository
public class EducationDao {
	@Autowired
	EducationRepository repository;

	public Education saveEducation(Education e) {
		return repository.save(e);
	}

	public List<Education> findAllEducations() {
		return repository.findAll();
	}

	public void deleteEducationsById(int id) {
		repository.deleteById(id);

	}

	public Optional<Education> findAllEducationsById(int id) {

		return repository.findById(id);
	}

	public List<Education> findAllEducationsByUserId(int uid) {

		return repository.findAllEducationsByUserId(uid);
	}

}
