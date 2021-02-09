package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eresapplication.R;

public class ResManagerActivity extends AppCompatActivity {

    CardView btnPostAnnouncements;
    CardView btnUpdateEventsCalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_manager);

        btnPostAnnouncements = findViewById(R.id.btnPostAnnouncements);
        btnUpdateEventsCalender = findViewById(R.id.btnUpdateEventsCalender);

        btnPostAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(ResManagerActivity.this,PostAnnouncements.class);
              startActivity(intent);
            }
        });

        btnUpdateEventsCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResManagerActivity.this,AddEventsCalender.class);
                startActivity(intent);
            }
        });
    }
}
