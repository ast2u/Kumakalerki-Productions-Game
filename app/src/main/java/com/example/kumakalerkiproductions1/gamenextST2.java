package com.example.kumakalerkiproductions1;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class gamenextST2 extends AppCompatActivity  {
LinearLayout lin;
int view = R.layout.activity_gamenext_st2;
TextView input1,input2,input3,input4,healt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setContentView(view);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        gameview g1 = new gameview(this,null);
        input1 =(TextView) findViewById(R.id.tView1);
        input2 =(TextView) findViewById(R.id.tView2);
        input3 =(TextView) findViewById(R.id.tView3);
        input4 =(TextView) findViewById(R.id.tView4);
        healt = (TextView) findViewById(R.id.healthbar);
        lin =  (LinearLayout) findViewById(R.id.parent);
        healt.setText("100");

        lin.addView(g1);
    }
    class gameview extends View implements View.OnTouchListener,Runnable {
        Paint p1;
        Bitmap player,enemy1;
        Bitmap diabox;
        Rect player_rect,player_d,diabox_d;
        Rect enemy1_d,enemy1_rect;
        Bitmap blet1,alet1,rlet1,klet1,resbt1;
        Rect bletd,aletd,rletd,kletd,resbtd;
        int[] players1={0,64*11,64,64*12};
        int[] playerd1={0, 346, 384, 730};
        int[] playerenemys1={0,0,64,64};
        int[] playerened1={1300,210,1850,760};
        playerRight pr1;
        enemyplayer epr1;

        public gameview(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            p1=new Paint();
            p1.setColor(Color.WHITE);
            p1.setTextSize(50);
            InputStream is =getResources().openRawResource(R.raw.rpgplayer);
            InputStream is2 = getResources().openRawResource(R.raw.bullet);
            player= BitmapFactory.decodeStream(is);
            enemy1=BitmapFactory.decodeStream(is2);
            diabox=BitmapFactory.decodeResource(getResources(),R.drawable.diaboxrpg);
            blet1=BitmapFactory.decodeResource(getResources(),R.drawable.bletter);
            alet1=BitmapFactory.decodeResource(getResources(),R.drawable.aletter);
            rlet1=BitmapFactory.decodeResource(getResources(),R.drawable.rletter);
            klet1=BitmapFactory.decodeResource(getResources(),R.drawable.kletter);
            resbt1=BitmapFactory.decodeResource(getResources(),R.drawable.resetrpg);
            bletd= new Rect (400,770,550,910);
            aletd= new Rect (760,770,910,910);
            rletd= new Rect (580,770,730,910);
            kletd= new Rect (940,770,1090,910);
            resbtd= new Rect(1130,770,1280,910);
            player_d= new Rect(playerd1[0],playerd1[1],playerd1[2],playerd1[3]);
            diabox_d = new Rect(200,700,1600,1020);
            enemy1_rect = new Rect(playerenemys1[0],playerenemys1[1],playerenemys1[2],playerenemys1[3]);
            enemy1_d = new Rect(playerened1[0],playerened1[1],playerened1[2],playerened1[3]);
            pr1 = new playerRight();
            epr1=new enemyplayer();
            epr1.setPlayer_enemys1(playerenemys1);
            pr1.setPlayers1(players1);
            player_rect = new Rect(0,64*11,64,64*12);

            Thread t1 =new Thread(pr1);
            t1.start();
            Thread t2=new Thread(epr1);
            t2.start();
            Thread t= new Thread(this);
            t.start();
            setOnTouchListener(this);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            player_rect.set(players1[0],players1[1],players1[2],players1[3]);
            enemy1_rect.set(playerenemys1[0],playerenemys1[1],playerenemys1[2],playerenemys1[3]);
            enemy1_d.set(playerened1[0],playerened1[1],playerened1[2],playerened1[3]);

            canvas.drawBitmap(diabox,null,diabox_d,p1);
            canvas.drawBitmap(blet1,null,bletd,p1);
            canvas.drawBitmap(alet1,null,aletd,p1);
            canvas.drawBitmap(rlet1,null,rletd,p1);
            canvas.drawBitmap(klet1,null,kletd,p1);
            canvas.drawBitmap(resbt1,null,resbtd,p1);

            canvas.drawBitmap(enemy1,enemy1_rect,enemy1_d,p1);
            canvas.drawBitmap(player,player_rect,player_d,p1);
            invalidate();
        }

        @Override
        public void run() {
            while(true) {

                playerened1[0] = 1300;
                playerened1[2] = 1850;
                SystemClock.sleep(100);
            }
        }
        int tx,ty;
        int enter=0;
        String word1="";
        int numbh=0;
        String numb1="BARK";

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            tx=(int)event.getX();
            ty=(int)event.getY();
            boolean bletbutton=bletd.contains(tx,ty);
            boolean aletbutton=aletd.contains(tx,ty);
            boolean rletbutton=rletd.contains(tx,ty);
            boolean kletbutton=kletd.contains(tx,ty);
            boolean resetbut =resbtd.contains(tx,ty);


            if(bletbutton){
                if(input1.getText().toString()=="") {
                    input1.setText("B");

                }else if(input2.getText().toString()==""&&input1.getText().toString()!="") {
                    input2.setText("B");
                }else if(input3.getText().toString()==""&&input2.getText().toString()!="") {
                    input3.setText("B");
                }else if(input4.getText().toString()==""&&input3.getText().toString()!="") {
                    input4.setText("B");
                }
            }
            if(aletbutton){
                if(input1.getText().toString()=="") {
                    input1.setText("A");
                }else if(input2.getText().toString()==""&&input1.getText().toString()!="") {
                    input2.setText("A");
                }else if(input3.getText().toString()==""&&input2.getText().toString()!="") {
                    input3.setText("A");
                }else if(input4.getText().toString()==""&&input3.getText().toString()!="") {
                    input4.setText("A");
                }
            }
            if(rletbutton){
                if(input1.getText().toString()=="") {
                    input1.setText("R");
                }else if(input2.getText().toString()==""&&input1.getText().toString()!="") {
                    input2.setText("R");
                }else if(input3.getText().toString()==""&&input2.getText().toString()!="") {
                    input3.setText("R");
                }else if(input4.getText().toString()==""&&input3.getText().toString()!="") {
                    input4.setText("R");
                }
            }
            if(kletbutton){
                if(input1.getText().toString()=="") {
                    input1.setText("K");
                }else if(input2.getText().toString()==""&&input1.getText().toString()!="") {
                    input2.setText("K");
                }else if(input3.getText().toString()==""&&input2.getText().toString()!="") {
                    input3.setText("K");
                }else if(input4.getText().toString()==""&&input3.getText().toString()!="") {
                    input4.setText("K");
                }
            }
            if(resetbut){
                word1= (input1.getText().toString()+input2.getText().toString()+
                        input3.getText().toString()+input4.getText().toString());
                Log.i("help","cc "+word1);
                if(word1!="BARK"){
                    healt.setText("50");

                }
                input1.setText("");
                input2.setText("");
                input3.setText("");
                input4.setText("");

            }
            return false;
        }
        void scorin(){

        }
    }


}