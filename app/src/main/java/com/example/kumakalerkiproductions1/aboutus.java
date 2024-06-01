package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class aboutus extends AppCompatActivity implements View.OnClickListener{

Button bt1;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        bt1=findViewById(R.id.backbb1);
        bt1.setOnClickListener(this);
        bt1.setBackgroundColor(Color.RED);
        getSupportActionBar().hide();
        bt1.setId(1);

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