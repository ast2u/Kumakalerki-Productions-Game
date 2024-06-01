package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class gameoverleap extends AppCompatActivity implements View.OnClickListener {
MediaPlayer bgm2;
ImageView surrbt,retribt;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        bgm2 = MediaPlayer.create(gameoverleap.this, R.raw.silence);
        setContentView(R.layout.gameoverleap);
        surrbt =findViewById(R.id.surrenderbt);
        TextView scorelbl = (TextView) findViewById(R.id.score1);
        TextView hscorelbl = (TextView) findViewById(R.id.hscore1);
        retribt=findViewById(R.id.retrybt);
        retribt.setOnClickListener(this);
        surrbt.setOnClickListener(this);

        int score = getIntent().getIntExtra("SCORE",0);
        scorelbl.setText("Score: "+score);

        SharedPreferences sharedPref= getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int hscore = sharedPref.getInt("HIGH_SCORE",0);
        if(score>hscore){
            hscorelbl.setText("High Score: "+score);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("HIGH_SCORE",score);
            editor.commit();
        }else{
            hscorelbl.setText("High Score: "+hscore);
        }

        surrbt.setId(2);
        retribt.setId(1);
        bgm2.start();
    }

    @Override
    public void onClick(View view) {
        Intent inte1,inte2,inte3;
        inte1= new Intent(this, startleap2.class);
        inte2= new Intent(this,startleap.class);
        int tabId = view.getId();
        if(tabId==1){
            if(bgm2!=null){
                bgm2.release();
                bgm2=null;
            }
            startActivity(inte1);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            finish();
        }
        if(tabId==2){
            if(bgm2!=null){
                bgm2.release();
                bgm2=null;
            }
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(inte2);
            finish();
        }
    }
}