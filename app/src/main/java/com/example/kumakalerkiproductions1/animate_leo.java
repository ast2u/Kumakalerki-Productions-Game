package com.example.kumakalerkiproductions1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.io.InputStream;

public class animate_leo extends View implements Runnable {
    Paint p1;
    Rect leo_rect,bg_rect,leo_d;
    int[] leo_source= {0,0,400,400};
    Bitmap bg1,player;
    public animate_leo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        p1=new Paint();
        p1.setColor(Color.BLUE);
        InputStream is = getResources().openRawResource(R.raw.leo);
        bg1 = BitmapFactory.decodeResource(getResources(), R.drawable.bg_hearty);
        player = BitmapFactory.decodeStream(is);
        leo_rect = new Rect(0, 0, 400, 400);
        leo_d=new Rect(300, 100, 1500, 800+300+200+200);
        bg_rect = new Rect(0, 0, 1800, 1200);
        Thread t = new Thread(this);
        t.start();


    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        leo_rect.set(leo_source[0],leo_source[1],leo_source[2],leo_source[3]);
        canvas.drawBitmap(bg1, null, bg_rect, p1);
        canvas.drawBitmap(player, leo_rect, leo_d, p1);
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
    }
