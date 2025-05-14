package com.studentdemo.StudentManage.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentdemo.StudentManage.model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
