package com.stu.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stu.model.Student;
import com.stu.repository.StudentRepository;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	StudentRepository studentRepo;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> addStudentDetails(@Valid @RequestBody Student student, BindingResult bindingResult) {
		studentRepo.save(student);
		return new ResponseEntity<String>("student created", HttpStatus.CREATED);
	}

	@GetMapping(value = "{studentId}")
	public ResponseEntity<Student> getStudentDetails(@PathVariable(value = "studentId") int id) {
		Student list = studentRepo.findOne(id);
		return new ResponseEntity<Student>(list, HttpStatus.OK);
	}

	@DeleteMapping(value = "{studentId}")
	public ResponseEntity<Integer> deleteStudentDetail(@PathVariable(value = "studentId") int id) {
		studentRepo.delete(id);
		return new ResponseEntity<Integer>(id, HttpStatus.NO_CONTENT);
	}
}
