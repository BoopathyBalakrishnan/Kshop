package com.tmbl.exception;

import java.util.List;

import com.tmbl.util.ErrorResponse;

public class StudentDetailsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public StudentDetailsException(List<ErrorResponse> err) {
		this.err=err;
	}

	List<ErrorResponse> err;

	public List<ErrorResponse> getErr() {
		return err;
	}

	public void setErr(List<ErrorResponse> err) {
		this.err = err;
	}
	
	

	/*public StudentDetailsException(ErrorResponse error) {
		this.error=error;
	}


	private ErrorResponse error;

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}*/

}
