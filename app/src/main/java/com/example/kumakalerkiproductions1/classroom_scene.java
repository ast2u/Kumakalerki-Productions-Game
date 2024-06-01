package com.example.kumakalerkiproductions1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class classroom_scene extends AppCompatActivity implements View.OnClickListener {
Button next,next2,next3,next4,next5,next6,next7,next8,next9,next10,next11,c1,c2,c3,c4,c5,c6,c7,c8;
Button overnxt;
ImageButton bck;
TextView first,sec,third,fourth,five,six,seven,eight,nine,ten,elev,twlv;
    MediaPlayer bgm;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_scene);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        bgm=MediaPlayer.create(classroom_scene.this,R.raw.classroooom);
        bgm.start();


        first=findViewById(R.id.txt);
        sec=findViewById(R.id.txt2);
        third=findViewById(R.id.txt3);
        fourth=findViewById(R.id.txt4);
        five=findViewById(R.id.txt5);
        six=findViewById(R.id.txt6);
        seven=findViewById(R.id.txt7);
        eight=findViewById(R.id.txt9);
        nine=findViewById(R.id.txt8);
        ten=findViewById(R.id.txt10);
        elev=findViewById(R.id.txt11);
        twlv=findViewById(R.id.txt12);
        bck=findViewById(R.id.imageButton3);





        first.setText("You have now entered your classroom");


        next=findViewById(R.id.btn);
        next2=findViewById(R.id.btn2);
        next3=findViewById(R.id.btn3);
        next4=findViewById(R.id.btn4);
        next5=findViewById(R.id.btn5);
        next6=findViewById(R.id.btn6);
        next7=findViewById(R.id.btn7);
        next8=findViewById(R.id.btn8);
        next9=findViewById(R.id.btn9);
        next10=findViewById(R.id.btn10);
        next11=findViewById(R.id.btn11);
        overnxt=findViewById(R.id.ovr1);


        c1=findViewById(R.id.choice_1);
        c2=findViewById(R.id.choice_2);
        c3=findViewById(R.id.choice_3);
        c4=findViewById(R.id.choice_4);
        c5=findViewById(R.id.choice_5);
        c6=findViewById(R.id.choice_6);
        c7=findViewById(R.id.choice_7);
        c8=findViewById(R.id.choice_8);









        next.setOnClickListener(this);
        next2.setOnClickListener(this);
        next3.setOnClickListener(this);
        next4.setOnClickListener(this);
        next5.setOnClickListener(this);
        next6.setOnClickListener(this);
        next7.setOnClickListener(this);
        next8.setOnClickListener(this);
        next9.setOnClickListener(this);
        next10.setOnClickListener(this);
        next11.setOnClickListener(this);
        overnxt.setOnClickListener(this);
        bck.setOnClickListener(this);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        c6.setOnClickListener(this);
        c7.setOnClickListener(this);
        c8.setOnClickListener(this);



        next.setBackgroundColor(Color.MAGENTA);
        next2.setBackgroundColor(Color.MAGENTA);
        next3.setBackgroundColor(Color.MAGENTA);
        next4.setBackgroundColor(Color.MAGENTA);
        next5.setBackgroundColor(Color.MAGENTA);
        next6.setBackgroundColor(Color.MAGENTA);
        next7.setBackgroundColor(Color.MAGENTA);
        next8.setBackgroundColor(Color.MAGENTA);
        next9.setBackgroundColor(Color.MAGENTA);
        next10.setBackgroundColor(Color.MAGENTA);
        next11.setBackgroundColor(Color.MAGENTA);
        overnxt.setBackgroundColor(Color.MAGENTA);
        c1.setBackgroundColor(Color.MAGENTA);
        c2.setBackgroundColor(Color.MAGENTA);
        c3.setBackgroundColor(Color.MAGENTA);
        c4.setBackgroundColor(Color.MAGENTA);
        c5.setBackgroundColor(Color.MAGENTA);
        c6.setBackgroundColor(Color.MAGENTA);
        c7.setBackgroundColor(Color.MAGENTA);
        c8.setBackgroundColor(Color.MAGENTA);





        next2.setEnabled(false);
        next3.setEnabled(false);
        next4.setEnabled(false);
        next5.setEnabled(false);
        next6.setEnabled(false);
        next7.setEnabled(false);
        next8.setEnabled(false);
        next9.setEnabled(false);
        next10.setEnabled(false);
        next11.setEnabled(false);
        overnxt.setEnabled(false);
        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
        c4.setEnabled(false);
        c5.setEnabled(false);
        c6.setEnabled(false);
        c7.setEnabled(false);
        c8.setEnabled(false);





        next.setId(1);
        next2.setId(2);
        next3.setId(3);
        next4.setId(4);
        next5.setId(5);
        next6.setId(6);
        next7.setId(7);
        next8.setId(8);
        next9.setId(9);
        next10.setId(10);
        next11.setId(11);
        overnxt.setId(12);


        c1.setId(21);
        c2.setId(22);
        c3.setId(23);
        c4.setId(24);
        c5.setId(25);
        c6.setId(26);
        c7.setId(27);
        c8.setId(28);

        bck.setId(100);




    }

    @Override
    public void onClick(View view) {
        int vid = view.getId();
        if(vid==1){
            first.setText("");
            sec.setText("*You barely made it before the time*");
            next.setEnabled(false);
            next2.setEnabled(true);
        }
        if(vid==2){
            sec.setText("");
            third.setText("*At the corner of your eye you saw someone familiar approaching you*");
            next2.setEnabled(false);
            next3.setEnabled(true);

        }
        if(vid==3){

            ImageView image=(ImageView) findViewById(R.id.imageView4);
            image.setImageResource(R.drawable.classroom_leo);
            fourth.setText("Oi diba ikaw ung bumanga sakin");
            third.setText("");
            next4.setEnabled(true);
            next3.setEnabled(false);

        }
        if(vid==4){
            fourth.setText("");
            five.setText("Tsk ikaw pa talaga naging classmate ko");
            next4.setEnabled(false);
            next5.setEnabled(true);
        }
        if(vid==5){
            five.setText("");
            six.setText("Oi ano pangalan mo");
            next5.setEnabled(false);
            next6.setEnabled(true);

        }
        if(vid==6){
            next6.setEnabled(false);
            c1.setEnabled(true);
            c2.setEnabled(true);
            c3.setEnabled(true);
            c4.setEnabled(true);
        }

        if(vid==21){
            ImageView image=(ImageView) findViewById(R.id.imageView4);
            image.setImageResource(R.drawable.cracks);

            six.setText("");
            seven.setText("Ako si Leonardo the conqueror of the seas");
            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);
            next7.setEnabled(true);
        }
        if(vid==22){
            ImageView image=(ImageView) findViewById(R.id.imageView4);
            image.setImageResource(R.drawable.cracks);

            six.setText("");
            seven.setText("Ako si Leonardo the conqueror of the seas");
            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);
            next7.setEnabled(true);
        }

        if(vid==23){
            ImageView image=(ImageView) findViewById(R.id.imageView4);
            image.setImageResource(R.drawable.cracks);

            six.setText("");
            seven.setText("Ako si Leonardo the conqueror of the seas");
            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);
            next7.setEnabled(true);
        }
        if(vid==24){
            ImageView image=(ImageView) findViewById(R.id.imageView4);
            image.setImageResource(R.drawable.cracks);

            six.setText("");
            seven.setText("Ako si Leonardo the conqueror of the seas");
            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);
            next7.setEnabled(true);
        }






        if(vid==7){
        seven.setText("");
        eight.setText("Ako hari ng school na to");
        next7.setEnabled(false);
        next8.setEnabled(true);
        }

        if(vid==8){
           c5.setEnabled(true);
           c6.setEnabled(true);
           next8.setEnabled(false);


        }

        if(vid==26){
            ImageView image=(ImageView) findViewById(R.id.imageView4);
            image.setImageResource(R.drawable.sad_leo);
            eight.setText("");
            twlv.setText("Ay sge sorry");
            c5.setEnabled(false);
            c6.setEnabled(false);
            overnxt.setEnabled(true);
        }



        if(vid==25){
            ImageView image=(ImageView) findViewById(R.id.imageView4);
            image.setImageResource(R.drawable.classroom_leo);
            eight.setText("");
            nine.setText("*blushes*");
            c5.setEnabled(false);
            c6.setEnabled(false);
            next9.setEnabled(true);

        }






        if(vid==9){
            nine.setText("");
            ten.setText("B-B-Baliwwww!!!!");
            next9.setEnabled(false);
            next10.setEnabled(true);


        }
        if(vid==10){
            ten.setText("");
            elev.setText("Gusto mo ba na kumain mamaya????");
            next10.setEnabled(false);
            next11.setEnabled(true);

        }





        if(vid==11){
            next11.setEnabled(false);
            c7.setEnabled(true);
            c8.setEnabled(true);


        }



        if(vid==27){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            Intent intent = new Intent(this, com.example.kumakalerkiproductions1.FINAL_SCENE.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadeinfast, R.anim.fadeoutfast);
            finish();

        }

        if(vid==28){

            ImageView image=(ImageView) findViewById(R.id.imageView4);
            image.setImageResource(R.drawable.sad_leo);
            elev.setText("");
            twlv.setText("Ay sge sorry");
            c8.setEnabled(false);
            c7.setEnabled(false);
            overnxt.setEnabled(true);

        }

        if(vid==12){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            Intent intent = new Intent(this, com.example.kumakalerkiproductions1.gameover.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        }

        if(vid==100){
            if(bgm!=null){
                bgm.release();
                bgm=null;
            }
            Intent intent = new Intent(this, com.example.kumakalerkiproductions1.MainActivity.class);

            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        }




    }
}