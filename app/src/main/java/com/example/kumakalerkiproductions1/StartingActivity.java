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

public class StartingActivity extends AppCompatActivity implements View.OnClickListener {
ImageView bt1,bt2,bt3;
Button bt4;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.starting_main);
        setTitle("Games");
        bt1=findViewById(R.id.lovegame1);
        bt2=findViewById(R.id.leapf1);
        bt3=findViewById(R.id.typeh1);
        bt4=findViewById(R.id.backbtt);
        bt4.setBackgroundColor(Color.MAGENTA);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt1.setId(1);
        bt2.setId(2);
        bt3.setId(3);
        bt4.setId(4);
    }

    @Override
    public void onClick(View view) {
        int tabId=view.getId();
        Intent t1,t2,t3,t4;
        t1= new Intent (this,MainActivity.class);
        t2= new Intent(this,startleap.class);
        if(tabId==1){
            startActivity(t1);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        }
        if(tabId==2){
            startActivity(t2);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            finish();

        }if(tabId==3){
            t3=new Intent(this,typerpgstart.class);
            startActivity(t3);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            finish();
        }
        if(tabId==4){
            t4= new Intent(this,startingstartactivity.class);
            startActivity(t4);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            finish();
        }
    }
}