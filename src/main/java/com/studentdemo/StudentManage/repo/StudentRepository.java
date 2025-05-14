package com.studentdemo.StudentManage.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentdemo.StudentManage.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	
	List<Student> findByNameContainingIgnoreCase(String name);
    
	List<Student> findByDepartmentId(Long deptId);
    
	List<Student> findByCourseId(Long courseId);
    
	List<Student> findByNameStartingWithIgnoreCase(String letter);

	List<Student> findByDepartmentIdAndCourseId(Long departmentId, Long courseId);
    
}
