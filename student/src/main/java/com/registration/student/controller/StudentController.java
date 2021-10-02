package com.registration.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registration.student.Exception.StudentNotFoundException;
import com.registration.student.entity.StudentEntity;

import com.registration.student.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<StudentEntity> getStudents() {
		return studentRepository.findAll();
	}
	
	@PostMapping("/registration")
	public StudentEntity registration(@RequestBody StudentEntity studentEntity) {
		return studentRepository.save(studentEntity);
	}
	
	@GetMapping("/student/{id}")
	public  Optional<StudentEntity> getByRoll(@PathVariable(value = "id") Long roll) {
		return studentRepository.findById(roll);
	}
	
	@DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long roll) throws StudentNotFoundException {
        StudentEntity student = studentRepository.findById(roll)
                .orElseThrow(() -> new StudentNotFoundException(roll));
        
        studentRepository.delete(student);

        return ResponseEntity.ok().build();
	}
}
