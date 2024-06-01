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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class second_scene extends AppCompatActivity implements View.OnClickListener {
    Button next,next2,next3,next4,next5,next6,next7,next8,nextend,sry,galet,di,tuldok;
    ImageButton bck;
    TextView first,sec,third,fourth,fifth,sixth,seven;
    MediaPlayer bgm;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_scene);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        bgm=MediaPlayer.create(second_scene.this,R.raw.una);
        bgm.start();



        first = findViewById(R.id.textView3);
        sec = findViewById(R.id.textView4);
        third=findViewById(R.id.textView5);
        fourth=findViewById(R.id.textView6);
        fifth=findViewById(R.id.textView7);
        sixth=findViewById(R.id.textView8);
        seven=findViewById(R.id.textView9);


        next = findViewById(R.id.button2);
        next2 =findViewById(R.id.button9);
        next3=findViewById(R.id.button14);
        next4=findViewById(R.id.button15);
        next5=findViewById(R.id.button16);
        next6=findViewById(R.id.button17);
        next7=findViewById(R.id.button18);
        next8=findViewById(R.id.button19);
        nextend=findViewById(R.id.button13);
        bck = findViewById(R.id.imageButton);


        sry=findViewById(R.id.btn6);
        galet=findViewById(R.id.choice2);
        di=findViewById(R.id.choice3);
        tuldok=findViewById(R.id.choice4);

        next.setBackgroundColor(Color.MAGENTA);
        next2.setBackgroundColor(Color.MAGENTA);
        next3.setBackgroundColor(Color.MAGENTA);
        next4.setBackgroundColor(Color.MAGENTA);
        next5.setBackgroundColor(Color.MAGENTA);
        next6.setBackgroundColor(Color.MAGENTA);
        next7.setBackgroundColor(Color.MAGENTA);
        next8.setBackgroundColor(Color.MAGENTA);
        nextend.setBackgroundColor(Color.MAGENTA);


        sry.setBackgroundColor(Color.MAGENTA);
        galet.setBackgroundColor(Color.MAGENTA);
        di.setBackgroundColor(Color.MAGENTA);
        tuldok.setBackgroundColor(Color.MAGENTA);


        next.setOnClickListener(this);
        next2.setOnClickListener(this);
        next3.setOnClickListener(this);
        next4.setOnClickListener(this);
        next5.setOnClickListener(this);
        next6.setOnClickListener(this);
        next7.setOnClickListener(this);
        next8.setOnClickListener(this);
        nextend.setOnClickListener(this);


        sry.setOnClickListener(this);
        galet.setOnClickListener(this);
        di.setOnClickListener(this);
        tuldok.setOnClickListener(this);

        first.setText("'TOL NAMAN'!!'");
        next3.setEnabled(false);
        next4.setEnabled(false);
        next6.setEnabled(false);
        next7.setEnabled(false);
        next8.setEnabled(false);
        next5.setEnabled(false);
        next2.setEnabled(false);
        nextend.setEnabled(false);
        sry.setEnabled(false);
        galet.setEnabled(false);
        di.setEnabled(false);
        tuldok.setEnabled(false);
        bck.setOnClickListener(this);
        next3.setId(8);
        tuldok.setId(7);
        di.setId(6);
        galet.setId(5);
        sry.setId(4);
        next.setId(2);
        next2.setId(3);
        next4.setId(9);
        next5.setId(10);
        next6.setId(11);
        next7.setId(12);
        next8.setId(14);
        nextend.setId(13);
        bck.setId(1);
    }

    @Override
    public void onClick(View view) {
        int vid = view.getId();
        if (vid == 2) {
        first.setText("'UMAYOS KA NMN!!'");
        next.setEnabled(false);
        next2.setEnabled(true);
        }
        if(vid==3){
            next2.setEnabled(false);
            sry.setEnabled(true);
            galet.setEnabled(true);
            di.setEnabled(true);
            tuldok.setEnabled(true);
        }
        if(vid==4){
            first.setText("'Ayus-ayusin mo ugali mo ah'");
            sry.setEnabled(false);
            galet.setEnabled(false);
            di.setEnabled(false);
            tuldok.setEnabled(false);
            next3.setEnabled(true);

        }
        if(vid==5){
            first.setText("");
            sixth.setText("*Sinuntok ka ng makatulog ka ng mahimbing");
            next2.setEnabled(false);
            sry.setEnabled(false);
            galet.setEnabled(false);
            di.setEnabled(false);
            tuldok.setEnabled(false);
            nextend.setEnabled(true);

        }
        if(vid==6){
            first.setText("'Ayus-ayusin mo ugali mo ah'");
            sry.setEnabled(false);
            galet.setEnabled(false);
            di.setEnabled(false);
            tuldok.setEnabled(false);
            next3.setEnabled(true);
        }
        if(vid==7){
            first.setText("");
            seven.setText("AHHH GANON DI KA IIMIK AH!!!");
            next8.setEnabled(true);
            sry.setEnabled(false);
            galet.setEnabled(false);
            di.setEnabled(false);
            tuldok.setEnabled(false);
        }
        if(vid==8){
            first.setText("");
            sec.setText("BAKA MA LATE PA AKO DAHIL SAYO BOI!!");
            next3.setEnabled(false);
            next4.setEnabled(true);
        }
        if(vid==9){

            ImageView image=(ImageView) findViewById(R.id.imageView);
            image.setImageResource(R.drawable.introoo);
            sec.setText("");
            third.setText("*You just met Leonardo the Great the heartthrob of your school");
            next4.setEnabled(false);
            next5.setEnabled(true);
        }
        if(vid==10){
            third.setText("");
            fourth.setText("He ran hurriedly because he is also late");
            next5.setEnabled(false);
            next6.setEnabled(true);
        }
        if(vid==11){
            fourth.setText("");
            fifth.setText("You also ran fast");
            next6.setEnabled(false);
            next7.setEnabled(true);
        }
        if(vid==12){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
                Intent intent = new Intent(this,classroom_scene.class);

                startActivity(intent);
                overridePendingTransition(R.anim.fadeinfast, R.anim.fadeoutfast);
                finish();

        }
        if(vid==13){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            Intent intent = new Intent(this,gameover.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        }
        if(vid==14){
            sixth.setText("*Sinuntok ka ng makatulog ka ng mahimbing");
            seven.setText("");
            next2.setEnabled(false);
            sry.setEnabled(false);
            galet.setEnabled(false);
            di.setEnabled(false);
            tuldok.setEnabled(false);
            nextend.setEnabled(true);
        }

        if (vid == 1) {
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            Intent intent = new Intent(this,MainActivity.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadeinfast, R.anim.fadeoutfast);
            finish();
        }
    }
}