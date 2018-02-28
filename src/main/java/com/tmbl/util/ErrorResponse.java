package com.tmbl.util;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	private String errorCode;
	private String message;

	private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}*/

}
