package com.tmbl.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tmbl.exception.StudentDetailsException;

@ControllerAdvice
public class StudentBaseController {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) throws  StudentDetailsException{
		ErrorResponse error = null ;
				
		if(ex instanceof StudentDetailsException) {
			error=((StudentDetailsException) ex).getError();
		}
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
