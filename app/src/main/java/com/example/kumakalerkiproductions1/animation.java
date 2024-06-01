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
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class animation extends AppCompatActivity   {
Button btn;
    MediaPlayer bgm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        animate_leo cview=new animate_leo(this,null);


        bgm=MediaPlayer.create(animation.this,R.raw.introduc);
        bgm.start();


        setContentView(cview);
    }


    class animate_leo extends View implements Runnable,View.OnTouchListener {
        Paint p1;
        Rect leo_rect,bg_rect,leo_d,arrow_rect;
        int[] leo_source= {0,0,400,400};
        Bitmap bg1,player,arrow;
        public animate_leo(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            p1=new Paint();
            p1.setColor(Color.BLUE);
            InputStream is = getResources().openRawResource(R.raw.leo);
            bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.bg_hearty);

            player = BitmapFactory.decodeStream(is);
            arrow=BitmapFactory.decodeResource(getResources(), R.drawable.arrrrrowww);
            leo_rect = new Rect(0, 0, 400, 400);
            leo_d=new Rect(300, 100, 1500, 800+300+200+200);
            bg_rect = new Rect(0, 0, 1800, 1200);
            arrow_rect=new Rect(1600, 0, 1400+400, 200);
            Thread t = new Thread(this);
            t.start();
            setOnTouchListener(this);

        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            leo_rect.set(leo_source[0],leo_source[1],leo_source[2],leo_source[3]);
            canvas.drawBitmap(bg1, null, bg_rect, p1);
            canvas.drawBitmap(player, leo_rect, leo_d, p1);
            canvas.drawBitmap(arrow, null, arrow_rect, p1);
            invalidate();
        }

        int frame1 = 0;
        @Override
        public void run() {
            while (true) {
                if (frame1 > 2) {
                    frame1 = 0;
                    leo_source[0] = 0;
                    leo_source[2] = 400;
                }else {
                    leo_source[0] += 400;
                    leo_source[2] += 400;
                }
                frame1++;
                SystemClock.sleep(500);
            }
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


                Intent intent = new Intent(getContext(), com.example.kumakalerkiproductions1.second_scene.class);

             getContext().startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();

            }
            return false;
        }
    }
}