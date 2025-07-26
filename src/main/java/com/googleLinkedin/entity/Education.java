package com.googleLinkedin.entity;

import java.util.Objects;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String qualification;
	private String university;
	private String college;
	private int yop;
	private double cgpa;
	
	@ManyToOne
	private User user;

	@Override
	public String toString() {
		return "Education [id=" + id + ", qualification=" + qualification + ", university=" + university + ", college="
				+ college + ", yop=" + yop + ", cgpa=" + cgpa + ", user=" + user + "]";
	}

	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Education(int id, String qualification, String university, String college, int yop, double cgpa, User user) {
		super();
		this.id = id;
		this.qualification = qualification;
		this.university = university;
		this.college = college;
		this.yop = yop;
		this.cgpa = cgpa;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cgpa, college, id, qualification, university, user, yop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Education other = (Education) obj;
		return Double.doubleToLongBits(cgpa) == Double.doubleToLongBits(other.cgpa)
				&& Objects.equals(college, other.college) && id == other.id
				&& Objects.equals(qualification, other.qualification) && Objects.equals(university, other.university)
				&& Objects.equals(user, other.user) && yop == other.yop;
	}
	
}
