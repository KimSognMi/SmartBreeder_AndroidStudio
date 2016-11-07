package com.fitsttest.smartbreeder_fitst;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.TreeMap;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button = (ImageButton) findViewById(R.id.menu_button);
        navi_map = (LinearLayout) findViewById(R.id.navi_map);
        navi_shop = (LinearLayout) findViewById(R.id.navi_shop);
        navi_search = (LinearLayout) findViewById(R.id.navi_search);
        navi_request = (LinearLayout) findViewById(R.id.navi_request);

        dogPhoto = (CircleImageView) findViewById(R.id.dogPhoto);
        userPhoto = (CircleImageView) findViewById(R.id.userPhoto);


        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "navigationDrawer 연결", Toast.LENGTH_SHORT).show();
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
