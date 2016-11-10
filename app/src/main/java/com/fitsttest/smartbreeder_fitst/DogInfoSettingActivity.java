package com.fitsttest.smartbreeder_fitst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dto.PetDTO;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ksmi0_000 on 2016-11-06.
 *나는나는나는??
 */

public class DogInfoSettingActivity extends AppCompatActivity{
    DrawerLayout mDrawerLayout;
    ImageButton menu_button;

    LinearLayout navi_map;
    LinearLayout navi_shop;
    LinearLayout navi_search;
    LinearLayout navi_request;

    TextView p_num;
    TextView p_kkcnumber;
    TextView p_name;
    TextView p_age;
    TextView p_gender;
    TextView p_birth;
    TextView p_type;
    TextView p_feature;
    TextView mom_kkc;
    TextView papa_kkc;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doginfosettiong);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button = (ImageButton) findViewById(R.id.menu_button);
        navi_map = (LinearLayout) findViewById(R.id.navi_map);
        navi_shop = (LinearLayout) findViewById(R.id.navi_shop);
        navi_search = (LinearLayout) findViewById(R.id.navi_search);
        navi_request = (LinearLayout) findViewById(R.id.navi_request);


        p_num = ( TextView)findViewById(R.id.p_num);
        p_kkcnumber = ( TextView)findViewById(R.id.p_kkcnumber);
        p_name = ( TextView)findViewById(R.id.p_name);
        p_age = ( TextView)findViewById(R.id.p_age);
        p_birth = ( TextView)findViewById(R.id.p_birth);
        p_type = ( TextView)findViewById(R.id.p_type);


        p_num.setInputType(0);
        p_kkcnumber.setInputType(0);
        p_name.setInputType(0);
        p_age.setInputType(0);
        p_birth.setInputType(0);
        p_type.setInputType(0);

        Intent intent = getIntent();
        PetDTO dto = (PetDTO)intent.getSerializableExtra("mydog");

        p_num.setText(String.valueOf(dto.getP_num()));
        p_kkcnumber.setText(dto.getP_kkcnumber());
        p_name.setText(dto.getP_name());
        p_age.setText(dto.getP_age());
        p_birth.setText(dto.getP_birth());
        p_type.setText(dto.getP_type());




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
