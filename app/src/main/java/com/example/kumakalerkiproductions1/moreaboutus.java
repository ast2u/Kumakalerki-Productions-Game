package com.example.kumakalerkiproductions1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class moreaboutus extends AppCompatActivity implements View.OnClickListener{
Button bt1;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_moreaboutus);
        setTitle("About Us");
        bt1=findViewById(R.id.backingbt);
        bt1.setOnClickListener(this);
        bt1.setId(1);
        bt1.setBackgroundColor(Color.MAGENTA);
    }

    @Override
    public void onClick(View view) {
        int tabid = view.getId();
        if(tabid==1){
            Intent t1 = new Intent(this,startingstartactivity.class);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(t1);
            finish();
        }
    }
}