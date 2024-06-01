package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity implements View.OnClickListener{
    ImageButton b;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        b=findViewById(R.id.imageButton6);
        b.setOnClickListener(this);


        b.setId(1);
    }

    @Override
    public void onClick(View view) {
        int vid= view.getId();
        if(vid==1){
            Intent intent = new Intent(this,MainActivity.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadeinfast, R.anim.fadeoutfast);
            finish();
        }
    }
}