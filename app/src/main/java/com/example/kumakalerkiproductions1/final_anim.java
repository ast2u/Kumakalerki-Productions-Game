package com.example.kumakalerkiproductions1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class final_anim extends AppCompatActivity {
    MediaPlayer bgm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_anim);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        final_animation cview= new final_animation(this,null);
        setContentView(cview);
        bgm= MediaPlayer.create(final_anim.this,R.raw.finalanimtaito);
        bgm.start();

    }




     class final_animation extends View implements Runnable,View.OnTouchListener {
        Paint p1;
        Rect img,img2,img3,arrow_rect,img4,img5,img6,img7;
        Bitmap bg1,bg2,bg3,bg4,bg5,bg6,bg7,arrow;

        public final_animation(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            p1=new Paint();
            p1.setColor(Color.BLUE);

            arrow=BitmapFactory.decodeResource(getResources(), R.drawable.arrrrrowww);
            arrow_rect=new Rect(1600, 0, 1400+400, 200);
            bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.first);
            //  bg2=BitmapFactory.decodeResource(getResources(), R.drawable.sec);
            img = new Rect(0, 0, 1800, 1200);
            img2 = new Rect(0, 0, 1800, 1200);
            Thread t = new Thread(this);
            t.start();
            setOnTouchListener(this);


        }



        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawBitmap(bg1, null, img, p1);
            canvas.drawBitmap(arrow, null, arrow_rect, p1);
            invalidate();

        }
        int tx,ty;
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            tx = (int) motionEvent.getX();
            ty = (int) motionEvent.getY();
            boolean detect = arrow_rect.contains(tx, ty);
            if (detect) {
                if(bgm!=null){
                    bgm.release();
                    bgm=null;
                }
                Intent intent = new Intent(getContext(),YOUWIN.class);

                getContext().startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
            return false;





        }
        int frame=0;
        @Override
        public void run() {
            while(true){
                if(frame==0){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.first);

                }
                if (frame==1){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.sec);


                }

                if (frame==2){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.third);

                }
                if (frame==3){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.fourth);

                }
                if (frame==4){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.fifth);

                }
                if (frame==5){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.six);

                }
                if (frame==6){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.sev);

                }
                if (frame==7){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.eight);

                }
                if (frame==8){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.nine);

                }
                if (frame==9){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.ten);

                }
                if (frame==10){
                    bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.elev);

                }





                frame++;
                SystemClock.sleep(1000);
            }







        }



    }
}