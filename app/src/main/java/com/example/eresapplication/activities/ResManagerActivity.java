package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eresapplication.R;

public class ResManagerActivity extends AppCompatActivity {

    CardView btnUpdateEventsCalender,btnReplyComplaints,btnViewComplaints,btnLogOut,btnManageProfile,btnPostAnnouncements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_manager);

        btnPostAnnouncements = findViewById(R.id.btnPostAnnouncements);
        btnUpdateEventsCalender = findViewById(R.id.btnUpdateEventsCalender);
        btnReplyComplaints = findViewById(R.id.btnPostAnnouncements);
        btnViewComplaints = findViewById(R.id.btnPostAnnouncements);
        btnLogOut = findViewById(R.id.btnPostAnnouncements);
        btnManageProfile = findViewById(R.id.btnPostAnnouncements);


        btnUpdateEventsCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(ResManagerActivity.this,UpdateEventsCalender.class);
              startActivity(intent);
            }
        });

        btnPostAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResManagerActivity.this,PostAnnouncements.class);
                startActivity(intent);
            }
        });

      /*  btnReplyComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResManagerActivity.this,ReplyComplaints.class);
                startActivity(intent);
            }
        });
       */

        btnViewComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResManagerActivity.this,ViewComplaints.class);
                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResManagerActivity.this, "Please wait!!! Logging you out", Toast.LENGTH_SHORT).show();
            }
        });

        btnManageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResManagerActivity.this,AddEventsCalender.class);
                startActivity(intent);
            }
        });
    }
}
