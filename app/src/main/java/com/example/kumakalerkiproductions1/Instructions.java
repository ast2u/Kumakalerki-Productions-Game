package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Instructions extends AppCompatActivity implements View.OnClickListener{
ImageButton back;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

back=findViewById(R.id.imageButton7);
back.setOnClickListener(this);


back.setId(1);




    }

    @Override
    public void onClick(View view) {
        int vid= view.getId();
        if(vid==1){
            Intent intent = new Intent(this, com.example.kumakalerkiproductions1.MainActivity.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadeinfast, R.anim.fadeoutfast);
            finish();
        }
    }
}