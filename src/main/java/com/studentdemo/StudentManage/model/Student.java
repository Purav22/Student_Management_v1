package com.studentdemo.StudentManage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String name;
    private String email;
    
    
	    
   
    public Student(String name, String email, Department department, Course course) {
		super();
		this.name = name;
		this.email = email;
		this.department = department;
		this.course = course;
	}


	public Student() {
		super();
	}


	@ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
    
    
}
