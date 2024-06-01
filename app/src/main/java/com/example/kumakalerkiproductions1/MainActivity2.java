package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    TextView first,sec,third;
    Button next,next2,next3,next4,next5;
    ImageButton bck;
    MediaPlayer bgm,bgm2;
    int mov;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        bgm=MediaPlayer.create(MainActivity2.this,R.raw.una);
        bgm2=MediaPlayer.create(MainActivity2.this,R.raw.tabi);
        bgm.start();

        first = findViewById(R.id.textView);
        sec = findViewById(R.id.textView2);
        next = findViewById(R.id.button3);
        bck= findViewById(R.id.imageButton2);
        next2 = findViewById(R.id.button6);
        next3 = findViewById(R.id.button7);
        next4 = findViewById(R.id.button8);
        next5=findViewById(R.id.button11);

        next.setBackgroundColor(Color.MAGENTA);
        next2.setBackgroundColor(Color.MAGENTA);
        next3.setBackgroundColor(Color.MAGENTA);
        next4.setBackgroundColor(Color.MAGENTA);
        next5.setBackgroundColor(Color.MAGENTA);

        next.setOnClickListener(this);
        bck.setOnClickListener(this);
        next2.setOnClickListener(this);
        next3.setOnClickListener(this);
        next4.setOnClickListener(this);
        next5.setOnClickListener(this);

        first.setText("'It's your first day at school'");
        sec.setText("");
        next.setId(1);
        bck.setId(2);
        next2.setId(3);
        next3.setId(4);
        next4.setId(5);
        next5.setId(6);

        next2.setEnabled(false);
        next3.setEnabled(false);
        next4.setEnabled(false);
        next5.setEnabled(false);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @Override
    public void onClick(View view) {
        int vid = view.getId();
        if (vid == 1) {
            first.setText("");
            sec.setText("'You are now excited to experience your youth'");
            next.setEnabled(false);
            next2.setEnabled(true);


        }
        if (vid == 3) {
            sec.setText("'You notice the time that you are almost late'");
            next2.setEnabled(false);
            next3.setEnabled(true);


        }
        if(vid==4){
            sec.setText("'You ran fast and bumped in to somone'");
            next3.setEnabled(false);
            next4.setEnabled(true);
        }
        if(vid==5){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            bgm2.start();
            sec.setText("");
        first.setText("TOL TABIII NAMANNN!!!!!!!");
        next4.setEnabled(false);
        next5.setEnabled(true);
        }
        if(vid==6){



            if(bgm!=null){
                bgm.release();
                bgm=null;
            }



            Intent intent = new Intent(this, com.example.kumakalerkiproductions1.animation.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        }


        if (vid ==2 ){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            Intent intent = new Intent(this, com.example.kumakalerkiproductions1.MainActivity.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadeinfast, R.anim.fadeoutfast);
            finish();
        }
        

    }
}