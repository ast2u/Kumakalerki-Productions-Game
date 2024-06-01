package com.example.kumakalerkiproductions1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.io.InputStream;

public class gameST extends View implements View.OnTouchListener,Runnable {
    Paint p1,p2;
    Bitmap player,bg1,enemy1;
    Bitmap diabox;
    Rect player_rect,player_d,bg_d,diabox_d;
    Rect enemy1_d,enemy1_rect;
    int[] players1={0,64*11,64,64*12};
    int[] playerd1={0, 346, 384, 730};
    int[] playerenemys1={0,0,64,64};
    int[] playerened1={1850,210,2400,760};
    playerRight pr1;
    enemyplayer epr1;
    public gameST(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        p1=new Paint();
        p1.setColor(Color.WHITE);
        p1.setTextSize(50);
        InputStream is =getResources().openRawResource(R.raw.rpgplayer);
        InputStream is2 = getResources().openRawResource(R.raw.bullet);
        player= BitmapFactory.decodeStream(is);
        enemy1=BitmapFactory.decodeStream(is2);
        bg1 = BitmapFactory.decodeResource(getResources(),R.drawable.rpgbg2);
        diabox=BitmapFactory.decodeResource(getResources(),R.drawable.diaboxrpg);
        bg_d = new Rect (0, 0, 1800, 1050);
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
        canvas.drawBitmap(bg1,null,bg_d,p1);
        canvas.drawBitmap(diabox,null,diabox_d,p1);
        canvas.drawBitmap(enemy1,enemy1_rect,enemy1_d,p1);
        canvas.drawBitmap(player,player_rect,player_d,p1);
        if(enemyshow==1){
            canvas.drawText("AN ENEMY APPEARED",330,820,p1);
        }

        invalidate();
    }
int ctr=20;
   int enemyshow=0;
    int enemyshow1=0;
    @Override
    public void run() {
        while(true) {
            playerened1[0] -= ctr;
            playerened1[2] -= ctr;
            if (playerened1[0] < 1301) {
                playerened1[0] = 1300;
                playerened1[2] = 1850;
                enemyshow=1;

            }
            SystemClock.sleep(100);
        }

    }
    int tx,ty;
    boolean bt1;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        tx=(int)event.getX();
        ty=(int)event.getY();
        if(enemyshow==1) {
            bt1 = diabox_d.contains(tx, ty);
        }
        if(bt1){
            Intent inte1= new Intent(getContext(), gamenextST2.class);
            getContext().startActivity(inte1);
        }
        return false;
    }
}
