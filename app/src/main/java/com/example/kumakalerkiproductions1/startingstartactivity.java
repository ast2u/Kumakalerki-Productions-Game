package com.example.kumakalerkiproductions1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class startingstartactivity extends AppCompatActivity implements View.OnClickListener {
ImageView t1,t2;
Button bt1;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        setTitle("group5_Kumakalerki_FINALassignment4F");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_startingstartactivity);
        bt1 = findViewById(R.id.extbt);
        t1=findViewById(R.id.gamesp1);
        t2=findViewById(R.id.aboutbutony1);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt1.setBackgroundColor(Color.MAGENTA);
        bt1.setId(1);
        t1.setId(2);
        t2.setId(3);


    }

    @Override
    public void onClick(View view) {
        int tabid = view.getId();
        if(tabid==1){
            System.exit(0);
        }
        if(tabid==2){
            Intent tt1=new Intent(this,StartingActivity.class);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(tt1);
            finish();
        }
        if(tabid==3){
            Intent tt2=new Intent(this,moreaboutus.class);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(tt2);
            finish();
        }
    }
}