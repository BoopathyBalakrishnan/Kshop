package com.pojo;

public class UpdateTaskCompletion {

	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getPercentageCompleted() {
		return percentageCompleted;
	}
	public void setPercentageCompleted(String percentageCompleted) {
		this.percentageCompleted = percentageCompleted;
	}
	private String task;
	private String percentageCompleted;
}
