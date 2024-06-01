package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class gameover extends AppCompatActivity implements View.OnClickListener {
ImageButton btn;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_gameover);
        btn=findViewById(R.id.imageButton5);
        btn.setOnClickListener(this);
        btn.setId(1);
    }

    @Override
    public void onClick(View view) {
        int vid = view.getId();

        if(vid==1){
            Intent intent = new Intent(this, com.example.kumakalerkiproductions1.MainActivity.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadeinfast, R.anim.fadeoutfast);
            finish();
        }

    }
}