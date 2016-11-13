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
 * 나는나는나는??
 */

public class DogInfoSettingActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    ImageButton menu_button;

    LinearLayout navi_map;
    LinearLayout navi_shop;
    LinearLayout navi_search;
    LinearLayout navi_request;

    TextView kkc;
    TextView dogname;
    TextView type;
    TextView dogbirth;
    TextView dogage;
    TextView featrue;
    TextView gender;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doginfosettiong);

        String r3 = getIntent().getExtras().getString("r3");
        String r4 = getIntent().getExtras().getString("r4");
        String r5 = getIntent().getExtras().getString("r5");
        String r6 = getIntent().getExtras().getString("r6");
        String r7 = getIntent().getExtras().getString("r7");
        String r8 = getIntent().getExtras().getString("r8");
        String r10 = getIntent().getExtras().getString("r10");


        kkc = (TextView) findViewById(R.id.kkc);
        dogname = (TextView) findViewById(R.id.dogname);
        type = (TextView) findViewById(R.id.type);
        dogbirth = (TextView) findViewById(R.id.dogbirth);
        dogage = (TextView) findViewById(R.id.dogage);
        featrue = (TextView) findViewById(R.id.featrue);
        gender = (TextView) findViewById(R.id.gender);

        kkc.setInputType(0);
        dogname.setInputType(0);
        type.setInputType(0);
        dogbirth.setInputType(0);
        dogage.setInputType(0);
        featrue.setInputType(0);
        gender.setInputType(0);

        kkc.setText(r3);
        dogname.setText(r4);
        type.setText(r8);
        dogbirth.setText(r7);
        dogage.setText(r5);
        featrue.setText(r10);
        gender.setText(r6);


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
