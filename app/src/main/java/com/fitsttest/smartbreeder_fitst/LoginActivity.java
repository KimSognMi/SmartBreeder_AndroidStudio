package com.fitsttest.smartbreeder_fitst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by ksmi0_000 on 2016-11-02.
 *
 * 자 여기에서 변경을 해볼껭
 *
 */

public class LoginActivity extends AppCompatActivity {
    EditText userid;
    EditText passwd;
    ImageButton signbutton;
    String result;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userid = (EditText) findViewById(R.id.userid);
        passwd = (EditText) findViewById(R.id.passwd);
        signbutton = (ImageButton) findViewById(R.id.signbutton);

    }

    public void send(View v) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                String id=userid.getText().toString();
                String pw = passwd.getText().toString();

                try {
                    URL url = new URL("http://210.125.213.92/BreederAndroid/login.jsp?userid="+id+"&passwd="+pw);
                    HttpURLConnection conn =
                            (HttpURLConnection)  url.openConnection();
                    //conn.setRequestProperty("Accept-Encoding", "UTF-8");
                    conn.setDoOutput(true);
                    conn.setChunkedStreamingMode(0);
                    OutputStream out =
                            new BufferedOutputStream(conn.getOutputStream());
                    PrintWriter xx = new PrintWriter(out );
                    String mesg = "userid="+userid.getText().toString()+"&passwd="+passwd.getText().toString();
                    xx.print(mesg);
                    xx.close();
                    Log.i("TAG", "conn >>" + conn);

                    // InputStream in = new BufferedInputStream(conn.getInputStream());
                    InputStream in = conn.getInputStream();
                    Log.i("TAG" , "in >>"+ in);
                    String xxx = streamToString(in);
                    Log.i("TAG" , ">>"+ xxx);

                    if(!("fail".equals(xxx.trim()))){

                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("xxx",xxx);
                        startActivity(intent);
                        finish();
                    }else{

                    }


                    in.close();
                    conn.disconnect();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        t.start();
    }


    public String streamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(is));
            String data = reader.readLine();
            while(data != null){
                buffer.append(data+"\n");
                data = reader.readLine();
            }
            reader.close();
        }catch(Exception e){ e.printStackTrace();}
        return buffer.toString();
    }//end streamToString




}//end class
