package com.stu.util;

public enum ServiceConstant {

	
	validateName("Name cannot be empty");
	
	private String desc;

	
	private ServiceConstant(String name) {
		this.desc = name;
	}

	public String getdesc() {
		return desc;
	}
	
	
}
