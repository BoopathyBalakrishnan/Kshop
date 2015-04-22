package com.service;

import org.springframework.stereotype.Component;

import com.pojo.Login;
import com.pojo.Manager;
import com.pojo.Task;
import com.pojo.User;

@Component("util")
public class Util 
{

	public boolean checkUserPasswordCombinationForManager(Login login, Manager manager)
	{
		if(login.getUserId().equalsIgnoreCase(manager.getManagerId()) && login.getPassword().equalsIgnoreCase(manager.getPassword()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean checkUserPasswordCombinationForUser(Login login, User user)
	{
		if(login.getUserId().equalsIgnoreCase(user.getUserId()) && login.getPassword().equalsIgnoreCase(user.getPassword()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void calculateAndSetEffectiveTaskCompletionPercentage(User user)
	{
		int effectivePercentage=0;
		String totalEffectivePercentage;
		
		for(Task task:user.getTasks())
		{
			effectivePercentage=effectivePercentage+ Integer.parseInt(task.getPercentageCompleted());
					
		}
		
		totalEffectivePercentage=String.valueOf(effectivePercentage);
		
		user.setEffectivePercentage(totalEffectivePercentage);
		
	}
}
