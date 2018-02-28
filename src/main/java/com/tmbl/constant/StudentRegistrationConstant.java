package com.tmbl.constant;

public enum StudentRegistrationConstant {

	validateStuName("401", "Name is missing");

	private String code;
	private String message;

	private StudentRegistrationConstant(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
