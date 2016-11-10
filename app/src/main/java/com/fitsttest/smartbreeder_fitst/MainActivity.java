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
        StringTokenizer st1=new StringTokenizer(A,"/");

           String result1=st1.nextToken();
        result2=st1.nextToken();
        String result3=st1.nextToken();
         result4=st1.nextToken();
         result5=st1.nextToken();
        String result6=st1.nextToken();
         String result7=st1.nextToken();
         result8=st1.nextToken();
         result9=st1.nextToken();
            Log.i("TAG" , ">>"+ result4);



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
                mDrawerLayout.closeDrawers();
                startActivity(intent);

            }
        });

    }
}
