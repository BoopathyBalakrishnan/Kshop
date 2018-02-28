package com.tmbl.exception;

import com.tmbl.util.ErrorResponse;

public class StudentDetailsException extends RuntimeException {

	public StudentDetailsException(ErrorResponse error) {
		this.error=error;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorResponse error;

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}

}
