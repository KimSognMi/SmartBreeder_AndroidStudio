package com.fitsttest.smartbreeder_fitst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ksmi0_000 on 2016-11-02.
 * 나도나도나도 바뀌니
 */

public class LoginActivity extends AppCompatActivity {
    EditText userid;
    EditText passwd;
    ImageButton signbutton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userid = (EditText) findViewById(R.id.userid);
        passwd = (EditText) findViewById(R.id.passwd);
        signbutton = (ImageButton) findViewById(R.id.signbutton);

    }

    public void send(View v) {
        String muserid = userid.getText().toString();
        String mpasswd = passwd.getText().toString();
        Log.i("TAG", muserid);
        Log.i("TAG", mpasswd);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://210.125.213.71:8090/BreederAndroid/login.jsp?userid=" + muserid + "&passwd=" + mpasswd;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                try {
                    JSONObject obj = new JSONObject(response);
                    String getusername = obj.get("username").toString();
                    String muserid = obj.get("userid").toString();
                    String mpasswd = obj.get("passwd").toString();

                    Toast.makeText(getApplicationContext(), getusername + "님 안녕하세요.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "등록된 회원이 아닙니다.", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "이거 아니야", Toast.LENGTH_SHORT).show();
                Log.i("TAG", error.toString());
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }//end send
}//end class
