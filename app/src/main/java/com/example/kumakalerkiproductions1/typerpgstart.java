package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class typerpgstart extends AppCompatActivity implements View.OnClickListener {
Button bt1,bt2,bt3,bt4;
MediaPlayer bgm;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.typerpgstart_main);
        bt1 = findViewById(R.id.startbt);
        bt2=findViewById(R.id.infobt);
        bt3=findViewById(R.id.exitbt);
        bt4=findViewById(R.id.aboutbt);
        bgm=MediaPlayer.create(this,R.raw.shantidope);
        bgm.start();
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
    public void onClick(View v) {
        Intent inte1 = new Intent(this, gamestarting.class);
        Intent inte2 = new Intent(this, infopg.class);
        Intent inte3 = new Intent(this, aboutrpg.class);
        Intent t4=new Intent(this,StartingActivity.class);

        int tabId =v.getId();
        if(tabId==1){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(inte1);
            finish();
        }
        if(tabId==2){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(inte2);
            finish();
        }
        if(tabId==3){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(t4);
            finish();
        }
        if(tabId==4){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(inte3);
            finish();
        }
    }
}