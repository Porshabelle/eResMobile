package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.eresapplication.R;

public class MainActivity extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 4000;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        getSupportActionBar().hide();

        //splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this , Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
        //end splash screen
    }
}