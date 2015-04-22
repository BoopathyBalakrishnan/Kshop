package com.pojo;

public class Task
{

	private String taskname;
	private String percentageCompleted;
	private String colour;
	private String tastStartTime;
	private String taskEndTime;

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

	public String getColour()
	{
		return colour;
	}

	public void setColour(String colour)
	{
		this.colour = colour;
	}

	public String getTaskname()
	{
		return taskname;
	}

	public void setTaskname(String taskname)
	{
		this.taskname = taskname;
	}

	public String getPercentageCompleted()
	{
		return percentageCompleted;
	}

	public void setPercentageCompleted(String percentageCompleted)
	{
		this.percentageCompleted = percentageCompleted;
	}
}
