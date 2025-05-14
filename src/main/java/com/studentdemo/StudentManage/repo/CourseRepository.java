package com.studentdemo.StudentManage.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentdemo.StudentManage.model.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
