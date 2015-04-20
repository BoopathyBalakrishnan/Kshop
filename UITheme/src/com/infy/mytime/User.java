package com.infy.mytime;


import java.util.ArrayList;
import java.util.List;

public class User
{

	private String userId;
	private String managerId;
	private String userName;
	private String password;
	private List<Task> tasks;
	private String tastStartTime;
	private String taskEndTime;
	private List<String> swipeIns;
	private List<String> swipeOuts;
	private String effectiveTime;
	private String effectivePercentage;
	private String progressBarColor;



	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getTastStartTime()
	{
		return tastStartTime;
	}

	public void setTastStartTime(String tastStartTime)
	{
		this.tastStartTime = tastStartTime;
	}

	public String getTaskEndTime()
	{
		return taskEndTime;
	}

	public void setTaskEndTime(String taskEndTime)
	{
		this.taskEndTime = taskEndTime;
	}

	public List<String> getSwipeIns()
	{
		return swipeIns;
	}

	public void setSwipeIns(List<String> swipeIns)
	{
		this.swipeIns = swipeIns;
	}

	public List<String> getSwipeOuts()
	{
		return swipeOuts;
	}

	public void setSwipeOuts(List<String> swipeOuts)
	{
		this.swipeOuts = swipeOuts;
	}

	public String getEffectiveTime()
	{
		return effectiveTime;
	}

	public void setEffectiveTime(String effectiveTime)
	{
		this.effectiveTime = effectiveTime;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getManagerId()
	{
		return managerId;
	}

	public void setManagerId(String managerId)
	{
		this.managerId = managerId;
	}

	public List<Task> getTasks()
	{
		if (null == tasks)
		{
			this.tasks = new ArrayList<Task>();
		}
		return tasks;
	}

	public void setTasks(List<Task> tasks)
	{

		this.tasks = tasks;
	}

	public String getEffectivePercentage()
	{
		return effectivePercentage;
	}

	public void setEffectivePercentage(String effectivePercentage)
	{
		this.effectivePercentage = effectivePercentage;
	}

}
