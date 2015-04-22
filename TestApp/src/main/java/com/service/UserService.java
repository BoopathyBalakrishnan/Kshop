package com.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pojo.Task;
import com.pojo.User;
import com.test.DB;

@Component("userService")
public class UserService
{

	@Autowired
	private DB db;

	@Autowired
	private Util util;

	public User getUserDetails(String loginId)
	{

		User user = null;

		user = db.getUserDetails(loginId);
		for (Task task : user.getTasks())
		{
			task.setColour(checkProgress(task.getTastStartTime(),
					task.getTaskEndTime(), task.getPercentageCompleted()));

		}
		util.calculateAndSetEffectiveTaskCompletionPercentage(user);
		return user;

	}

	public String checkProgress(String startDate, String endDate,
			String completion)
	{

		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
		try
		{
			Date stDate = sdf.parse(startDate);
			Date edDate = sdf.parse(endDate);
			Date currenDate = new Date();
			long completionPercent = Integer.parseInt(completion);

			if (currenDate.after(edDate) && completionPercent != 100)
			{
				return "red";
			}
			if (currenDate.equals(stDate))
			{
				return "green";
			}
			else
			{
				long diff = edDate.getTime() - stDate.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
				long diffCurrentdate = currenDate.getTime() - stDate.getTime();
				long diffdaysCurrenDate = diffCurrentdate / (24 * 60 * 60 * 1000);
				if (diffDays != 0)
				{
					if ((long)(((double)diffdaysCurrenDate /(double) diffDays) * 100) > completionPercent)
					{
						return "red";
					}
				}
			}
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "green";

	}
}
