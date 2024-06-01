package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity   implements View.OnClickListener{
    Button start,opt,charac,endb;
MediaPlayer bgm;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.button);
        opt=findViewById(R.id.button4);
        charac=findViewById(R.id.button5);
        endb=findViewById(R.id.exitbut);
        start.setOnClickListener(this);
        opt.setOnClickListener(this);
        charac.setOnClickListener(this);
        endb.setOnClickListener(this);
        start.setId(1);
        opt.setId(2);
        charac.setId(3);
        endb.setId(4);
        start.setBackgroundColor(Color.MAGENTA);
        opt.setBackgroundColor(Color.MAGENTA);
        charac.setBackgroundColor(Color.MAGENTA);
        endb.setBackgroundColor(Color.MAGENTA);
        bgm=MediaPlayer.create(MainActivity.this,R.raw.menu);
        bgm.start();

    }


    @Override
    public void onClick(View view) {
        int vid= view.getId();
        if(vid==1){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);


        }
        if(vid==2){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            Intent intent = new Intent(this,Instructions.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadeinfast, R.anim.fadeoutfast);
            finish();

        }

        if(vid==3){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            Intent intent = new Intent(this, com.example.kumakalerkiproductions1.About.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadeinfast, R.anim.fadeoutfast);
            finish();
        }
        if(vid==4){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            Intent t1=  new Intent(this,StartingActivity.class);
            startActivity(t1);
            finish();

        }

    }
}
