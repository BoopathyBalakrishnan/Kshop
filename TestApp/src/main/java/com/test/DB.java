package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pojo.Manager;
import com.pojo.Task;
import com.pojo.UpdateTaskCompletion;
import com.pojo.User;
import com.pojo.UserLogin;
import com.service.ManagerService;
import com.service.UserService;
import com.service.Util;

@Path("/test")
@Component
public class DB
{

	@Autowired
	private UserService userService;

	@Autowired
	private ManagerService managerService;

	@Autowired
	private Util util;

	public static final Map<String, Manager> managerMap;
	public static final Map<String, UserLogin> userLoginMap;
	static
	{

		userLoginMap = new HashMap<String, UserLogin>();
		UserLogin login = new UserLogin("grito_tk", "ucup", "manager", null);
		setLoginDetails(login);
		login = new UserLogin("vipin_krishnan", "uc", "user", "grito_tk");
		setLoginDetails(login);
		login = new UserLogin("ajith_george", "uc", "user", "grito_tk");
		setLoginDetails(login);
		login = new UserLogin("boopathy_b", "uc", "user", "grito_tk");
		setLoginDetails(login);

		managerMap = new HashMap<String, Manager>();

		List<User> users = new ArrayList<User>();
		User user = new User("vipin_krishnan", "grito_tk", "Vipn Krishnan", "uc",
				null, "03012015", "03102015");
		users.add(user);
		Task task = setTasksForUser("Testing", "03012015", "03102015");
		user.getTasks().add(task);

		task = setTasksForUser("Testing", "03012015", "03102015");
		user.getTasks().add(task);

		user = new User("ajith_george", "grito_tk", "Ajith George", "uc", null,
				"03012015", "03032015");
		users.add(user);
		task = setTasksForUser("Testing", "03012015", "03102015");
		user.getTasks().add(task);

		task = setTasksForUser("Testing", "03012015", "03102015");
		user.getTasks().add(task);

		user = new User("vipin_krishnan", "grito_tk", "Vipn Krishnan", "uc",
				null, "03012015", "03102015");

		task = setTasksForUser("Testing", "03012015", "03102015");
		user.getTasks().add(task);

		task = setTasksForUser("Testing", "03012015", "03102015");
		user.getTasks().add(task);

		Manager manager = new Manager();
		manager.setManagerId("Grito_tk");
		manager.setManagerName("Grito");
		manager.setPassword("ucup");
		manager.setUsers(users);
		managerMap.put("grito_tk", manager);

	}

	private static Task setTasksForUser(String taskName, String startTime,
			String endTime)
	{
		Task task;
		task = new Task();
		task.setTaskname(taskName);
		task.setTastStartTime(startTime);
		task.setTaskEndTime(endTime);
		task.setPercentageCompleted("0");
		return task;
	}

	private static void setLoginDetails(UserLogin login)
	{
		userLoginMap.put(login.getUserId(), login);
	}

	@GET
	@Path("/check")
	public Response getHello()
	{
		Manager manager1 = managerMap.get("grito_tk");
		manager1.setManagerName("Grito Thekkumpuram");
		return Response.ok("Hello").build();
	}

	public Manager getManagerDetails(String loginId)
	{
		UserLogin userLogin = userLoginMap.get(loginId);

		if (userLogin.getRole().equalsIgnoreCase("manager"))
		{
			return managerMap.get(loginId);
		}
		else
		{
			return null;
		}
	}

	public User getUserDetails(String loginId)
	{
		UserLogin userLogin = userLoginMap.get(loginId);

		if (userLogin.getRole().equalsIgnoreCase("user"))
		{
			Manager manager = managerMap.get(userLogin.getAssociatedManagerId());

			for (User user : manager.getUsers())
			{
				if (user.getUserId().equalsIgnoreCase(loginId))
				{
					return user;
				}
			}

		}
		else
		{
			return null;

		}

		return null;
	}

	public boolean updateTaskStatus(UpdateTaskCompletion taskUpdate)
	{
		User user = getUserDetails(taskUpdate.getUserId());

		if (user != null && user.getTasks() != null)
		{
			for (Task task : user.getTasks())
			{
				if (task.getTaskname().equalsIgnoreCase(taskUpdate.getTask()))
				{
					task.setPercentageCompleted(taskUpdate.getPercentageCompleted());
					util.calculateAndSetEffectiveTaskCompletionPercentage(user);
					return true;
				}
			}
		}
		return false;

	}

}
