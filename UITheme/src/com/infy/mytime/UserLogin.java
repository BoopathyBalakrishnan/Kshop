package com.infy.mytime;



public class UserLogin {

	private String userId;
	private String password;
	private String role;
	private String associatedManagerId;

	public String getAssociatedManagerId() {
		return associatedManagerId;
	}

	public void setAssociatedManagerId(String associatedManagerId) {
		this.associatedManagerId = associatedManagerId;
	}

	public UserLogin(String userId, String password, String role,
			String associatedManagerId) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.associatedManagerId = associatedManagerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
