package com.tmbl.constant;

public enum StudentRegistrationConstant {

	validateStuName("402", "Name is missing"),
	validateCourseName("403", "course name is missing");

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
