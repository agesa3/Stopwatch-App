package com.agesa.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtMain,sub_txt;
    Button bt_next;
    Animation animation,btgOne,btgTwo;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMain=findViewById(R.id.txt_splash);
        sub_txt=findViewById(R.id.txt_sub_splash);
        bt_next=findViewById(R.id.btn_next);
        imageView=findViewById(R.id.image_splash);
        btgOne=AnimationUtils.loadAnimation(this,R.anim.btg_one);
        btgTwo=AnimationUtils.loadAnimation(this,R.anim.btg_two);


        animation= AnimationUtils.loadAnimation(this,R.anim.anim);
        imageView.startAnimation(animation);
        txtMain.startAnimation(btgOne);
        sub_txt.startAnimation(btgOne);
        bt_next.startAnimation(btgTwo);

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timer=new Intent(MainActivity.this,StopWatchActivity.class);
                timer.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(timer);
            }
        });

    }
}