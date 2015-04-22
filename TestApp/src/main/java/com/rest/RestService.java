package com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pojo.Login;
import com.pojo.Manager;
import com.pojo.UpdateTaskCompletion;
import com.pojo.User;
import com.service.ManagerService;
import com.service.UserService;
import com.service.Util;
import com.test.DB;

@Component
@Path("/rest")
public class RestService
{

	@Autowired
	private UserService userService;

	@Autowired
	private ManagerService managerService;

	@Autowired
	private Util util;

	@Autowired
	private DB db;

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(Login login)
	{
		Manager manager = null;
		User user = null;
		String loginId = login.getUserId();
		String password = login.getPassword();

		if (loginId != null && password != null)
		{

			manager = managerService.getManagerDetails(loginId);

			if (manager != null)
			{
				if (util.checkUserPasswordCombinationForManager(login, manager))
				{
					return Response.ok(manager, MediaType.APPLICATION_JSON)
							.status(200).build();
				}
				else
				{
					return Response.status(500).build();
				}
			}

			user = userService.getUserDetails(loginId);

			if (user != null)
			{
				if (util.checkUserPasswordCombinationForUser(login, user))
				{
					return Response.ok(user, MediaType.APPLICATION_JSON)
							.status(201).build();
				}
				else
				{
					return Response.status(500).build();
				}
			}
			else
			{
				return Response.status(500).build();
			}

		}
		else
		{
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/manager")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getManagerDetails(@PathParam("managerId") String managerId)
	{
		Manager manager = null;

		if (managerId != null)
		{
			manager = managerService.getManagerDetails(managerId);

		}

		if (manager == null)
		{
			return Response.status(500).build();
		}
		else
		{
			return Response.ok(manager, MediaType.APPLICATION_JSON).build();
		}
	}

	@GET
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserDetails(@PathParam("userId") String userId)
	{
		User user = null;

		if (userId != null)
		{
			user = userService.getUserDetails(userId);

		}

		if (user == null)
		{
			return Response.status(500).build();
		}
		else
		{
			return Response.ok(user, MediaType.APPLICATION_JSON).build();
		}
	}

	@PUT
	@Path("/updateTask")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTaskStatus(UpdateTaskCompletion taskCompletion)
	{
		if (taskCompletion != null && taskCompletion.getUserId() != null
				&& taskCompletion.getTask() != null
				&& taskCompletion.getPercentageCompleted() != null)
		{
			if (db.updateTaskStatus(taskCompletion))
			{
				return Response.ok().build();
			}
			else
			{
				return Response.status(500).build();
			}
		}
		else
		{
			return Response.status(500).build();
		}
	}
}
