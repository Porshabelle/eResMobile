package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.eresapplication.R;

import static com.example.eresapplication.activities.MainActivity.SPLASH_TIME_OUT;

public class WelcomeScreen extends AppCompatActivity implements View.OnClickListener {
    public CardView btnBrowseAnnouncements, btnPostAnnouncements, btnUpdateEventsCalender, btnViewComplaints, btnManageProfile, btnLogOut;
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        btnViewComplaints = findViewById(R.id.btnViewComplaints);
        btnBrowseAnnouncements = findViewById(R.id.btnBrowseAnnouncements);
        // btnPostAnnouncements = findViewById(R.id.btnPostAnnouncements);
        btnUpdateEventsCalender = findViewById(R.id.btnUpdateEventsCalender);
        btnManageProfile = findViewById(R.id.btnManageProfile);
        btnLogOut = findViewById(R.id.btnLogOut);

        btnBrowseAnnouncements.setOnClickListener((View.OnClickListener) this);
        btnPostAnnouncements.setOnClickListener((View.OnClickListener) this);
        btnUpdateEventsCalender.setOnClickListener((View.OnClickListener) this);
        btnViewComplaints.setOnClickListener((View.OnClickListener) this);
        btnManageProfile.setOnClickListener((View.OnClickListener) this);
        btnLogOut.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.btnBrowseAnnouncements:
                intent = new Intent(this, BrowseAnnouncements.class);
                startActivity(intent);
                break;
/*
            case R.id.btnPostAnnouncements:
                intent = new Intent(this,PostAnnouncements.class);
                startActivity(intent);
                break;
            case R.id.btnUpdateEventsCalender:
                intent = new Intent(this,UpdateEventsCalender.class);
                startActivity(intent);
                break;
            case R.id.btnViewComplaints:
                intent = new Intent(this,ViewComplaints.class);
                startActivity(intent);
                break;
            case R.id.btnManageProfile:
                intent = new Intent(this,ManageProfile.class);
                startActivity(intent);
                break;

            case R.id.btnLogOut:
                SharedPreferences myPrefs = getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.clear();
                editor.commit();

                Intent logOutintent = new Intent(WelcomeScreen.this , Login.class);
                startActivity(logOutintent);
                //splash screen
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent splashIntent = new Intent(WelcomeScreen.this , Login.class);
                        startActivity(splashIntent);
                        finish();
                    }
                },SPLASH_TIME_OUT);
                //end splash screen
                break;
        }*/
        }
    }
}
