package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class infopg extends AppCompatActivity implements View.OnClickListener {
Button bt1;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infopg);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        bt1=findViewById(R.id.backbt);
        bt1.setOnClickListener(this);
        bt1.setId(1);
    }

    @Override
    public void onClick(View v) {
        Intent inte1 = new Intent(this, typerpgstart.class);
        int tabId =v.getId();
        if(tabId==1){
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(inte1);
            finish();
        }
    }
}