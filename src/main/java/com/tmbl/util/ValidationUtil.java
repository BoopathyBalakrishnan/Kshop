package com.tmbl.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.tmbl.constant.StudentRegistrationConstant;
import com.tmbl.exception.StudentDetailsException;

@Component
public class ValidationUtil {

	public void validateRequest(BindingResult bindingResult) {

		for(ObjectError errors:bindingResult.getAllErrors()) {
			
//			String msg=errors.getDefaultMessage();
			
			ErrorResponse error = new ErrorResponse();
			error.setErrorCode(StudentRegistrationConstant.valueOf(errors.getDefaultMessage()).getCode());
			error.setMessage(StudentRegistrationConstant.valueOf(errors.getDefaultMessage()).getMessage());
			
			throw new StudentDetailsException(error);
		}
	}

}
