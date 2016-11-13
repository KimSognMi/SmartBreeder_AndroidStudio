package com.fitsttest.smartbreeder_fitst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ksmi0_000 on 2016-11-06.
 */

public class DogRetrieveActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    ImageButton menu_button;

    LinearLayout navi_map;
    LinearLayout navi_shop;
    LinearLayout navi_search;
    LinearLayout navi_request;


    TextView dogname;
    TextView message;
    TextView type;
    TextView dogage;
    TextView featrue;
    TextView gender;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dogretrieve);

        String rq1=getIntent().getExtras().getString("rq1");
        String rq2=getIntent().getExtras().getString("rq2");
        String rq3=getIntent().getExtras().getString("rq3");
        String rq5=getIntent().getExtras().getString("rq5");
        String rq6=getIntent().getExtras().getString("rq6");
        String rq7=getIntent().getExtras().getString("rq7");
        String rq9=getIntent().getExtras().getString("rq9");



        dogname = ( TextView)findViewById(R.id.dogname);
        type = ( TextView)findViewById(R.id.type);
        message = ( TextView)findViewById(R.id.message);

        dogage = ( TextView)findViewById(R.id.dogage);
        featrue = ( TextView)findViewById(R.id.featrue);
        gender = ( TextView)findViewById(R.id.gender);


        dogname.setInputType(0);
        type.setInputType(0);
        message.setInputType(0);

        dogage.setInputType(0);
        featrue.setInputType(0);
        gender.setInputType(0);


        dogname.setText(rq3);
        type.setText(rq5);
        message.setText(rq1);
        dogage.setText(rq9);
        featrue.setText(rq7);
        gender.setText(rq2);

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
                Intent intent = new Intent(getApplicationContext(), DogRetrieveActivity.class);
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
