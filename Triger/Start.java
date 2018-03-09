package com.example.wangshuai.myapplication;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wang shuai on 2018/1/2.
 */

public class Start extends Thread {
    public static final String ADD_URL = "http://192.168.43.130:16000/refereeServers";

    public Start(String athletes_name, String id, String event_type, int team_type, int athletes_sex) {
                try {
                    //创建连接
                    URL url = new URL(ADD_URL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setRequestMethod("POST");
                    connection.setUseCaches(false);
                    connection.setInstanceFollowRedirects(true);
                    connection.setRequestProperty("Content-Type",
                            "application/x-www-form-urlencoded");
                    connection.connect();
                    Log.e("Start", "true777");

                    //POST请求
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                JSONObject obj = new JSONObject();
                try {
                    obj.put("jsonId","eventStart");
                    obj.put("athletesName", athletes_name);
                    obj.put("athletesId", id);
                    obj.put("eventType", event_type);
                    obj.put("eventTeam", team_type);
                    obj.put("athleteSex",athletes_sex);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                    out.writeBytes(obj.toString());
                    //String s = "aaaa";
                    out.writeBytes(obj.toString());
                    out.flush();
                    out.close();

                    //读取响应
                    BufferedReader reader = new BufferedReader(new InputStreamReader(
                            connection.getInputStream()));
                    String lines;
                    StringBuffer sb = new StringBuffer("");
                    while ((lines = reader.readLine()) != null) {
                        lines = new String(lines.getBytes(), "utf-8");
                        sb.append(lines);
                    }
                    System.out.println(sb);
                    reader.close();
                    // 断开连接
                    connection.disconnect();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }



