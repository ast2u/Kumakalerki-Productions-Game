package com.example.kumakalerkiproductions1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.io.InputStream;

;

public class gamestart extends View implements View.OnTouchListener, Runnable {
    Paint p1, p2;
    MediaPlayer bgm;
    Rect player_rect, player_d, bg_d, coin_rect, coin_d, enemy_rect, enemy_d;
    Rect coin_d1, coin_d2, coin_d3, coin_d4, coin_d5, coin_d6, coin_d7;
    Rect enemy_d1, enemy_d2, enemy_d3, enemy_d4, enemy_d5, enemy_d6;
    Bitmap bg1, enemy1, coinz, player;
    int[] coinzdd = {1890, 0, 2000, 110};
    int[] coinzdd1 = {2490, 350, 2600, 460};
    int[] coinzdd2 = {3090, 850, 3200, 960};
    int[] coinzdd3 = {4290, 650, 4400, 760};
    int[] coinzdd4 = {4890, 150, 5000, 260};
    int[] coinzdd5 = {5490, 710, 5600, 820};
    int[] coinzdd6 = {6090, 490, 6200, 600};
    int[] coinzdd7 = {6690, 280, 6800, 390};
    int[] coinzs = {0, 30, 200, 200};
    int[] enemys1 = {0, 0, 125, 125};
    int[] enemyd = {2190, 800, 2330, 940};
    int[] enemyd1 = {2840, 360, 2980, 500};
    int[] enemyd2 = {3490, 725, 3630, 865};
    int[] enemyd3 = {4140, 1, 4280, 141};
    int[] enemyd4 = {4790, 437, 4930, 577};
    int[] enemyd5 = {5440, 586, 5580, 726};
    int[] enemyd6 = {6090, 300, 6230, 440};

    boolean gamestate = true;

    int[] player_gRight = {0, 64, 64, 64 * 2};
    int[] player_mainD = {0, 774, 256, 1030};
    Thread t, t1, t2, t3;
    character1 ggRight;
    coinscore conssc;
    enemyy eyenemy;
    int score = 0;
    int jump = 0;
    boolean jump1 = false;

    public gamestart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        p1 = new Paint();
        p2 = new Paint();
        p1.setColor(Color.WHITE);
        p2.setColor(Color.RED);
        p2.setTextSize(60);
        p1.setTextSize(120);

        p1.setTypeface(Typeface.create("Arial", Typeface.BOLD));
        p2.setTypeface(Typeface.create("Arial", Typeface.BOLD));
        InputStream is = getResources().openRawResource(R.raw.jumpcharacter);
        InputStream is2 = getResources().openRawResource(R.raw.coinsprite);
        InputStream is3 = getResources().openRawResource(R.raw.skullhead);
        player = BitmapFactory.decodeStream(is);
        coinz = BitmapFactory.decodeStream(is2);
        enemy1 = BitmapFactory.decodeStream(is3);
        bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.jumpbg);
        coin_rect = new Rect(0, 30, 200, 200);
        enemy_rect = new Rect(0, 0, 64, 64);
        enemy_d = new Rect(enemyd[0], enemyd[1], enemyd[2], enemyd[3]);
        enemy_d1 = new Rect(enemyd1[0], enemyd1[1], enemyd1[2], enemyd1[3]);
        enemy_d2 = new Rect(enemyd2[0], enemyd2[1], enemyd2[2], enemyd2[3]);
        enemy_d3 = new Rect(enemyd3[0], enemyd3[1], enemyd3[2], enemyd3[3]);
        enemy_d4 = new Rect(enemyd4[0], enemyd4[1], enemyd4[2], enemyd4[3]);
        enemy_d5 = new Rect(enemyd5[0], enemyd5[1], enemyd5[2], enemyd5[3]);
        enemy_d6 = new Rect(enemyd6[0], enemyd6[1], enemyd6[2], enemyd6[3]);
        player_rect = new Rect(0, 64, 64, 64 * 2);
        player_d = new Rect(player_mainD[0], player_mainD[1], player_mainD[2], player_mainD[3]);
        bgm = MediaPlayer.create(context.getApplicationContext(), R.raw.hivemind);
        coin_d = new Rect(coinzdd[0], coinzdd[1], coinzdd[2], coinzdd[3]);
        coin_d1 = new Rect(coinzdd1[0], coinzdd1[1], coinzdd1[2], coinzdd1[3]);
        coin_d2 = new Rect(coinzdd2[0], coinzdd2[1], coinzdd2[2], coinzdd2[3]);
        coin_d3 = new Rect(coinzdd3[0], coinzdd3[1], coinzdd3[2], coinzdd3[3]);
        coin_d4 = new Rect(coinzdd4[0], coinzdd4[1], coinzdd4[2], coinzdd4[3]);
        coin_d5 = new Rect(coinzdd5[0], coinzdd5[1], coinzdd5[2], coinzdd5[3]);
        coin_d6 = new Rect(coinzdd6[0], coinzdd6[1], coinzdd6[2], coinzdd6[3]);
        coin_d7 = new Rect(coinzdd7[0], coinzdd7[1], coinzdd7[2], coinzdd7[3]);
        bg_d = new Rect(0, 0, 1800, 1050);

        eyenemy = new enemyy();
        eyenemy.setEnemys1(enemys1);
        t3 = new Thread(eyenemy);


        ggRight = new character1();
        ggRight.setPlayer_gRight(player_gRight);
        conssc = new coinscore();
        conssc.setCoinzs(coinzs);
        conssc.setCoin_d(coinzdd);
        t2 = new Thread(conssc);

        bgm.start();


        t1 = new Thread(ggRight);
        t = new Thread(this);
        t.start();
        t1.start();
        t2.start();
        t3.start();
        setOnTouchListener(this);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(gamestate==true) {
            player_d.set(player_mainD[0], player_mainD[1], player_mainD[2], player_mainD[3]);
            player_rect.set(player_gRight[0], player_gRight[1], player_gRight[2], player_gRight[3]);
            enemy_rect.set(enemys1[0], enemys1[1], enemys1[2], enemys1[3]);
            coin_rect.set(coinzs[0], coinzs[1], coinzs[2], coinzs[3]);
            enemydraw();
            coindraw();
            canvas.drawBitmap(bg1, null, bg_d, p1);
            canvas.drawBitmap(coinz, coin_rect, coin_d7, p1);
            canvas.drawBitmap(coinz, coin_rect, coin_d6, p1);
            canvas.drawBitmap(coinz, coin_rect, coin_d5, p1);
            canvas.drawBitmap(coinz, coin_rect, coin_d4, p1);
            canvas.drawBitmap(coinz, coin_rect, coin_d3, p1);
            canvas.drawBitmap(coinz, coin_rect, coin_d2, p1);
            canvas.drawBitmap(coinz, coin_rect, coin_d1, p1);
            canvas.drawBitmap(coinz, coin_rect, coin_d, p1);
            canvas.drawBitmap(enemy1, enemy_rect, enemy_d6, p1);
            canvas.drawBitmap(enemy1, enemy_rect, enemy_d5, p1);
            canvas.drawBitmap(enemy1, enemy_rect, enemy_d4, p1);
            canvas.drawBitmap(enemy1, enemy_rect, enemy_d3, p1);
            canvas.drawBitmap(enemy1, enemy_rect, enemy_d2, p1);
            canvas.drawBitmap(enemy1, enemy_rect, enemy_d1, p1);
            canvas.drawBitmap(enemy1, enemy_rect, enemy_d, p1);
            canvas.drawBitmap(player, player_rect, player_d, p1);
            canvas.drawText("" + score, 870, 120, p1);
            invalidate();
        }
        if(gamestate==false) {
            gameover();
        }
        }

int ctr=10;
    int ctr1=50;
    int ctr2=100;
    @Override
    public void run() {

        while (true) {

            player_mainD[1] += 20;
            player_mainD[3] += 20;
            if (jump1==true&&player_mainD[1]>420) {
                player_mainD[1] -= 50;
                player_mainD[3] -= 50;
                jump=1;
                if(player_mainD[1]<420){
                    jump1=false;
                }
            }
                if (player_mainD[1] > 774) {
                    player_mainD[1] = 774;
                    player_mainD[3] = 1030;
                    jump=0;
                }
                SystemClock.sleep(50);
                enemymake();
                enemyrespawn();
                 coinsmake();
                 respawncoin();
                 scoring();
                 endGame();
            }


        }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if(player_mainD[1]==774){
            jump1=true;
        }
        if(jump==1) {
            player_mainD[1] -= 150;
            player_mainD[3] -= 150;
        }
        /*
        tx = (int) event.getX();
        ty = (int) event.getY();
        boolean bt1=retry1_d.contains(tx,ty);
        boolean bt2=surr_d.contains(tx,ty);
        if (bt1){
            gamestate=true;

            Intent inte1= new Intent(getContext(),MainActivity2.class);
            getContext().startActivity(inte1);
        }
        if(bt2){

            Intent inte2= new Intent(getContext(),MainActivity.class);
            getContext().startActivity(inte2);
            System.exit(1);

        }
         */
        return false;

    }

    void enemydraw(){
        enemy_d.set(enemyd[0],enemyd[1],enemyd[2],enemyd[3]);
        enemy_d1.set(enemyd1[0],enemyd1[1],enemyd1[2],enemyd1[3]);
       enemy_d2.set(enemyd2[0],enemyd2[1],enemyd2[2],enemyd2[3]);
        enemy_d3.set(enemyd3[0],enemyd3[1],enemyd3[2],enemyd3[3]);
        enemy_d4.set(enemyd4[0],enemyd4[1],enemyd4[2],enemyd4[3]);
       enemy_d5.set(enemyd5[0],enemyd5[1],enemyd5[2],enemyd5[3]);
       enemy_d6.set(enemyd6[0],enemyd6[1],enemyd6[2],enemyd6[3]);


    }
    void enemymake(){

            enemyd[0] -=ctr;
            enemyd[2] -=ctr;

            enemyd1[0] -=ctr;
            enemyd1[2] -=ctr;

            enemyd2[0] -=ctr;
            enemyd2[2] -=ctr;

            enemyd3[0] -=ctr;
            enemyd3[2] -=ctr;

            enemyd4[0] -=ctr;
            enemyd4[2] -=ctr;

            enemyd5[0] -=ctr;
            enemyd5[2] -=ctr;

            enemyd6[0] -=ctr;
            enemyd6[2] -=ctr;
        if(score>=7){
            enemyd[0] -=ctr1;
            enemyd[2] -=ctr1;

            enemyd1[0] -=ctr1;
            enemyd1[2] -=ctr1;

            enemyd2[0] -=ctr1;
            enemyd2[2] -=ctr1;

            enemyd3[0] -=ctr1;
            enemyd3[2] -=ctr1;

            enemyd4[0] -=ctr1;
            enemyd4[2] -=ctr1;

            enemyd5[0] -=ctr1;
            enemyd5[2] -=ctr1;

            enemyd6[0] -=ctr1;
            enemyd6[2] -=ctr1;
        }
        if(score>=20){
            enemyd[0] -=ctr2;
            enemyd[2] -=ctr2;

            enemyd1[0] -=ctr2;
            enemyd1[2] -=ctr2;

            enemyd2[0] -=ctr2;
            enemyd2[2] -=ctr2;

            enemyd3[0] -=ctr2;
            enemyd3[2] -=ctr2;

            enemyd4[0] -=ctr2;
            enemyd4[2] -=ctr2;

            enemyd5[0] -=ctr2;
            enemyd5[2] -=ctr2;

            enemyd6[0] -=ctr2;
            enemyd6[2] -=ctr2;
        }



    }
    void enemyrespawn(){


        if (enemyd[0] < -2500) {
            enemyd[0] = 2190;
            enemyd[2] = 2330;
        }
        if (enemyd1[0] < -2500) {
            enemyd1[0] = 2840;
            enemyd1[2] = 2980;
        }
        if (enemyd2[0] < -2500) {
            enemyd2[0] = 3490;
            enemyd2[2] = 3630;
        }
        if (enemyd3[0] < -2500) {
            enemyd3[0] = 4140;
            enemyd3[2] = 4280;
        }
        if (enemyd4[0] < -2500) {
            enemyd4[0] = 4790;
            enemyd4[2] = 4930;
        }
        if (enemyd5[0] < -2500) {
            enemyd5[0] = 5440;
            enemyd5[2] = 5580;
        }
        if (enemyd3[0] < -2500) {
            enemyd3[0] = 6090;
            enemyd3[2] = 6230;
        }

    }
    void coindraw(){
        coin_d.set(coinzdd[0],coinzdd[1],coinzdd[2],coinzdd[3]);
        coin_d1.set(coinzdd1[0],coinzdd1[1],coinzdd1[2],coinzdd1[3]);
        coin_d2.set(coinzdd2[0],coinzdd2[1],coinzdd2[2],coinzdd2[3]);
        coin_d3.set(coinzdd3[0],coinzdd3[1],coinzdd3[2],coinzdd3[3]);
        coin_d4.set(coinzdd4[0],coinzdd4[1],coinzdd4[2],coinzdd4[3]);
        coin_d5.set(coinzdd5[0],coinzdd5[1],coinzdd5[2],coinzdd5[3]);
        coin_d6.set(coinzdd6[0],coinzdd6[1],coinzdd6[2],coinzdd6[3]);
        coin_d7.set(coinzdd7[0],coinzdd7[1],coinzdd7[2],coinzdd7[3]);
    }
void coinsmake(){
    coinzdd[0] -=ctr;
    coinzdd[2] -=ctr;

    coinzdd1[0]-=ctr;
    coinzdd1[2]-=ctr;

    coinzdd2[0]-=ctr;
    coinzdd2[2]-=ctr;

    coinzdd3[0]-=ctr;
    coinzdd3[2]-=ctr;

    coinzdd4[0]-=ctr;
    coinzdd4[2]-=ctr;

    coinzdd5[0]-=ctr;
    coinzdd5[2]-=ctr;

    coinzdd6[0]-=ctr;
    coinzdd6[2]-=ctr;

    coinzdd7[0]-=ctr;
    coinzdd7[2]-=ctr;
}
void respawncoin() {
    if (coinzdd[0] < -3000) {
        coinzdd[0] = 1890;
        coinzdd[2] = 2000;
    }
    if (coinzdd1[0] < -3100) {
        coinzdd1[0] = 2490;
        coinzdd1[2] = 2600;
    }
    if (coinzdd2[0] < -3200) {
        coinzdd2[0] = 3090;
        coinzdd2[2] = 3200;
    }
    if (coinzdd3[0] < -3300) {
        coinzdd3[0] = 4290;
        coinzdd3[2] = 4400;
    }
    if (coinzdd4[0] < -3400) {
        coinzdd4[0] = 4890;
        coinzdd4[2] = 5000;
    }
    if (coinzdd5[0] < -3200) {
        coinzdd5[0] = 5490;
        coinzdd5[2] = 5600;
    }
    if (coinzdd6[0] < -3500) {
        coinzdd6[0] = 6090;
        coinzdd6[2] = 6200;
    }
    if (coinzdd7[0] < -3200) {
        coinzdd7[0] = 6690;
        coinzdd7[2] = 6800;
    }
}
void scoring(){
    if(coin_d.contains(player_d.left+100,player_d.top+150)){
        score+=1;
        coinzdd[0] = -1890;
        coinzdd[2] = -2000;
    }
    if(coin_d1.contains(player_d.left+100,player_d.top+150)){
        score+=1;
        coinzdd1[0] = -1890;
        coinzdd1[2] = -2000;
    }
    if(coin_d2.contains(player_d.left+100,player_d.top+150)){
        score+=1;
        coinzdd2[0] = -1890;
        coinzdd2[2] = -2000;
    }
    if(coin_d3.contains(player_d.left+100,player_d.top+150)){
        score+=1;
        coinzdd3[0] = -1890;
        coinzdd3[2] = -2000;
    }
    if(coin_d4.contains(player_d.left+100,player_d.top+150)){
        score+=1;
        coinzdd4[0] = -1890;
        coinzdd4[2] = -2000;
    }
    if(coin_d5.contains(player_d.left+100,player_d.top+150)){
        score+=1;
        coinzdd5[0] = -1890;
        coinzdd5[2] = -2000;
    }
    if(coin_d6.contains(player_d.left+100,player_d.top+150)){
        score+=1;
        coinzdd6[0] = -1890;
        coinzdd6[2] = -2000;
    }
    if(coin_d7.contains(player_d.left+100,player_d.top+150)){
        score+=1;
        coinzdd7[0] = -1890;
        coinzdd7[2] = -2000;
    }
    }
    void endGame(){
        if(enemy_d.contains(player_d.left+100,player_d.top+150)){

            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            gamestate=false;
        }
        if(enemy_d1.contains(player_d.left+100,player_d.top+150)){

            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            gamestate=false;
        }
        if(enemy_d2.contains(player_d.left+100,player_d.top+150)){

            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            gamestate=false;
        }
        if(enemy_d3.contains(player_d.left+100,player_d.top+150)){

            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            gamestate=false;
        }
        if(enemy_d4.contains(player_d.left+100,player_d.top+150)){

            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            gamestate=false;
        }
        if(enemy_d5.contains(player_d.left+100,player_d.top+150)){

            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            gamestate=false;


        }
        if(enemy_d6.contains(player_d.left+100,player_d.top+150)){

            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            gamestate=false;
        }
    }
    void gameover(){
        Intent gameovernext = new Intent(getContext(), gameoverleap.class);
        gameovernext.putExtra("SCORE",score);
        getContext().startActivity(gameovernext);
        System.exit(1);


    }

}


