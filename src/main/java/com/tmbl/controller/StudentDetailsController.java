package com.tmbl.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

import com.tmbl.exception.StudentDetailsException;
import com.tmbl.repository.StudentDetailsRepository;
import com.tmbl.request.StudentDetailsRequest;
import com.tmbl.util.ErrorResponse;
import com.tmbl.util.ValidationUtil;

@RestController
public class StudentDetailsController {

	@Autowired
	StudentDetailsRepository studentRepo;

	@Autowired
	ValidationUtil validationUtil;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> addStudentDetails(@Valid @RequestBody StudentDetailsRequest student,
			BindingResult bindingResult) throws StudentDetailsException {
		List<ErrorResponse> err = new ArrayList<>();

		if (bindingResult.hasErrors()) {
			validationUtil.validateRequest(bindingResult, err);
		}

		if (!err.isEmpty()) {
			throw new StudentDetailsException(err);
		}

		studentRepo.save(student);
		return new ResponseEntity<>("student created", HttpStatus.CREATED);
	}

	@GetMapping(value = "{studentId}")
	public ResponseEntity<StudentDetailsRequest> getStudentDetails(@PathVariable(value = "studentId") int id)
			throws StudentDetailsException {
		StudentDetailsRequest list = studentRepo.findOne(id);
		return new ResponseEntity<StudentDetailsRequest>(list, HttpStatus.OK);
	}

	@DeleteMapping(value = "{studentId}")
	public ResponseEntity<Integer> deleteStudentDetail(@PathVariable(value = "studentId") int id)
			throws StudentDetailsException {
		studentRepo.delete(id);
		return new ResponseEntity<Integer>(id, HttpStatus.NO_CONTENT);
	}
}
