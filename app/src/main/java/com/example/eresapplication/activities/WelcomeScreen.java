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

        }
    }
}
