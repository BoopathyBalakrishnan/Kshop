package com.infy.mytime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SplashActivity extends Activity {
	public static String datas;
	
	Button login;
	LoginData loginData;
	String getUserName;
	String getPassWord;
	ProgressDialog prgDialog;
	EditText userName,passWord;
	JSONObject jsonObject;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		initWidgets();
		/*
		 * prgDialog = new ProgressDialog(this);
		 * prgDialog.setMessage("Please wait...");
		 * prgDialog.setCancelable(false);
		 */
	}

	private void initWidgets() {
		userName = (EditText) findViewById(R.id.login_frm_txt_splash_login);
		passWord = (EditText) findViewById(R.id.invoiceNO);
		login = (Button) findViewById(R.id.login_frm_btn_inital_registration);
		login.setOnClickListener(new OnClickListener() {
			// http://10.67.207.227:8080/TestApp/test/check"
			@Override
			public void onClick(View arg0) {
				// int httpResponse=result.getStatusLine().getStatusCode();
				getUserName = userName.getText().toString();
				getPassWord = passWord.getText().toString();
				Log.i("username and password", getUserName + "" + getPassWord);

				new HttpAsyncTask()
						.execute("http://10.67.207.227:8080/TestApp/rest/login");

			}
		});

	}

	public String POST(String url, LoginData loginData) {
		InputStream inputStream = null;
		String result = "";
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);

			String json = "";
			 jsonObject = new JSONObject();
			jsonObject.accumulate("userId", loginData.getUserName());
			jsonObject.accumulate("password", loginData.getPassword());
			json = jsonObject.toString();
			StringEntity se = new StringEntity(json);
			httpPost.setEntity(se);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			HttpResponse httpResponse = httpclient.execute(httpPost);
			inputStream = httpResponse.getEntity().getContent();
			
			int responseCode = httpResponse.getStatusLine().getStatusCode();

			if (inputStream != null) {
				result = convertInputStreamToString(inputStream);
				 datas=result;

			}

			if (responseCode == 200) {
				// invoke manager page
				navigateToManagerActivity();
			}
			if (responseCode == 201) {
				// invoke employee page

				navigateToEmployeeActivity();
			} else {
				result = "Did not work!";

			}
		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
		}

		return result;
	}

	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {

			loginData = new LoginData();
			loginData.setUserName(getUserName);
			loginData.setPassword(getPassWord);

			return POST(urls[0], loginData);
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getBaseContext(), "Data Sent!", Toast.LENGTH_LONG)
					.show();
		}

	}

	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;

	}

	private void navigateToManagerActivity() {
		Intent managerIntent = new Intent(getApplicationContext(),
				ManagerActivity.class);
		managerIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(managerIntent);
	}

	private void navigateToEmployeeActivity() {
		Intent employeeIntent = new Intent(getApplicationContext(),
				EmployeeActivity.class);
		employeeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(employeeIntent);

	}

}
