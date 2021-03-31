package com.agesa.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {
    Button btnStart, btnStop;
    ImageView watch_hand;
    Animation counting_anim;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = findViewById(R.id.btn_start);
        watch_hand = findViewById(R.id.img_hand);
        btnStop = findViewById(R.id.btn_stop);
        btnStop.setAlpha(0);
        chronometer=findViewById(R.id.timer);

        counting_anim = AnimationUtils.loadAnimation(this, R.anim.roundinganim);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watch_hand.startAnimation(counting_anim);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();

                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}