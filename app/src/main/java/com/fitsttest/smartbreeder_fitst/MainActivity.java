package com.fitsttest.smartbreeder_fitst;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dto.MemberDTO;
import com.dto.PetDTO;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ImageButton menu_button;


    LinearLayout navi_map;
    LinearLayout navi_shop;
    LinearLayout navi_search;
    LinearLayout navi_request;

    CircleImageView dogPhoto;
    CircleImageView userPhoto;

    TextView dogname;
    TextView username;
    TextView userid;
    TextView dogtype;
    String result;

    String result2;

    String result4;
    String result5;
    String result8;
    String result9;

    String r3;
    String r4;
    String r5;
    String r6;
    String r7;
    String r8;
    String r10;
 /*   LoginActivity login=new LoginActivity();
    String result2=login.result;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = getIntent();
        String xxx=getIntent().getExtras().getString("xxx");
        Log.i("TAG", "xxx >>" + xxx);

        String A=xxx;
        StringTokenizer st0=new StringTokenizer(A,"&");
        String result01=st0.nextToken();
        String result02=st0.nextToken();
        Log.i("TAG" , ">>"+ result01);
        Log.i("TAG" , ">>"+ result02);

        StringTokenizer st1=new StringTokenizer(result01,"/");

        String result1=st1.nextToken();
        result2=st1.nextToken();
        String result3=st1.nextToken();
        result4=st1.nextToken();
        result5=st1.nextToken();
        String result6=st1.nextToken();
        String result7=st1.nextToken();
        result8=st1.nextToken();
        result9=st1.nextToken();

        StringTokenizer st2=new StringTokenizer(result02,"/");

        String r1=st2.nextToken();
        String r2=st2.nextToken();
        r3=st2.nextToken();
        r4=st2.nextToken();
        r5=st2.nextToken();
        r6=st2.nextToken();
        r7=st2.nextToken();
        r8=st2.nextToken();
        String r9=st2.nextToken();
        r10=st2.nextToken();
        String r11=st2.nextToken();
        String r12=st2.nextToken();


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button = (ImageButton) findViewById(R.id.menu_button);
        navi_map = (LinearLayout) findViewById(R.id.navi_map);
        navi_shop = (LinearLayout) findViewById(R.id.navi_shop);
        navi_search = (LinearLayout) findViewById(R.id.navi_search);
        navi_request = (LinearLayout) findViewById(R.id.navi_request);

        dogPhoto = (CircleImageView) findViewById(R.id.dogPhoto);
        userPhoto = (CircleImageView) findViewById(R.id.userPhoto);

        dogname = ( TextView)findViewById(R.id.dogname);
        username = ( TextView)findViewById(R.id.username);
        userid = ( TextView)findViewById(R.id.userid);
        dogtype = ( TextView)findViewById(R.id.dogtype);

        username.setText(result4);
        userid.setText(result2);
        dogname.setText(r4);
        dogtype.setText(r8);


        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        dogPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "dog 정보 편집 연결", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DogInfoSettingActivity.class);

                intent.putExtra("r3",r3);
                intent.putExtra("r4",r4);
                intent.putExtra("r5",r5);
                intent.putExtra("r6",r6);
                intent.putExtra("r7",r7);
                intent.putExtra("r8",r8);
                intent.putExtra("r10",r10);

                startActivity(intent);
            }
        });
        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "user 정보 편집 연결", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), UserInfoSettingActivity.class);

                intent.putExtra("result2",result2);
                intent.putExtra("result4",result4);
                intent.putExtra("result5",result5);
                intent.putExtra("result8",result8);
                intent.putExtra("result9",result9);

                startActivity(intent);
            }
        });

        navi_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "족보창 연결", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), TreeMappingActivity.class);
                mDrawerLayout.closeDrawers();
                startActivity(intent);
            }
        });
        navi_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "근처 편의시설 검색 연결", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ConvenienceActivity.class);
                mDrawerLayout.closeDrawers();
                startActivity(intent);
            }
        });
        navi_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "근처 애견 검색 연결", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SearchDogActivity.class);
                mDrawerLayout.closeDrawers();
                startActivity(intent);

            }
        });
        navi_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "신청 현황 확인 페이지 연결", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), RequestActivity.class);

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        String id=userid.getText().toString();
                        try {
                            URL url = new URL("http://210.125.213.92/BreederAndroid/request.jsp?userid="+id);
                            HttpURLConnection conn =
                                    (HttpURLConnection)  url.openConnection();
                            //conn.setRequestProperty("Accept-Encoding", "UTF-8");
                            conn.setDoOutput(true);
                            conn.setChunkedStreamingMode(0);
                            OutputStream out =
                                    new BufferedOutputStream(conn.getOutputStream());
                            PrintWriter xx = new PrintWriter(out );
                            String mesg = "userid="+userid.getText().toString();
                            xx.print(mesg);
                            xx.close();
                            Log.i("TAG", "conn >>" + conn);

                            // InputStream in = new BufferedInputStream(conn.getInputStream());
                            InputStream in = conn.getInputStream();
                            Log.i("TAG" , "in >>"+ in);
                            String xxx = streamToString(in);
                            Log.i("TAG" , ">>"+ xxx);

                            if(!("fail".equals(xxx.trim()))){

                                Intent intent = new Intent(getApplicationContext(), RequestActivity.class);
                                intent.putExtra("xxx",xxx);
                               /* mDrawerLayout.closeDrawers();*/
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
                startActivity(intent);
            }
        });



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


}
