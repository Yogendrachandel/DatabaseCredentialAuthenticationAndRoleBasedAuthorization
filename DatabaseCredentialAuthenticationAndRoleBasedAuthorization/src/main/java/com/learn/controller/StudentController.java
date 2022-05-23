package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.Student;
import com.learn.repository.StudentRepositoryImpl;


@RestController
@RequestMapping("api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentRepositoryImpl studentRepositoryImpl;

	  
	   
	    
	    @GetMapping
	    @PreAuthorize("hasAnyAuthority('USER','CREATOR','ADMIN','EDITOR')")
	    public List<Student> getAllStudents() {
	        System.out.println("getAllStudents");
	        return studentRepositoryImpl.getAllStudents();
	        
	    }
	    
		
		@DeleteMapping(path = "{studentId}")
		@PreAuthorize("hasAuthority('ADMIN')")
		public void deleteStudent(@PathVariable("studentId") Integer studentId) {
			System.out.println("deleteStudent");
			studentRepositoryImpl.deleteStudent(studentId);
		}

		@PostMapping
		@PreAuthorize("hasAnyAuthority('CREATOR','ADMIN')")
		public void registerNewStudent(@RequestBody Student student) {
			System.out.println("registerNewStudent");
			studentRepositoryImpl.createNewStudent(student);
		}

		@PutMapping(path = "{studentId}")
		@PreAuthorize("hasAnyAuthority('ADMIN','EDITOR')")
		public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
			System.out.println("updateStudent");
			studentRepositoryImpl.updateStudent(student, studentId);
		}

}
