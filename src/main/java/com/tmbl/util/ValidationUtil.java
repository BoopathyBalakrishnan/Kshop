package com.tmbl.util;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.tmbl.constant.StudentRegistrationConstant;
import com.tmbl.exception.StudentDetailsException;

@Component
public class ValidationUtil {

	public void validateRequest(BindingResult bindingResult, List<ErrorResponse> err) {

		for (ObjectError errors : bindingResult.getAllErrors()) {

			ErrorResponse error = new ErrorResponse();
			error.setErrorCode(StudentRegistrationConstant.valueOf(errors.getDefaultMessage()).getCode());
			error.setMessage(StudentRegistrationConstant.valueOf(errors.getDefaultMessage()).getMessage());
			err.add(error);
			
//			throw new StudentDetailsException(error);
		}
	}

}
