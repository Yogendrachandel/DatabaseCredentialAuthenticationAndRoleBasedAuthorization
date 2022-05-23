package com.learn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.learn.model.Student;

@Service
public class StudentRepositoryImpl   {

	@Autowired
	private StudentRepository studentRepository;
	
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	
	public void createNewStudent(Student student){
		 studentRepository.save(student);
	}
	
	
	public void deleteStudent(Integer studentId){
		 studentRepository.deleteById(studentId);
	}
	
	
	public void updateStudent(Student student,Integer studentId){
		 Optional<Student> optional= studentRepository.findById(studentId);
		 if(optional.isPresent()) {
			 System.out.println("Student present with id:"+studentId);
			 Student studentExist=optional.get();
			 studentExist.setName(student.getName());
			 studentExist.setScity(student.getScity());
			 studentRepository.save(studentExist);
		 }else {
			 System.out.println("Student not present with id:"+studentId);
		 }
		
	}
}
