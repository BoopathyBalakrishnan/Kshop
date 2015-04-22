package com.infy.mitime.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class EmployeeActivity extends Activity {
	Button sendReport;
	JSONArray user = null;
	TextView empname, name1, email1, task3,p1,p2;
	String taskName, empName, taskName1,percentage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.employeeview);
		initWidgets();
		jsonParser();
	}

	private void jsonParser() {

		JSONObject jsonObject = new JSONObject();

		JSONParser jParser = new JSONParser();

		String json = SplashActivity.datas;
		Gson gson = new Gson();
		User user = new User();
		Manager manager = new Manager();
		Object obj = gson.fromJson(json, User.class);

		user = (User) obj;

		String empName = user.getUserName();
		for (Task task : user.getTasks()) {
			taskName = task.getTaskname();
			percentage=task.getPercentageCompleted();

			empName = user.getUserName();

		}
		try { // Getting JSON Array

			/*
			 * c.getString(Utils.TAG_TASK1); String task2 =
			 * c.getString(Utils.TAG_TASK2); String task3 =
			 * c.getString(Utils.TAG_TASK3);
			 */

			empname.setText(empName);
			email1.setText(taskName);
			name1.setText(taskName);
			p1.setText(percentage);
			p2.setText(percentage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * private void jsonParser() { JSONParser jParser = new JSONParser(); String
	 * json = jParser.getJSONFromUrl(Utils.EMPLOYEE_TASK_URL); try { user =
	 * json.getJSONArray(Utils.TAG_EMPNAME); JSONObject c =
	 * user.getJSONObject(0); String task1 = c.getString(Utils.TAG_TASK1);
	 * String task2 = c.getString(Utils.TAG_TASK2); String task3 =
	 * c.getString(Utils.TAG_TASK3); final TextView empname = (TextView)
	 * findViewById(R.id.empname); final TextView name1 = (TextView)
	 * findViewById(R.id.task1); final TextView email1 = (TextView)
	 * findViewById(R.id.task2); uid.setText(id); name1.setText(name);
	 * email1.setText(email); } catch (JSONException e) { e.printStackTrace(); }
	 * }
	 */

	private void initWidgets() {
		empname = (TextView) findViewById(R.id.empname);
		name1 = (TextView) findViewById(R.id.task1);
		p1=(TextView) findViewById(R.id.progress1);
		p2=(TextView) findViewById(R.id.progress2);
		email1 = (TextView) findViewById(R.id.task2);
		sendReport = (Button) findViewById(R.id.sendreport);
		sendReport.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sendsms("859391077", "U GOT NOTICITICATION");
			}
		});
	}

	protected void sendsms(String address, String msgContent) {
		try {
			SmsManager sms = SmsManager.getDefault();
			ArrayList<String> smsString = sms.divideMessage(msgContent);
			sms.sendMultipartTextMessage(address, null, smsString, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
