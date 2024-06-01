package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class infotab extends AppCompatActivity implements View.OnClickListener{
Button btt1;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_infotab);
        btt1=  findViewById(R.id.backbt1);
        btt1.setOnClickListener(this);
        btt1.setId(1);


    }

    @Override
    public void onClick(View view) {
        Intent inte1;
        inte1= new Intent(this, startleap.class);
        int tabId = view.getId();
        if(tabId==1){
            startActivity(inte1);
            finish();
        }
    }
}