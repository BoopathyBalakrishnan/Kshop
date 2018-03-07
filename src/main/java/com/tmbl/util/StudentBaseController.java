package com.tmbl.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tmbl.exception.StudentDetailsException;

@ControllerAdvice
public class StudentBaseController {

	@ExceptionHandler
	public ResponseEntity<Object> exceptionHandler(Exception ex) throws StudentDetailsException {
		List<ErrorResponse> error = null;

		if (ex instanceof StudentDetailsException) {
			error = ((StudentDetailsException) ex).getErr();

		}

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
