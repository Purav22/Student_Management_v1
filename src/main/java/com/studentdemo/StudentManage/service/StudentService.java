package com.studentdemo.StudentManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentdemo.StudentManage.model.Student;
import com.studentdemo.StudentManage.repo.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentDb;
	
	public List<Student> getAllStudent() {
		
		return studentDb.findAll();
	}
	
	public Student getStudent(Long id) {
		return studentDb.getReferenceById(id);
	}
	public void saveStudent(Student s) {
		studentDb.save(s);
	}
	
	

	
	
	public void deleteByStudentID(Long id) {
		studentDb.deleteById(id);
	}
	
	public List<Student> searchByName(String name) {
        return studentDb.findByNameContainingIgnoreCase(name);
    }
	
	public List<Student> filterByDepartment(Long deptId) {
	    return studentDb.findByDepartmentId(deptId);
	}
	
	
	public List<Student> filterByCourse(Long courseId) {
	    return studentDb.findByCourseId(courseId);
	}
	public List<Student> getStudentsByDepartmentAndCourse(Long departmentId, Long courseId) {
	    return studentDb.findByDepartmentIdAndCourseId(departmentId, courseId);
	}
}
