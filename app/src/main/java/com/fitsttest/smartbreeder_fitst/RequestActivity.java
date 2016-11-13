package com.fitsttest.smartbreeder_fitst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

/**
 * Created by ksmi0_000 on 2016-11-06.
 */

public class RequestActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    ImageButton menu_button;

    LinearLayout navi_map;
    LinearLayout navi_shop;
    LinearLayout navi_search;
    LinearLayout navi_request;

    ImageButton button2;
    ImageButton button3;
    Button button22;

    String rq1;
    String rq2;
    String rq3;
    String rq5;
    String rq6;
    String rq7;
    String rq9;

    String rq01;
    String rq02;
    String rq03;
    String rq05;
    String rq06;
    String rq07;
    String rq09;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request);

        String xxx=getIntent().getExtras().getString("xxx");
        Log.i("TAG", "xxx >>" + xxx);

        String A=xxx;
        StringTokenizer st0=new StringTokenizer(A,"&");
        String result01=st0.nextToken();
        String result02=st0.nextToken();
        Log.i("TAG" , ">>"+ result01);
        Log.i("TAG" , ">>"+ result02);


        StringTokenizer st1=new StringTokenizer(result01,"/");
        rq1=st1.nextToken();
        rq2=st1.nextToken();
        rq3=st1.nextToken();
        String rq4=st1.nextToken();
        rq5=st1.nextToken();
        rq6=st1.nextToken();
        rq7=st1.nextToken();
        String rq8=st1.nextToken();
        rq9=st1.nextToken();
        String rq10=st1.nextToken();
        String rq11=st1.nextToken();

        StringTokenizer st2=new StringTokenizer(result02,"/");
        rq01=st2.nextToken();
        rq02=st2.nextToken();
        rq03=st2.nextToken();
        String rq04=st2.nextToken();
        rq05=st2.nextToken();
        rq06=st2.nextToken();
        rq07=st2.nextToken();
        String rq08=st2.nextToken();
        rq09=st2.nextToken();
        String rq010=st2.nextToken();
        String rq011=st2.nextToken();



        button3 = (ImageButton) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "애견 정보", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DogRetrieveActivity.class);

                intent.putExtra("rq1", rq1);
                intent.putExtra("rq2", rq2);
                intent.putExtra("rq3", rq3);
                intent.putExtra("rq5", rq5);
                intent.putExtra("rq6", rq6);
                intent.putExtra("rq7", rq7);
                intent.putExtra("rq9", rq9);

                startActivity(intent);
            }
        });

        button2 = (ImageButton) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "받은 애견 정보", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getApplicationContext(), DogRetrieveActivity2.class);

                intent2.putExtra("rq01", rq01);
                intent2.putExtra("rq02", rq02);
                intent2.putExtra("rq03", rq03);
                intent2.putExtra("rq05", rq05);
                intent2.putExtra("rq06", rq06);
                intent2.putExtra("rq07", rq07);
                intent2.putExtra("rq09", rq09);

                startActivity(intent2);
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button = (ImageButton) findViewById(R.id.menu_button);
        navi_map = (LinearLayout) findViewById(R.id.navi_map);
        navi_shop = (LinearLayout) findViewById(R.id.navi_shop);
        navi_search = (LinearLayout) findViewById(R.id.navi_search);
        navi_request = (LinearLayout) findViewById(R.id.navi_request);


        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
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
