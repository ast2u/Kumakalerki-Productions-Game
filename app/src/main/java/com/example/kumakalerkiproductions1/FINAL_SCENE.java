package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class FINAL_SCENE extends AppCompatActivity implements View.OnClickListener {
TextView first,sec,third,fourth;
Button next,next2,next3,next4;
    MediaPlayer bgm;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_scene);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        first=findViewById(R.id.tv);
        sec=findViewById(R.id.tv2);
        third=findViewById(R.id.tv3);
       fourth= findViewById(R.id.tv4);
       first.setText("* A month has passed*");
        sec.setText("");
        third.setText("");
        fourth.setText("");



        bgm=MediaPlayer.create(FINAL_SCENE.this,R.raw.finalscenenee);
        bgm.start();


        next=findViewById(R.id.but);
        next2=findViewById(R.id.but2);
        next3=findViewById(R.id.but3);
        next4=findViewById(R.id.but4);
        next.setOnClickListener(this);
        next2.setOnClickListener(this);
        next3.setOnClickListener(this);
        next4.setOnClickListener(this);



        next2.setEnabled(false);
        next3.setEnabled(false);
        next4.setEnabled(false);

        next.setBackgroundColor(Color.MAGENTA);
        next2.setBackgroundColor(Color.MAGENTA);
        next3.setBackgroundColor(Color.MAGENTA);
        next4.setBackgroundColor(Color.MAGENTA);



        next.setId(1);
        next2.setId(2);
        next3.setId(3);
        next4.setId(4);



    }

    @Override
    public void onClick(View view) {
        int vid = view.getId();

     if(vid==1){
         first.setText("");
         sec.setText("*You have been dating ever since*");
         next.setEnabled(false);
         next2.setEnabled(true);
     }

     if(vid==2){
         ImageView image=(ImageView) findViewById(R.id.imageView7);
         image.setImageResource(R.drawable.leo_fna);
         sec.setText("");
         third.setText("Oi bat ka nakatulala diyan");

         next2.setEnabled(false);
         next3.setEnabled(true);


     }

     if(vid==3){
         third.setText("");
         fourth.setText("Tara punta na tayo sa taas");
         next3.setEnabled(false);
         next4.setEnabled(true);
     }


     if(vid==4){
         if(bgm!=null){
             bgm.release();
             bgm=null;
         }
         Intent intent = new Intent(this, com.example.kumakalerkiproductions1.final_anim.class);

         startActivity(intent);
         overridePendingTransition(R.anim.fadeinfast, R.anim.fadeoutfast);
         finish();
     }
    }
}