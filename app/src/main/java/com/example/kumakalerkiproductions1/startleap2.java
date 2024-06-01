package com.example.kumakalerkiproductions1;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class startleap2 extends AppCompatActivity {
MediaPlayer bgm,bgm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        gamestart gstart = new gamestart(this,null);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(gstart);

    }


}