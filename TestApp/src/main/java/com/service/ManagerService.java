package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pojo.Manager;
import com.pojo.User;
import com.test.DB;

@Component("managerService")
public class ManagerService
{

	@Autowired
	private DB db;

	@Autowired
	private Util util;

	public Manager getManagerDetails(String loginId)
	{
		Manager manager = null;

		manager = db.getManagerDetails(loginId);
		if (null != manager)
		{
			for (User user : manager.getUsers())
			{
				util.calculateAndSetEffectiveTaskCompletionPercentage(user);
			}
		}

		return manager;

	}

}
