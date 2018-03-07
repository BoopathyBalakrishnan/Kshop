package com.tmbl.util;

import java.util.List;

public class Error {

	List<ErrorResponse> err;

	private String code;

	private String userMessage;

	public List<ErrorResponse> getErr() {
		return err;
	}

	public void setErr(List<ErrorResponse> err) {
		this.err = err;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

}
