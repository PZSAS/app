package com.example.sas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.database.SQLException;

public class DBConnector {
	private DBHandler dbh;
	private Context context;
	//Setting set = new Setting();
	
	DBConnector(Context context){
		this.context = context;
		this.dbh = new DBHandler(context);
	}
	
	public void open(){
		dbh.open();
	}
	
	public void close(){
		dbh.close();
	}
	
	private String getData(String function,String[] params){
		int m = 0;
		StringBuilder builder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		
		/*String q = "SELECT server FROM general WHERE id = 1;";
		Cursor c = sdb.rawQuery(q, null);
		String s = "";
		if(c.moveToFirst())
			s = c.getString(c.getColumnIndex("server"));
		c.close();*/
		
		String s = "http://192.168.43.152/";//"http://192.168.2.2/";
		String connect = s+"PZ/common/php/database.php";

		HttpPost httpPost = new HttpPost(connect);
		
		try {
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2+params.length);
	        nameValuePairs.add(new BasicNameValuePair("function", function));
	        for(int i=0;i<params.length;i++){
	        	nameValuePairs.add(new BasicNameValuePair("p"+(i+1), params[i]));
	        }
	        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				m=-5;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = builder.toString();
		return result;
	}
	
	public boolean getLogin(String name){
		boolean result = true;
		
		String params[] = {name};
		String res = getData("sendLogin",params);
		
		try {
			JSONArray jsonArray = new JSONArray(res);
			
			if(jsonArray.getJSONObject(0).optBoolean("result"))
				return false;
			else{
			
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jo = jsonArray.getJSONObject(i);
					
			            int pid = jo.getInt("user_id");
			            String pname = jo.getString("login_name");
			            String ppass = jo.getString("login_password");   
		                
			            dbh.setLogin(pid, pname, ppass);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
}
