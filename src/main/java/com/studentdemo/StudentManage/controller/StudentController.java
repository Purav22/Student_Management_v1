package com.studentdemo.StudentManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentdemo.StudentManage.model.Student;
import com.studentdemo.StudentManage.repo.CourseRepository;
import com.studentdemo.StudentManage.repo.DepartmentRepository;
import com.studentdemo.StudentManage.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DepartmentRepository departmentService;
	
	@Autowired
	private CourseRepository courseService;
	
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		
		model.addAttribute("students", studentService.getAllStudent());
		model.addAttribute("departments", departmentService.findAll());
		model.addAttribute("courses", courseService.findAll());
		
		return "students";
	}
	
	
	@GetMapping("/students/add")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("departments", departmentService.findAll());
		model.addAttribute("courses", courseService.findAll());
        return "addstudent";
		
	}
	
	@PostMapping("/students/add")
	public String addStudent(@ModelAttribute Student student) {
		studentService.saveStudent(student);
        return "redirect:/students";
		
	}
	
	@GetMapping("/students/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.deleteByStudentID(id);
        return "redirect:/students";
    }
	
	@GetMapping("/students/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
		
		Student student = studentService.getStudent(id);
		
		model.addAttribute("student", student);
		model.addAttribute("departments", departmentService.findAll());
		model.addAttribute("courses", courseService.findAll());
		
        
        return "editStudent";
    }
	
	
	@PostMapping("/students/edit")
    public String edit(@ModelAttribute Student student) {
		Student student2 = studentService.getStudent(student.getId());
		student2.setName(student.getName());
		student2.setCourse(student.getCourse());
		student2.setDepartment(student.getDepartment());
		studentService.saveStudent(student2);
		 return "redirect:/students";
		
    }
	
	@GetMapping("/students/search")
	public String search(@RequestParam("query") String keyword, Model model) {
	    model.addAttribute("students", studentService.searchByName(keyword));
	    model.addAttribute("departments", departmentService.findAll());
		model.addAttribute("courses", courseService.findAll());
		
        
        return "students";
	}
	
	@GetMapping("/students/filter")
	public String filterStudents(@RequestParam(value = "departmentId", required = false) Long departmentId,
	                             @RequestParam(value = "courseId", required = false) Long courseId,
	                             Model model) {
		
		List<Student> filteredStudents = null;
		
		if(courseId == null && departmentId == null){	
			return getAllStudents(model);
		}else if(courseId == null) {
			filteredStudents = studentService.filterByDepartment(departmentId);
			
		}else if(departmentId == null) {
			 filteredStudents = studentService.filterByCourse(courseId);
			
		}else {
		   filteredStudents = studentService.getStudentsByDepartmentAndCourse(departmentId, courseId);
		   
		}
		
		model.addAttribute("students", filteredStudents);
	    return "students";
	}


	

}
