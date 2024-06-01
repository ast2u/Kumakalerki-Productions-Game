package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class startleap extends AppCompatActivity implements View.OnClickListener {
    Button bt1,bt2,bt3,bt4;
    MediaPlayer bgm;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.start_leap);
        bt2=findViewById(R.id.infobt);
        bt1 =  findViewById(R.id.startbt);
        bt3=findViewById(R.id.exitb2);
        bt4=findViewById(R.id.abotb);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt1.setBackgroundColor(Color.RED);
        bt2.setBackgroundColor(Color.RED);
        bt3.setBackgroundColor(Color.RED);
        bt4.setBackgroundColor(Color.RED);
        bt1.setId(1);
        bt2.setId(2);
        bt3.setId(3);
        bt4.setId(4);

        bgm=MediaPlayer.create(startleap.this,R.raw.taleofcruel);
            bgm.start();

    }

    @Override
    public void onClick(View view) {
        Intent inte1,inte2,inte3;
        inte1= new Intent(this, startleap2.class);
        int tabId = view.getId();
        if(tabId==1){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(inte1);
            finish();
        }
        if(tabId==3){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
           Intent t2=new Intent(this,StartingActivity.class);
           startActivity(t2);
           finish();
        }
        if(tabId==2){

            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            inte2=new Intent(this, infotab.class);
            startActivity(inte2);
            finish();
        }
        if(tabId==4){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            inte3=new Intent(this, aboutus.class);
            startActivity(inte3);
            finish();
        }
    }
}